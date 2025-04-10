package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
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
		boolean canBeam = false;
		if (world.dayTime() % 24000 > 23000) {
			angulation = 24000 - world.dayTime() % 24000;
		} else if (world.dayTime() % 24000 < 13700) {
			angulation = 1000 + world.dayTime() % 24000;
		}
		if (angulation > 0) {
			deg = (180 * angulation) / 14700;
			canBeam = true;
			Scaling = 0.6;
			for (int index0 = 0; index0 < 25; index0++) {
				lx = x + 0.5 + Math.cos(Math.toRadians(deg)) * Scaling;
				ly = y + 1.1 + Math.sin(Math.toRadians(deg)) * Scaling;
				if (!world.getBlockState(BlockPos.containing(lx, ly, z)).canOcclude()) {
					Scaling = Scaling + 0.9;
				} else {
					canBeam = false;
					break;
				}
			}
			Scaling = -0.6;
			if (canBeam) {
				for (int index1 = 0; index1 < 40; index1++) {
					lx = x + 0.5 + Math.cos(Math.toRadians(deg)) * Scaling;
					ly = y + 0.5 + Math.sin(Math.toRadians(deg)) * Scaling;
					lz = z + 0.5;
					if (!world.getBlockState(BlockPos.containing(lx, ly, lz)).canOcclude()) {
						Scaling = Scaling - 1;
					} else {
						{
							final Vec3 _center = new Vec3(lx, ly, lz);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (IsKryptonianProcedure.execute(entityiterator)) {
									{
										double _setval = (entityiterator.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powermeter + 20;
										entityiterator.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.powermeter = _setval;
											capability.syncPlayerVariables(entityiterator);
										});
									}
									if (!world.isClientSide()) {
										if (Math.random() < 0.1) {
											if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 1, false, false));
										}
									}
								}
							}
						}
						break;
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.FLASH, lx, ly, lz, 1, 0.1, 0.1, 0.1, 1);
				}
			}
		}
	}
}
