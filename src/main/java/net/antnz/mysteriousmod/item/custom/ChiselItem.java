package net.antnz.mysteriousmod.item.custom;

import net.antnz.mysteriousmod.block.ModBlocks;
import net.antnz.mysteriousmod.component.ModDataComponentTypes;
import net.antnz.mysteriousmod.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChiselItem extends Item {

    public static final  Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.GRASS_BLOCK , ModBlocks.MYSTERIOUS_LAMP_BLOCK
            );

    public ChiselItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        Block block = world.getBlockState(pos).getBlock();

        if (world instanceof ServerWorld){

            if (CHISEL_MAP.containsKey(block)){

                context.getStack().set(ModDataComponentTypes.COORDINATES, pos);

                world.setBlockState(pos, CHISEL_MAP.get(block).getDefaultState());

                world.playSound(null, pos, ModSounds.CHISEL_USE, SoundCategory.BLOCKS, 1f, 1f);

            }
        }
        return ActionResult.SUCCESS;
    }



    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {

        if (stack.get(ModDataComponentTypes.COORDINATES) != null){
            tooltip.add(Text.literal("Block at X = " + stack.get(ModDataComponentTypes.COORDINATES).getX() +
                    ", Y = " + stack.get(ModDataComponentTypes.COORDINATES).getY() +
                    ", Z = " + stack.get(ModDataComponentTypes.COORDINATES).getZ() + " is now a lamp"));
        }
        
        super.appendTooltip(stack, context, tooltip, type);
    }
}
