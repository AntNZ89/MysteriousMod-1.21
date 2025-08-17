package net.antnz.mysteriousmod.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Rarity;

public class MysteriousAxeItem extends AxeItem {
    public MysteriousAxeItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
        settings.rarity(Rarity.EPIC);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WIND_CHARGED, 1200, 3));
        return super.postHit(stack, target, attacker);
    }
}
