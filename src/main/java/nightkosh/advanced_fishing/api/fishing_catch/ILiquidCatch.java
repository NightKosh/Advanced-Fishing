package nightkosh.advanced_fishing.api.fishing_catch;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.storage.loot.LootParams;

import java.util.List;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@FunctionalInterface
public interface ILiquidCatch {

    /**
     * Used to get list of items which will be caught in water
     *
     * @param lootBuilder loot builder
     * @param level       Level
     * @param biomeHolder biome holder at the position of fishing hook
     * @param luck        player luck (fishing rod enchantment + luck potions effects)
     * @return list of items (only one random item will be caught)
     */
    List<ItemStack> getCatch(LootParams.Builder lootBuilder, Level level, Holder<Biome> biomeHolder, float luck);

}
