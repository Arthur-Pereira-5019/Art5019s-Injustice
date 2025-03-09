package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.artinjustice.Art5019injusticeMod;

public class SuperFertilizerOnVenusFlyTrapProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double time = 0;
		for (int index0 = 0; index0 < 7; index0++) {
			Art5019injusticeMod.queueServerWork((int) (10 * time), () -> {
				SuperFertilizerVenusFlyTrap2Procedure.execute(world, x, y, z);
			});
			time = time + 2;
		}
	}
}
