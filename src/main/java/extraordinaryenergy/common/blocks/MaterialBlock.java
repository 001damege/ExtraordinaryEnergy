package extraordinaryenergy.common.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

public class MaterialBlock extends Block {
    public MaterialBlock(Properties properties) {
        super(properties.requiresCorrectToolForDrops());
    }

    public static Properties defaultProps(MapColor mapColor, SoundType soundType) {
        return Properties.of().strength(2.2f, 11.0f).mapColor(mapColor).sound(soundType);
    }

    public static Properties stoneProps() {
        return defaultProps(MapColor.STONE, SoundType.STONE).forceSolidOn();
    }

    public static Properties metalProps() {
        return defaultProps(MapColor.METAL, SoundType.METAL).forceSolidOn();
    }

    public static Properties glassProps() {
        return defaultProps(MapColor.NONE, SoundType.GLASS);
    }


}
