package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;

public class SetBloodDiseaseProcedure {
	public static double execute(LevelAccessor world, double diseasePower) {
		double random = 0;
		if (!world.isClientSide()) {
			random = Math.random();
			if (random < diseasePower * 0.02) {
				return 6;
			} else if (random < diseasePower * 0.04) {
				return 8;
			} else if (random < diseasePower * 0.06) {
				return 5;
			} else if (random < diseasePower * 0.085) {
				return 7;
			} else if (random < diseasePower * 0.135) {
				return 4;
			} else if (random < 0.33 * diseasePower) {
				return 3;
			} else if (random < 0.65 * diseasePower) {
				return 2;
			} else {
				return 1;
			}
		}
		return 1;
	}
}
