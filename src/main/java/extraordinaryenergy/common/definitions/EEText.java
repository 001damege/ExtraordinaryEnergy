package extraordinaryenergy.common.definitions;

import extraordinaryenergy.ExtraordinaryEnergy;
import guideme.internal.data.LocalizationEnum;

public enum EEText implements LocalizationEnum {
    Null("Texture is Missing!", Type.TOOLTIP),
    ModName("Extraordinary Energy", Type.GUI)
    ;

    private final String englishText;
    private final Type type;

    EEText(String englishText, Type type) {
        this.englishText = englishText;
        this.type = type;
    }

    @Override
    public String getEnglishText() {
        return englishText;
    }

    @Override
    public String getTranslationKey() {
        return String.format("%s.%s.%s", type.root, ExtraordinaryEnergy.MODID, name());
    }

    private enum Type {
        GUI("gui"),
        TOOLTIP("tooltips");

        private final String root;

        Type(String root) {
            this.root = root;
        }
    }
}
