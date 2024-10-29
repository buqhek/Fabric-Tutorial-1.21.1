package net.mustardking.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.mustardking.tutorialmod.TutorialMod;
import net.mustardking.tutorialmod.block.ModBlocks;

public class ModItemGroups {

    // Creates the Pink Garnet Items tab in the creative menu
    public static final ItemGroup PINK_GARNET_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "pink_garnet_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PINK_GARNET)) // Gives item group the pink garnet icon
                    .displayName(Text.translatable("itemgroup.tutorialmod.pink_garnet_items"))  // Gives item group the name we want from the green directory location
                    .entries((displayContext, entries) -> {
                        // Add Pink Garnet Items here below:
                        entries.add(ModItems.PINK_GARNET);
                        entries.add(ModItems.RAW_PINK_GARNET);
                    })
                    .build());

    // Creates the Pink Garnet Blocks tab in the creative menu
    public static final ItemGroup PINK_GARNET_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "pink_garnet_block"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.PINK_GARNET_BLOCK)) // Gives item group the pink garnet icon
                    .displayName(Text.translatable("itemgroup.tutorialmod.pink_garnet_blocks"))  // Gives item group the name we want from the green directory location
                    .entries((displayContext, entries) -> {
                        // Add Pink Garnet Blocks here below:
                        entries.add(ModBlocks.PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.PINK_GARNET_ORE);
                        entries.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
                    })
                    .build());


    public static void registerItemGroups() {
        TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID);

    }
}
