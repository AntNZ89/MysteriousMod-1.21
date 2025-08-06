package net.antnz.mysteriousmod.block.custom;

import net.antnz.mysteriousmod.item.ModItems;
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

import java.util.Random;


public class LampBlock extends Block {

    public static final BooleanProperty CLICKED = BooleanProperty.of("clicked");

    Random random = new Random();

    public LampBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(CLICKED, true));
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {

        if (world instanceof ServerWorld){
            BlockState newState = state.cycle(CLICKED);
            world.setBlockState(pos, state.cycle(CLICKED));
            world.playSound(null, pos, SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.BLOCKS, 1, 1);

            if (newState.get(CLICKED)){

                player.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 200));

                int num = random.nextInt(0, 2);

                if (num == 0){
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 20));
                }
                if (num == 1){
                    player.addExperience(10000);
                }


            }


        }

        return ActionResult.SUCCESS;

    }




    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CLICKED);
    }

}
