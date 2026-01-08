package nightkosh.advanced_fishing.core;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import nightkosh.advanced_fishing.api.particles.IParticlesManager;
import nightkosh.advanced_fishing.api.particles.ISpawnBubbleParticles;
import nightkosh.advanced_fishing.api.particles.ISpawnSplashParticles;
import nightkosh.advanced_fishing.api.particles.ISpawnWakeParticles;

import java.util.HashMap;
import java.util.Map;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ParticlesManager implements IParticlesManager {

    public static final ParticlesManager INSTANCE = new ParticlesManager();

    private static final Map<Block, ISpawnSplashParticles> SPLASH_PARTICLES = new HashMap<>();
    private static final Map<Block, ISpawnBubbleParticles> BUBBLE_PARTICLES = new HashMap<>();
    private static final Map<Block, ISpawnWakeParticles> FISHING_PARTICLES = new HashMap<>();

    static {
        SPLASH_PARTICLES.put(Blocks.WATER, ParticlesManager::spawnWaterSplashParticles);
        SPLASH_PARTICLES.put(Blocks.LAVA, ParticlesManager::spawnLavaSplashParticles);

        BUBBLE_PARTICLES.put(Blocks.WATER, ParticlesManager::spawnWaterBubbleParticles);
        BUBBLE_PARTICLES.put(Blocks.LAVA, ParticlesManager::spawnLavaBubbleParticles);

        FISHING_PARTICLES.put(Blocks.WATER, ParticlesManager::spawnWaterFishingParticles);
        FISHING_PARTICLES.put(Blocks.LAVA, ParticlesManager::spawnLavaFishingParticles);
    }

    @Override
    public void addSplashParticles(Block block, ISpawnSplashParticles particles) {
        SPLASH_PARTICLES.put(block, particles);
    }

    @Override
    public ISpawnSplashParticles getSplashParticles(Block block) {
        return SPLASH_PARTICLES.getOrDefault(block, ParticlesManager::spawnWaterSplashParticles);
    }

    @Override
    public void addBubbleParticles(Block block, ISpawnBubbleParticles particles) {
        BUBBLE_PARTICLES.put(block, particles);
    }

    @Override
    public ISpawnBubbleParticles getBubbleParticles(Block block) {
        return BUBBLE_PARTICLES.getOrDefault(block, ParticlesManager::spawnWaterBubbleParticles);
    }

    @Override
    public void addWakeParticles(Block block, ISpawnWakeParticles particles) {
        FISHING_PARTICLES.put(block, particles);
    }

    @Override
    public ISpawnWakeParticles getFishingParticles(Block block) {
        return FISHING_PARTICLES.getOrDefault(block, ParticlesManager::spawnWaterFishingParticles);
    }

    private static void spawnWaterSplashParticles(
            ServerLevel level,
            double x, double y, double z,
            int num,
            double xOffset, double yOffset, double zOffset,
            double speed) {
        level.sendParticles(ParticleTypes.SPLASH,
                x, y, z,
                num,
                xOffset, yOffset, zOffset,
                speed);
    }

    private static void spawnLavaSplashParticles(
            ServerLevel level,
            double x, double y, double z,
            int num,
            double xOffset, double yOffset, double zOffset,
            double speed) {
        level.sendParticles(ParticleTypes.SMOKE,
                x, y, z,
                num,
                xOffset, yOffset, zOffset,
                speed);
        level.sendParticles(ParticleTypes.LAVA,
                x, y, z,
                num,
                xOffset, yOffset, zOffset,
                speed);
    }

    private static void spawnWaterBubbleParticles(
            ServerLevel level,
            double x, double y, double z,
            int num,
            double xOffset, double yOffset, double zOffset,
            double speed) {
        level.sendParticles(ParticleTypes.BUBBLE,
                x, y, z,
                num,
                xOffset, yOffset, zOffset,
                speed);
    }

    private static void spawnLavaBubbleParticles(
            ServerLevel level,
            double x, double y, double z,
            int num,
            double xOffset, double yOffset, double zOffset,
            double speed) {
        level.sendParticles(ParticleTypes.SMOKE,
                x, y, z,
                num,
                xOffset, yOffset, zOffset,
                speed);
    }

    private static void spawnWaterFishingParticles(
            ServerLevel level,
            double x, double y, double z,
            int num,
            double xOffset, double yOffset, double zOffset,
            double speed) {
        level.sendParticles(ParticleTypes.FISHING,
                x, y, z,
                num,
                xOffset, yOffset, zOffset,
                speed);
    }

    public static void spawnLavaFishingParticles(
            ServerLevel level,
            double x, double y, double z,
            int num,
            double xOffset, double yOffset, double zOffset,
            double speed) {
        level.sendParticles(ParticleTypes.LARGE_SMOKE,
                x, y, z,
                num,
                xOffset, yOffset, zOffset,
                speed);
        level.sendParticles(ParticleTypes.LAVA,
                x, y, z,
                num,
                xOffset, yOffset, zOffset,
                speed);
    }

    public static void spawnFireFlies(
            ServerLevel level,
            double x, double y, double z,
            int num,
            double xOffset, double yOffset, double zOffset,
            double speed) {
        level.sendParticles(ParticleTypes.FIREFLY,
                x, y, z,
                num,
                xOffset, yOffset, zOffset,
                speed);
    }

}
