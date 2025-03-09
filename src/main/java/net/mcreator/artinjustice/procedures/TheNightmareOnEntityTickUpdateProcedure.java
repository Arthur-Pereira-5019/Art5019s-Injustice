package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;
import net.mcreator.artinjustice.init.Art5019injusticeModEntities;
import net.mcreator.artinjustice.entity.TheNightmareEntity;
import net.mcreator.artinjustice.entity.TheNightmareCloneEntity;
import net.mcreator.artinjustice.Art5019injusticeMod;

import java.util.List;
import java.util.Comparator;

public class TheNightmareOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof TheNightmareEntity _datEntI ? _datEntI.getEntityData().get(TheNightmareEntity.DATA_nextattack) : 0) <= 0) {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				if (Math.random() < 0.7) {
					if (Math.random() < 0.7) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = Art5019injusticeModEntities.THE_NIGHTMARE_CLONE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setDeltaMovement(0, 0, 0);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = Art5019injusticeModEntities.THE_NIGHTMARE_CLONE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setDeltaMovement(0, 0, 0);
							}
						}
						Art5019injusticeMod.queueServerWork(3, () -> {
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (!((entityiterator instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) == null) == entityiterator instanceof TheNightmareCloneEntity) {
										if (entityiterator instanceof TamableAnimal _toTame && (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof Player _owner)
											_toTame.tame(_owner);
									}
								}
							}
						});
					} else {
						{
							Entity _ent = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null);
							_ent.setYRot(Mth.nextInt(RandomSource.create(), -90, 90));
							_ent.setXRot(Mth.nextInt(RandomSource.create(), -180, 180));
							_ent.setYBodyRot(_ent.getYRot());
							_ent.setYHeadRot(_ent.getYRot());
							_ent.yRotO = _ent.getYRot();
							_ent.xRotO = _ent.getXRot();
							if (_ent instanceof LivingEntity _entity) {
								_entity.yBodyRotO = _entity.getYRot();
								_entity.yHeadRotO = _entity.getYRot();
							}
						}
					}
				} else {
					if (Math.random() < 0.7) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = Art5019injusticeModEntities.THE_NIGHTMARE_CLONE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setDeltaMovement(0, 0, 0);
							}
						}
						Art5019injusticeMod.queueServerWork(3, () -> {
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (!((entityiterator instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) == null) == entityiterator instanceof TheNightmareCloneEntity) {
										if (entityiterator instanceof TamableAnimal _toTame && (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof Player _owner)
											_toTame.tame(_owner);
									}
								}
							}
						});
					} else {
						if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 100, 1, false, false));
					}
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.FEAR.get(), 200, 1, false, false));
					}
				}
			}
			if (entity instanceof TheNightmareEntity _datEntSetI)
				_datEntSetI.getEntityData().set(TheNightmareEntity.DATA_nextattack, 200);
		} else {
			if (entity instanceof TheNightmareEntity _datEntSetI)
				_datEntSetI.getEntityData().set(TheNightmareEntity.DATA_nextattack, (int) ((entity instanceof TheNightmareEntity _datEntI ? _datEntI.getEntityData().get(TheNightmareEntity.DATA_nextattack) : 0) - 1));
		}
	}
}
