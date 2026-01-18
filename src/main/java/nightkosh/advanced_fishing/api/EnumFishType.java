package nightkosh.advanced_fishing.api;

import net.minecraft.world.item.Rarity;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public enum EnumFishType {
    BLUE_JELLYFISH("blue_jellyfish", 1, Rarity.UNCOMMON),
    MUD_TUNA("mud_tuna", 2, Rarity.UNCOMMON),
    FROST_MINNOW("frost_minnow", 2, Rarity.UNCOMMON),
    PIRANHA("piranha", 2),
    GOLDEN_KOI("golden_koi", 2, Rarity.UNCOMMON),
    SPECULAR_SNAPPER("specular_snapper", 2, Rarity.RARE),
    CAVE_TROUT("cave_trout", 2, Rarity.UNCOMMON),
    MAGMA_JELLYFISH("magma_jellyfish", 1, Rarity.UNCOMMON),
    OBSIDIAN_BREAM("obsidian_bream", 1, Rarity.UNCOMMON),
    NETHER_STURGEON("nether_sturgeon", 1),
    QUARTZ_CHUB("quartz_chub", 1, Rarity.UNCOMMON),
    FLAREFIN_KOI("flarefin_koi", 1, Rarity.RARE),
    BLAZE_PIKE("blaze_pike", 1, Rarity.RARE),
    ENDER_SHAD("ender_shad", 1),
    PEARL_SARDINE("pearl_sardine", 2, Rarity.UNCOMMON),
    CHORUS_KOI("chorus_koi", 2, Rarity.RARE),
    EXPLOSIVE_CRUCIAN("explosive_crucian", 1, Rarity.RARE),
    RUFFE("ruffe", 2),
    SPARKLING_EEL("sparkling_eel", 2, Rarity.UNCOMMON),
    ANGELFISH("angelfish", 2),
    ANGLER_FISH("angler_fish", 2, Rarity.RARE),
    SPONGE_EATER("sponge_eater", 2, Rarity.RARE),
    SNOWY_WALLEYE("snowy_walleye", 2),
    SQUID("squid", 1),
    WITHERED_CRUCIAN("withered_crucian", 1, Rarity.UNCOMMON),
    SANDY_BASS("sandy_bass", 1),
    MANDARINFISH("mandarinfish", 3, Rarity.RARE),
    RED_SHROOMFIN("red_shroomfin", 2, Rarity.RARE),
    BROWN_SHROOMFIN("brown_shroomfin", 2, Rarity.RARE),
    FUNGI_CATFISH("fungi_catfish", 1, Rarity.UNCOMMON),
    SWAMP_PLAICE("swamp_plaice", 1, Rarity.RARE),
    CRYSTAL_MULLET("crystal_mullet", 1, Rarity.RARE),
    CHARGED_BULLHEAD("charged_bullhead", 1, Rarity.RARE),
    ABYSSAL_LURKER("abyssal_lurker", 1, Rarity.UNCOMMON),
    SUNFISH("sunfish", 2, Rarity.RARE),
    GLACIER_ANCHOVY("glacier_anchovy", 1, Rarity.RARE),
    CATFISH("catfish", 3, 0.2F, Rarity.UNCOMMON),
    PIKE("pike", 2, 0.2F, Rarity.UNCOMMON),
    MAGIKARP("magikarp", 1, 0.05F),
    GREEN_JELLYFISH("green_jellyfish", 1, Rarity.UNCOMMON),
    BONE_FISH("bone_fish", 1, 0.05F, Rarity.UNCOMMON),
    CURSED_KOI("cursed_koi", 1, Rarity.RARE),
    SPOOKYFIN("spookyfin", 1, Rarity.UNCOMMON),
    COAL_CRUCIAN("coal_crucian", 1),
    COPPER_MINNOW("copper_minnow", 1),
    IRON_BASS("iron_bass", 1, Rarity.UNCOMMON),
    AMETHYST_CATFISH("amethyst_catfish", 1, Rarity.RARE),
    EMERALD_SALMON("emerald_salmon", 1, Rarity.UNCOMMON),
    DIAMOND_KOI("diamond_koi", 1, Rarity.RARE);

    private final String name;
    private final int healAmount;
    private final float saturationModifier;
    private final Rarity rarity;

    EnumFishType(String name, int healAmount) {
        this(name, healAmount, 0.1F);
    }

    EnumFishType(String name, int healAmount, Rarity rarity) {
        this(name, healAmount, 0.1F, rarity);
    }

    EnumFishType(String name, int healAmount, float saturationModifier) {
        this(name, healAmount, saturationModifier, Rarity.COMMON);
    }

    EnumFishType(String name, int healAmount, float saturationModifier, Rarity rarity) {
        this.name = name;
        this.healAmount = healAmount;
        this.saturationModifier = saturationModifier;
        this.rarity = Rarity.COMMON;
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

    public Rarity getRarity() {
        return rarity;
    }

}
