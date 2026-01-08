package nightkosh.advanced_fishing.api.fishing_catch;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public interface ICatchManager {

    /**
     * Add catch handler for custom block of liquid
     *
     * @param block        block of liquid
     * @param fishingCatch instance of ICatch functional interface
     */
    void addCatch(Block block, ICatch fishingCatch);

    /**
     * Add catch handler for fishing in water with custom "conditions",
     * such as specific biome type, or anything else.
     * <p>
     * <p>
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!! WARNING !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * <p>
     * Please be careful with your "conditions" - do not override already existed one
     * only one "condition" will be used ot get fishing catch, so try not to break already existed logic
     * <p>
     * If you'd like to change catch for already existed "conditions" - modify loot tables instead
     *
     * @param condition  instance of IWaterCondition functional interface
     * @param waterCatch instance of IWaterCatch functional interface
     */
    void addWaterCatch(IWaterCondition condition, IWaterCatch waterCatch);

    /**
     * Gives you an instance of ICatch functional interface
     * so you will be able to use this mod fishing logic to get fishing catch in any way you want
     *
     * @param level level
     * @param pos position of bobber
     * @param block block of liquid
     * @return instance of ICatch functional interface
     */
    ICatch getICatch(Level level, BlockPos pos, Block block);

}
