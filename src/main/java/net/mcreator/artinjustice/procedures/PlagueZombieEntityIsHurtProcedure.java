package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.artinjustice.Art5019injusticeMod;

import java.util.List;
import java.util.Comparator;

public class PlagueZombieEntityIsHurtProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource) {
		if (damagesource == null)
			return;
		if (!world.isClientSide()) {
			if (!(damagesource.is(DamageTypes.MAGIC) || damagesource.is(DamageTypes.INDIRECT_MAGIC) || damagesource.is(DamageTypes.IN_FIRE))) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.WARPED_SPORE, x, (y + 1), z, 40, 1, 1, 1, 0);
				if (Math.random() < 0.03) {
					Art5019injusticeMod.queueServerWork(40, () -> {
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (!BiologicalSecurityCheckProcedure.execute(entityiterator)) {
									GenericApplyDiseaseProcedure.execute(entityiterator, SetBloodDiseaseProcedure.execute(world, 2));
								}
							}
						}
					});
				}
			}
		}
	}
}
