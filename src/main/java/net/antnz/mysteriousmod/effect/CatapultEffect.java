package net.antnz.mysteriousmod.effect;

import net.antnz.mysteriousmod.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.projectile.AbstractWindChargeEntity;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class CatapultEffect extends StatusEffect {
    public CatapultEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }
    boolean canWind = false;

    @Override
    public boolean applyUpdateEffect(LivingEntity playerEntity, int amplifier) {

        if (playerEntity.handSwinging && playerEntity.getMainHandStack().getItem() == ModItems.CATAPULT_WAND){
            World serverWorld = playerEntity.getWorld();
            if (serverWorld instanceof ServerWorld serverWorld1){
                double d = playerEntity.getX();
                double e = playerEntity.getY() + (double)(playerEntity.getHeight() / 2.0F);
                double f = playerEntity.getZ();
                float g = 3.0F + playerEntity.getRandom().nextFloat() * 2.0F;
                serverWorld1.createExplosion(playerEntity, (DamageSource)null, AbstractWindChargeEntity.EXPLOSION_BEHAVIOR, d, e, f, g, false, World.ExplosionSourceType.TRIGGER, ParticleTypes.GUST_EMITTER_SMALL, ParticleTypes.GUST_EMITTER_LARGE, SoundEvents.ENTITY_BREEZE_WIND_BURST);
                return true;
            }

            float g = playerEntity.getYaw();
            float h = playerEntity.getPitch();
            float j = -MathHelper.sin(g * ((float)Math.PI / 180F)) * MathHelper.cos(h * ((float)Math.PI / 180F));
            float k = -MathHelper.sin(h * ((float)Math.PI / 180F));
            float l = MathHelper.cos(g * ((float)Math.PI / 180F)) * MathHelper.cos(h * ((float)Math.PI / 180F));
            float m = MathHelper.sqrt(j * j + k * k + l * l);
            j *= m/2;
            k *= m/2;
            l *= m/2;
            playerEntity.addVelocity((double)j, (double)k, (double)l);
            return true;
        }

        if (playerEntity.fallDistance > 10){
            canWind=true;
        }

        if (playerEntity.isOnGround()){
            World serverWorld = playerEntity.getWorld();
            if (serverWorld instanceof ServerWorld serverWorld1 && canWind){
                double d = playerEntity.getX();
                double e = playerEntity.getY() + (double)(playerEntity.getHeight() / 2.0F);
                double f = playerEntity.getZ();
                float g = 3.0F + playerEntity.getRandom().nextFloat() * 2.0F;
                serverWorld1.createExplosion(playerEntity, (DamageSource)null, AbstractWindChargeEntity.EXPLOSION_BEHAVIOR, d, e, f, g, false, World.ExplosionSourceType.TNT, ParticleTypes.GUST_EMITTER_SMALL, ParticleTypes.GUST_EMITTER_LARGE, SoundEvents.ENTITY_BREEZE_WIND_BURST);
                canWind = false;
                return true;
            }
        }

        return super.applyUpdateEffect(playerEntity, amplifier);

    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
