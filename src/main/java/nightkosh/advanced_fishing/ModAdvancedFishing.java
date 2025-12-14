package nightkosh.advanced_fishing;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import nightkosh.advanced_fishing.api.AdvancedFishingAPI;
import nightkosh.advanced_fishing.api.ModInfo;
import nightkosh.advanced_fishing.core.*;
import nightkosh.advanced_fishing.event.AFEventsHandler;
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

    public ModAdvancedFishing(IEventBus eventBus, ModContainer container) {
        INSTANCE = this;

        container.registerConfig(ModConfig.Type.COMMON, AFConfig.SPEC, ModInfo.ID + ".toml");

        AFTabs.register(eventBus);
        AFItems.register(eventBus);
        AFEntities.register(eventBus);

        NeoForge.EVENT_BUS.register(new AFEventsHandler());

        AdvancedFishingAPI.PARTICLES_MANAGER = ParticlesManager.INSTANCE;
        AdvancedFishingAPI.CATCH_MANAGER = CatchManager.INSTANCE;
        AdvancedFishingAPI.MATERIAL_MANAGER = MaterialManager.INSTANCE;
        //TODO
//        AdvancedFishingAPI.FISH_TAB = AFTabs.ADVANCED_FISHING_TAB.get();
    }

}
