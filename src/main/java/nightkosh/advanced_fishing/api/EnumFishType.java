package nightkosh.advanced_fishing.api;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public enum EnumFishType {
    BLUE_JELLYFISH("blue_jellyfish", 1),
    MUD_TUNA("mud_tuna", 2),
    FROST_MINNOW("frost_minnow", 2),
    PIRANHA("piranha", 2),
    GOLDEN_KOI("golden_koi", 2),
    SPECULAR_SNAPPER("specular_snapper", 2),
    CAVE_TROUT("cave_trout", 2),
    MAGMA_JELLYFISH("magma_jellyfish", 1),
    OBSIDIAN_BREAM("obsidian_bream", 1),
    NETHER_STURGEON("nether_sturgeon", 1),
    QUARTZ_CHUB("quartz_chub", 1),
    FLAREFIN_KOI("flarefin_koi", 1),
    BLAZE_PIKE("blaze_pike", 1),
    ENDER_SHAD("ender_shad", 1),
    PEARL_SARDINE("pearl_sardine", 2),
    CHORUS_KOI("chorus_koi", 2),
    EXPLOSIVE_CRUCIAN("explosive_crucian", 1),
    RUFFE("ruffe", 2),
    SPARKLING_EEL("sparkling_eel", 2),
    ANGELFISH("angelfish", 2),
    ANGLER_FISH("angler_fish", 2),
    SPONGE_EATER("sponge_eater", 2),
    SNOWY_WALLEYE("snowy_walleye", 2),
    SQUID("squid", 1),
    WITHERED_CRUCIAN("withered_crucian", 1),
    SANDY_BASS("sandy_bass", 1),
    MANDARINFISH("mandarinfish", 3),
    RED_SHROOMFIN("red_shroomfin", 2),
    BROWN_SHROOMFIN("brown_shroomfin", 2),
    FUNGI_CATFISH("fungi_catfish", 1),
    SWAMP_PLAICE("swamp_plaice", 1),
    CRYSTAL_MULLET("crystal_mullet", 1),
    CHARGED_BULLHEAD("charged_bullhead", 1),
    ABYSSAL_LURKER("abyssal_lurker", 1),
    SUNFISH("sunfish", 2),
    GLACIER_ANCHOVY("glacier_anchovy", 1),
    CATFISH("catfish", 3, 0.2F),
    PIKE("pike", 2, 0.2F),
    MAGIKARP("magikarp", 1, 0.05F),
    GREEN_JELLYFISH("green_jellyfish", 1),
    BONE_FISH("bone_fish", 1, 0.05F),
    CURSED_KOI("cursed_koi", 1),
    SPOOKYFIN("spookyfin", 1);

    private final String name;
    private final int healAmount;
    private final float saturationModifier;

    EnumFishType(String name, int healAmount) {
        this(name, healAmount, 0.1F);
    }

    EnumFishType(String name, int healAmount, float saturationModifier) {
        this.name = name;
        this.healAmount = healAmount;
        this.saturationModifier = saturationModifier;
    }

    public String getName() {
        return this.name;
    }

    public int getHealAmount() {
        return healAmount;
    }

    public float getSaturationModifier() {
        return saturationModifier;
    }

}
