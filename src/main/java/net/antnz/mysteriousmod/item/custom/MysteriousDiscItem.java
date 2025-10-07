package net.antnz.mysteriousmod.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

public class MysteriousDiscItem extends Item {
    public MysteriousDiscItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (Screen.hasShiftDown()){
            tooltip.add(Text.literal("Hearing this everywhere is definitely §2INTENDED"));
        }
        else {
            tooltip.add(Text.literal("press SHIFT"));
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}
