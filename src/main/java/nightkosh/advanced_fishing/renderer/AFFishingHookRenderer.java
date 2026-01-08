package nightkosh.advanced_fishing.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.FishingHookRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.projectile.FishingHook;
import nightkosh.advanced_fishing.entity.projectile.AbstractFishHook;

import javax.annotation.Nonnull;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AFFishingHookRenderer extends FishingHookRenderer {

    public AFFishingHookRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected int getBlockLightLevel(FishingHook hook, @Nonnull BlockPos pos) {
        if (hook instanceof AbstractFishHook afHook && afHook.hasGlowingEnchantment()) {
            return 15;
        } else {
            return super.getBlockLightLevel(hook, pos);
        }
    }

}
