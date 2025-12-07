package nightkosh.advanced_fishing.core;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import nightkosh.advanced_fishing.api.ModInfo;
import nightkosh.advanced_fishing.entity.projectile.AdvancedFishHook;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EventsHandler {

    private static final Logger LOGGER = LogManager.getLogger(ModInfo.ID);

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onEntityJoinLevel(EntityJoinLevelEvent event) {
        var entity = event.getEntity();

        if (AFConfig.DEBUG_MODE.get()) {
            LOGGER.info("EntityJoinLevelEvent triggered");
        }

        if (AFConfig.OVERRIDE_VANILLA_FISHING.get() &&
                entity instanceof FishingHook hook &&
                entity.getClass().equals(FishingHook.class)) {
            if (AFConfig.DEBUG_MODE.get()) {
                LOGGER.info("EntityJoinLevelEvent - this is a FishingHook entity");
            }
            var level = event.getLevel();
            if (!level.isClientSide()) {
                var player = hook.getPlayerOwner();
                if (player != null) {
                    if (AFConfig.DEBUG_MODE.get()) {
                        LOGGER.info("EntityJoinLevelEvent - everything ok, hook will be replaced");
                    }
                    var fishingPole = player.getItemInHand(InteractionHand.MAIN_HAND);
                    if (fishingPole.getItem() != Items.FISHING_ROD) {
                        fishingPole = player.getItemInHand(InteractionHand.OFF_HAND);
                    }
                    entity.discard();

                    level.addFreshEntity(new AdvancedFishHook(player, level,
                            EnchantmentHelper.getFishingLuckBonus(fishingPole),
                            EnchantmentHelper.getFishingSpeedBonus(fishingPole)));

                    event.setCanceled(true);
                }
            }
        }
    }

}
