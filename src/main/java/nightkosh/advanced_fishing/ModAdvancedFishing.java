package nightkosh.advanced_fishing;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import nightkosh.advanced_fishing.core.*;
import nightkosh.advanced_fishing.proxy.CommonProxy;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION)
public class ModAdvancedFishing {

    @Mod.Instance(ModInfo.ID)
    public static ModAdvancedFishing INSTANCE;

    @SidedProxy(clientSide = "nightkosh.advanced_fishing.proxy.ClientProxy", serverSide = "nightkosh.advanced_fishing.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        new Config(event.getModConfigurationDirectory()).getConfigs();

        Tabs.registration();

        Entity.registration();
    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new EventsHandler());

        Recipes.registration();
        Recipes.smeltingRecipesRegistration();

        proxy.registerMobsRenderers();
    }
}
