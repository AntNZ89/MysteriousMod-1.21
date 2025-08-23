package net.antnz.mysteriousmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockRemoverItem extends Item {
    public BlockRemoverItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {


        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        Block block = world.getBlockState(pos).getBlock();

        world.setBlockState(pos, Blocks.AIR.getDefaultState());

        return ActionResult.SUCCESS;



    }
}
