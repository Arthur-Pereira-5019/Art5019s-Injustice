package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;

import net.mcreator.artinjustice.entity.MrNegativeEntity;

import java.util.List;
import java.util.Comparator;

public class MrNegativeOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity targetting = null;
		if (!world.isClientSide()) {
			if (Math.random() < 0.02) {
				targetting = entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null;
				if (!(targetting == null)) {
					if ((entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_stage) : 0) == 1) {
						MrNegativeStage1AttacksProcedure.execute(world, x, y, z, entity, targetting);
					} else if ((entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_stage) : 0) == 2) {
						MrNegativeStage2AttacksProcedure.execute(world, x, y, z, entity, targetting);
					} else if ((entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_stage) : 0) == 3) {
						MrNegativeStage3AttacksProcedure.execute(world, x, y, z, entity, targetting);
					} else if ((entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_stage) : 0) == 4) {
						if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE) ? _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier() : 0) == 4) {
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (entityiterator instanceof Warden) {
										if (entityiterator instanceof Mob _entity && targetting instanceof LivingEntity _ent)
											_entity.setTarget(_ent);
									}
								}
							}
						} else {
							MrNegativeStage4AttacksProcedure.execute(world, x, y, z, entity, targetting);
						}
					} else if ((entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_stage) : 0) == 5) {
						MrNegativeStage5AttacksProcedure.execute(world, x, y, z, entity, targetting);
					} else if ((entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_stage) : 0) == 6) {
						MrNegativeStage6AttacksProcedure.execute(world, x, y, z, entity, targetting);
					}
					if (Math.random() < 0.05) {
						MrNegativeRandomDialogueProcedure.execute(world, x, y, z, entity);
					}
				} else {
					if ((entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_stage) : 0) == 4) {
						if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE) ? _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier() : 0) == 4) {
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (entityiterator instanceof Warden) {
										if (entityiterator instanceof Mob _entity)
											_entity.setTarget(null);
										if (entityiterator instanceof Mob _entity)
											_entity.getNavigation().moveTo(x, y, (z + 10), 1);
									}
								}
							}
						}
					}
				}
				if (entity instanceof MrNegativeEntity _datEntSetI)
					_datEntSetI.getEntityData().set(MrNegativeEntity.DATA_attackcycle, (int) ((entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_attackcycle) : 0) + 1));
			}
		}
		if ((entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_maxattackcycle) : 0) == (entity instanceof MrNegativeEntity _datEntI
				? _datEntI.getEntityData().get(MrNegativeEntity.DATA_attackcycle)
				: 0)) {
			if (entity instanceof MrNegativeEntity _datEntSetI)
				_datEntSetI.getEntityData().set(MrNegativeEntity.DATA_attackcycle, 0);
		}
	}
}
