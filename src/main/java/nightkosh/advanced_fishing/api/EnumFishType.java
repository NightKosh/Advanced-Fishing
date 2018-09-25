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
    SPECULAR_FISH("specular_fish", 2), //6
    CAVEFISH("cavefish", 2), //7
    OBSIDIFISH("obsidifish", 1), //8
    NETHER_SALMON("nether_salmon", 1), //9
    QUARTZ_COD("quartz_cod", 1), //10
    FLAREFIN_KOI("flarefin_koi", 1), //11
    BLAZE_COD("blaze_cod", 1), //12
    ENDERFIN("enderfin", 1), //13
    PEARL_BASS("pearl_bass", 2), //14
    CHORUS_KOI("chorus_koi", 2), //15
    EXPLOSIVE_CRUCIAN("explosive_crucian", 1), //16
    RUFFE("ruffe", 2), //17
    SPARKLING_EEL("sparkling_eel", 2), //18
    ANGELFISH("angelfish", 2), //19
    ANGLER_FISH("angler_fish", 2), //20
    SPONGE_EATER("sponge_eater", 2), //21
    SNOWY_CRUCIAN("snowy_crucian", 2), //22
    SQUID("squid", 1), //23
    WITHERED_CRUCIAN("withered_crucian", 1), //24
    SANDY_BASS("sandy_bass", 1); //25

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
