package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class FeastNPCOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			if (Math.random() < 0.0007) {
				if (Math.random() < 0.25) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.FALLING_DRIPSTONE_WATER, x, (y + 1.65), z, 40, 0.1, 0.1, 0.1, 0);
				} else {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.ANGRY_VILLAGER, x, (y + 1.65), z, 40, 0.5, 1, 0.5, 1);
				}
			}
		}
	}
}
