package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;

public class CriminalNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			if (Math.random() < Art5019injusticeModVariables.MapVariables.get(world).criminality_rate && TaskMasterNaturalEntitySpawningConditionProcedure.execute(world, x, y, z)) {
				return true;
			}
		}
		return false;
	}
}
