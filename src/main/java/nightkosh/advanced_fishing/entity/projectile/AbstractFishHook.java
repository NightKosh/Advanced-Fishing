package nightkosh.advanced_fishing.entity.projectile;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import nightkosh.advanced_fishing.entity.item.FireproofItemEntity;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class AbstractFishHook extends FishingHook {

    private static final List<TagKey<Fluid>> SUPPORTED_LIQUID_TYPE = List.of(FluidTags.WATER);

    public AbstractFishHook(EntityType<? extends AbstractFishHook> entityType, Level level) {
        super(entityType, level);
    }

    public AbstractFishHook(EntityType<? extends AbstractFishHook> entityType, Player player, Level level, int luck, int lureSpeed) {
        super(entityType, level, luck, lureSpeed);
        this.setOwner(player);
        float f = player.getXRot();
        float f1 = player.getYRot();
        float f2 = Mth.cos((float) (-f1 * (Math.PI / 180) - Math.PI));
        float f3 = Mth.sin((float) (-f1 * (Math.PI / 180) - Math.PI));
        float f4 = -Mth.cos(-f * ((float) Math.PI / 180));
        float f5 = Mth.sin(-f * ((float) Math.PI / 180));
        double d0 = player.getX() - f3 * 0.3;
        double d1 = player.getEyeY();
        double d2 = player.getZ() - f2 * 0.3;
        this.moveTo(d0, d1, d2, f1, f);
        var vec3 = new Vec3(-f3, Mth.clamp(-(f5 / f4), -5, 5), -f2);
        double d3 = vec3.length();
        vec3 = vec3.multiply(0.6 / d3 + this.random.triangle(0.5, 0.0103365),
                0.6 / d3 + this.random.triangle(0.5, 0.0103365),
                0.6 / d3 + this.random.triangle(0.5, 0.0103365));
        this.setDeltaMovement(vec3);
        this.setYRot((float) (Mth.atan2(vec3.x, vec3.z) * (180 / Math.PI)));
        this.setXRot((float) (Mth.atan2(vec3.y, vec3.horizontalDistance()) * (180 / Math.PI)));
        this.yRotO = this.getYRot();
        this.xRotO = this.getXRot();
    }

    @Override
    public void tick() {
        // code form FishingHook.tick()
        this.syncronizedRandom.setSeed(this.getUUID().getLeastSignificantBits() ^ this.getLevel().getGameTime());

        // code form Projectile.tick()
        if (!this.hasBeenShot) {
            this.gameEvent(GameEvent.PROJECTILE_SHOOT, this.getOwner());
            this.hasBeenShot = true;
        }

        if (!this.leftOwner) {
            this.leftOwner = this.checkLeftOwner();
        }

        super.baseTick();

        // code form FishingHook.tick()
        var player = this.getPlayerOwner();
        if (player == null) {
            this.discard();
        } else if (this.getLevel().isClientSide() || !this.shouldStopFishing(player)) {
            if (this.onGround) {
                this.life++;
                if (this.life >= 1200) {
                    this.discard();
                    return;
                }
            } else {
                this.life = 0;
            }

            float f = 0;
            var blockpos = this.blockPosition();
            var fluidstate = this.getLevel().getFluidState(blockpos);
            if (isInSupportedLiquid(fluidstate)) {
                f = fluidstate.getHeight(this.getLevel(), blockpos);
            }

            boolean flag = f > 0;
            if (this.currentState == FishingHook.FishHookState.FLYING) {
                if (this.hookedIn != null) {
                    this.setDeltaMovement(Vec3.ZERO);
                    this.currentState = FishingHook.FishHookState.HOOKED_IN_ENTITY;
                    return;
                }

                if (flag) {
                    this.setDeltaMovement(this.getDeltaMovement().multiply(0.3, 0.2, 0.3));
                    this.currentState = FishingHook.FishHookState.BOBBING;
                    return;
                }

                this.checkCollision();
            } else {
                if (this.currentState == FishingHook.FishHookState.HOOKED_IN_ENTITY) {
                    if (this.hookedIn != null) {
                        if (!this.hookedIn.isRemoved() && this.hookedIn.getLevel().dimension() == this.getLevel().dimension()) {
                            this.setPos(this.hookedIn.getX(), this.hookedIn.getY(0.8), this.hookedIn.getZ());
                        } else {
                            this.setHookedEntity(null);
                            this.currentState = FishingHook.FishHookState.FLYING;
                        }
                    }

                    return;
                }

                if (this.currentState == FishingHook.FishHookState.BOBBING) {
                    var vec3 = this.getDeltaMovement();
                    double d0 = this.getY() + vec3.y - blockpos.getY() - f;
                    if (Math.abs(d0) < 0.01) {
                        d0 += Math.signum(d0) * 0.1;
                    }

                    this.setDeltaMovement(vec3.x * 0.9, vec3.y - d0 * this.random.nextFloat() * 0.2, vec3.z * 0.9);
                    if (this.nibble <= 0 && this.timeUntilHooked <= 0) {
                        this.openWater = true;
                    } else {
                        this.openWater = this.openWater && this.outOfWaterTime < 10 && this.calculateOpenWater(blockpos);
                    }

                    if (flag) {
                        this.outOfWaterTime = Math.max(0, this.outOfWaterTime - 1);
                        if (this.biting) {
                            this.setDeltaMovement(this.getDeltaMovement().add(0,
                                    -0.1 * this.syncronizedRandom.nextFloat() * this.syncronizedRandom.nextFloat(),
                                    0));
                        }

                        if (!this.getLevel().isClientSide()) {
                            this.catchingFish(blockpos);
                        }
                    } else {
                        this.outOfWaterTime = Math.min(10, this.outOfWaterTime + 1);
                    }
                }
            }

            if (!isInSupportedLiquid(fluidstate)) {
                this.setDeltaMovement(this.getDeltaMovement().add(0, -0.03, 0));
            }

            this.move(MoverType.SELF, this.getDeltaMovement());
            this.updateRotation();
            if (this.currentState == FishingHook.FishHookState.FLYING && (this.onGround || this.horizontalCollision)) {
                this.setDeltaMovement(Vec3.ZERO);
            }

            this.setDeltaMovement(this.getDeltaMovement().scale(0.92));
            this.reapplyPosition();
        }
    }

    @Nonnull
    @Override
    protected FishingHook.OpenWaterType getOpenWaterTypeForBlock(@Nonnull BlockPos blockPos) {
        var blockstate = this.getLevel().getBlockState(blockPos);
        if (!blockstate.isAir() && !blockstate.is(Blocks.LILY_PAD)) {
            var fluidstate = blockstate.getFluidState();
            return isInSupportedLiquid(fluidstate) && fluidstate.isSource() && blockstate.getCollisionShape(this.getLevel(), blockPos).isEmpty() ?
                    FishingHook.OpenWaterType.INSIDE_WATER :
                    FishingHook.OpenWaterType.INVALID;
        } else {
            return FishingHook.OpenWaterType.ABOVE_WATER;
        }
    }

    protected boolean isInSupportedLiquid(FluidState fluidstate) {
        return getSupportedLiquidType().stream()
                .anyMatch(fluidstate::is);
    }

    protected List<TagKey<Fluid>> getSupportedLiquidType() {
        return SUPPORTED_LIQUID_TYPE;
    }

    protected ItemEntity getFireproofCatchEntityItem(ItemStack stack) {
        return new FireproofItemEntity(this.getLevel(), this.getX(), this.getY(), this.getX(), stack);
    }

}
