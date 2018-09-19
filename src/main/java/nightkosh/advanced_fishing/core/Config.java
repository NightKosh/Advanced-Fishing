package nightkosh.advanced_fishing.core;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Config {

    private final Configuration CONFIG;

    public static boolean overrideVanillaFishing;

    public Config(File configFile) {
        this.CONFIG = new Configuration(configFile);
    }

    public final void getConfigs() {
        CONFIG.load();

        overrideVanillaFishing = CONFIG.get(Configuration.CATEGORY_GENERAL, "OverrideVanillaFishing", true).getBoolean();

        CONFIG.save();
    }
}