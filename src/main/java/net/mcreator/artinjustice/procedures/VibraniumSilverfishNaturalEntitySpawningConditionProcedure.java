package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;

public class VibraniumSilverfishNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world) {
		if (world.dimensionType().moonPhase(world.dayTime()) == 4) {
			return true;
		}
		return false;
	}
}
