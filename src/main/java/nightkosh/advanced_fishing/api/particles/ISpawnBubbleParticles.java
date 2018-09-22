package nightkosh.advanced_fishing.api.particles;

import net.minecraft.world.WorldServer;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@FunctionalInterface
public interface ISpawnBubbleParticles {
    public void spawn(WorldServer world, double x, double y, double z, int num, double xOffset, double yOffset, double zOffset, double speed);
}
