package extraordinaryenergy.common.items;

import net.minecraft.world.item.ItemStack;

public class TinyAntimatter extends MaterialItem{
    public TinyAntimatter(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
