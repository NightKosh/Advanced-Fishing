package nightkosh.advanced_fishing.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import nightkosh.advanced_fishing.api.EnumFishType;
import nightkosh.advanced_fishing.api.ModInfo;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AFTabs {

    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ModInfo.ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ADVANCED_FISHING_TAB =
            TABS.register("advanced_fishing", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(AFItems.getFish(EnumFishType.GOLDEN_KOI)))
                    .title(Component.translatable("itemGroup." + ModInfo.ID))
                    .displayItems((parameters, output) -> {
                        output.accept(AFItems.getBlazingFishingPole());

                        for (var fishType : EnumFishType.values()) {
                            output.accept(new ItemStack(AFItems.getFish(fishType)));
                        }

                        output.accept(AFItems.COOKED_PIKE.get());
                        output.accept(AFItems.COOKED_CATFISH.get());
                        output.accept(AFItems.COOKED_CRUCIAN.get());
                        output.accept(AFItems.COOKED_EEL.get());
                        output.accept(AFItems.COOKED_KOI.get());

                    })
                    .build()
            );

    public static void register(IEventBus modEventBus) {
        TABS.register(modEventBus);
    }

}
