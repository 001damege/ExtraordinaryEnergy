package extraordinaryenergy.common.items;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

public class InfinityIngot extends MaterialItem{
    public InfinityIngot(Properties properties) {
        super(properties.rarity(Rarity.EPIC).fireResistant());
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
