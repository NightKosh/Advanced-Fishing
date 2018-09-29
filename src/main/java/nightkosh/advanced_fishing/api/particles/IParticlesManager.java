package nightkosh.advanced_fishing.api.particles;

import net.minecraft.block.Block;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public interface IParticlesManager {

    /**
     * Used to add custom splash particles for your liquid
     *
     * @param block block of liquid
     * @param particles an instance of Functional Interface, which used to spawn splash particles
     */
    public void addSplashParticles(Block block, ISpawnSplashParticles particles);

    /**
     * Gives you an instance of Functional Interface, which used to spawn splash particles for liquid
     *
     * @param block block of liquid
     */
    public ISpawnSplashParticles getSplashParticles(Block block);

    /**
     * Used to add custom bubble particles for your liquid
     *
     * @param block block of liquid
     * @param particles an instance of Functional Interface, which used to spawn bubble particles
     */
    public void addBubbleParticles(Block block, ISpawnBubbleParticles particles) ;

    /**
     * Gives you an instance of Functional Interface, which used to spawn splash bubble for liquid
     *
     * @param block block of liquid
     */
    public ISpawnBubbleParticles getBubbleParticles(Block block);

    /**
     * Used to add custom wake particles for your liquid
     *
     * @param block block of liquid
     * @param particles an instance of Functional Interface, which used to spawn wake particles
     */
    public void addWakeParticles(Block block, ISpawnWakeParticles particles);

    /**
     * Gives you an instance of Functional Interface, which used to spawn wake particles for liquid
     *
     * @param block block of liquid
     */
    public ISpawnWakeParticles getWakeParticles(Block block);

}
