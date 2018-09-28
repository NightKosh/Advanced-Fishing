package nightkosh.advanced_fishing.core;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nightkosh.advanced_fishing.api.EnumFishType;
import nightkosh.advanced_fishing.api.ModInfo;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@GameRegistry.ObjectHolder(ModInfo.ID)
public class Models {

    @Mod.EventBusSubscriber(modid = ModInfo.ID)
    public static class RegistrationHandler {

        @SubscribeEvent
        public static void registerModels(final ModelRegistryEvent event) {
            ModelLoader.setCustomModelResourceLocation(Items.BLAZING_FISHING_POLE, 0, ResourcesModels.BLAZING_FISHING_POLE);

            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.BLUE_JELLYFISH.ordinal(), ResourcesModels.BLUE_JELLYFISH);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.MAGMA_JELLYFISH.ordinal(), ResourcesModels.MAGMA_JELLYFISH);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.MUD_TUNA.ordinal(), ResourcesModels.MUD_TUNA);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.FROST_MINNOW.ordinal(), ResourcesModels.FROST_MINNOW);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.PIRANHA.ordinal(), ResourcesModels.PIRANHA);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.GOLDEN_KOI.ordinal(), ResourcesModels.GOLDEN_KOI);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.SPECULAR_SNAPPER.ordinal(), ResourcesModels.SPECULAR_SNAPPER);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.CAVE_TROUT.ordinal(), ResourcesModels.CAVE_TROUT);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.OBSIDIAN_BREAM.ordinal(), ResourcesModels.OBSIDIAN_BREAM);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.NETHER_STURGEON.ordinal(), ResourcesModels.NETHER_STURGEON);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.QUARTZ_CHUB.ordinal(), ResourcesModels.QUARTZ_CHUB);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.FLAREFIN_KOI.ordinal(), ResourcesModels.FLAREFIN_KOI);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.BLAZE_PIKE.ordinal(), ResourcesModels.BLAZE_PIKE);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.ENDER_SHAD.ordinal(), ResourcesModels.ENDER_SHAD);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.PEARL_SARDINE.ordinal(), ResourcesModels.PEARL_SARDINE);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.CHORUS_KOI.ordinal(), ResourcesModels.CHORUS_KOI);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.EXPLOSIVE_CRUCIAN.ordinal(), ResourcesModels.EXPLOSIVE_CRUCIAN);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.RUFFE.ordinal(), ResourcesModels.RUFFE);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.SPARKLING_EEL.ordinal(), ResourcesModels.SPARKLING_EEL);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.ANGELFISH.ordinal(), ResourcesModels.ANGELFISH);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.ANGLER_FISH.ordinal(), ResourcesModels.ANGLER_FISH);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.SPONGE_EATER.ordinal(), ResourcesModels.SPONGE_EATER);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.SNOWY_WALLEYE.ordinal(), ResourcesModels.SNOWY_WALLEYE);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.SQUID.ordinal(), ResourcesModels.SQUID);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.WITHERED_CRUCIAN.ordinal(), ResourcesModels.WITHERED_CRUCIAN);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.SANDY_BASS.ordinal(), ResourcesModels.SANDY_BASS);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.MANDARINFISH.ordinal(), ResourcesModels.MANDARINFISH);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.RED_SHROOMFIN.ordinal(), ResourcesModels.RED_SHROOMFIN);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.BROWN_SHROOMFIN.ordinal(), ResourcesModels.BROWN_SHROOMFIN);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.FUNGI_CATFISH.ordinal(), ResourcesModels.FUNGI_CATFISH);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.SWAMP_PLAICE.ordinal(), ResourcesModels.SWAMP_PLAICE);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.CRYSTAL_MULLET.ordinal(), ResourcesModels.CRYSTAL_MULLET);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.CHARGED_BULLHEAD.ordinal(), ResourcesModels.CHARGED_BULLHEAD);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.ABYSSAL_LURKER.ordinal(), ResourcesModels.ABYSSAL_LURKER);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.SUNFISH.ordinal(), ResourcesModels.SUNFISH);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.GLACIER_ANCHOVY.ordinal(), ResourcesModels.GLACIER_ANCHOVY);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.CATFISH.ordinal(), ResourcesModels.CATFISH);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.PIKE.ordinal(), ResourcesModels.PIKE);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.MAGIKARP.ordinal(), ResourcesModels.MAGIKARP);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.GREEN_JELLYFISH.ordinal(), ResourcesModels.GREEN_JELLYFISH);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.BONE_FISH.ordinal(), ResourcesModels.BONE_FISH);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.CURSED_KOI.ordinal(), ResourcesModels.CURSED_KOI);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, EnumFishType.SPOOKYFIN.ordinal(), ResourcesModels.SPOOKYFIN);

            ModelBakery.registerItemVariants(Items.FISH, ResourcesModels.BLUE_JELLYFISH, ResourcesModels.MAGMA_JELLYFISH, ResourcesModels.MUD_TUNA,
                    ResourcesModels.PIRANHA, ResourcesModels.GOLDEN_KOI, ResourcesModels.SPECULAR_SNAPPER, ResourcesModels.CAVE_TROUT, ResourcesModels.OBSIDIAN_BREAM,
                    ResourcesModels.NETHER_STURGEON, ResourcesModels.QUARTZ_CHUB, ResourcesModels.FLAREFIN_KOI, ResourcesModels.BLAZE_PIKE, ResourcesModels.ENDER_SHAD,
                    ResourcesModels.PEARL_SARDINE, ResourcesModels.CHORUS_KOI, ResourcesModels.EXPLOSIVE_CRUCIAN, ResourcesModels.RUFFE, ResourcesModels.SPARKLING_EEL,
                    ResourcesModels.ANGELFISH, ResourcesModels.ANGLER_FISH, ResourcesModels.SPONGE_EATER, ResourcesModels.SNOWY_WALLEYE, ResourcesModels.SQUID,
                    ResourcesModels.WITHERED_CRUCIAN, ResourcesModels.SANDY_BASS, ResourcesModels.MANDARINFISH, ResourcesModels.RED_SHROOMFIN, ResourcesModels.BROWN_SHROOMFIN,
                    ResourcesModels.FUNGI_CATFISH, ResourcesModels.SWAMP_PLAICE, ResourcesModels.CRYSTAL_MULLET, ResourcesModels.CHARGED_BULLHEAD, ResourcesModels.ABYSSAL_LURKER,
                    ResourcesModels.SUNFISH, ResourcesModels.GLACIER_ANCHOVY, ResourcesModels.CATFISH, ResourcesModels.PIKE, ResourcesModels.MAGIKARP, ResourcesModels.GREEN_JELLYFISH,
                    ResourcesModels.BONE_FISH, ResourcesModels.CURSED_KOI, ResourcesModels.SPOOKYFIN);
        }
    }
}
