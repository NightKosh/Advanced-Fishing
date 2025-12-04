package nightkosh.advanced_fishing.core;

import net.minecraftforge.common.ForgeConfigSpec;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Config {

    public static final ForgeConfigSpec SPEC;
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static ForgeConfigSpec.ConfigValue<Boolean> OVERRIDE_VANILLA_FISHING;
    public static ForgeConfigSpec.ConfigValue<Boolean> DEBUG_MODE;

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