package extraordinaryenergy.common.items;

import net.minecraft.world.item.Rarity;

public class NeutronItem extends MaterialItem{
    public NeutronItem(Properties properties) {
        super(properties.rarity(Rarity.RARE));
    }
}
