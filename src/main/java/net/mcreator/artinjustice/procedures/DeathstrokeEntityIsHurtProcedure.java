package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.entity.DeathstrokeEntity;

public class DeathstrokeEntityIsHurtProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof DeathstrokeEntity _datEntI ? _datEntI.getEntityData().get(DeathstrokeEntity.DATA_blockcycle) : 0) >= 4) {
			if (entity instanceof DeathstrokeEntity _datEntSetI)
				_datEntSetI.getEntityData().set(DeathstrokeEntity.DATA_blockcycle, 0);
			if (world.isClientSide()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.HOSTILE, 1, (float) 1.4);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.HOSTILE, 1, (float) 1.4, false);
					}
				}
			}
			return false;
		}
		return true;
	}
}
