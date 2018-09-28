package nightkosh.advanced_fishing.api.fishing_catch;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import java.util.Set;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@FunctionalInterface
public interface IWaterCondition {
    public boolean shouldGetCatch(World world, BlockPos pos, Biome biome, Set<BiomeDictionary.Type> biomeTypesList, float luck);
}
