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
    /**
     * Used to know should "this" instance of IWaterCatch be used to get catch
     *
     * @param world World
     * @param pos position of fishing hook
     * @param biome biome at the position of fishing hook
     * @param biomeTypesList Set with biome types of the biome at the position of fishing hook
     * @param luck player luck (fishing rod enchantment + luck potions effects)
     * @return boolean value
     */
    public boolean shouldGetCatch(World world, BlockPos pos, Biome biome, Set<BiomeDictionary.Type> biomeTypesList, float luck);
}
