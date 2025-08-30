package net.antnz.mysteriousmod.block.custom;

import net.antnz.mysteriousmod.item.ModItems;
import net.antnz.mysteriousmod.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Stack;

public class MysteriousBlock extends Block {
    public MysteriousBlock(Settings settings) {
        super(settings);
    }


    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {

        if (entity instanceof ItemEntity itemEntity){
            if (isValidItem(itemEntity.getStack())){
                itemEntity.setStack(new ItemStack(ModItems.MYSTERIOUS_ITEM, itemEntity.getStack().getCount()));
                world.playSound(null, pos, SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.BLOCKS);
            }
        }
        super.onSteppedOn(world, pos, state, entity);
    }

    private boolean isValidItem(ItemStack stack) {
        return stack.isIn(ModTags.Items.TRANSFORMABLE);
    }
}
