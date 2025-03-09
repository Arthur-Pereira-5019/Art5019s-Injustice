package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;
import net.mcreator.artinjustice.Art5019injusticeMod;

import java.util.List;
import java.util.Comparator;

public class HerdImmunityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Art5019injusticeMod.queueServerWork(2, () -> {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.IMMUNITY.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.IMMUNITY.get()).getDuration() : 0) < 479920) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.HEART, (entity.getX()), (entity.getY()), (entity.getZ()), 40, 1, 1, 1, 0.4);
				VaccineTypeIAppliedProcedure.execute(entity);
				{
					final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(25 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if ((ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).equals(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()) && !(entityiterator == entity)) {
							HerdImmunityProcedure.execute(world, x, y, z, entityiterator);
						}
					}
				}
			}
		});
	}
}
