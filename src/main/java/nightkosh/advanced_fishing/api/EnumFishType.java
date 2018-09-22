package nightkosh.advanced_fishing.api;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public enum EnumFishType {
    BLUE_JELLYFISH("blue_jellyfish"),
    MAGMA_JELLYFISH("magma_jellyfish"),
    MUD_TUNA("mud_tuna"),
    FROST_MINNOW("frost_minnow"),
    PIRANHA("piranha"),
    GOLDEN_KOI("golden_koi"),
    SPECULAR_FISH("specular_fish"),
    CAVEFISH("cavefish"),
    OBSIDIFISH("obsidifish"),
    NETHER_SALMON("nether_salmon"),
    QUARTZ_COD("quartz_cod"),
    FLAREFIN_KOI("flarefin_koi"),
    BLAZE_COD("blaze_cod"),
    ENDERFIN("enderfin"),
    PEARL_BASS("pearl_bass"),
    CHORUS_KOI("chorus_koi"),
    EXPLOSIVE_CRUCIAN("explosive_crucian"),
    RUFFE("ruffe"),
    SPARKLING_EEL("sparkling_eel"),
    ANGELFISH("angelfish"),
    ANGLER_FISH("angler_fish"),
    SPONGE_EATER("sponge_eater"),
    SNOWY_CRUCIAN("snowy_crucian"),
    SQUID("squid"),
    WITHERED_CRUCIAN("withered_crucian"),
    SANDY_BASS("sandy_bass");

    private String name;

    EnumFishType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
