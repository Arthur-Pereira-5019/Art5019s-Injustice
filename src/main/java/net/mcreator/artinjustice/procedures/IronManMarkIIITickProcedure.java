package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class IronManMarkIIITickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.isUnderWater()) {
			entity.setAirSupply(300);
		}
		if (entity.getTicksFrozen() >= 1) {
			entity.setTicksFrozen((int) (entity.getTicksFrozen() - 1));
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMOKE, x, y, z, 1, 0.6, 1, 0.6, 0);
		}
		entity.clearFire();
	}
}
