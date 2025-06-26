package extraordinaryenergy.common.items;

import net.minecraft.world.item.ItemStack;

public class UltimateDyeBase extends MaterialItem{
    public UltimateDyeBase(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
