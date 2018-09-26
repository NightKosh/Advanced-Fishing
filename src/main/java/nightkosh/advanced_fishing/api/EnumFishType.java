package nightkosh.advanced_fishing.api;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public enum EnumFishType {
    BLUE_JELLYFISH("blue_jellyfish", 1), //0
    MAGMA_JELLYFISH("magma_jellyfish", 1), //1
    MUD_TUNA("mud_tuna", 2), //2
    FROST_MINNOW("frost_minnow", 2), //3
    PIRANHA("piranha", 2), //4
    GOLDEN_KOI("golden_koi", 2), //5
    SPECULAR_SNAPPER("specular_snapper", 2), //6
    CAVE_TROUT("cave_trout", 2), //7
    OBSIDIAN_BREAM("obsidian_bream", 1), //8
    NETHER_STURGEON("nether_sturgeon", 1), //9
    QUARTZ_CHUB("quartz_chub", 1), //10
    FLAREFIN_KOI("flarefin_koi", 1), //11
    BLAZE_PIKE("blaze_pike", 1), //12
    ENDER_SHAD("ender_shad", 1), //13
    PEARL_SARDINE("pearl_sardine", 2), //14
    CHORUS_KOI("chorus_koi", 2), //15
    EXPLOSIVE_CRUCIAN("explosive_crucian", 1), //16
    RUFFE("ruffe", 2), //17
    SPARKLING_EEL("sparkling_eel", 2), //18
    ANGELFISH("angelfish", 2), //19
    ANGLER_FISH("angler_fish", 2), //20
    SPONGE_EATER("sponge_eater", 2), //21
    SNOWY_WALLEYE("snowy_walleye", 2), //22
    SQUID("squid", 1), //23
    WITHERED_CRUCIAN("withered_crucian", 1), //24
    SANDY_BASS("sandy_bass", 1), //25
    MANDARINFISH("mandarinfish", 3), //26
    RED_SHROOMFIN("red_shroomfin", 2), //27
    BROWN_SHROOMFIN("brown_shroomfin", 2), //28
    FUNGI_CATFISH("fungi_catfish", 1), //29
    SWAMP_PLAICE("swamp_plaice", 1), //30
    CRYSTAL_MULLET("crystal_mullet", 1), //31
    CHARGED_BULLHEAD("charged_bullhead", 1), //32
    ABYSSAL_LURKER("abyssal_lurker", 1), //33
    SUNFISH("sunfish", 2), //34
    GLACIER_ANCHOVY("glacier_anchovy", 1), //35
    CATFISH("catfish", 3, 0.2F), //36
    PIKE("pike", 2, 0.2F), //37
    MAGIKARP("magikarp", 1, 0.05F); //38

    private String name;
    private int healAmount;
    private float saturationModifier;

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
