package nightkosh.advanced_fishing.core;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.common.BiomeDictionary;
import nightkosh.advanced_fishing.api.EnumFishType;
import nightkosh.advanced_fishing.api.fishing_catch.ICatch;
import nightkosh.advanced_fishing.api.fishing_catch.ICatchManager;

import java.util.*;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class CatchManager implements ICatchManager {

    public static final CatchManager INSTANCE = new CatchManager();

    private static final Map<Block, ICatch> CATCH = new HashMap<>();

    static {
        CATCH.put(Blocks.WATER, CatchManager::getWaterCatch);
        CATCH.put(Blocks.FLOWING_WATER, CatchManager::getWaterCatch);
        CATCH.put(Blocks.LAVA, CatchManager::getLavaCatch);
        CATCH.put(Blocks.FLOWING_LAVA, CatchManager::getLavaCatch);
    }

    @Override
    public void addCatch(Block block, ICatch fishingCatch) {
        CATCH.put(block, fishingCatch);
    }

    @Override
    public ICatch getCatch(Block block) {
        return CATCH.getOrDefault(block, CatchManager::getWaterCatch);
    }


    public static List<ItemStack> getWaterCatch(World world, BlockPos pos, Set<BiomeDictionary.Type> biomeTypesList, float luck) {
        LootContext.Builder lootContextBuilder = new LootContext.Builder((WorldServer) world);
        lootContextBuilder.withLuck(luck);

        int chance = world.rand.nextInt(100) + Math.round(luck);

        List<ItemStack> list = new ArrayList<>();
        if (chance < 10) {
            list = world.getLootTableManager().getLootTableFromLocation(LootTableList.GAMEPLAY_FISHING_JUNK).generateLootForPools(world.rand, lootContextBuilder.build());
        } else if (chance < 90) {
//                    result = this.world.getLootTableManager().getLootTableFromLocation(LootTableList.GAMEPLAY_FISHING_FISH).generateLootForPools(this.rand, lootContextBuilder.build());
            // 60 25 13 2
            chance = world.rand.nextInt(100) + Math.round(luck);
            if (chance < 50) {
                tier1(list, biomeTypesList);
            } else if (chance < 80) {
                tier2(list, biomeTypesList);
            } else if (chance < 95) {
                tier3(list, biomeTypesList);
            } else {
                if (!world.canBlockSeeSky(pos)) {
                    if (pos.getY() < 50) {
                        list.add(new ItemStack(Items.FISH, 1, EnumFishType.SPECULAR_FISH.ordinal()));
                        if (pos.getY() < 40) {
                            list.add(new ItemStack(Items.FISH, 1, EnumFishType.CAVEFISH.ordinal()));
                            if (pos.getY() < 25) {
                                list.add(new ItemStack(Items.FISH, 1, EnumFishType.ANGLER_FISH.ordinal()));
                            }
                        }

                    } else {
                        tier4(list, biomeTypesList);
                    }
                } else {
                    tier4(list, biomeTypesList);
                }
            }

            list.add(list.get(world.rand.nextInt(list.size())));
        } else {
            list = world.getLootTableManager().getLootTableFromLocation(LootTableList.GAMEPLAY_FISHING_TREASURE).generateLootForPools(world.rand, lootContextBuilder.build());
        }
        return list;
    }

    public static List<ItemStack> getLavaCatch(World world, BlockPos pos, Set<BiomeDictionary.Type> biomeTypesList, float luck) {
        List<ItemStack> tempList = new ArrayList<>();

        int chance = world.rand.nextInt(100) + Math.round(luck);
        if (!biomeTypesList.contains(BiomeDictionary.Type.NETHER)) {
            if (chance < 80) {
                tempList.add(new ItemStack(Items.FISH, 1, EnumFishType.OBSIDIFISH.ordinal()));
            } else if (chance < 95) {
                tempList.add(new ItemStack(Items.FISH, 1, EnumFishType.MAGMA_JELLYFISH.ordinal()));
            } else {
                if (chance < 98) {
                    tempList.add(new ItemStack(Blocks.SKULL, 1, 1)); //WITHER SKULL
                } else {
                    //TODO
//                    EnchantmentHelper.addRandomEnchantment(world.rand, new ItemStack(AFItem.ENCHANTED_SKULL, 1, 1), new RandomValueRange(40, 50).generateInt(world.rand), true);
                }
            }
        } else {
            if (chance < 40) {
                tempList.add(new ItemStack(Items.FISH, 1, EnumFishType.NETHER_SALMON.ordinal()));
            } else if (chance < 80) {
                tempList.add(new ItemStack(Items.FISH, 1, EnumFishType.MAGMA_JELLYFISH.ordinal()));
                tempList.add(new ItemStack(Items.FISH, 1, EnumFishType.QUARTZ_COD.ordinal()));
                tempList.add(new ItemStack(Items.FISH, 1, EnumFishType.WITHERED_CRUCIAN.ordinal()));
            } else if (chance < 95) {
                tempList.add(new ItemStack(Items.FISH, 1, EnumFishType.FLAREFIN_KOI.ordinal()));
                tempList.add(new ItemStack(Items.FISH, 1, EnumFishType.BLAZE_COD.ordinal()));
            } else {
                if (chance < 98) {
                    tempList.add(new ItemStack(Blocks.SKULL, 1, 1)); //WITHER SKULL
                } else {
                    //TODO
//                    EnchantmentHelper.addRandomEnchantment(world.rand, new ItemStack(AFItem.ENCHANTED_SKULL, 1, 1), new RandomValueRange(40, 50).generateInt(world.rand), true);
                }
            }
        }
        return tempList;
    }

    protected static void tier1(List<ItemStack> tempList, Set<BiomeDictionary.Type> biomeTypesList) {
        if (biomeTypesList.contains(BiomeDictionary.Type.OCEAN) || biomeTypesList.contains(BiomeDictionary.Type.BEACH)) {
            tempList.add(new ItemStack(Items.FISH, 1, EnumFishType.BLUE_JELLYFISH.ordinal()));
            tempList.add(new ItemStack(Items.FISH, 1, EnumFishType.ANGELFISH.ordinal()));
            tempList.add(new ItemStack(Items.FISH, 1, EnumFishType.SQUID.ordinal()));
        }
        if (biomeTypesList.contains(BiomeDictionary.Type.END)) {
            tempList.add(new ItemStack(Items.FISH, 1, EnumFishType.ENDERFIN.ordinal()));
        }
        if (tempList.isEmpty()) {
            tempList.add(new ItemStack(net.minecraft.init.Items.FISH, 1, 0)); //cod
            tempList.add(new ItemStack(Items.FISH, 1, EnumFishType.SQUID.ordinal()));
        }
    }

    protected static void tier2(List<ItemStack> tempList, Set<BiomeDictionary.Type> biomeTypesList) {
        if (biomeTypesList.contains(BiomeDictionary.Type.OCEAN) || biomeTypesList.contains(BiomeDictionary.Type.BEACH)) {
            tempList.add(new ItemStack(net.minecraft.init.Items.FISH, 1, 3)); //puffer
        }
        if (biomeTypesList.contains(BiomeDictionary.Type.END)) {
            tempList.add(new ItemStack(Items.FISH, 1, EnumFishType.PEARL_BASS.ordinal()));
        }
        if (biomeTypesList.contains(BiomeDictionary.Type.SANDY)) {
            tempList.add(new ItemStack(Items.FISH, 1, EnumFishType.SANDY_BASS.ordinal()));
        }
        if (biomeTypesList.contains(BiomeDictionary.Type.SNOWY)) {
            tempList.add(new ItemStack(Items.FISH, 1, EnumFishType.SNOWY_CRUCIAN.ordinal()));
        }
        if (biomeTypesList.contains(BiomeDictionary.Type.SWAMP)) {
            tempList.add(new ItemStack(Items.FISH, 1, EnumFishType.RUFFE.ordinal()));
        }
        if (biomeTypesList.contains(BiomeDictionary.Type.JUNGLE)) {
            tempList.add(new ItemStack(Items.FISH, 1, EnumFishType.PIRANHA.ordinal()));
        }
        if (tempList.isEmpty()) {
            tempList.add(new ItemStack(net.minecraft.init.Items.FISH, 1, 1)); //salmon
        }
    }

    protected static void tier3(List<ItemStack> tempList, Set<BiomeDictionary.Type> biomeTypesList) {
        if (biomeTypesList.contains(BiomeDictionary.Type.OCEAN) || biomeTypesList.contains(BiomeDictionary.Type.BEACH)) {
            tempList.add(new ItemStack(net.minecraft.init.Items.FISH, 1, 2)); // clown
        }
        if (biomeTypesList.contains(BiomeDictionary.Type.END)) {
            tempList.add(new ItemStack(Items.FISH, 1, EnumFishType.CHORUS_KOI.ordinal()));
        }
        if (biomeTypesList.contains(BiomeDictionary.Type.SANDY)) {
            tempList.add(new ItemStack(Items.FISH, 1, EnumFishType.GOLDEN_KOI.ordinal()));
        }
        if (biomeTypesList.contains(BiomeDictionary.Type.SNOWY)) {
            tempList.add(new ItemStack(Items.FISH, 1, EnumFishType.FROST_MINNOW.ordinal()));
        }
        if (biomeTypesList.contains(BiomeDictionary.Type.SWAMP)) {
            tempList.add(new ItemStack(Items.FISH, 1, EnumFishType.MUD_TUNA.ordinal()));
        }
        if (biomeTypesList.contains(BiomeDictionary.Type.JUNGLE)) {
            tempList.add(new ItemStack(Items.FISH, 1, EnumFishType.SPARKLING_EEL.ordinal()));
        }
        if (tempList.isEmpty()) {
            tempList.add(new ItemStack(Items.FISH, 1, EnumFishType.EXPLOSIVE_CRUCIAN.ordinal()));
        }
    }

    protected static void tier4(List<ItemStack> tempList, Set<BiomeDictionary.Type> biomeTypesList) {
        if (biomeTypesList.contains(BiomeDictionary.Type.OCEAN) || biomeTypesList.contains(BiomeDictionary.Type.BEACH)) {
            tempList.add(new ItemStack(Items.FISH, 1, EnumFishType.SPONGE_EATER.ordinal()));
        } else {
            tier3(tempList, biomeTypesList);
        }
    }
}
