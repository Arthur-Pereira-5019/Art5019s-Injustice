package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class ShotReactionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double range = 0;
		double range2 = 0;
		double range3 = 0;
		if (Math.random() < 0.7) {
			entity.setDeltaMovement(new Vec3(((sourceentity.getX() - entity.getX()) * 0.2), ((sourceentity.getY() - entity.getY()) * 0.2), ((sourceentity.getZ() - entity.getZ()) * 0.2)));
		} else {
			entity.setDeltaMovement(new Vec3(((sourceentity.getX() - entity.getX()) * (-0.2)), ((sourceentity.getY() - entity.getY()) * (-0.2)), ((sourceentity.getZ() - entity.getZ()) * (-0.2))));
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:chains")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:chains")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
	}
}
