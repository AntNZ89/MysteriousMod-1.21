package net.antnz.mysteriousmod.item.custom;

import net.antnz.mysteriousmod.block.ModBlocks;
import net.antnz.mysteriousmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MysteriousPickaxeItem extends PickaxeItem {
    public MysteriousPickaxeItem(ToolMaterial material, Settings settings) {
        super(material, settings);
        settings.rarity(Rarity.EPIC);
    }


    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        Block clickedBlock = world.getBlockState(pos).getBlock();

        if (world instanceof ServerWorld){
            world.setBlockState(pos, ModBlocks.MYSTERIOUS_PICKAXE_BLOCK.getDefaultState());
        }

        return ActionResult.SUCCESS;


    }
}
