package nightkosh.advanced_fishing.core;

import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import nightkosh.advanced_fishing.api.ModInfo;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AFAdvancements {

    public static final Identifier ROOT = fromNamespaceAndPath(ModInfo.ID, "root");

    public static final Identifier FEEDING_FRENZY = fromNamespaceAndPath(ModInfo.ID, "feeding_frenzy");
    public static final Identifier LUMINOUS_FLOAT = fromNamespaceAndPath(ModInfo.ID, "luminous_float");
    public static final Identifier AWAKENED_ROD = fromNamespaceAndPath(ModInfo.ID, "awakened_rod");
    public static final Identifier INFERNAL_LINE = fromNamespaceAndPath(ModInfo.ID, "infernal_line");
    public static final Identifier PLAYING_WITH_FIRE = fromNamespaceAndPath(ModInfo.ID, "playing_with_fire");

    public static final Identifier THE_LOCAL_CATCH = fromNamespaceAndPath(ModInfo.ID, "the_local_catch");
    public static final Identifier SOMETHINGS_HISSING = fromNamespaceAndPath(ModInfo.ID, "somethings_hissing");

    public static final Identifier JUNGLE_FISHING = fromNamespaceAndPath(ModInfo.ID, "jungle_fishing");
    public static final Identifier EXOTIC_CATCH = fromNamespaceAndPath(ModInfo.ID, "exotic_catch");
    public static final Identifier WISDOM_IN_A_BOTTLE = fromNamespaceAndPath(ModInfo.ID, "wisdom_in_a_bottle");

    public static final Identifier FROZEN_WATERS = fromNamespaceAndPath(ModInfo.ID, "frozen_waters");
    public static final Identifier FROZEN_SOLID = fromNamespaceAndPath(ModInfo.ID, "frozen_solid");

    public static final Identifier SWAMP_FISHER = fromNamespaceAndPath(ModInfo.ID, "swamp_fisher");
    public static final Identifier MURKY_WATERS = fromNamespaceAndPath(ModInfo.ID, "murky_waters");

    public static final Identifier DESERT_CATCH = fromNamespaceAndPath(ModInfo.ID, "desert_catch");
    public static final Identifier SUNKEN_TREASURE = fromNamespaceAndPath(ModInfo.ID, "sunken_treasure");

    public static final Identifier FUNGAL_SHORES = fromNamespaceAndPath(ModInfo.ID, "fungal_shores");

    public static final Identifier OPEN_WATERS = fromNamespaceAndPath(ModInfo.ID, "open_waters");
    public static final Identifier SOAK_IT_UP = fromNamespaceAndPath(ModInfo.ID, "soak_it_up");
    public static final Identifier FROM_THE_ABYSS = fromNamespaceAndPath(ModInfo.ID, "from_the_abyss");
    public static final Identifier LIQUID_LUCK = fromNamespaceAndPath(ModInfo.ID, "liquid_luck");

    public static final Identifier DEEP_CAVERNS = fromNamespaceAndPath(ModInfo.ID, "deep_caverns");
    public static final Identifier ENCHANTED_CATCH = fromNamespaceAndPath(ModInfo.ID, "enchanted_catch");
    public static final Identifier IS_THIS_TRADABLE = fromNamespaceAndPath(ModInfo.ID, "is_this_tradable");
    public static final Identifier A_STRANGE_CRYSTAL = fromNamespaceAndPath(ModInfo.ID, "a_strange_crystal");
    public static final Identifier TREASURE_OF_THE_CAVES = fromNamespaceAndPath(ModInfo.ID, "treasure_of_the_caves");

    public static final Identifier A_TERRIBLE_CATCH = fromNamespaceAndPath(ModInfo.ID, "a_terrible_catch");
    public static final Identifier BAD_OMEN = fromNamespaceAndPath(ModInfo.ID, "bad_omen");
    public static final Identifier GRIM_CATCH = fromNamespaceAndPath(ModInfo.ID, "grim_catch");

    public static final Identifier BEYOND_THE_VOID = fromNamespaceAndPath(ModInfo.ID, "beyond_the_void");
    public static final Identifier WARPED_CATCH = fromNamespaceAndPath(ModInfo.ID, "warped_catch");

    public static final Identifier THATS_NOT_WATER = fromNamespaceAndPath(ModInfo.ID, "thats_not_water");
    public static final Identifier TOO_HOT_TO_TOUCH = fromNamespaceAndPath(ModInfo.ID, "too_hot_to_touch");
    public static final Identifier FROM_FIRE_TO_STONE = fromNamespaceAndPath(ModInfo.ID, "from_fire_to_stone");
    public static final Identifier MOLTEN_SEAS = fromNamespaceAndPath(ModInfo.ID, "molten_seas");
    public static final Identifier GLOW_FROM_BELOW = fromNamespaceAndPath(ModInfo.ID, "glow_from_below");
    public static final Identifier FISHING_FOR_BLAZE = fromNamespaceAndPath(ModInfo.ID, "fishing_for_blaze");
    public static final Identifier NOT_A_FISH = fromNamespaceAndPath(ModInfo.ID, "not_a_fish");

    public static void giveAdvancement(Player player, Level level, Identifier advancement) {
        if (player instanceof ServerPlayer serverPlayer) {
            var adv = level.getServer().getAdvancements().get(advancement);
            if (adv != null) {
                var playerAdv = serverPlayer.getAdvancements();
                if (!playerAdv.getOrStartProgress(adv).isDone()) {
                    playerAdv.award(adv, "triggered");
                }
            }
        }
    }

}
