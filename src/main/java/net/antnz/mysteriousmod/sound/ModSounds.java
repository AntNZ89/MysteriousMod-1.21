package net.antnz.mysteriousmod.sound;

import net.antnz.mysteriousmod.MysteriousMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent CHISEL_USE = registerSound("chisel_use");
    public static final SoundEvent MYSTERIOUS_BLOCK_BREAK = registerSound("mysterious_block_break");
    public static final SoundEvent MYSTERIOUS_BLOCK_FALL = registerSound("mysterious_block_fall");
    public static final SoundEvent MYSTERIOUS_BLOCK_HIT = registerSound("mysterious_block_hit");
    public static final SoundEvent MYSTERIOUS_BLOCK_PLACE = registerSound("mysterious_block_place");
    public static final SoundEvent MYSTERIOUS_BLOCK_STEP = registerSound("mysterious_block_step");

    public static final BlockSoundGroup MYSTERIOUS_SOUNDS = new BlockSoundGroup(1f, 1f, MYSTERIOUS_BLOCK_BREAK, MYSTERIOUS_BLOCK_STEP,
            MYSTERIOUS_BLOCK_PLACE, MYSTERIOUS_BLOCK_HIT, MYSTERIOUS_BLOCK_FALL);

    private static SoundEvent registerSound(String name){
        Identifier id = Identifier.of(MysteriousMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }


    public static void registerModSounds(){
        MysteriousMod.LOGGER.info("Registering Sounds for " + MysteriousMod.MOD_ID);
    }

}
