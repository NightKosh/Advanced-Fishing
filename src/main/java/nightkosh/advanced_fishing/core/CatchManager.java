package nightkosh.advanced_fishing.core;

import net.minecraft.block.Block;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.common.BiomeDictionary;
import nightkosh.advanced_fishing.api.ModInfo;
import nightkosh.advanced_fishing.api.fishing_catch.ICatch;
import nightkosh.advanced_fishing.api.fishing_catch.ICatchManager;
import nightkosh.advanced_fishing.api.fishing_catch.IWaterCatch;
import nightkosh.advanced_fishing.api.fishing_catch.IWaterCondition;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class CatchManager implements ICatchManager {

    public static final CatchManager INSTANCE = new CatchManager();
    private static final Logger LOGGER = LogManager.getLogger(ModInfo.ID);

    private static final Map<Block, ICatch> CATCH = new HashMap<>();
    private static final Map<IWaterCondition, IWaterCatch> CATCH_WATER = new HashMap<>();

    static {
        CATCH.put(Blocks.WATER, CatchManager::getWaterCatch);
        CATCH.put(Blocks.FLOWING_WATER, CatchManager::getWaterCatch);
        CATCH.put(Blocks.LAVA, CatchManager::getLavaCatch);
        CATCH.put(Blocks.FLOWING_LAVA, CatchManager::getLavaCatch);

        CATCH_WATER.put(CatchManager::getOceanCondition, CatchManager::getOceanCatch);
        CATCH_WATER.put(CatchManager::getBeachCondition, CatchManager::getBeachCatch);
        CATCH_WATER.put(CatchManager::getEndCondition, CatchManager::getEndCatch);
        CATCH_WATER.put(CatchManager::getSandyCondition, CatchManager::getSandyCatch);
        CATCH_WATER.put(CatchManager::getSnowyCondition, CatchManager::getSnowyCatch);
        CATCH_WATER.put(CatchManager::getSwampCondition, CatchManager::getSwampCatch);
        CATCH_WATER.put(CatchManager::getJungleCondition, CatchManager::getJungleCatch);
        CATCH_WATER.put(CatchManager::getMushroomCondition, CatchManager::getMushroomCatch);
        CATCH_WATER.put(CatchManager::getDeadCondition, CatchManager::getDeadCatch);
    }

    @Override
    public void addCatch(Block block, ICatch fishingCatch) {
        CATCH.put(block, fishingCatch);
    }

    @Override
    public void addWaterCatch(IWaterCondition condition, IWaterCatch waterCatch) {
        CATCH_WATER.put(condition, waterCatch);
    }

    @Override
    public ICatch getCatch(Block block) {
        if (Config.debugMode) {
            LOGGER.log(Level.INFO, "Fishing in : " + block.toString());
        }
        return CATCH.getOrDefault(block, CatchManager::getWaterCatch);
    }

    public static List<ItemStack> getWaterCatch(World world, BlockPos pos, float luck) {
        int chance = world.rand.nextInt(100) + Math.round(luck);

        if (chance < 10) {
            if (Config.debugMode) {
                LOGGER.log(Level.INFO, "junk");
            }
            return getCatch(world, LootTableList.GAMEPLAY_FISHING_JUNK, luck);
        } else if (chance < 90) {
            List<ItemStack> list = new ArrayList<>();
            if (!world.canBlockSeeSky(pos)) {
                chance = world.rand.nextInt(100) + Math.round(luck);
                if (chance >= 95) {
                    if (Config.debugMode) {
                        LOGGER.log(Level.INFO, "Fishing in cave.");
                    }
                    if (pos.getY() < 50) {
                        list.addAll(getCatch(world, LootTables.FISHING_CAVE_50, luck));
                        if (Config.debugMode) {
                            LOGGER.log(Level.INFO, "< 50");
                        }
                        if (pos.getY() < 40) {
                            list.addAll(getCatch(world, LootTables.FISHING_CAVE_40, luck));
                            if (Config.debugMode) {
                                LOGGER.log(Level.INFO, "< 40");
                            }
                            if (pos.getY() < 25) {
                                list.addAll(getCatch(world, LootTables.FISHING_CAVE_25, luck));
                                if (Config.debugMode) {
                                    LOGGER.log(Level.INFO, "< 25");
                                }
                            }
                        }
                    }
                }
            }

            if (list.isEmpty()) {
                Biome biome = world.getBiome(pos);
                Set<BiomeDictionary.Type> biomeTypesList = BiomeDictionary.getTypes(biome);

                if (Config.debugMode) {
                    LOGGER.log(Level.INFO, biome.getBiomeName());
                    LOGGER.log(Level.INFO, biomeTypesList.toString());
                }

                for (IWaterCondition condition : CATCH_WATER.keySet()) {
                    if (condition.shouldGetCatch(world, pos, biome, biomeTypesList, luck)) {
                        list = CATCH_WATER.get(condition).getCatch(world, pos, biome, biomeTypesList, luck);
                        break;
                    }
                }

                if (list.isEmpty()) {
                    list = getCatch(world, LootTables.FISHING, luck);
                    if (Config.debugMode) {
                        LOGGER.log(Level.INFO, "No catch! Trying to get default catch.");
                    }
                }
            }

            return list;
        } else {
            if (Config.debugMode) {
                LOGGER.log(Level.INFO, "treasure");
            }
            return getCatch(world, LootTableList.GAMEPLAY_FISHING_TREASURE, luck);
        }
    }


    public static boolean getOceanCondition(World world, BlockPos pos, Biome biome, Set<BiomeDictionary.Type> biomeTypesList, float luck) {
        return biomeTypesList.contains(BiomeDictionary.Type.OCEAN);
    }

    public static boolean getBeachCondition(World world, BlockPos pos, Biome biome, Set<BiomeDictionary.Type> biomeTypesList, float luck) {
        return biomeTypesList.contains(BiomeDictionary.Type.BEACH);
    }

    public static boolean getEndCondition(World world, BlockPos pos, Biome biome, Set<BiomeDictionary.Type> biomeTypesList, float luck) {
        return biomeTypesList.contains(BiomeDictionary.Type.END);
    }

    public static boolean getSandyCondition(World world, BlockPos pos, Biome biome, Set<BiomeDictionary.Type> biomeTypesList, float luck) {
        return biomeTypesList.contains(BiomeDictionary.Type.SANDY) || biomeTypesList.contains(BiomeDictionary.Type.MESA) || biomeTypesList.contains(BiomeDictionary.Type.SAVANNA);
    }

    public static boolean getSnowyCondition(World world, BlockPos pos, Biome biome, Set<BiomeDictionary.Type> biomeTypesList, float luck) {
        return biomeTypesList.contains(BiomeDictionary.Type.SNOWY) || biomeTypesList.contains(BiomeDictionary.Type.CONIFEROUS);
    }

    public static boolean getSwampCondition(World world, BlockPos pos, Biome biome, Set<BiomeDictionary.Type> biomeTypesList, float luck) {
        return biomeTypesList.contains(BiomeDictionary.Type.SWAMP);
    }

    public static boolean getJungleCondition(World world, BlockPos pos, Biome biome, Set<BiomeDictionary.Type> biomeTypesList, float luck) {
        return biomeTypesList.contains(BiomeDictionary.Type.JUNGLE);
    }

    public static boolean getMushroomCondition(World world, BlockPos pos, Biome biome, Set<BiomeDictionary.Type> biomeTypesList, float luck) {
        return biomeTypesList.contains(BiomeDictionary.Type.MUSHROOM);
    }

    public static boolean getDeadCondition(World world, BlockPos pos, Biome biome, Set<BiomeDictionary.Type> biomeTypesList, float luck) {
        return biomeTypesList.contains(BiomeDictionary.Type.DEAD);
    }

    public static List<ItemStack> getOceanCatch(World world, BlockPos pos, Biome biome, Set<BiomeDictionary.Type> biomeTypesList, float luck) {
        if (biome == Biomes.DEEP_OCEAN) {
            return getCatch(world, LootTables.FISHING_OCEAN_DEEP, luck);
        } else {
            return getCatch(world, LootTables.FISHING_OCEAN, luck);
        }
    }

    public static List<ItemStack> getBeachCatch(World world, BlockPos pos, Biome biome, Set<BiomeDictionary.Type> biomeTypesList, float luck) {
        return getCatch(world, LootTables.FISHING_OCEAN, luck);
    }

    public static List<ItemStack> getEndCatch(World world, BlockPos pos, Biome biome, Set<BiomeDictionary.Type> biomeTypesList, float luck) {
        return getCatch(world, LootTables.FISHING_END, luck);
    }

    public static List<ItemStack> getSandyCatch(World world, BlockPos pos, Biome biome, Set<BiomeDictionary.Type> biomeTypesList, float luck) {
        return getCatch(world, LootTables.FISHING_SANDY, luck);
    }

    public static List<ItemStack> getSnowyCatch(World world, BlockPos pos, Biome biome, Set<BiomeDictionary.Type> biomeTypesList, float luck) {
        return getCatch(world, LootTables.FISHING_SNOWY, luck);
    }

    public static List<ItemStack> getSwampCatch(World world, BlockPos pos, Biome biome, Set<BiomeDictionary.Type> biomeTypesList, float luck) {
        return getCatch(world, LootTables.FISHING_SWAMP, luck);
    }

    public static List<ItemStack> getJungleCatch(World world, BlockPos pos, Biome biome, Set<BiomeDictionary.Type> biomeTypesList, float luck) {
        return getCatch(world, LootTables.FISHING_JUNGLE, luck);
    }

    public static List<ItemStack> getMushroomCatch(World world, BlockPos pos, Biome biome, Set<BiomeDictionary.Type> biomeTypesList, float luck) {
        return getCatch(world, LootTables.FISHING_MUSHROOM, luck);
    }

    public static List<ItemStack> getDeadCatch(World world, BlockPos pos, Biome biome, Set<BiomeDictionary.Type> biomeTypesList, float luck) {
        return getCatch(world, LootTables.FISHING_DEAD, luck);
    }

    public static List<ItemStack> getLavaCatch(World world, BlockPos pos, float luck) {
        Biome biome = world.getBiome(pos);
        Set<BiomeDictionary.Type> biomeTypesList = BiomeDictionary.getTypes(biome);

        if (Config.debugMode) {
            LOGGER.log(Level.INFO, biome.getBiomeName());
            LOGGER.log(Level.INFO, biomeTypesList.toString());
        }

        if (biomeTypesList.contains(BiomeDictionary.Type.NETHER)) {
            int chance = world.rand.nextInt(100) + Math.round(luck);
            if (chance < 95) {
                return getCatch(world, LootTables.FISHING_LAVA_NETHER, luck);
            } else {
                return getCatch(world, LootTables.FISHING_LAVA_NETHER_TREASURE, luck);
            }
        } else {
            return getCatch(world, LootTables.FISHING_LAVA, luck);
        }
    }

    public static List<ItemStack> getCatch(World world, ResourceLocation lootTable, float luck) {
        LootContext.Builder lootContextBuilder = new LootContext.Builder((WorldServer) world);
        lootContextBuilder.withLuck(luck);

        return world.getLootTableManager().getLootTableFromLocation(lootTable).generateLootForPools(world.rand, lootContextBuilder.build());
    }
}
