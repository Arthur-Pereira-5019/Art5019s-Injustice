package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;

public class PhantomZoneVisualPortalProcedure {
	public static void execute(LevelAccessor world, double newX, double newY, double newZ) {
		double offset = 0;
		GenerateDustParticlesProcedure.execute(world, newX, newY, newZ, "800", "0.8", "0.8", "0.8", "0.4 0.6 1 0.6", "0.3");
	}
}
