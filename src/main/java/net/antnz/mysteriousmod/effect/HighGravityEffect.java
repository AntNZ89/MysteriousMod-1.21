package net.antnz.mysteriousmod.effect;

import net.antnz.mysteriousmod.item.ModItems;
import net.antnz.mysteriousmod.sound.ModSounds;
import net.antnz.mysteriousmod.util.ModTags;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Items;
import net.minecraft.util.math.Vec3d;

public class HighGravityEffect extends StatusEffect {
    protected HighGravityEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }


    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {

        entity.setVelocity(entity.getVelocity().x, -100, entity.getVelocity().z);

        if (entity.horizontalCollision){
            Vec3d initial = entity.getVelocity();
            Vec3d climbing = new Vec3d(initial.x, 0.2*amplifier, initial.z);
            entity.setVelocity(climbing);
        }

        return super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
