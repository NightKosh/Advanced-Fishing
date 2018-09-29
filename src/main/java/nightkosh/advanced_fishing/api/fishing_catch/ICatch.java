package nightkosh.advanced_fishing.api.fishing_catch;

import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@FunctionalInterface
public interface ICatch {
    /**
     * Used to get a list of items which will be catched
     *
     * @param world World
     * @param pos position of fishing hook
     * @param luck player luck (fishing rod enchantment + luck potions effects)
     * @return list of items (only one random item will be catched)
     */
    public List<ItemStack> getCatch(World world, BlockPos pos, float luck);
}
