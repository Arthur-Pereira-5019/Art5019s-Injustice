package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.ParticleTypes;

public class SulfuricAcidOnRandomClientDisplayTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.addParticle(ParticleTypes.CLOUD, x, y, z, 0, 0.1, 0);
	}
}
