package net.antnz.mysteriousmod.item.custom;

import net.antnz.mysteriousmod.block.ModBlocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MysteriousSwordItem extends SwordItem {
    public MysteriousSwordItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
        settings.rarity(Rarity.EPIC);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();

        if (world instanceof ServerWorld){

            world.setBlockState(pos, ModBlocks.MYSTERIOUS_SWORD_BLOCK.getDefaultState());
            world.playSound(null, pos, SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.BLOCKS);

        }
        return ActionResult.SUCCESS;
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 200, 2));
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 2));
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 200, 2));
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 200, 2));
        return true;
    }










}
