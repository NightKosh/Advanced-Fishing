package nightkosh.advanced_fishing.api.particles;

import net.minecraft.server.level.ServerLevel;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@FunctionalInterface
public interface ISpawnBubbleParticles {

    void spawn(ServerLevel level,
               double x, double y, double z,
               int num,
               double xOffset, double yOffset, double zOffset,
               double speed);

}
