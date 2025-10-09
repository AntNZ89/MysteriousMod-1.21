package net.antnz.mysteriousmod.item.custom;

import net.antnz.mysteriousmod.effect.ModEffects;
import net.minecraft.client.render.model.json.ModelElement;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CatapultStickItem extends Item {
    public CatapultStickItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        user.addStatusEffect(new StatusEffectInstance(ModEffects.CATAPULT, 200));


        return super.use(world, user, hand);
    }
}
