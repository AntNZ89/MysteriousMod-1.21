package net.antnz.mysteriousmod.item.custom;

import net.antnz.mysteriousmod.block.ModBlocks;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;

import java.util.Map;

public class Chiseltem extends Item {

    public static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.GRASS_BLOCK, ModBlocks.MYSTERIOUS_LAMP_BLOCK
            );

    public Chiseltem(Settings settings) {
        super(settings);
    }


    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        Block clickedBlock = world.getBlockState(pos).getBlock();


        if (context.getWorld() instanceof ServerWorld) {


            context.getWorld().playSound(null, context.getBlockPos(), SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.BLOCKS);

            world.setBlockState(pos, CHISEL_MAP.get(clickedBlock).getDefaultState());

            context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                    item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));


        }
        return ActionResult.SUCCESS;




    }
}
