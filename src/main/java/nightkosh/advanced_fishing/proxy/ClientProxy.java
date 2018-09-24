package nightkosh.advanced_fishing.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderFish;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import nightkosh.advanced_fishing.entity.item.EntityFireproofItem;
import nightkosh.advanced_fishing.entity.projectile.EntityCustomFishHook;
import nightkosh.advanced_fishing.entity.projectile.EntityLavaFishHook;
import nightkosh.advanced_fishing.renderer.entity.item.RendererFireproofItem;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void registerMobsRenderers() {
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();

        RenderingRegistry.registerEntityRenderingHandler(EntityCustomFishHook.class, new RenderFish(renderManager));

        RenderingRegistry.registerEntityRenderingHandler(EntityLavaFishHook.class, new RenderFish(renderManager));

        RenderingRegistry.registerEntityRenderingHandler(EntityFireproofItem.class, new RendererFireproofItem(renderManager, Minecraft.getMinecraft().getRenderItem()));
    }
}
