package nightkosh.advanced_fishing.event;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.LootTableLoadEvent;
import nightkosh.advanced_fishing.api.ModInfo;
import nightkosh.advanced_fishing.core.AFConfig;
import nightkosh.advanced_fishing.core.LootTables;

import static nightkosh.advanced_fishing.ModAdvancedFishing.LOGGER;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@EventBusSubscriber(modid = ModInfo.ID, bus = EventBusSubscriber.Bus.GAME)
public class AFLootInjector {

    @SubscribeEvent
    public static void inject(LootTableLoadEvent event) {
        if (event.getName().toString().equals("minecraft:chests/nether_bridge")) {
            if (AFConfig.DEBUG_MODE.get()) {
                LOGGER.info("LootTableLoadEvent event triggered. Going to inject additional nether_bridge loot.");
            }

            event.getTable().addPool(
                    LootPool.lootPool()
                            .name("advanced_fishing_nether_bridge_inject")
                            .add(NestedLootTable.lootTableReference(
                                            ResourceKey.create(Registries.LOOT_TABLE, LootTables.INJECT_NETHER_BRIDGE))
                                    .setWeight(1))
                            .build());
        }
    }

}
