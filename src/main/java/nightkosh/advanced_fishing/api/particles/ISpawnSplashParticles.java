package nightkosh.advanced_fishing.api.particles;

import net.minecraft.world.WorldServer;

import java.util.Random;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@FunctionalInterface
public interface ISpawnSplashParticles {
    public void spawn(WorldServer world, Random rand, double x, double y, double z);
}
