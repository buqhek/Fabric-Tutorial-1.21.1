package net.mustardking.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mustardking.tutorialmod.TutorialMod;

public class ModItems {

    // Items:
    // Pink Garnet item. The name of the item must be all lowercase and no spaces
    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings()));
    // Raw Pink Garnet
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(new Item.Settings()));

    // Helper function for registering mod items
    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }


    // Registers all the items for the mod in the 'onInitialize' function in the main method
    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering mod items for " + TutorialMod.MOD_ID);

        // Adding the items to the 'Ingrediants' item group on the creative menu
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PINK_GARNET);
            entries.add(RAW_PINK_GARNET);
        });
    }
}
