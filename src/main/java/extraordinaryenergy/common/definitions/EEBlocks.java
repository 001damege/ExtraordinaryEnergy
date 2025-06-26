package extraordinaryenergy.common.definitions;

import appeng.core.definitions.BlockDefinition;
import appeng.core.definitions.ItemDefinition;
import extraordinaryenergy.ExtraordinaryEnergy;
import extraordinaryenergy.common.blocks.GlowBlock;
import extraordinaryenergy.common.blocks.MaterialBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public final class EEBlocks {
    public static final DeferredRegister.Blocks DR = DeferredRegister.createBlocks(ExtraordinaryEnergy.MODID);
    private static final List<BlockDefinition<?>> BLOCKS = new ArrayList<>();

    public static List<BlockDefinition<?>> getBlocks() {
        return Collections.unmodifiableList(BLOCKS);
    }

    public static final BlockDefinition<MaterialBlock> WTF_CASING = block("Uncanny Casing", "wtf_casing", () -> new MaterialBlock(MaterialBlock.metalProps()), BlockItem::new);
    public static final BlockDefinition<MaterialBlock> ERRC = block("Electricity Resistant Reinforced Casing", "electricity_resistant_reinforced_casing", () -> new MaterialBlock(MaterialBlock.metalProps()), BlockItem::new);
    public static final BlockDefinition<MaterialBlock> URANITE_FLUX_CASING = block("Uranite-Flux Casing", "uranite_flux_casing", () -> new MaterialBlock(MaterialBlock.metalProps()), BlockItem::new);
    public static final BlockDefinition<TransparentBlock> LASER_GLASS = block("Laser Induction Glass", "laser_glass", () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)), BlockItem::new);
    public static final BlockDefinition<MaterialBlock> BLACK_CASING = block("Darkness Casing", "black_casing", () -> new MaterialBlock(MaterialBlock.metalProps()), BlockItem::new);
    public static final BlockDefinition<MaterialBlock> REINFORCED_STEEL_CASING = block("Reinforced Steel Casing", "reinforced_steel_casing", () -> new MaterialBlock(MaterialBlock.metalProps()), BlockItem::new);
    public static final BlockDefinition<MaterialBlock> TIN_CASING = block("Tin Casing", "tin_casing", () -> new MaterialBlock(MaterialBlock.metalProps()), BlockItem::new);
    public static final BlockDefinition<MaterialBlock> TIN_CASING_INCOMPLETE = block("Incomplete Tin Casing", "tin_casing_incomplete", () -> new MaterialBlock(MaterialBlock.metalProps()), BlockItem::new);
    public static final BlockDefinition<MaterialBlock> FUSION_COIL = block("Creativity Fusion Coil", "fusion_coil", () -> new MaterialBlock(MaterialBlock.metalProps()), BlockItem::new);
    public static final BlockDefinition<MaterialBlock> BLAST_COIL = block("Blast Coil", "blast_coil", () -> new MaterialBlock(MaterialBlock.metalProps()), BlockItem::new);
    public static final BlockDefinition<MaterialBlock> FUSION_CASING = block("Creativity Fusion Casing", "fusion_casing", () -> new MaterialBlock(MaterialBlock.metalProps()), BlockItem::new);
    public static final BlockDefinition<MaterialBlock> CHARGED_REDSTONE_BLOCK = block("Charged Redstone Block", "charged_redstone_block", () -> new MaterialBlock(MaterialBlock.metalProps()), BlockItem::new);
    public static final BlockDefinition<MaterialBlock> COMPRESSED_SPS_CASING = block("Compressed SPS Casing", "compressed_sps_casing", () -> new MaterialBlock(MaterialBlock.metalProps()), GlowBlock::new);

    private static <T extends Block> BlockDefinition<T> block(String englishName, String id, Supplier<T> blockSupplier, @Nullable BiFunction<Block, Item.Properties, BlockItem> factory) {
        var block = DR.register(id, blockSupplier);
        var item = EEItems.DR.register(id, () -> Objects.requireNonNull(factory).apply(block.get(), new Item.Properties()));
        var def = new BlockDefinition<>(englishName, block, new ItemDefinition<>(englishName, item));
        BLOCKS.add(def);
        return def;
    }
}
