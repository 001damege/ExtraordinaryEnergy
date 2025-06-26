package extraordinaryenergy.common.definitions;

import appeng.core.definitions.ItemDefinition;
import extraordinaryenergy.ExtraordinaryEnergy;
import extraordinaryenergy.common.items.*;
import io.github.lapis256.ae2_mega_things.integration.appmek.item.ChemicalDISKDrive;
import io.github.lapis256.ae2_mega_things.item.FluidDISKDrive;
import io.github.lapis256.ae2_mega_things.item.ItemDISKDrive;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public final class EEItems {
    public static final DeferredRegister.Items DR = DeferredRegister.createItems(ExtraordinaryEnergy.MODID);
    private static final List<ItemDefinition<?>> ITEMS = new ArrayList<>();

    public static List<ItemDefinition<?>> getItems() {
        return Collections.unmodifiableList(ITEMS);
    }

    public static final ItemDefinition<MaterialItem> ENERGY_CATALYST = item("Energy Catalyst", "energy_catalyst", MaterialItem::new);
    public static final ItemDefinition<MaterialItem> ITEM_CATALYST = item("Item Catalyst", "item_catalyst", MaterialItem::new);
    public static final ItemDefinition<MaterialItem> FLUID_CATALYST = item("Fluid Catalyst", "fluid_catalyst", MaterialItem::new);
    public static final ItemDefinition<MaterialItem> CHEMICAL_CATALYST = item("Chemical Catalyst", "chemical_catalyst", MaterialItem::new);
    public static final ItemDefinition<MaterialItem> EMC = item("Energy Matter Cluster", "emc", MaterialItem::new);
    public static final ItemDefinition<TheNull> THE_NULL = item("The Null", "null", TheNull::new);
    public static final ItemDefinition<MaterialItem> LDPE = item("LDPE Wrapping Film", "ldpe", MaterialItem::new);
    public static final ItemDefinition<MaterialItem> STRAY_CAT = item("Stary Cat", "cat_crystal", MaterialItem::new);
    public static final ItemDefinition<TinyAntimatter> TINY_ANTIMATTER = item("Tiny Antimatter", "tiny_antimatter", TinyAntimatter::new);
    public static final ItemDefinition<MaterialItem> DUST_AMETHYST = item("Amethyst Dust", "dust_amethyst", MaterialItem::new);
    public static final ItemDefinition<BedrockiumIngot> BEDROCKIUM_INGOT = item("Bedrockium Ingot", "bedrockium_ingot", BedrockiumIngot::new);
    public static final ItemDefinition<MaterialItem> ULTIMATE_ALLOY_INGOT = item("Ultimate Alloy Ingot", "ultimate_alloy_ingot", MaterialItem::new);
    public static final ItemDefinition<NeutronItem> NEUTRONIUM_INGOT = item("Neutronium Ingot", "neutronium_ingot", NeutronItem::new);
    public static final ItemDefinition<InfinityIngot> INFINITY_INGOT = item("Infinity Ingot", "infinity_ingot", InfinityIngot::new);
    public static final ItemDefinition<UltimateDyeBase> ULTIMATE_DYE_BASE = item("Ultimate Dye Base", "ultimate_dye_base", UltimateDyeBase::new);
    public static final ItemDefinition<MaterialItem> BASIC_SUPER_CIRCUIT = item("Basic Super Circuit", "basic_super_circuit", MaterialItem::new);
    public static final ItemDefinition<MaterialItem> ADV_SUPER_CIRCUIT = item("Advanced Super Circuit", "advanced_super_circuit", MaterialItem::new);
    public static final ItemDefinition<MaterialItem> ELITE_SUPER_CIRCUIT = item("Elite Super Circuit", "elite_super_circuit", MaterialItem::new);
    public static final ItemDefinition<MaterialItem> ULTIMATE_SUPER_CIRCUIT = item("Ultimate Super Circuit", "ultimate_super_circuit", MaterialItem::new);
    public static final ItemDefinition<MaterialItem> ABSOLUTE_SUPER_CIRCUIT = item("Absolute Super Circuit", "absolute_super_circuit", MaterialItem::new);
    public static final ItemDefinition<MaterialItem> SUPREME_SUPER_CIRCUIT = item("Supreme Super Circuit", "supreme_super_circuit", MaterialItem::new);
    public static final ItemDefinition<MaterialItem> COSMIC_SUPER_CIRCUIT = item("Cosmic Super Circuit", "cosmic_super_circuit", MaterialItem::new);
    public static final ItemDefinition<MaterialItem> INFINITY_SUPER_CIRCUIT = item("Infinity Super Circuit", "infinity_super_circuit", MaterialItem::new);

    public static final ItemDefinition<MaterialItem> ULTIMATE_STORAGE_HOUSING = item("Ultimate Storage Housing", "ultimate_storage_housing", MaterialItem::new);
    public static final ItemDefinition<MaterialItem> ITEM_CELL_COMPONENT_INF = item("Infinity Item Cell Component", "item_cell_component_inf", MaterialItem::new);
    public static final ItemDefinition<MaterialItem> FLUID_CELL_COMPONENT_INF = item("Infinity Fluid Cell Component", "fluid_cell_component_inf", MaterialItem::new);
    public static final ItemDefinition<MaterialItem> CHEMICAL_CELL_COMPONENT_INF = item("Infinity Chemical Cell Component", "chemical_cell_component_inf", MaterialItem::new);

    public static final ItemDefinition<ItemDISKDrive> ITEM_DISK_DRIVE_INF = item("Infinity Item Disk Drive", "inf_item_disk_drive", p -> new ItemDISKDrive(ITEM_CELL_COMPONENT_INF, ULTIMATE_STORAGE_HOUSING, Integer.MAX_VALUE / 1000, 10.0f));
    public static final ItemDefinition<FluidDISKDrive> FLUID_DISK_DRIVE_INF = item("Infinity Fluid Disk Drive", "inf_fluid_disk_drive", p -> new FluidDISKDrive(FLUID_CELL_COMPONENT_INF, ULTIMATE_STORAGE_HOUSING, Integer.MAX_VALUE / 1000, 10.0f));
    public static final ItemDefinition<ChemicalDISKDrive> CHEMICAL_DISK_DRIVE_INF = item("Infinity Chemical Disk Drive", "inf_chemical_disk_drive", p -> new ChemicalDISKDrive(CHEMICAL_CELL_COMPONENT_INF, ULTIMATE_STORAGE_HOUSING, Integer.MAX_VALUE / 1000, 10.0f));

    private static <T extends Item> ItemDefinition<T> item(String englishName, String id, Function<Item.Properties, T> factory) {
        var def = new ItemDefinition<>(englishName, DR.registerItem(id, factory));
        ITEMS.add(def);
        return def;
    }
}
