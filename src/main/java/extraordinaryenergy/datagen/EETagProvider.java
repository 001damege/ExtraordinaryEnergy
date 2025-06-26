package extraordinaryenergy.datagen;

import appeng.core.definitions.BlockDefinition;
import extraordinaryenergy.ExtraordinaryEnergy;
import extraordinaryenergy.common.definitions.EEBlocks;
import extraordinaryenergy.common.definitions.EEItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class EETagProvider {

    public static class EEBlockTagProvider extends IntrinsicHolderTagsProvider<Block> {
        public EEBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, @Nullable ExistingFileHelper existing) {
            super(output, Registries.BLOCK, registries, b -> BuiltInRegistries.BLOCK.getResourceKey(b).orElseThrow(), ExtraordinaryEnergy.MODID, existing);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            Map<BlockDefinition<?>, List<TagKey<Block>>> specialTags = new HashMap<>();
            var defaultTags = List.of(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL);

            for (var block : EEBlocks.getBlocks()) {
                for (var desiredTag : specialTags.getOrDefault(block, defaultTags)) {
                    tag(desiredTag).add(block.block());
                }
            }
        }

        @Override
        public String getName() {
            return "Tags (Block)";
        }
    }

    public static class EEItemTagProvider extends ItemTagsProvider {
        public EEItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, CompletableFuture<TagsProvider.TagLookup<Block>> blockTags, ExistingFileHelper existing) {
            super(output, registries, blockTags, ExtraordinaryEnergy.MODID, existing);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            tag(Tags.Items.INGOTS)
                    .add(EEItems.ULTIMATE_ALLOY_INGOT.asItem())
                    .add(EEItems.BEDROCKIUM_INGOT.asItem())
                    .add(EEItems.NEUTRONIUM_INGOT.asItem())
                    .add(EEItems.INFINITY_INGOT.asItem());
            tag(Tags.Items.DUSTS)
                    .add(EEItems.DUST_AMETHYST.asItem());
        }

        @Override
        public String getName() {
            return "Tags (Item)";
        }
    }
}
