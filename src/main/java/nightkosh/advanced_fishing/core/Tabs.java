package nightkosh.advanced_fishing.core;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import nightkosh.advanced_fishing.api.EnumFishType;
import nightkosh.advanced_fishing.api.ModInfo;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@Mod.EventBusSubscriber(modid = ModInfo.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Tabs {

    public static CreativeModeTab ADVANCED_FISHING_TAB;

    @SubscribeEvent
    public static void registerTabs(CreativeModeTabEvent.Register event) {
        ADVANCED_FISHING_TAB = event.registerCreativeModeTab(
                ResourceLocation.fromNamespaceAndPath(ModInfo.ID, "advanced_fishing"),
                builder -> builder
                        .icon(() -> new ItemStack(Items.getFish(EnumFishType.GOLDEN_KOI)))
                        .title(Component.translatable("itemGroup." + ModInfo.ID))
                        .build()
        );
    }

    @SubscribeEvent
    public static void buildContents(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == ADVANCED_FISHING_TAB) {
            event.accept(Items.getBlazingFishingPole());

            for (var fishType : EnumFishType.values()) {
                event.accept(new ItemStack(Items.getFish(fishType)));
            }
        }
    }

}
