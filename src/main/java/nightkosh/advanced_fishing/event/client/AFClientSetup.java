package nightkosh.advanced_fishing.event.client;

import net.minecraft.client.renderer.entity.ItemEntityRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import nightkosh.advanced_fishing.api.ModInfo;
import nightkosh.advanced_fishing.core.AFEntities;
import nightkosh.advanced_fishing.renderer.AFFishingHookRenderer;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@EventBusSubscriber(modid = ModInfo.ID, value = Dist.CLIENT)
public class AFClientSetup {

    @SubscribeEvent
    public static void entityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(AFEntities.getCustomFishHook(), AFFishingHookRenderer::new);
        event.registerEntityRenderer(AFEntities.getLavaFishHook(), AFFishingHookRenderer::new);
        event.registerEntityRenderer(AFEntities.getFireproofItem(), ItemEntityRenderer::new);
    }

}
