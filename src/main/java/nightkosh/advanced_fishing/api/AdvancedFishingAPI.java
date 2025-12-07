package nightkosh.advanced_fishing.api;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import nightkosh.advanced_fishing.api.fishing_catch.ICatchManager;
import nightkosh.advanced_fishing.api.material.IMaterialManager;
import nightkosh.advanced_fishing.api.particles.IParticlesManager;

import javax.annotation.Nullable;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AdvancedFishingAPI {

    @Nullable
    public static IParticlesManager PARTICLES_MANAGER;

    @Nullable
    public static ICatchManager CATCH_MANAGER;

    @Nullable
    public static IMaterialManager MATERIAL_MANAGER;

    @Nullable
    public static Item FISH_ITEM;

    @Nullable
    public static CreativeModeTab FISH_TAB;

}
