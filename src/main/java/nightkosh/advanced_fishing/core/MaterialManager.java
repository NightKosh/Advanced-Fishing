package nightkosh.advanced_fishing.core;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import nightkosh.advanced_fishing.api.material.IMaterialManager;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class MaterialManager implements IMaterialManager {

    public static final MaterialManager INSTANCE = new MaterialManager();

    public static final Set<Block> MATERIAL_SET = new HashSet<>();

    static {
        MATERIAL_SET.addAll(List.of(Blocks.WATER, Blocks.LAVA));
    }

    @Override
    public void addMaterial(Block material) {
        MATERIAL_SET.add(material);
    }

}
