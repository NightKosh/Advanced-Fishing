package nightkosh.advanced_fishing.api.particles;

import net.minecraft.block.Block;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public interface IParticlesManager {

    public void addSplashParticles(Block block, ISpawnSplashParticles particles);

    public ISpawnSplashParticles getSplashParticles(Block block);

    public void addBubbleParticles(Block block, ISpawnBubbleParticles particles) ;

    public ISpawnBubbleParticles getBubbleParticles(Block block);

    public void addWakeParticles(Block block, ISpawnWakeParticles particles);

    public ISpawnWakeParticles getWakeParticles(Block block);

}
