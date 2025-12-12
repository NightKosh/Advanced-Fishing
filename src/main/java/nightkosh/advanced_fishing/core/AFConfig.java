package nightkosh.advanced_fishing.core;

import net.neoforged.neoforge.common.ModConfigSpec;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AFConfig {

    public static final ModConfigSpec SPEC;
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static ModConfigSpec.ConfigValue<Boolean> OVERRIDE_VANILLA_FISHING;
    public static ModConfigSpec.ConfigValue<Boolean> DEBUG_MODE;

    static {
        BUILDER.push("Configs for Advanced Fishing Mod");

        OVERRIDE_VANILLA_FISHING = BUILDER.comment("Override vanilla fishing by mod")
                .define("Override Vanilla Fishing", true);

        DEBUG_MODE = BUILDER.comment("Enable debug mode for additional dev logs")
                .define("Debug Mode", false);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }

}