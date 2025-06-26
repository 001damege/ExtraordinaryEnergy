package extraordinaryenergy.datagen;

import extraordinaryenergy.common.definitions.EEBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.ExplosionCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class EEBlockLootProvider extends LootTableProvider {
    public EEBlockLootProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, Collections.emptySet(), Collections.singletonList(new SubProviderEntry(EESubProvider::new, LootContextParamSets.BLOCK)), provider);
    }

    public static class EESubProvider extends BlockLootSubProvider {
        protected EESubProvider(HolderLookup.Provider provider) {
            super(Set.of(), FeatureFlags.DEFAULT_FLAGS, provider);
        }

        @Override
        public void generate(@NotNull BiConsumer<ResourceKey<LootTable>, LootTable.Builder> writer) {
            generate();
            map.forEach(writer);
        }

        @Override
        protected void generate() {
            for (var block : EEBlocks.getBlocks()) {
                add(block.block(), LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(LootItem.lootTableItem(block))
                                .when(ExplosionCondition.survivesExplosion())));
            }
        }
    }
}
