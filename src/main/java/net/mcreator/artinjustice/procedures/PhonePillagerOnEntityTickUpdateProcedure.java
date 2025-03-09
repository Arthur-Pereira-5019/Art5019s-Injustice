package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.artinjustice.init.Art5019injusticeModEntities;
import net.mcreator.artinjustice.entity.PhonePillagerEntity;

import java.util.List;
import java.util.Comparator;

public class PhonePillagerOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity targetedplayer = null;
		if ((entity instanceof PhonePillagerEntity _datEntI ? _datEntI.getEntityData().get(PhonePillagerEntity.DATA_timescalled) : 0) <= 50) {
			if ((entity instanceof PhonePillagerEntity _datEntI ? _datEntI.getEntityData().get(PhonePillagerEntity.DATA_timetoaction) : 0) % 400 == 0) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "fill ~3 ~3 ~3 ~-3 ~-3 ~-3 art5019injustice:signal_machine_pillager replace art5019injustice:signal_machine");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "fill ~3 ~4 ~3 ~-3 ~-3 ~-3 art5019injustice:signal_machine_pillager_temp replace art5019injustice:signal_machine_pillager");
					}
				}
				if (entity instanceof PhonePillagerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(PhonePillagerEntity.DATA_timescalled, (int) ((entity instanceof PhonePillagerEntity _datEntI ? _datEntI.getEntityData().get(PhonePillagerEntity.DATA_timescalled) : 0) + 1));
			}
			if ((entity instanceof PhonePillagerEntity _datEntI ? _datEntI.getEntityData().get(PhonePillagerEntity.DATA_timetoaction) : 0) == 0) {
				if (Math.random() < 0.7) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof Player) {
								targetedplayer = entityiterator;
								if (world.isEmptyBlock(BlockPos.containing(x, entityiterator.getY() + 14, z))) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = EntityType.PILLAGER.spawn(_level, BlockPos.containing(x, entityiterator.getY() + 13, z), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setDeltaMovement(0, 0, 0);
										}
									}
								}
								if (world.isEmptyBlock(BlockPos.containing(x, entityiterator.getY() + 14, entityiterator.getZ() + 2))) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = EntityType.PILLAGER.spawn(_level, BlockPos.containing(x, entityiterator.getY() + 14, entityiterator.getZ() + 2), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setDeltaMovement(0, 0, 0);
										}
									}
								}
								if (world.isEmptyBlock(BlockPos.containing(entityiterator.getX() + 1, entityiterator.getY() + 12, z))) {
									if (world instanceof ServerLevel _level) {
										Entity entityToSpawn = EntityType.PILLAGER.spawn(_level, BlockPos.containing(entityiterator.getX() + 1, entityiterator.getY() + 12, z), MobSpawnType.MOB_SUMMONED);
										if (entityToSpawn != null) {
											entityToSpawn.setDeltaMovement(0, 0, 0);
										}
									}
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:item.airplane")), SoundSource.NEUTRAL, (float) 0.2, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:item.airplane")), SoundSource.NEUTRAL, (float) 0.2, 1, false);
									}
								}
							}
						}
					}
					if (!(targetedplayer == null)) {
						{
							final Vec3 _center = new Vec3(x, (targetedplayer.getY() + 13), z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof Pillager) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 300, 0, false, false));
								}
							}
						}
					}
				} else {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(33 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof Player) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:item.airplane")), SoundSource.NEUTRAL, (float) 0.2, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:item.airplane")), SoundSource.NEUTRAL, (float) 0.2, 1, false);
									}
								}
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = Art5019injusticeModEntities.MUSTARD_GAS_BOMB_PROJECTILE.get().spawn(_level, BlockPos.containing(x, entityiterator.getY() + 13, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
							}
						}
					}
				}
				if (entity instanceof PhonePillagerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(PhonePillagerEntity.DATA_timescalled, (int) ((entity instanceof PhonePillagerEntity _datEntI ? _datEntI.getEntityData().get(PhonePillagerEntity.DATA_timescalled) : 0) + 1));
				if (entity instanceof PhonePillagerEntity _datEntSetI)
					_datEntSetI.getEntityData().set(PhonePillagerEntity.DATA_timetoaction, 420);
			}
			if (entity instanceof PhonePillagerEntity _datEntSetI)
				_datEntSetI.getEntityData().set(PhonePillagerEntity.DATA_timetoaction, (int) ((entity instanceof PhonePillagerEntity _datEntI ? _datEntI.getEntityData().get(PhonePillagerEntity.DATA_timetoaction) : 0) - 1));
		}
	}
}
