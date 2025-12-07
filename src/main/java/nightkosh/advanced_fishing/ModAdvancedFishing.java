package nightkosh.advanced_fishing;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import nightkosh.advanced_fishing.api.AdvancedFishingAPI;
import nightkosh.advanced_fishing.api.ModInfo;
import nightkosh.advanced_fishing.core.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Advanced Fishing
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@Mod(ModInfo.ID)
public class ModAdvancedFishing {

    public static final Logger LOGGER = LogManager.getLogger(ModInfo.ID);

    public static ModAdvancedFishing INSTANCE;

    public ModAdvancedFishing() {
        INSTANCE = this;

        AdvancedFishingAPI.PARTICLES_MANAGER = ParticlesManager.INSTANCE;
        AdvancedFishingAPI.CATCH_MANAGER = CatchManager.INSTANCE;
        AdvancedFishingAPI.MATERIAL_MANAGER = MaterialManager.INSTANCE;
        AdvancedFishingAPI.FISH_TAB = AFTabs.ADVANCED_FISHING_TAB;

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, AFConfig.SPEC, ModInfo.ID + ".toml");

        var eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        AFItems.register(eventBus);
        AFEntities.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new EventsHandler());
    }

}
