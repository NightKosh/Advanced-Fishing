package nightkosh.advanced_fishing.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;
import nightkosh.advanced_fishing.api.ModInfo;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AFEnchantments {

    public static final ResourceKey<Enchantment> CURSE_OF_FALSE_BITE =
            ResourceKey.create(Registries.ENCHANTMENT, fromNamespaceAndPath(ModInfo.ID, "curse_of_false_bite"));

}
