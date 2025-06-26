package extraordinaryenergy;

import appeng.api.upgrades.Upgrades;
import appeng.core.definitions.AEItems;
import extraordinaryenergy.common.definitions.EEBlocks;
import extraordinaryenergy.common.definitions.EECreativeTabs;
import extraordinaryenergy.common.definitions.EEItems;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(ExtraordinaryEnergy.MODID)
public class ExtraordinaryEnergy {
    public static final String MODID = "extraordinary_energy";
    public static final String MOD_NAME = "Extraordinary Energy";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public ExtraordinaryEnergy(IEventBus eventBus, ModContainer container) {
        EEBlocks.DR.register(eventBus);
        EEItems.DR.register(eventBus);
        EECreativeTabs.DR.register(eventBus);

        eventBus.addListener(ExtraordinaryEnergy::initUpgrades);
    }

    public static ResourceLocation makeId(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    private static void initUpgrades(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Upgrades.add(AEItems.INVERTER_CARD, EEItems.ITEM_DISK_DRIVE_INF, 1);
            Upgrades.add(AEItems.FUZZY_CARD, EEItems.ITEM_DISK_DRIVE_INF, 1);
            Upgrades.add(AEItems.INVERTER_CARD, EEItems.FLUID_DISK_DRIVE_INF, 1);
            Upgrades.add(AEItems.INVERTER_CARD, EEItems.CHEMICAL_DISK_DRIVE_INF, 1);
        });
    }
}
