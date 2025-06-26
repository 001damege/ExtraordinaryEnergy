package extraordinaryenergy.common.blocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class GlowBlock extends BlockItem {

    public GlowBlock(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
