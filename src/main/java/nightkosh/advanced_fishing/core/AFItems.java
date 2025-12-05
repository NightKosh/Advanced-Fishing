package nightkosh.advanced_fishing.core;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import nightkosh.advanced_fishing.api.EnumFishType;
import nightkosh.advanced_fishing.api.ModInfo;
import nightkosh.advanced_fishing.item.ItemBlazingFishingPole;
import nightkosh.advanced_fishing.item.ItemFish;

import java.util.HashMap;
import java.util.Map;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AFItems {

    public static final DeferredRegister<Item> ITEMS_REGISTER =
            DeferredRegister.create(ForgeRegistries.ITEMS, ModInfo.ID);

    private static final RegistryObject<Item> BLAZING_FISHING_POLE = ITEMS_REGISTER.register("blazing_fishing_pole", ItemBlazingFishingPole::new);
    private static final Map<EnumFishType, RegistryObject<Item>> FISHES = new HashMap<>();

    static {
        for (var fishType : EnumFishType.values()) {
            FISHES.put(fishType, ITEMS_REGISTER.register(fishType.getName(), ItemFish::new));
        }
    }

    public static void register(IEventBus eventBus) {
        ITEMS_REGISTER.register(eventBus);
    }

    public static Item getFish(EnumFishType fishType) {
        return FISHES.get(fishType).get();
    }

    public static Item getBlazingFishingPole() {
        return BLAZING_FISHING_POLE.get();
    }

}
