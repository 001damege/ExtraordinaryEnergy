package extraordinaryenergy.datagen;

import extraordinaryenergy.ExtraordinaryEnergy;
import extraordinaryenergy.common.definitions.EEBlocks;
import extraordinaryenergy.common.definitions.EEItems;
import extraordinaryenergy.common.definitions.EEText;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class EELocalizationProvider extends LanguageProvider {
    public EELocalizationProvider(PackOutput output) {
        super(output, ExtraordinaryEnergy.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        for (var item : EEItems.getItems()) {
            add(item.asItem(), item.getEnglishName());
        }
        for (var block : EEBlocks.getBlocks()) {
            add(block.block(), block.getEnglishName());
        }
        for (var text : EEText.values()) {
            add(text.getTranslationKey(), text.getEnglishText());
        }
    }

    @Override
    public String getName() {
        return "Language";
    }
}
