package nightkosh.advanced_fishing.api;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public enum EnumFishType {
    BLUE_JELLYFISH("blue_jellyfish"), //0
    MAGMA_JELLYFISH("magma_jellyfish"), //1
    MUD_TUNA("mud_tuna"), //2
    FROST_MINNOW("frost_minnow"), //3
    PIRANHA("piranha"), //4
    GOLDEN_KOI("golden_koi"), //5
    SPECULAR_FISH("specular_fish"), //6
    CAVEFISH("cavefish"), //7
    OBSIDIFISH("obsidifish"), //8
    NETHER_SALMON("nether_salmon"), //9
    QUARTZ_COD("quartz_cod"), //10
    FLAREFIN_KOI("flarefin_koi"), //11
    BLAZE_COD("blaze_cod"), //12
    ENDERFIN("enderfin"), //13
    PEARL_BASS("pearl_bass"), //14
    CHORUS_KOI("chorus_koi"), //15
    EXPLOSIVE_CRUCIAN("explosive_crucian"), //16
    RUFFE("ruffe"), //17
    SPARKLING_EEL("sparkling_eel"), //18
    ANGELFISH("angelfish"), //19
    ANGLER_FISH("angler_fish"), //20
    SPONGE_EATER("sponge_eater"), //21
    SNOWY_CRUCIAN("snowy_crucian"), //22
    SQUID("squid"), //23
    WITHERED_CRUCIAN("withered_crucian"), //24
    SANDY_BASS("sandy_bass"); //25

    private String name;

    EnumFishType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
