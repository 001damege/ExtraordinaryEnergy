package extraordinaryenergy.common.definitions;

import appeng.core.definitions.BlockDefinition;
import appeng.core.definitions.ItemDefinition;
import extraordinaryenergy.ExtraordinaryEnergy;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;

public final class EECreativeTabs {
    public static final DeferredRegister<CreativeModeTab> DR = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExtraordinaryEnergy.MODID);

    static {
        DR.register("tab", () -> CreativeModeTab.builder()
                .title(EEText.ModName.text())
                .icon(EEItems.STRAY_CAT::stack)
                .displayItems(EECreativeTabs::populateTab)
                .build());
    }

    private static void populateTab(CreativeModeTab.ItemDisplayParameters params, CreativeModeTab.Output output) {
        var itemDefs = new ArrayList<ItemDefinition<?>>();
        itemDefs.addAll(EEItems.getItems());
        itemDefs.addAll(EEBlocks.getBlocks().stream().map(BlockDefinition::item).toList());

        for (var itemDef : itemDefs) {
            var item = itemDef.asItem();
            output.accept(item);
        }
    }
}
