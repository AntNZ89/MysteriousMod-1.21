package net.antnz.mysteriousmod.item.custom;

import net.antnz.mysteriousmod.effect.ModEffects;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.model.json.ModelElement;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.ClickType;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class CatapultStickItem extends Item {
    public CatapultStickItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.addStatusEffect(new StatusEffectInstance(ModEffects.CATAPULT, 1200));
        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {

        if (Screen.hasShiftDown()){
            tooltip.add(Text.literal("Right-Click & Left-Click please"));
        }
        else {
            tooltip.add(Text.literal("press SHIFT"));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
