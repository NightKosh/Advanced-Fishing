package nightkosh.advanced_fishing.core;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nightkosh.advanced_fishing.item.ItemFish;

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
            ModelLoader.setCustomModelResourceLocation(Items.FISH, ItemFish.EnumFishType.BLUE_JELLYFISH.ordinal(), ResourcesModels.BLUE_JELLYFISH);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, ItemFish.EnumFishType.MAGMA_JELLYFISH.ordinal(), ResourcesModels.MAGMA_JELLYFISH);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, ItemFish.EnumFishType.MUD_TUNA.ordinal(), ResourcesModels.MUD_TUNA);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, ItemFish.EnumFishType.FROST_MINNOW.ordinal(), ResourcesModels.FROST_MINNOW);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, ItemFish.EnumFishType.PIRANHA.ordinal(), ResourcesModels.PIRANHA);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, ItemFish.EnumFishType.GOLDEN_KOI.ordinal(), ResourcesModels.GOLDEN_KOI);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, ItemFish.EnumFishType.SPECULAR_FISH.ordinal(), ResourcesModels.SPECULAR_FISH);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, ItemFish.EnumFishType.CAVEFISH.ordinal(), ResourcesModels.CAVEFISH);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, ItemFish.EnumFishType.OBSIDIFISH.ordinal(), ResourcesModels.OBSIDIFISH);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, ItemFish.EnumFishType.NETHER_SALMON.ordinal(), ResourcesModels.NETHER_SALMON);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, ItemFish.EnumFishType.QUARTZ_COD.ordinal(), ResourcesModels.QUARTZ_COD);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, ItemFish.EnumFishType.FLAREFIN_KOI.ordinal(), ResourcesModels.FLAREFIN_KOI);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, ItemFish.EnumFishType.BLAZE_COD.ordinal(), ResourcesModels.BLAZE_COD);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, ItemFish.EnumFishType.ENDERFIN.ordinal(), ResourcesModels.ENDERFIN);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, ItemFish.EnumFishType.PEARL_BASS.ordinal(), ResourcesModels.PEARL_BASS);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, ItemFish.EnumFishType.CHORUS_KOI.ordinal(), ResourcesModels.CHORUS_KOI);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, ItemFish.EnumFishType.EXPLOSIVE_CRUCIAN.ordinal(), ResourcesModels.EXPLOSIVE_CRUCIAN);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, ItemFish.EnumFishType.RUFFE.ordinal(), ResourcesModels.RUFFE);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, ItemFish.EnumFishType.SPARKLING_EEL.ordinal(), ResourcesModels.SPARKLING_EEL);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, ItemFish.EnumFishType.ANGELFISH.ordinal(), ResourcesModels.ANGELFISH);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, ItemFish.EnumFishType.ANGLER_FISH.ordinal(), ResourcesModels.ANGLER_FISH);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, ItemFish.EnumFishType.SPONGE_EATER.ordinal(), ResourcesModels.SPONGE_EATER);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, ItemFish.EnumFishType.SNOWY_CRUCIAN.ordinal(), ResourcesModels.SNOWY_CRUCIAN);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, ItemFish.EnumFishType.SQUID.ordinal(), ResourcesModels.SQUID);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, ItemFish.EnumFishType.WITHERED_CRUCIAN.ordinal(), ResourcesModels.WITHERED_CRUCIAN);
            ModelLoader.setCustomModelResourceLocation(Items.FISH, ItemFish.EnumFishType.SANDY_BASS.ordinal(), ResourcesModels.SANDY_BASS);

            ModelBakery.registerItemVariants(Items.FISH, ResourcesModels.BLUE_JELLYFISH, ResourcesModels.MAGMA_JELLYFISH, ResourcesModels.MUD_TUNA,
                    ResourcesModels.PIRANHA, ResourcesModels.GOLDEN_KOI, ResourcesModels.SPECULAR_FISH, ResourcesModels.CAVEFISH, ResourcesModels.OBSIDIFISH,
                    ResourcesModels.NETHER_SALMON, ResourcesModels.QUARTZ_COD, ResourcesModels.FLAREFIN_KOI, ResourcesModels.BLAZE_COD, ResourcesModels.ENDERFIN,
                    ResourcesModels.PEARL_BASS, ResourcesModels.CHORUS_KOI, ResourcesModels.EXPLOSIVE_CRUCIAN, ResourcesModels.RUFFE, ResourcesModels.SPARKLING_EEL,
                    ResourcesModels.ANGELFISH, ResourcesModels.ANGLER_FISH, ResourcesModels.SPONGE_EATER, ResourcesModels.SNOWY_CRUCIAN, ResourcesModels.SQUID,
                    ResourcesModels.WITHERED_CRUCIAN, ResourcesModels.SANDY_BASS);
        }
    }
}
