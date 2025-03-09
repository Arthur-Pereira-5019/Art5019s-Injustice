package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.entity.monster.Zoglin;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.animal.MushroomCow;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.entity.VenomBossEntity;

public class MobHealsProcedure {
	public static double execute(LevelAccessor world, Entity entity, double context) {
		if (entity == null)
			return 0;
		if (entity instanceof ZombieVillager) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = EntityType.VILLAGER.spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(entity.getYRot());
					entityToSpawn.setYBodyRot(entity.getYRot());
					entityToSpawn.setYHeadRot(entity.getYRot());
					entityToSpawn.setXRot(entity.getXRot());
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			if (!entity.level().isClientSide())
				entity.discard();
		} else if (entity instanceof VenomBossEntity) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = EntityType.PILLAGER.spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(entity.getYRot());
					entityToSpawn.setYBodyRot(entity.getYRot());
					entityToSpawn.setYHeadRot(entity.getYRot());
					entityToSpawn.setXRot(entity.getXRot());
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth(0);
			if (context == 0) {
				return 1;
			}
		} else if (entity instanceof Ravager) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = EntityType.IRON_GOLEM.spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(entity.getYRot());
					entityToSpawn.setYBodyRot(entity.getYRot());
					entityToSpawn.setYHeadRot(entity.getYRot());
					entityToSpawn.setXRot(entity.getXRot());
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			if (!entity.level().isClientSide())
				entity.discard();
		} else if (entity instanceof WitherSkeleton) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = EntityType.SKELETON.spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(entity.getYRot());
					entityToSpawn.setYBodyRot(entity.getYRot());
					entityToSpawn.setYHeadRot(entity.getYRot());
					entityToSpawn.setXRot(entity.getXRot());
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			if (!entity.level().isClientSide())
				entity.discard();
		} else if (entity instanceof WitherBoss) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 60) {
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)), 60);
			} else {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.WITHER_SKELETON.spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(entity.getYRot());
						entityToSpawn.setYBodyRot(entity.getYRot());
						entityToSpawn.setYHeadRot(entity.getYRot());
						entityToSpawn.setXRot(entity.getXRot());
						entityToSpawn.setDeltaMovement(0, 0, 0);
					}
				}
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.WITHER_SKELETON.spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(entity.getYRot());
						entityToSpawn.setYBodyRot(entity.getYRot());
						entityToSpawn.setYHeadRot(entity.getYRot());
						entityToSpawn.setXRot(entity.getXRot());
						entityToSpawn.setDeltaMovement(0, 0, 0);
					}
				}
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.WITHER_SKELETON.spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(entity.getYRot());
						entityToSpawn.setYBodyRot(entity.getYRot());
						entityToSpawn.setYHeadRot(entity.getYRot());
						entityToSpawn.setXRot(entity.getXRot());
						entityToSpawn.setDeltaMovement(0, 0, 0);
					}
				}
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth(0);
			}
		} else if (entity instanceof MushroomCow) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = EntityType.COW.spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(entity.getYRot());
					entityToSpawn.setYBodyRot(entity.getYRot());
					entityToSpawn.setYHeadRot(entity.getYRot());
					entityToSpawn.setXRot(entity.getXRot());
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			if (!entity.level().isClientSide())
				entity.discard();
		} else if (entity instanceof Zoglin || entity instanceof Hoglin || entity instanceof Piglin || entity instanceof PiglinBrute || entity instanceof ZombifiedPiglin) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = EntityType.PIG.spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(entity.getYRot());
					entityToSpawn.setYBodyRot(entity.getYRot());
					entityToSpawn.setYHeadRot(entity.getYRot());
					entityToSpawn.setXRot(entity.getXRot());
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			if (!entity.level().isClientSide())
				entity.discard();
		} else if (entity instanceof LivingEntity _livEnt75 && _livEnt75.getMobType() == MobType.UNDEAD) {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth(0);
		}
		if (context == 1) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (entity.getX()), (entity.getY()), (entity.getZ()), 40, 1, 1, 1, 0.2);
		}
		return 0;
	}
}
