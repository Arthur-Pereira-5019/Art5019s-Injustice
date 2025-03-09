package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.Art5019injusticeMod;

public class TaskMasterOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!TaskMasterNaturalEntitySpawningConditionProcedure.execute(world, x, y, z)) {
			Art5019injusticeMod.queueServerWork(2, () -> {
				if (!entity.level().isClientSide())
					entity.discard();
			});
		}
	}
}
