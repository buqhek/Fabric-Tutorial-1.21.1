package net.mustardking.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.mustardking.tutorialmod.block.ModBlocks;
import net.mustardking.tutorialmod.item.ModItemGroups;
import net.mustardking.tutorialmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
    public static final String MOD_ID = "tutorialmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        //	Registering all mod assets
        ModItemGroups.registerItemGroups(); // Creative Mode Item Group
        ModItems.registerModItems();        // Mod Items
        ModBlocks.registerModBlocks();      // Mod Blocks

        LOGGER.info("Hello Fabric world!");
    }
}