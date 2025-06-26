package extraordinaryenergy.datagen;

import extraordinaryenergy.ExtraordinaryEnergy;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@SuppressWarnings({"removal", "unused"})
@EventBusSubscriber(modid = ExtraordinaryEnergy.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EEDataGen {

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        var generator = event.getGenerator();
        var output = generator.getPackOutput();
        var existing = event.getExistingFileHelper();
        var lookup = event.getLookupProvider();
        var localization = new EELocalizationProvider(output);
        var blockTags = new EETagProvider.EEBlockTagProvider(output, lookup, existing);
        var itemTags = new EETagProvider.EEItemTagProvider(output, lookup, blockTags.contentsGetter(), existing);

        generator.addProvider(event.includeClient(), localization);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), itemTags);
        generator.addProvider(event.includeServer(), new EEBlockLootProvider(output, lookup));
    }
}
