package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;

import java.util.List;
import java.util.Comparator;

public class IceLenseOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double angulation = 0;
		double deg = 0;
		double Scaling = 0;
		double lx = 0;
		double ly = 0;
		double lz = 0;
		if (world.dayTime() % 24000 > 23000) {
			angulation = 24000 - world.dayTime() % 24000;
		} else if (world.dayTime() % 24000 < 13700) {
			angulation = 1000 + world.dayTime() % 24000;
		}
		if (angulation > 0) {
			deg = (180 * angulation) / 14700;
			for (int index0 = 0; index0 < 25; index0++) {
				lx = x + -1 + Math.cos(Math.toRadians(deg)) * Scaling;
				ly = y + -1 + Math.sin(Math.toRadians(deg)) * Scaling;
				if (!world.getBlockState(BlockPos.containing(lx, ly, z)).canOcclude()) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.FLASH, x, y, z, 5, 1, 1, 1, 1);
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if ((entityiterator.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 23) {
								{
									double _setval = (entityiterator.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powermeter + 40;
									entityiterator.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.powermeter = _setval;
										capability.syncPlayerVariables(entityiterator);
									});
								}
							}
						}
					}
					Scaling = Scaling - 0.6;
				} else {
					break;
				}
				GenerateDustParticlesProcedure.execute(world, lx, ly, z, "15", "0.1", "0.1", "0.1", "1.000 0.800 0.200 1", "0.1");
			}
		}
	}
}
