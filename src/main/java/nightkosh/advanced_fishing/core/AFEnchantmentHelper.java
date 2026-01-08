package nightkosh.advanced_fishing.core;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.event.entity.player.ItemFishedEvent;

import static nightkosh.advanced_fishing.ModAdvancedFishing.LOGGER;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AFEnchantmentHelper {

    public static void applyItemFishedEventEffect(ItemFishedEvent event, Level level, Player player) {
        if (player != null && !level.isClientSide()) {
            var mainItem = player.getMainHandItem();
            var offhandItem = player.getOffhandItem();
            if (level.random.nextInt(10) < 3) {
                var ench = getEnchantmentHolder(level, AFEnchantments.CURSE_OF_FALSE_BITE);
                if (EnchantmentHelper.getItemEnchantmentLevel(ench, mainItem) > 0 ||
                        EnchantmentHelper.getItemEnchantmentLevel(ench, offhandItem) > 0) {
                    if (AFConfig.DEBUG_MODE.get()) {
                        LOGGER.info("Event canceled due to CURSE_OF_FALSE_BITE");
                    }
                    event.setCanceled(true);
                    return;
                }
            }
            var ench = getEnchantmentHolder(level, AFEnchantments.CURSE_OF_THE_ABYSS);
            if (level.random.nextInt(10) < 2 &&
                    (EnchantmentHelper.getItemEnchantmentLevel(ench, mainItem) > 0 ||
                    EnchantmentHelper.getItemEnchantmentLevel(ench, offhandItem) > 0)) {
                if (AFConfig.DEBUG_MODE.get()) {
                    LOGGER.info("Summon drowned near player {} due to CURSE_OF_THE_ABYSS", player.getScoreboardName());
                }

                var hook = event.getHookEntity();
                var drowned = EntityType.DROWNED.create(level, EntitySpawnReason.TRIGGERED);
                drowned.snapTo(hook.getX(), hook.getY(), hook.getZ());
                if (level instanceof ServerLevel serverLevel)
                ParticlesManager.spawnLavaFishingParticles(serverLevel,
                        hook.getX(), hook.getY(), hook.getZ(),
                        30,
                        0, 1, 0, 0);


                level.addFreshEntity(drowned);
            }

            ench = getEnchantmentHolder(level, AFEnchantments.CURSE_OF_SCORCHING_LINE);
            if (EnchantmentHelper.getItemEnchantmentLevel(ench, mainItem) > 0 ||
                    EnchantmentHelper.getItemEnchantmentLevel(ench, offhandItem) > 0) {
                if (AFConfig.DEBUG_MODE.get()) {
                    LOGGER.info("Ignite player {} due to CURSE_OF_SCORCHING_LINE", player.getScoreboardName());
                }
                player.igniteForSeconds(5);
            }
        }
    }

    public static Holder<Enchantment> getEnchantmentHolder(Level level, ResourceKey<Enchantment> key) {
        return level.registryAccess()
                .lookupOrThrow(Registries.ENCHANTMENT)
                .getOrThrow(key);
    }

}
