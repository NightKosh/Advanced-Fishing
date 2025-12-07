package nightkosh.advanced_fishing.api.fishing_catch;

import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;

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
     * @param biomeHolder biome holder at the position of fishing hook
     * @return boolean value
     */
    boolean shouldGetCatch(Holder<Biome> biomeHolder);

}
