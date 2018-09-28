package nightkosh.advanced_fishing.core;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.advanced_fishing.api.EnumFishType;
import nightkosh.advanced_fishing.api.ModInfo;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@SideOnly(Side.CLIENT)
public class ResourcesModels {
    public static final ModelResourceLocation BLAZING_FISHING_POLE = new ModelResourceLocation(ModInfo.ID + ":fishing_pole/blazing/blazing_fishing_pole", "inventory");

    public static final ModelResourceLocation BLUE_JELLYFISH = getFish(EnumFishType.BLUE_JELLYFISH);
    public static final ModelResourceLocation MAGMA_JELLYFISH = getFish(EnumFishType.MAGMA_JELLYFISH);
    public static final ModelResourceLocation MUD_TUNA = getFish(EnumFishType.MUD_TUNA);
    public static final ModelResourceLocation FROST_MINNOW = getFish(EnumFishType.FROST_MINNOW);
    public static final ModelResourceLocation PIRANHA = getFish(EnumFishType.PIRANHA);
    public static final ModelResourceLocation GOLDEN_KOI = getFish(EnumFishType.GOLDEN_KOI);
    public static final ModelResourceLocation SPECULAR_SNAPPER = getFish(EnumFishType.SPECULAR_SNAPPER);
    public static final ModelResourceLocation CAVE_TROUT = getFish(EnumFishType.CAVE_TROUT);
    public static final ModelResourceLocation OBSIDIAN_BREAM = getFish(EnumFishType.OBSIDIAN_BREAM);
    public static final ModelResourceLocation NETHER_STURGEON = getFish(EnumFishType.NETHER_STURGEON);
    public static final ModelResourceLocation QUARTZ_CHUB = getFish(EnumFishType.QUARTZ_CHUB);
    public static final ModelResourceLocation FLAREFIN_KOI = getFish(EnumFishType.FLAREFIN_KOI);
    public static final ModelResourceLocation BLAZE_PIKE = getFish(EnumFishType.BLAZE_PIKE);
    public static final ModelResourceLocation ENDER_SHAD = getFish(EnumFishType.ENDER_SHAD);
    public static final ModelResourceLocation PEARL_SARDINE = getFish(EnumFishType.PEARL_SARDINE);
    public static final ModelResourceLocation CHORUS_KOI = getFish(EnumFishType.CHORUS_KOI);
    public static final ModelResourceLocation EXPLOSIVE_CRUCIAN = getFish(EnumFishType.EXPLOSIVE_CRUCIAN);
    public static final ModelResourceLocation RUFFE = getFish(EnumFishType.RUFFE);
    public static final ModelResourceLocation SPARKLING_EEL = getFish(EnumFishType.SPARKLING_EEL);
    public static final ModelResourceLocation ANGELFISH = getFish(EnumFishType.ANGELFISH);
    public static final ModelResourceLocation ANGLER_FISH = getFish(EnumFishType.ANGLER_FISH);
    public static final ModelResourceLocation SPONGE_EATER = getFish(EnumFishType.SPONGE_EATER);
    public static final ModelResourceLocation SNOWY_WALLEYE = getFish(EnumFishType.SNOWY_WALLEYE);
    public static final ModelResourceLocation SQUID = getFish(EnumFishType.SQUID);
    public static final ModelResourceLocation WITHERED_CRUCIAN = getFish(EnumFishType.WITHERED_CRUCIAN);
    public static final ModelResourceLocation SANDY_BASS = getFish(EnumFishType.SANDY_BASS);
    public static final ModelResourceLocation MANDARINFISH = getFish(EnumFishType.MANDARINFISH);
    public static final ModelResourceLocation RED_SHROOMFIN = getFish(EnumFishType.RED_SHROOMFIN);
    public static final ModelResourceLocation BROWN_SHROOMFIN = getFish(EnumFishType.BROWN_SHROOMFIN);
    public static final ModelResourceLocation FUNGI_CATFISH = getFish(EnumFishType.FUNGI_CATFISH);
    public static final ModelResourceLocation SWAMP_PLAICE = getFish(EnumFishType.SWAMP_PLAICE);
    public static final ModelResourceLocation CRYSTAL_MULLET = getFish(EnumFishType.CRYSTAL_MULLET);
    public static final ModelResourceLocation CHARGED_BULLHEAD = getFish(EnumFishType.CHARGED_BULLHEAD);
    public static final ModelResourceLocation ABYSSAL_LURKER = getFish(EnumFishType.ABYSSAL_LURKER);
    public static final ModelResourceLocation SUNFISH = getFish(EnumFishType.SUNFISH);
    public static final ModelResourceLocation GLACIER_ANCHOVY = getFish(EnumFishType.GLACIER_ANCHOVY);
    public static final ModelResourceLocation CATFISH = getFish(EnumFishType.CATFISH);
    public static final ModelResourceLocation PIKE = getFish(EnumFishType.PIKE);
    public static final ModelResourceLocation MAGIKARP = getFish(EnumFishType.MAGIKARP);
    public static final ModelResourceLocation GREEN_JELLYFISH = getFish(EnumFishType.GREEN_JELLYFISH);
    public static final ModelResourceLocation BONE_FISH = getFish(EnumFishType.BONE_FISH);
    public static final ModelResourceLocation CURSED_KOI = getFish(EnumFishType.CURSED_KOI);
    public static final ModelResourceLocation SPOOKYFIN = getFish(EnumFishType.SPOOKYFIN);
    
    
    private static ModelResourceLocation getFish(EnumFishType fishType) {
        return new ModelResourceLocation(ModInfo.ID + ":fish/" + fishType.getName(), "inventory");
    }

}
