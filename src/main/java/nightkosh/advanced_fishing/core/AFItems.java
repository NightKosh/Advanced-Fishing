package nightkosh.advanced_fishing.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import nightkosh.advanced_fishing.api.EnumFishType;
import nightkosh.advanced_fishing.api.ModInfo;
import nightkosh.advanced_fishing.item.ItemBlazingFishingRod;
import nightkosh.advanced_fishing.item.ItemFish;

import java.util.HashMap;
import java.util.Map;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AFItems {

    public static final DeferredRegister<Item> ITEMS_REGISTER =
            DeferredRegister.create(Registries.ITEM, ModInfo.ID);

    private static final DeferredHolder<Item, ItemBlazingFishingRod> BLAZING_FISHING_POLE =
            ITEMS_REGISTER.register("blazing_fishing_pole", ItemBlazingFishingRod::new);

    // fish
    private static final Map<EnumFishType, DeferredHolder<Item, ItemFish>> FISHES = new HashMap<>();

    static {
        for (var fishType : EnumFishType.values()) {
            FISHES.put(fishType, ITEMS_REGISTER.register(fishType.getName(), () -> new ItemFish(fishType, new Item.Properties()
                    .stacksTo(64)
                    .rarity(fishType.getRarity())
                    .setId(ResourceKey.create(Registries.ITEM, fromNamespaceAndPath(ModInfo.ID, fishType.getName())))
                    .food(new FoodProperties.Builder()
                            .nutrition(fishType.getHealAmount())
                            .saturationModifier(fishType.getSaturationModifier())
                            .build()))));
        }
    }

    // cooked fish
    public static final DeferredHolder<Item, Item> COOKED_PIKE =
            ITEMS_REGISTER.register("cooked_pike", () -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, fromNamespaceAndPath(ModInfo.ID, "cooked_pike")))
                    .food(new FoodProperties.Builder()
                            .nutrition(8)
                            .saturationModifier(0.7F)//11.2
                            .build())));

    public static final DeferredHolder<Item, Item> COOKED_CATFISH =
            ITEMS_REGISTER.register("cooked_catfish", () -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, fromNamespaceAndPath(ModInfo.ID, "cooked_catfish")))
                    .food(new FoodProperties.Builder()
                            .nutrition(15)
                            .saturationModifier(0.2F)//6
                            .build())));

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
