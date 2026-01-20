package nightkosh.advanced_fishing.entity.projectile;

import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.slot.SlotCollection;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.DynamicGameEventListener;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import nightkosh.advanced_fishing.core.AFConfig;
import nightkosh.advanced_fishing.core.AFEnchantmentHelper;
import nightkosh.advanced_fishing.core.AFEnchantments;
import nightkosh.advanced_fishing.core.AFItems;
import nightkosh.advanced_fishing.entity.item.FireproofItemEntity;
import org.jspecify.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;

import static nightkosh.advanced_fishing.ModAdvancedFishing.LOGGER;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class AFishHook extends FishingHook {

    private static final List<TagKey<Fluid>> SUPPORTED_LIQUID_TYPE = List.of(FluidTags.WATER);

    protected static final float PI_DIV_180 = 0.0175F;

    protected static final EntityDataAccessor<Boolean> GLOWING_ENCH = SynchedEntityData.defineId(AFishHook.class, EntityDataSerializers.BOOLEAN);
    protected static final EntityDataAccessor<Boolean> AUTO_FISH = SynchedEntityData.defineId(AFishHook.class, EntityDataSerializers.BOOLEAN);

    public AFishHook(EntityType<? extends AFishHook> entityType, Level level) {
        super(entityType, level);
        spawnLog();
    }

    public AFishHook(EntityType<? extends AFishHook> entityType, Player player, ServerLevel level,
                     int additionalLuck, int additionalLureSpeed, ItemStack fishingPole) {
        super(entityType, level,
                EnchantmentHelper.getFishingLuckBonus(level, fishingPole, player) + additionalLuck,
                (int) (EnchantmentHelper.getFishingTimeReduction(level, fishingPole, player)) * 20 + additionalLureSpeed * 100);
        if (AFConfig.DEBUG_MODE.get()) {
            LOGGER.info("Fishing hook created with next params:");
            LOGGER.info("Additional luck {}, additional speed {}", additionalLuck, additionalLureSpeed * 100);
            LOGGER.info("Final luck {}, final lureSpeed {}", this.luck, this.lureSpeed);
        }
        this.setOwner(player);
        float f = player.getXRot();
        float f1 = player.getYRot();
        float f2 = Mth.cos((float) (-f1 * PI_DIV_180 - Math.PI));
        float f3 = Mth.sin((float) (-f1 * PI_DIV_180 - Math.PI));
        float f4 = -Mth.cos(-f * PI_DIV_180);
        float f5 = Mth.sin(-f * PI_DIV_180);
        double d0 = player.getX() - f3 * 0.3;
        double d1 = player.getEyeY();
        double d2 = player.getZ() - f2 * 0.3;
        this.snapTo(d0, d1, d2, f1, f);
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

        this.hasGlowingEnchantment(AFEnchantmentHelper.isEnchanted(level, AFEnchantments.LUMINOUS_FLOAT, fishingPole));
        this.hasAutoFishing(AFEnchantmentHelper.isEnchanted(level, AFEnchantments.AWAKENED_ROD, fishingPole));
        spawnLog();
    }

    @Override
    protected void defineSynchedData(@Nonnull SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(GLOWING_ENCH, false);
        builder.define(AUTO_FISH, false);
    }

    @Override
    public boolean canCollideWith(@Nonnull Entity entity) {
        return !(entity instanceof ItemEntity) && super.canCollideWith(entity);
    }

    @Override
    protected boolean canHitEntity(@Nonnull Entity entity) {
        return !(entity instanceof ItemEntity) && super.canHitEntity(entity);
    }

    @Override
    public boolean isColliding(BlockPos pos, BlockState state) {
        return super.isColliding(pos, state);
    }

    @Override
    public void setOnGroundWithMovement(boolean onGround, boolean horizontalCollision, Vec3 movement) {
        super.setOnGroundWithMovement(onGround, horizontalCollision, movement);
    }

    @Override
    protected boolean isHorizontalCollisionMinor(Vec3 deltaMovement) {
        return super.isHorizontalCollisionMinor(deltaMovement);
    }

    @Override
    public boolean collidedWithFluid(FluidState fluid, BlockPos pos, Vec3 from, Vec3 to) {
        return super.collidedWithFluid(fluid, pos, from, to);
    }

    @Override
    public boolean collidedWithShapeMovingFrom(Vec3 from, Vec3 to, List<AABB> boxes) {
        return super.collidedWithShapeMovingFrom(from, to, boxes);
    }

    @Override
    public boolean canBeCollidedWith(@Nullable Entity entity) {
        return super.canBeCollidedWith(entity);
    }

    @Override
    public void updateDynamicGameEventListener(BiConsumer<DynamicGameEventListener<?>, ServerLevel> listenerConsumer) {
        super.updateDynamicGameEventListener(listenerConsumer);
    }

    @Override
    public CommandSourceStack createCommandSourceStackForNameResolution(ServerLevel level) {
        return super.createCommandSourceStackForNameResolution(level);
    }

    @Override
    public @Nullable Collection<ItemEntity> captureDrops() {
        return super.captureDrops();
    }

    @Override
    public @Nullable Collection<ItemEntity> captureDrops(@Nullable Collection<ItemEntity> value) {
        return super.captureDrops(value);
    }

    @Override
    public SlotCollection getSlotsFromRange(IntList p_461197_) {
        return super.getSlotsFromRange(p_461197_);
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        if (canCollideWith(result.getEntity())) {
            super.onHitEntity(result);
        }
    }

    @Override
    public void tick() {
        // code form FishingHook.tick()
        this.syncronizedRandom.setSeed(this.getUUID().getLeastSignificantBits() ^ this.level().getGameTime());
        this.getInterpolation().interpolate();

        // code form Projectile.tick()
        if (!this.hasBeenShot) {
            this.gameEvent(GameEvent.PROJECTILE_SHOOT, this.getOwner());
            this.hasBeenShot = true;
        }
        this.checkLeftOwner();

        super.baseTick();

        // code form FishingHook.tick()
        var player = this.getPlayerOwner();
        if (player == null) {
            this.discard();
        } else if (this.level().isClientSide() || !this.shouldStopFishing(player)) {
            if (this.onGround()) {
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
            var fluidstate = this.level().getFluidState(blockpos);
            if (isInSupportedLiquid(fluidstate)) {
                f = fluidstate.getHeight(this.level(), blockpos);
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
                        if (!this.hookedIn.isRemoved() && this.hookedIn.canInteractWithLevel() && this.hookedIn.level().dimension() == this.level().dimension()) {
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

                        if (!this.level().isClientSide()) {
                            this.catchingFish(blockpos);
                        }
                    } else {
                        this.outOfWaterTime = Math.min(10, this.outOfWaterTime + 1);
                    }
                }
            }

            if (!isInSupportedLiquid(fluidstate) && !this.onGround() && this.hookedIn == null) {
                this.setDeltaMovement(this.getDeltaMovement().add(0, -0.03, 0));
            }

            this.move(MoverType.SELF, this.getDeltaMovement());
            this.updateRotation();
            if (this.currentState == FishingHook.FishHookState.FLYING && (this.onGround() || this.horizontalCollision)) {
                this.setDeltaMovement(Vec3.ZERO);
            }

            this.setDeltaMovement(this.getDeltaMovement().scale(0.92));
            this.reapplyPosition();
        }

        // code form Projectile.tick()
        this.leftOwnerChecked = false;

        if (this.hasAutoFishing() && this.nibble > 0) {
            if (AFConfig.DEBUG_MODE.get()) {
                LOGGER.info("Auto catching!!!!!");
            }
            var rod = player.getMainHandItem();
            if (rod.is(Items.FISHING_ROD) || rod.is(AFItems.getBlazingFishingPole()) || rod.getItem() instanceof FishingRodItem) {
                rod.use(level(), player, InteractionHand.MAIN_HAND);
                rod.use(level(), player, InteractionHand.MAIN_HAND);
            } else {
                rod = player.getOffhandItem();
                if (rod.is(Items.FISHING_ROD) || rod.is(AFItems.getBlazingFishingPole()) || rod.getItem() instanceof FishingRodItem) {
                    rod.use(level(), player, InteractionHand.OFF_HAND);
                    rod.use(level(), player, InteractionHand.OFF_HAND);
                }
            }
        }
    }

    @Nonnull
    @Override
    protected FishingHook.OpenWaterType getOpenWaterTypeForBlock(@Nonnull BlockPos blockPos) {
        var blockstate = this.level().getBlockState(blockPos);
        if (!blockstate.isAir() && !blockstate.is(Blocks.LILY_PAD)) {
            var fluidstate = blockstate.getFluidState();
            return isInSupportedLiquid(fluidstate) && fluidstate.isSource() && blockstate.getCollisionShape(this.level(), blockPos).isEmpty() ?
                    FishingHook.OpenWaterType.INSIDE_WATER :
                    FishingHook.OpenWaterType.INVALID;
        } else {
            return FishingHook.OpenWaterType.ABOVE_WATER;
        }
    }

    public boolean hasGlowingEnchantment() {
        return this.getEntityData().get(GLOWING_ENCH);
    }

    public void hasGlowingEnchantment(boolean hasGlowingEnchantment) {
        this.getEntityData().set(GLOWING_ENCH, hasGlowingEnchantment);
    }

    public boolean hasAutoFishing() {
        return this.getEntityData().get(AUTO_FISH);
    }

    public void hasAutoFishing(boolean autoFishing) {
        this.getEntityData().set(AUTO_FISH, autoFishing);
    }

    protected boolean isInSupportedLiquid(FluidState fluidstate) {
        return getSupportedLiquidType().stream()
                .anyMatch(fluidstate::is);
    }

    protected List<TagKey<Fluid>> getSupportedLiquidType() {
        return SUPPORTED_LIQUID_TYPE;
    }

    protected ItemEntity getFireproofCatchEntityItem(ItemStack stack) {
        return new FireproofItemEntity(this.level(), this.getX(), this.getY(), this.getZ(), stack);
    }

    protected abstract void spawnLog();

}
