package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.artinjustice.entity.MrNegativeEntity;
import net.mcreator.artinjustice.Art5019injusticeMod;

import java.util.List;
import java.util.Comparator;

public class MrNegativeStage3AttacksProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity target) {
		if (entity == null || target == null)
			return;
		if ((entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_attackcycle) : 0) == 22
				|| (entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_attackcycle) : 0) == 12) {
			MrNegativeAura1Procedure.execute(world, entity);
			{
				Entity _ent = entity;
				_ent.teleportTo((target.getX()), (target.getY()), (target.getZ()));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport((target.getX()), (target.getY()), (target.getZ()), _ent.getYRot(), _ent.getXRot());
			}
			MrNegativeAura1Procedure.execute(world, entity);
		} else if ((entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_attackcycle) : 0) == 21
				|| (entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_attackcycle) : 0) == 11) {
			MrNegativeAura1Procedure.execute(world, entity);
			Art5019injusticeMod.queueServerWork(25, () -> {
				MrNegativeAura1Procedure.execute(world, entity);
			});
			Art5019injusticeMod.queueServerWork(50, () -> {
				MrNegativeAura1Procedure.execute(world, entity);
			});
		} else if ((entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_attackcycle) : 0) == 3
				|| (entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_attackcycle) : 0) == 13) {
			MrNegativeTerrainCorruptionProcedure.execute(world, x, y, z, entity);
		} else if ((entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_attackcycle) : 0) == 5
				|| (entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_attackcycle) : 0) == 15) {
			MrNegativeAura2Procedure.execute(world, entity);
		} else if ((entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_attackcycle) : 0) == 6
				|| (entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_attackcycle) : 0) == 16) {
			MrNegativeAura2Procedure.execute(world, entity);
		} else if ((entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_attackcycle) : 0) == 7
				|| (entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_attackcycle) : 0) == 17) {
			MrNegativeShockProcedure.execute(world, x, y, z, entity);
		} else if ((entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_attackcycle) : 0) == 16) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 3.75 * ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 6)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 180, 2, false, false));
			}
		} else if ((entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_attackcycle) : 0) == 17
				|| (entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_attackcycle) : 0) == 7) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Monster) {
						if (entityiterator instanceof Mob _entity && target instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 180, 1, false, false));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 180, 1, false, false));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 180, 1, false, false));
						MrNegativeAura1Procedure.execute(world, entityiterator);
					}
				}
			}
		}
	}
}
