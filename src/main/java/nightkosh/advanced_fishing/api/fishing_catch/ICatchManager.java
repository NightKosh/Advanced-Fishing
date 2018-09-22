package nightkosh.advanced_fishing.api.fishing_catch;

import net.minecraft.block.Block;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public interface ICatchManager {

    public void addCatch(Block block, ICatch fishingCatch);

    public ICatch getCatch(Block block);
}
