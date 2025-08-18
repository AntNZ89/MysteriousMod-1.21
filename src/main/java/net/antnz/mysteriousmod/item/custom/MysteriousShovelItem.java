package net.antnz.mysteriousmod.item.custom;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.antnz.mysteriousmod.block.ModBlocks;
import net.antnz.mysteriousmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

import java.util.Map;

public class MysteriousShovelItem extends ShovelItem {
    protected static final Map<Block, BlockState> PATH_STATES;

    public MysteriousShovelItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }


    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        Block block = world.getBlockState(blockPos).getBlock();

        if (block == Blocks.COBBLESTONE){

            world.setBlockState(blockPos, ModBlocks.MYSTERIOUS_SHOVEL_BLOCK.getDefaultState());
            return ActionResult.SUCCESS;

        }



        if (context.getSide() == Direction.DOWN) {
            return ActionResult.PASS;
        } else {
            PlayerEntity playerEntity = context.getPlayer();
            BlockState blockState2 = (BlockState)PATH_STATES.get(blockState.getBlock());
            BlockState blockState3 = null;
            if (blockState2 != null && world.getBlockState(blockPos.up()).isAir()) {
                world.playSound(playerEntity, blockPos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
                blockState3 = blockState2;
            } else if (blockState.getBlock() instanceof CampfireBlock && (Boolean)blockState.get(CampfireBlock.LIT)) {
                if (!world.isClient()) {
                    world.syncWorldEvent((PlayerEntity)null, 1009, blockPos, 0);
                }

                CampfireBlock.extinguish(context.getPlayer(), world, blockPos, blockState);
                blockState3 = (BlockState)blockState.with(CampfireBlock.LIT, false);
            }

            if (blockState3 != null) {
                if (!world.isClient) {
                    world.setBlockState(blockPos, blockState3, 11);
                    world.emitGameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Emitter.of(playerEntity, blockState3));
                    if (playerEntity != null) {
                        context.getStack().damage(1, playerEntity, LivingEntity.getSlotForHand(context.getHand()));
                    }
                }

                return ActionResult.success(world.isClient);
            } else {
                return ActionResult.PASS;
            }
        }
    }

    static {
        PATH_STATES = Maps.newHashMap((new ImmutableMap.Builder()).put(Blocks.GRASS_BLOCK, Blocks.DIRT_PATH.getDefaultState()).put(Blocks.DIRT, Blocks.DIRT_PATH.getDefaultState()).put(Blocks.PODZOL, Blocks.DIRT_PATH.getDefaultState()).put(Blocks.COARSE_DIRT, Blocks.DIRT_PATH.getDefaultState()).put(Blocks.MYCELIUM, Blocks.DIRT_PATH.getDefaultState()).put(Blocks.ROOTED_DIRT, Blocks.DIRT_PATH.getDefaultState()).build());
    }
}
