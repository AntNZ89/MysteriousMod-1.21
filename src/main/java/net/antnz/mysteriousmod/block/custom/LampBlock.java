package net.antnz.mysteriousmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LampBlock extends Block {

    public static final BooleanProperty CLICKED = BooleanProperty.of("clicked");

    public LampBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(CLICKED, true));
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {

        if (world instanceof ServerWorld){
            world.setBlockState(pos, state.cycle(CLICKED));
            world.playSound(null, pos, SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.BLOCKS, 1, 1);
        }

        return ActionResult.SUCCESS;

    }


    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {

        if (world instanceof ServerWorld){
            if (entity instanceof PlayerEntity playerEntity){

                playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 200));


            }




        }


        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CLICKED);
    }
}
