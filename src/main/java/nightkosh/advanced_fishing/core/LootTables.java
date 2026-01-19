package nightkosh.advanced_fishing.core;

import net.minecraft.resources.Identifier;
import nightkosh.advanced_fishing.api.ModInfo;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class LootTables {

    public static final Identifier FISHING_VANILLA =
            fromNamespaceAndPath("minecraft", "gameplay/fishing");

    public static final Identifier FISHING_JUNK =
            fromNamespaceAndPath("minecraft", "gameplay/fishing/junk");

    public static final Identifier FISHING_TREASURE =
            fromNamespaceAndPath("minecraft", "gameplay/fishing/treasure");

    public static final Identifier FISHING = fromNamespaceAndPath(ModInfo.ID, "gameplay/fishing/fishing");

    public static final Identifier FISHING_SANDY = fromNamespaceAndPath(ModInfo.ID, "gameplay/fishing/sandy/fishing");

    public static final Identifier FISHING_SNOWY = fromNamespaceAndPath(ModInfo.ID, "gameplay/fishing/snowy/fishing");

    public static final Identifier FISHING_SWAMP = fromNamespaceAndPath(ModInfo.ID, "gameplay/fishing/swamp/fishing");

    public static final Identifier FISHING_JUNGLE = fromNamespaceAndPath(ModInfo.ID, "gameplay/fishing/jungle/fishing");

    public static final Identifier FISHING_OCEAN = fromNamespaceAndPath(ModInfo.ID, "gameplay/fishing/ocean/fishing");

    public static final Identifier FISHING_OCEAN_DEEP = fromNamespaceAndPath(ModInfo.ID, "gameplay/fishing/ocean_deep/fishing");

    public static final Identifier FISHING_BEACH = fromNamespaceAndPath(ModInfo.ID, "gameplay/fishing_beach");

    public static final Identifier FISHING_END = fromNamespaceAndPath(ModInfo.ID, "gameplay/fishing/end/fishing");

    public static final Identifier FISHING_MUSHROOM = fromNamespaceAndPath(ModInfo.ID, "gameplay/fishing/mushroom/fishing");

    public static final Identifier FISHING_CAVE_50 = fromNamespaceAndPath(ModInfo.ID, "gameplay/fishing/cave/50");
    public static final Identifier FISHING_CAVE_40 = fromNamespaceAndPath(ModInfo.ID, "gameplay/fishing/cave/40");
    public static final Identifier FISHING_CAVE_25 = fromNamespaceAndPath(ModInfo.ID, "gameplay/fishing/cave/25");

    public static final Identifier FISHING_LAVA = fromNamespaceAndPath(ModInfo.ID, "gameplay/fishing/lava/fishing");

    public static final Identifier FISHING_NETHER = fromNamespaceAndPath(ModInfo.ID, "gameplay/fishing/nether/fishing");
    public static final Identifier FISHING_NETHER_BASALT_DELTAS = fromNamespaceAndPath(ModInfo.ID, "gameplay/fishing/nether/basalt_deltas/fishing");
    public static final Identifier FISHING_NETHER_FORESTS = fromNamespaceAndPath(ModInfo.ID, "gameplay/fishing/nether/crimson_and_warped_forest/fishing");
    public static final Identifier FISHING_NETHER_WASTES = fromNamespaceAndPath(ModInfo.ID, "gameplay/fishing/nether/nether_wastes/fishing");
    public static final Identifier FISHING_NETHER_SOUL_SAND_VALLEY = fromNamespaceAndPath(ModInfo.ID, "gameplay/fishing/nether/soul_sand_valley/fishing");
    public static final Identifier FISHING_NETHER_TREASURE = fromNamespaceAndPath(ModInfo.ID, "gameplay/fishing/nether/treasure");

    public static final Identifier FISHING_DEAD = fromNamespaceAndPath(ModInfo.ID, "gameplay/fishing/dead/fishing");

    public static final Identifier INJECT_NETHER_BRIDGE = fromNamespaceAndPath(ModInfo.ID, "inject/nether_bridge");

}
