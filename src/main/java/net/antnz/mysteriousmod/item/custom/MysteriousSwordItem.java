package net.antnz.mysteriousmod.item.custom;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Rarity;

public class MysteriousSwordItem extends SwordItem {
    public MysteriousSwordItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
        settings.rarity(Rarity.EPIC);
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 200, 2));
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 2));
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 200, 2));
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 200, 2));
        return true;
    }










}
