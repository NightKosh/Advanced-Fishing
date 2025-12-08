package nightkosh.advanced_fishing.event.client;

import net.minecraft.client.renderer.entity.FishingHookRenderer;
import net.minecraft.client.renderer.entity.ItemEntityRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import nightkosh.advanced_fishing.api.ModInfo;
import nightkosh.advanced_fishing.core.AFEntities;
import nightkosh.advanced_fishing.core.AFItems;
import nightkosh.advanced_fishing.item.ItemBlazingFishingRod;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@Mod.EventBusSubscriber(modid = ModInfo.ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AFClientSetup {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> ItemProperties.register(
                AFItems.getBlazingFishingPole(),
                ResourceLocation.parse("cast"),
                (stack, level, entity, seed) -> {
                    if (entity == null) {
                        return 0;
                    }

                    boolean main = entity.getMainHandItem() == stack;
                    boolean off = entity.getOffhandItem() == stack;
                    if (entity.getMainHandItem().getItem() instanceof ItemBlazingFishingRod) {
                        off = false;
                    }
                    if ((main || off) && entity instanceof Player player && player.fishing != null) {
                        return 1;
                    }

                    return 0;
                }
        ));
    }

    @SubscribeEvent
    public static void entityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(AFEntities.getCustomFishHook(), FishingHookRenderer::new);
        event.registerEntityRenderer(AFEntities.getLavaFishHook(), FishingHookRenderer::new);
        event.registerEntityRenderer(AFEntities.getFireproofItem(), ItemEntityRenderer::new);
    }

}
