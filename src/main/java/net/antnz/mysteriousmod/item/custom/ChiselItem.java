package net.antnz.mysteriousmod.item.custom;

import net.antnz.mysteriousmod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ChiselItem extends Item {

    public ChiselItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        Block block = world.getBlockState(pos).getBlock();

        if (world instanceof ServerWorld){

            if (block == Blocks.GRASS_BLOCK){

                world.setBlockState(pos, ModBlocks.MYSTERIOUS_LAMP_BLOCK.getDefaultState());

            }


        }

        return ActionResult.SUCCESS;

    }
}
