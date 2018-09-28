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
    public List<ItemStack> getCatch(World world, BlockPos pos, float luck);
}
