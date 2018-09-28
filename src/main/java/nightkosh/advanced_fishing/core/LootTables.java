package nightkosh.advanced_fishing.core;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraftforge.event.LootTableLoadEvent;
import nightkosh.advanced_fishing.api.ModInfo;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class LootTables {

    public static final ResourceLocation FISHING = new ResourceLocation(ModInfo.ID, "gameplay/fishing");
    public static final ResourceLocation FISHING_TIER1 = new ResourceLocation(ModInfo.ID, "gameplay/fishing/tier_1");
    public static final ResourceLocation FISHING_TIER2 = new ResourceLocation(ModInfo.ID, "gameplay/fishing/tier_2");
    public static final ResourceLocation FISHING_TIER3 = new ResourceLocation(ModInfo.ID, "gameplay/fishing/tier_3");
    public static final ResourceLocation FISHING_TIER4 = new ResourceLocation(ModInfo.ID, "gameplay/fishing/tier_4");

    public static final ResourceLocation FISHING_SANDY = new ResourceLocation(ModInfo.ID, "gameplay/fishing_sandy");
    public static final ResourceLocation FISHING_SANDY_TIER2 = new ResourceLocation(ModInfo.ID, "gameplay/fishing/sandy/tier_2");
    public static final ResourceLocation FISHING_SANDY_TIER3 = new ResourceLocation(ModInfo.ID, "gameplay/fishing/sandy/tier_3");
    public static final ResourceLocation FISHING_SANDY_TIER4 = new ResourceLocation(ModInfo.ID, "gameplay/fishing/sandy/tier_4");

    public static final ResourceLocation FISHING_SNOWY = new ResourceLocation(ModInfo.ID, "gameplay/fishing_snowy");
    public static final ResourceLocation FISHING_SNOWY_TIER2 = new ResourceLocation(ModInfo.ID, "gameplay/fishing/snowy/tier_2");
    public static final ResourceLocation FISHING_SNOWY_TIER3 = new ResourceLocation(ModInfo.ID, "gameplay/fishing/snowy/tier_3");
    public static final ResourceLocation FISHING_SNOWY_TIER4 = new ResourceLocation(ModInfo.ID, "gameplay/fishing/snowy/tier_4");

    public static final ResourceLocation FISHING_SWAMP = new ResourceLocation(ModInfo.ID, "gameplay/fishing_swamp");
    public static final ResourceLocation FISHING_SWAMP_TIER2 = new ResourceLocation(ModInfo.ID, "gameplay/fishing/swamp/tier_2");
    public static final ResourceLocation FISHING_SWAMP_TIER3 = new ResourceLocation(ModInfo.ID, "gameplay/fishing/swamp/tier_3");
    public static final ResourceLocation FISHING_SWAMP_TIER4 = new ResourceLocation(ModInfo.ID, "gameplay/fishing/swamp/tier_4");

    public static final ResourceLocation FISHING_JUNGLE = new ResourceLocation(ModInfo.ID, "gameplay/fishing_jungle");
    public static final ResourceLocation FISHING_JUNGLE_TIER2 = new ResourceLocation(ModInfo.ID, "gameplay/fishing/jungle/tier_2");
    public static final ResourceLocation FISHING_JUNGLE_TIER3 = new ResourceLocation(ModInfo.ID, "gameplay/fishing/jungle/tier_3");
    public static final ResourceLocation FISHING_JUNGLE_TIER4 = new ResourceLocation(ModInfo.ID, "gameplay/fishing/jungle/tier_4");

    public static final ResourceLocation FISHING_OCEAN_AND_BEACH = new ResourceLocation(ModInfo.ID, "gameplay/fishing_ocean_and_beach");
    public static final ResourceLocation FISHING_OCEAN_AND_BEACH_TIER1 = new ResourceLocation(ModInfo.ID, "gameplay/fishing/ocean_and_beach/tier_1");
    public static final ResourceLocation FISHING_OCEAN_AND_BEACH_TIER2 = new ResourceLocation(ModInfo.ID, "gameplay/fishing/ocean_and_beach/tier_2");
    public static final ResourceLocation FISHING_OCEAN_AND_BEACH_TIER3 = new ResourceLocation(ModInfo.ID, "gameplay/fishing/ocean_and_beach/tier_3");
    public static final ResourceLocation FISHING_OCEAN_AND_BEACH_TIER4 = new ResourceLocation(ModInfo.ID, "gameplay/fishing/ocean_and_beach/tier_4");

    public static final ResourceLocation FISHING_END = new ResourceLocation(ModInfo.ID, "gameplay/fishing_end");
    public static final ResourceLocation FISHING_END_TIER1 = new ResourceLocation(ModInfo.ID, "gameplay/fishing/end/tier_1");
    public static final ResourceLocation FISHING_END_TIER2 = new ResourceLocation(ModInfo.ID, "gameplay/fishing/end/tier_2");
    public static final ResourceLocation FISHING_END_TIER3 = new ResourceLocation(ModInfo.ID, "gameplay/fishing/end/tier_3");

    public static final ResourceLocation FISHING_MUSHROOM = new ResourceLocation(ModInfo.ID, "gameplay/fishing_mushroom");
    public static final ResourceLocation FISHING_MUSHROOM_TIER3 = new ResourceLocation(ModInfo.ID, "gameplay/fishing/mushroom/tier_3");

    public static final ResourceLocation FISHING_CAVE_50 = new ResourceLocation(ModInfo.ID, "gameplay/fishing/cave/50");
    public static final ResourceLocation FISHING_CAVE_40 = new ResourceLocation(ModInfo.ID, "gameplay/fishing/cave/40");
    public static final ResourceLocation FISHING_CAVE_25 = new ResourceLocation(ModInfo.ID, "gameplay/fishing/cave/25");

    public static final ResourceLocation FISHING_LAVA = new ResourceLocation(ModInfo.ID, "gameplay/fishing_lava");
    public static final ResourceLocation FISHING_LAVA_TIER1 = new ResourceLocation(ModInfo.ID, "gameplay/fishing_lava/tier_1");
    public static final ResourceLocation FISHING_LAVA_TIER2 = new ResourceLocation(ModInfo.ID, "gameplay/fishing_lava/tier_2");
    public static final ResourceLocation FISHING_LAVA_TREASURE = new ResourceLocation(ModInfo.ID, "gameplay/fishing_lava/treasure");

    public static final ResourceLocation FISHING_LAVA_NETHER = new ResourceLocation(ModInfo.ID, "gameplay/fishing_lava_nether");
    public static final ResourceLocation FISHING_LAVA_NETHER_TIER1 = new ResourceLocation(ModInfo.ID, "gameplay/fishing_lava_nether/tier_1");
    public static final ResourceLocation FISHING_LAVA_NETHER_TIER2 = new ResourceLocation(ModInfo.ID, "gameplay/fishing_lava_nether/tier_2");
    public static final ResourceLocation FISHING_LAVA_NETHER_TIER3 = new ResourceLocation(ModInfo.ID, "gameplay/fishing_lava_nether/tier_3");
    public static final ResourceLocation FISHING_LAVA_NETHER_TREASURE = new ResourceLocation(ModInfo.ID, "gameplay/fishing_lava_nether/treasure");

    public static void registration() {
        LootTableList.register(FISHING);
        LootTableList.register(FISHING_TIER1);
        LootTableList.register(FISHING_TIER2);
        LootTableList.register(FISHING_TIER3);
        LootTableList.register(FISHING_TIER4);

        LootTableList.register(FISHING_SANDY);
        LootTableList.register(FISHING_SANDY_TIER2);
        LootTableList.register(FISHING_SANDY_TIER3);
        LootTableList.register(FISHING_SANDY_TIER4);

        LootTableList.register(FISHING_SNOWY);
        LootTableList.register(FISHING_SNOWY_TIER2);
        LootTableList.register(FISHING_SNOWY_TIER3);
        LootTableList.register(FISHING_SNOWY_TIER4);

        LootTableList.register(FISHING_SWAMP);
        LootTableList.register(FISHING_SWAMP_TIER2);
        LootTableList.register(FISHING_SWAMP_TIER3);
        LootTableList.register(FISHING_SWAMP_TIER4);

        LootTableList.register(FISHING_JUNGLE);
        LootTableList.register(FISHING_JUNGLE_TIER2);
        LootTableList.register(FISHING_JUNGLE_TIER3);
        LootTableList.register(FISHING_JUNGLE_TIER4);

        LootTableList.register(FISHING_OCEAN_AND_BEACH);
        LootTableList.register(FISHING_OCEAN_AND_BEACH_TIER1);
        LootTableList.register(FISHING_OCEAN_AND_BEACH_TIER2);
        LootTableList.register(FISHING_OCEAN_AND_BEACH_TIER3);
        LootTableList.register(FISHING_OCEAN_AND_BEACH_TIER4);

        LootTableList.register(FISHING_END);
        LootTableList.register(FISHING_END_TIER1);
        LootTableList.register(FISHING_END_TIER2);
        LootTableList.register(FISHING_END_TIER3);

        LootTableList.register(FISHING_MUSHROOM);
        LootTableList.register(FISHING_MUSHROOM_TIER3);

        LootTableList.register(FISHING_CAVE_50);
        LootTableList.register(FISHING_CAVE_40);
        LootTableList.register(FISHING_CAVE_25);

        LootTableList.register(FISHING_LAVA);
        LootTableList.register(FISHING_LAVA_TIER1);
        LootTableList.register(FISHING_LAVA_TIER2);
        LootTableList.register(FISHING_LAVA_TREASURE);

        LootTableList.register(FISHING_LAVA_NETHER);
        LootTableList.register(FISHING_LAVA_NETHER_TIER1);
        LootTableList.register(FISHING_LAVA_NETHER_TIER2);
        LootTableList.register(FISHING_LAVA_NETHER_TIER3);
        LootTableList.register(FISHING_LAVA_NETHER_TREASURE);
    }

    public static void inject(LootTableLoadEvent event) {
        if (event.getName().toString().equals("minecraft:chests/nether_bridge")) {
            LootEntry entry = new LootEntryTable(new ResourceLocation(ModInfo.ID, "inject/nether_bridge"), 1, 1, new LootCondition[0], "nether_bridge_blazing_fishing_pole");
            LootPool pool = new LootPool(new LootEntry[]{entry}, new LootCondition[]{}, new RandomValueRange(1, 1), new RandomValueRange(0, 0), "nether_bridge_blazing_fishing_pole");
            event.getTable().addPool(pool);
        }
    }
}
