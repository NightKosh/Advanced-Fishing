package nightkosh.advanced_fishing.core;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
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
        if (level.random.nextInt(10) < 3) {
            var ench = getEnchantmentHolder(level, AFEnchantments.CURSE_OF_FALSE_BITE);
            var mainItem = player.getMainHandItem();
            var offhandItem = player.getOffhandItem();
            if (EnchantmentHelper.getItemEnchantmentLevel(ench, mainItem) > 0 ||
                    EnchantmentHelper.getItemEnchantmentLevel(ench, offhandItem) > 0) {
                if (AFConfig.DEBUG_MODE.get()) {
                    LOGGER.info("Event canceled due to CURSE_OF_FALSE_BITE");
                }
                event.setCanceled(true);
            }
        }
    }

    public static Holder<Enchantment> getEnchantmentHolder(Level level, ResourceKey<Enchantment> key) {
        return level.registryAccess()
                .lookupOrThrow(Registries.ENCHANTMENT)
                .getOrThrow(key);
    }

}
