package nightkosh.advanced_fishing.core;

import net.minecraft.init.Blocks;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nightkosh.advanced_fishing.api.EnumFishType;
import nightkosh.advanced_fishing.api.ModInfo;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Recipes {

    private static final ResourceLocation GROUP = new ResourceLocation(ModInfo.ID);

    public static void registration() {
        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_magma_cream"), GROUP, new ItemStack(net.minecraft.init.Items.MAGMA_CREAM),
                "f",
                'f', new ItemStack(Items.FISH, 1, EnumFishType.MAGMA_JELLYFISH.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_lava"), GROUP, new ItemStack(net.minecraft.init.Items.LAVA_BUCKET),
                "fb",
                'b', net.minecraft.init.Items.BUCKET,
                'f', new ItemStack(Items.FISH, 1, EnumFishType.MAGMA_JELLYFISH.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_obsidian"), GROUP, new ItemStack(Blocks.OBSIDIAN),
                "ff",
                "ff",
                'f', new ItemStack(Items.FISH, 1, EnumFishType.OBSIDIFISH.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_netherrack"), GROUP, new ItemStack(Blocks.NETHERRACK),
                "f",
                'f', new ItemStack(Items.FISH, 1, EnumFishType.NETHER_SALMON.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_quartz"), GROUP, new ItemStack(net.minecraft.init.Items.QUARTZ, 4),
                "f",
                'f', new ItemStack(Items.FISH, 1, EnumFishType.QUARTZ_COD.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_glowstone_dust"), GROUP, new ItemStack(net.minecraft.init.Items.GLOWSTONE_DUST, 2),
                "f",
                'f', new ItemStack(Items.FISH, 1, EnumFishType.FLAREFIN_KOI.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_blaze_rod"), GROUP, new ItemStack(net.minecraft.init.Items.BLAZE_ROD),
                "f",
                'f', new ItemStack(Items.FISH, 1, EnumFishType.BLAZE_COD.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_end_stone"), GROUP, new ItemStack(Blocks.END_STONE),
                "f",
                'f', new ItemStack(Items.FISH, 1, EnumFishType.ENDERFIN.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_ender_pearl"), GROUP, new ItemStack(net.minecraft.init.Items.ENDER_PEARL),
                "f",
                'f', new ItemStack(Items.FISH, 1, EnumFishType.PEARL_BASS.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_chorus_fruit"), GROUP, new ItemStack(net.minecraft.init.Items.CHORUS_FRUIT),
                "f",
                'f', new ItemStack(Items.FISH, 1, EnumFishType.CHORUS_KOI.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_sand"), GROUP, new ItemStack(Blocks.SAND),
                "f",
                'f', new ItemStack(Items.FISH, 1, EnumFishType.SANDY_BASS.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_clay"), GROUP, new ItemStack(net.minecraft.init.Items.CLAY_BALL, 4),
                "f",
                'f', new ItemStack(Items.FISH, 1, EnumFishType.MUD_TUNA.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_snow"), GROUP, new ItemStack(net.minecraft.init.Items.SNOWBALL, 4),
                "f",
                'f', new ItemStack(Items.FISH, 1, EnumFishType.SNOWY_CRUCIAN.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_ice"), GROUP, new ItemStack(Blocks.ICE, 1),
                "ff",
                "ff",
                'f', new ItemStack(Items.FISH, 1, EnumFishType.FROST_MINNOW.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_packed_ice"), GROUP, new ItemStack(Blocks.PACKED_ICE, 2),
                "fi",
                "if",
                'i', Blocks.ICE,
                'f', new ItemStack(Items.FISH, 1, EnumFishType.FROST_MINNOW.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_gunpowder"), GROUP, new ItemStack(net.minecraft.init.Items.GUNPOWDER, 3),
                "f",
                'f', new ItemStack(Items.FISH, 1, EnumFishType.EXPLOSIVE_CRUCIAN.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_sponge"), GROUP, new ItemStack(Blocks.SPONGE, 1),
                "ff",
                "ff",
                'f', new ItemStack(Items.FISH, 1, EnumFishType.SPONGE_EATER.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_soul_sand"), GROUP, new ItemStack(Blocks.SOUL_SAND, 1),
                "ff",
                "ff",
                'f', new ItemStack(Items.FISH, 1, EnumFishType.WITHERED_CRUCIAN.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_black_dye"), GROUP, new ItemStack(net.minecraft.init.Items.DYE, 5, EnumDyeColor.BLACK.getDyeDamage()),
                "f",
                'f', new ItemStack(Items.FISH, 1, EnumFishType.SQUID.ordinal()));
    }

    public static void smeltingRecipesRegistration() {
        GameRegistry.addSmelting(new ItemStack(Items.FISH, 1, EnumFishType.BLUE_JELLYFISH.ordinal()), new ItemStack(net.minecraft.init.Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(Items.FISH, 1, EnumFishType.MAGMA_JELLYFISH.ordinal()), new ItemStack(net.minecraft.init.Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(Items.FISH, 1, EnumFishType.MUD_TUNA.ordinal()), new ItemStack(net.minecraft.init.Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(Items.FISH, 1, EnumFishType.FROST_MINNOW.ordinal()), new ItemStack(net.minecraft.init.Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(Items.FISH, 1, EnumFishType.PIRANHA.ordinal()), new ItemStack(net.minecraft.init.Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(Items.FISH, 1, EnumFishType.GOLDEN_KOI.ordinal()), new ItemStack(net.minecraft.init.Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(Items.FISH, 1, EnumFishType.SPECULAR_FISH.ordinal()), new ItemStack(net.minecraft.init.Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(Items.FISH, 1, EnumFishType.CAVEFISH.ordinal()), new ItemStack(net.minecraft.init.Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(Items.FISH, 1, EnumFishType.OBSIDIFISH.ordinal()), new ItemStack(net.minecraft.init.Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(Items.FISH, 1, EnumFishType.NETHER_SALMON.ordinal()), new ItemStack(net.minecraft.init.Items.COOKED_FISH, 1, 1), 1);
        GameRegistry.addSmelting(new ItemStack(Items.FISH, 1, EnumFishType.QUARTZ_COD.ordinal()), new ItemStack(net.minecraft.init.Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(Items.FISH, 1, EnumFishType.FLAREFIN_KOI.ordinal()), new ItemStack(net.minecraft.init.Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(Items.FISH, 1, EnumFishType.BLAZE_COD.ordinal()), new ItemStack(net.minecraft.init.Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(Items.FISH, 1, EnumFishType.ENDERFIN.ordinal()), new ItemStack(net.minecraft.init.Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(Items.FISH, 1, EnumFishType.PEARL_BASS.ordinal()), new ItemStack(net.minecraft.init.Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(Items.FISH, 1, EnumFishType.CHORUS_KOI.ordinal()), new ItemStack(net.minecraft.init.Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(Items.FISH, 1, EnumFishType.EXPLOSIVE_CRUCIAN.ordinal()), new ItemStack(net.minecraft.init.Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(Items.FISH, 1, EnumFishType.RUFFE.ordinal()), new ItemStack(net.minecraft.init.Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(Items.FISH, 1, EnumFishType.SPARKLING_EEL.ordinal()), new ItemStack(net.minecraft.init.Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(Items.FISH, 1, EnumFishType.ANGELFISH.ordinal()), new ItemStack(net.minecraft.init.Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(Items.FISH, 1, EnumFishType.ANGLER_FISH.ordinal()), new ItemStack(net.minecraft.init.Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(Items.FISH, 1, EnumFishType.SPONGE_EATER.ordinal()), new ItemStack(net.minecraft.init.Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(Items.FISH, 1, EnumFishType.SNOWY_CRUCIAN.ordinal()), new ItemStack(net.minecraft.init.Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(Items.FISH, 1, EnumFishType.SQUID.ordinal()), new ItemStack(net.minecraft.init.Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(Items.FISH, 1, EnumFishType.WITHERED_CRUCIAN.ordinal()), new ItemStack(net.minecraft.init.Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(Items.FISH, 1, EnumFishType.SANDY_BASS.ordinal()), new ItemStack(net.minecraft.init.Items.COOKED_FISH, 1, 0), 1);

        //vanilla
        GameRegistry.addSmelting(new ItemStack(net.minecraft.init.Items.FISH, 1, ItemFishFood.FishType.PUFFERFISH.ordinal()), new ItemStack(net.minecraft.init.Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(net.minecraft.init.Items.FISH, 1, ItemFishFood.FishType.CLOWNFISH.ordinal()), new ItemStack(net.minecraft.init.Items.COOKED_FISH, 1, 0), 1);
    }

    public static void addLuckPotionRecipe() {
        PotionHelper.addMix(PotionTypes.AWKWARD, Ingredient.fromStacks(new ItemStack(net.minecraft.init.Items.FISH, 1, 2)), PotionType.getPotionTypeForName("luck"));
    }
}
