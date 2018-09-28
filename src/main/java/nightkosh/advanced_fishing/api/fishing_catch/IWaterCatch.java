package nightkosh.advanced_fishing.api.fishing_catch;

import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import java.util.List;
import java.util.Set;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@FunctionalInterface
public interface IWaterCatch {
    public List<ItemStack> getCatch(World world, BlockPos pos, Biome biome, Set<BiomeDictionary.Type> biomeTypes, float luck);
}
