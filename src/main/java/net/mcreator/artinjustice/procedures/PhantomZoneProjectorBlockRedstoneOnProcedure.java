package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class PhantomZoneProjectorBlockRedstoneOnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double offset = 0;
		double newX = 0;
		double newY = 0;
		double newZ = 0;
		StopSoundProcedure.execute(world, x, y, z, 16, "minecraft:block.beacon.activate", "block");
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.activate")), SoundSource.BLOCKS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.activate")), SoundSource.BLOCKS, 1, 1, false);
			}
		}
	}
}
