package net.mustardking.tutorialmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class ChiselItem extends Item {
    // Map of all blocks supported by the chisel. Added manually, and in pairs (hence the coding style)
    private static final Map<Block, Block> supported_chisel_blocks =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.STONE_BRICKS, Blocks.CRACKED_STONE_BRICKS,
                    Blocks.CRACKED_STONE_BRICKS, Blocks.CHISELED_STONE_BRICKS,
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS
            );

    public ChiselItem(Settings settings) {
        super(settings);
    }

    // Since this is a chisel, we will want to have it change the texture of a block when you right-click
    // on it. Hence, we will override the following function in order to change and use that property.
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        // Get a variable for the "world" to change the block's properties
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        // Now, having collected the block we want to change, we need to check if it's on the list of
        // blocks that CAN be changed (so that the game distinguishes a player clicking dirt vs stone)
        // This is done by creating a map (think C++ unordered_map<___,___>)

        if (supported_chisel_blocks.containsKey(clickedBlock)) {
            // Checking if the player is connected to the server
            if (!world.isClient()) {
                // Change the block state
                world.setBlockState(context.getBlockPos(), supported_chisel_blocks.get(clickedBlock).getDefaultState());

                // Damage the chisel by 1 durability
                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                // Play sound
                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS);
            }
        }

        return ActionResult.SUCCESS;
    }
}
