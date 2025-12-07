package nightkosh.advanced_fishing.entity.projectile;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemFishedEvent;
import nightkosh.advanced_fishing.core.AFConfig;
import nightkosh.advanced_fishing.core.AFEntities;
import nightkosh.advanced_fishing.core.MaterialManager;
import nightkosh.advanced_fishing.core.ParticlesManager;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;

import static nightkosh.advanced_fishing.ModAdvancedFishing.LOGGER;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AdvancedFishHook extends AbstractFishHook {

    public AdvancedFishHook(EntityType<? extends AdvancedFishHook> entityType, Level level) {
        super(entityType, level);
        spawnLog();
    }

    public AdvancedFishHook(Player player, Level level, int luck, int lureSpeed) {
        super(AFEntities.getCustomFishHook(), player, level, luck, lureSpeed);
        spawnLog();
    }

    public AdvancedFishHook(EntityType<? extends AbstractFishHook> entityType, Player player, Level level, int luck, int lureSpeed) {
        super(entityType, player, level, luck, lureSpeed);
        spawnLog();
    }

    @Override
    protected void catchingFish(BlockPos pos) {
        var serverLevel = (ServerLevel) this.getLevel();
        int i = 1;
        var blockpos = pos.above();

        if (this.random.nextFloat() < 0.25 && this.getLevel().isRainingAt(blockpos)) {
            i++;
        }

        if (this.random.nextFloat() < 0.5 && !this.getLevel().canSeeSky(blockpos)) {
            i--;
        }

        if (this.nibble > 0) {
            this.nibble--;
            if (this.nibble <= 0) {
                this.timeUntilLured = 0;
                this.timeUntilHooked = 0;
                this.getEntityData().set(DATA_BITING, false);
            }
        } else if (this.timeUntilHooked > 0) {
            this.timeUntilHooked -= i;

            if (this.timeUntilHooked > 0) {
                this.fishAngle += (float) this.random.triangle(0.0D, 9.188);
                float angle = this.fishAngle * 0.017453292F;
                float sin = Mth.sin(angle);
                float cos = Mth.cos(angle);
                double xPos = this.getX() + sin * this.timeUntilHooked * 0.1;
                double yPos = Mth.floor(this.getY()) + 1;
                double zPos = this.getZ() + cos * this.timeUntilHooked * 0.1;
                var blockstate = serverLevel.getBlockState(BlockPos.containing(xPos, yPos - 1, zPos));
                var liquidBlock = blockstate.getBlock();

                if (MaterialManager.MATERIAL_SET.contains(blockstate.getMaterial())) {
                    if (this.random.nextFloat() < 0.15) {
                        ParticlesManager.INSTANCE.getBubbleParticles(liquidBlock).spawn(
                                serverLevel,
                                xPos, yPos - 0.1, zPos,
                                1,
                                sin, 0.1, cos,
                                0);
                    }

                    float zOffset = sin * 0.04F;
                    float xOffset = cos * 0.04F;
                    ParticlesManager.INSTANCE.getFishingParticles(liquidBlock).spawn(
                            serverLevel,
                            xPos, yPos, zPos,
                            0,
                            xOffset, 0.01, -zOffset,
                            1);
                    ParticlesManager.INSTANCE.getFishingParticles(liquidBlock).spawn(
                            serverLevel,
                            xPos, yPos, zPos,
                            0,
                            -xOffset, 0.01, zOffset,
                            1);
                }
            } else {
                this.playSound(SoundEvents.FISHING_BOBBER_SPLASH, 0.25F, 1 + (this.random.nextFloat() - this.random.nextFloat()) * 0.4F);
                double yPos = this.getY() + 0.5;
                var blockstate = serverLevel.getBlockState(BlockPos.containing(this.getX(), yPos - 1, this.getZ()));
                var liquidBlock = blockstate.getBlock();
                ParticlesManager.INSTANCE.getBubbleParticles(liquidBlock).spawn(
                        serverLevel,
                        this.getX(), yPos, this.getX(),
                        (int) (1 + this.getBbWidth() * 20),
                        this.getBbWidth(), 0, this.getBbWidth(),
                        0.2);
                ParticlesManager.INSTANCE.getFishingParticles(liquidBlock).spawn(
                        serverLevel,
                        this.getX(), yPos, this.getX(),
                        (int) (1 + this.getBbWidth() * 20),
                        this.getBbWidth(), 0, this.getBbWidth(),
                        0.2);
                this.nibble = Mth.nextInt(this.random, 20, 40);
                this.getEntityData().set(DATA_BITING, true);
            }
        } else if (this.timeUntilLured > 0) {
            this.timeUntilLured -= i;
            float f5 = 0.15F;

            if (this.timeUntilLured < 20) {
                f5 += (float) (20 - this.timeUntilLured) * 0.05F;
            } else if (this.timeUntilLured < 40) {
                f5 += (float) (40 - this.timeUntilLured) * 0.02F;
            } else if (this.timeUntilLured < 60) {
                f5 += (float) (60 - this.timeUntilLured) * 0.01F;
            }

            if (this.random.nextFloat() < f5) {
                float f6 = Mth.nextFloat(this.random, 0, 360) * 0.017453292F;
                float f7 = Mth.nextFloat(this.random, 25, 60);
                double xPos = this.getX() + Mth.sin(f6) * f7 * 0.1;
                double yPos = Mth.floor(this.getY()) + 1;
                double zPos = this.getZ() + Mth.cos(f6) * f7 * 0.1;

                var blockState = serverLevel.getBlockState(BlockPos.containing(xPos, yPos - 1, zPos));
                if (MaterialManager.MATERIAL_SET.contains(blockState.getMaterial())) {
                    ParticlesManager.INSTANCE.getSplashParticles(blockState.getBlock())
                            .spawn(serverLevel, xPos, yPos, zPos,
                                    2 + this.random.nextInt(2),
                                    0.1, 0, 0.1,
                                    0);
                }
            }

            if (this.timeUntilLured <= 0) {
                this.fishAngle = Mth.nextFloat(this.random, 0, 360);
                this.timeUntilHooked = Mth.nextInt(this.random, 20, 80);
            }
        } else {
            this.timeUntilLured = Mth.nextInt(this.random, 100, 600);
            this.timeUntilLured -= this.lureSpeed * 20 * 5;
        }
    }

    @Override
    public int retrieve(@Nonnull ItemStack itemStack) {
        var player = this.getPlayerOwner();
        if (!this.level.isClientSide && player != null && !this.shouldStopFishing(player)) {
            int i = 0;

            ItemFishedEvent event = null;
            if (this.hookedIn != null) {
                this.pullEntity(this.getHookedIn());
                CriteriaTriggers.FISHING_ROD_HOOKED.trigger((ServerPlayer) player, itemStack, this, Collections.emptyList());
                this.getLevel().broadcastEntityEvent(this, (byte) 31);
                i = this.hookedIn instanceof ItemEntity ? 3 : 5;
            } else if (this.nibble > 0) {
                var catchList = this.getCatch(itemStack);
                event = new ItemFishedEvent(catchList, this.isOnGround() ? 2 : 1, this);
                MinecraftForge.EVENT_BUS.post(event);
                if (event.isCanceled()) {
                    this.discard();
                    return event.getRodDamage();
                }
                CriteriaTriggers.FISHING_ROD_HOOKED.trigger((ServerPlayer) player, itemStack, this, catchList);

                for (ItemStack stack : catchList) {
                    var entityItem = getCatchEntityItem(stack);
                    double d0 = player.getX() - this.getX();
                    double d1 = player.getY() - this.getY();
                    double d2 = player.getZ() - this.getZ();

                    entityItem.setDeltaMovement(d0 * 0.1, d1 * 0.1 + Math.sqrt(Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2)) * 0.08, d2 * 0.1);

                    this.getLevel().addFreshEntity(entityItem);
                    player.getLevel().addFreshEntity(
                            new ExperienceOrb(player.getLevel(),
                                    player.getX(), player.getY() + 0.5, player.getZ() + 0.5,
                                    this.random.nextInt(6) + 1));


                    if (stack.is(ItemTags.FISHES)) {
                        player.awardStat(Stats.FISH_CAUGHT, 1);
                    }
                }

                i = 1;
            }

            if (this.isOnGround()) {
                i = 2;
            }

            this.discard();
            return event == null ? i : event.getRodDamage();
        } else {
            return 0;
        }
    }

    protected ItemEntity getCatchEntityItem(ItemStack stack) {
        return new ItemEntity(this.getLevel(), this.getX(), this.getY(), this.getX(), stack);
    }

    protected List<ItemStack> getCatch(@Nonnull ItemStack itemStack) {
        var builder = new LootContext.Builder((ServerLevel) this.level)
                .withParameter(LootContextParams.ORIGIN, this.position())
                .withParameter(LootContextParams.TOOL, itemStack)
                .withParameter(LootContextParams.THIS_ENTITY, this)
                .withParameter(LootContextParams.KILLER_ENTITY, this.getOwner())
                .withParameter(LootContextParams.THIS_ENTITY, this)
                .withLuck((float) this.luck + this.getPlayerOwner().getLuck())
                .withRandom(this.random);

        var loottable = this.level.getServer()
                .getLootTables()
                .get(BuiltInLootTables.FISHING);
        return loottable.getRandomItems(builder.create(LootContextParamSets.FISHING));

//TODO
//        var result = new ArrayList<ItemStack>(1);
//        var liquidBlock = this.getLevel().getBlockState(
//                new BlockPos((int) this.getX(), Mth.floor(this.getBoundingBox().minY), (int) this.getX()))
//                .getBlock();
//
//        var tempList = CatchManager.INSTANCE.getCatch(liquidBlock)
//                .getCatch(this.getLevel(), this.blockPosition(), (this.luck + this.getPlayerOwner().getLuck()) * 1.5F);
//        result.add(tempList.get(this.random.nextInt(tempList.size())));
//
//        return result;
    }

    protected void spawnLog() {
        if (AFConfig.DEBUG_MODE.get()) {
            LOGGER.info("AdvancedFishHook spawned");
        }
    }

}
