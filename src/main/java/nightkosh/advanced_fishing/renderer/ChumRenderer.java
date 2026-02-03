package nightkosh.advanced_fishing.renderer;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.FishingHookRenderer;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.entity.state.FishingHookRenderState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.projectile.FishingHook;
import nightkosh.advanced_fishing.entity.Chum;
import nightkosh.advanced_fishing.entity.projectile.AFishHook;

import javax.annotation.Nonnull;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ChumRenderer extends EntityRenderer<Chum, EntityRenderState> {

    public ChumRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public EntityRenderState createRenderState() {
        return new EntityRenderState();
    }

}
