package nightkosh.advanced_fishing.event;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.player.ItemFishedEvent;
import nightkosh.advanced_fishing.api.ModInfo;
import nightkosh.advanced_fishing.core.AFConfig;
import nightkosh.advanced_fishing.core.AFEnchantmentHelper;
import nightkosh.advanced_fishing.core.AFEnchantments;
import nightkosh.advanced_fishing.entity.projectile.AdvancedFishHook;
import nightkosh.advanced_fishing.entity.projectile.LavaFishHook;

import static nightkosh.advanced_fishing.ModAdvancedFishing.LOGGER;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@EventBusSubscriber(modid = ModInfo.ID)
public class AFEventsHandler {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onEntityJoinLevel(EntityJoinLevelEvent event) {
        var entity = event.getEntity();

        if (AFConfig.OVERRIDE_VANILLA_FISHING.get() &&
                entity instanceof FishingHook hook &&
                entity.getClass().equals(FishingHook.class)) {
            if (AFConfig.DEBUG_MODE.get()) {
                LOGGER.info("EntityJoinLevelEvent triggered with FishingHook entity");
            }
            var level = event.getLevel();
            if (!level.isClientSide() && level instanceof ServerLevel serverlevel) {
                var player = hook.getPlayerOwner();
                if (player != null) {
                    if (AFConfig.DEBUG_MODE.get()) {
                        LOGGER.info("EntityJoinLevelEvent - everything is ok, hook should be replaced");
                    }
                    var fishingPole = player.getItemInHand(InteractionHand.MAIN_HAND);
                    if (fishingPole.getItem() != Items.FISHING_ROD) {
                        fishingPole = player.getItemInHand(InteractionHand.OFF_HAND);
                    }
                    entity.discard();

                    var newHook = AFEnchantmentHelper.isEnchanted(level, AFEnchantments.INFERNAL_LINE, fishingPole) ?
                            new LavaFishHook(player, level,
                                    EnchantmentHelper.getFishingLuckBonus(serverlevel, fishingPole, player),
                                    (int) EnchantmentHelper.getFishingTimeReduction(serverlevel, fishingPole, player) * 20,
                                    AFEnchantmentHelper.isEnchanted(level, AFEnchantments.LUMINOUS_FLOAT, fishingPole)) :
                            new AdvancedFishHook(player, level,
                                    EnchantmentHelper.getFishingLuckBonus(serverlevel, fishingPole, player),
                                    (int) EnchantmentHelper.getFishingTimeReduction(serverlevel, fishingPole, player) * 20,
                                    AFEnchantmentHelper.isEnchanted(level, AFEnchantments.LUMINOUS_FLOAT, fishingPole));

                    level.addFreshEntity(newHook);

                    event.setCanceled(true);
                }
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onItemFishedEvent(ItemFishedEvent event) {
        if (AFConfig.DEBUG_MODE.get()) {
            LOGGER.info("ItemFishedEvent triggered for player {}", event.getEntity().getScoreboardName());
        }
        AFEnchantmentHelper.applyItemFishedEventEffect(event, event.getEntity().level(), event.getEntity());
    }

}
