package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;
import net.mcreator.artinjustice.init.Art5019injusticeModEnchantments;
import net.mcreator.artinjustice.entity.MrNegativeEntity;
import net.mcreator.artinjustice.Art5019injusticeMod;

import java.util.List;
import java.util.Comparator;

public class MrNegativeEntityIsHurtProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == sourceentity)) {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 1, false, false));
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 200, 1, false, false));
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 200, 1, false, false));
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 5 * ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 6)
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 6 * ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 6)
				&& (entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_stage) : 0) < 2) {
			if (entity instanceof MrNegativeEntity _datEntSetI)
				_datEntSetI.getEntityData().set(MrNegativeEntity.DATA_stage, 1);
			if (entity instanceof MrNegativeEntity _datEntSetI)
				_datEntSetI.getEntityData().set(MrNegativeEntity.DATA_maxattackcycle, 21);
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 4 * ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 6)
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 5 * ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 6)
				&& (entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_stage) : 0) < 2) {
			if (entity instanceof MrNegativeEntity _datEntSetI)
				_datEntSetI.getEntityData().set(MrNegativeEntity.DATA_stage, 2);
			if (entity instanceof MrNegativeEntity _datEntSetI)
				_datEntSetI.getEntityData().set(MrNegativeEntity.DATA_maxattackcycle, 24);
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(24 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Mr. Negative> Once you hear the darkness,,, there's no way back."), false);
				}
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 3 * ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 6)
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 4 * ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 6)
				&& (entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_stage) : 0) < 3) {
			if (entity instanceof MrNegativeEntity _datEntSetI)
				_datEntSetI.getEntityData().set(MrNegativeEntity.DATA_stage, 3);
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).enchant(Art5019injusticeModEnchantments.DARK_ENERGY.get(), 5);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 40, 0, false, false));
			MrNegativeAura2Procedure.execute(world, entity);
			Art5019injusticeMod.queueServerWork(6, () -> {
				MrNegativeAura1Procedure.execute(world, entity);
				Art5019injusticeMod.queueServerWork(6, () -> {
					MrNegativeAura2Procedure.execute(world, entity);
					Art5019injusticeMod.queueServerWork(6, () -> {
						MrNegativeAura1Procedure.execute(world, entity);
						Art5019injusticeMod.queueServerWork(6, () -> {
							MrNegativeAura2Procedure.execute(world, entity);
							Art5019injusticeMod.queueServerWork(6, () -> {
								MrNegativeAura1Procedure.execute(world, entity);
								Art5019injusticeMod.queueServerWork(6, () -> {
									MrNegativeAura2Procedure.execute(world, entity);
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.HOSTILE, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.HOSTILE, 1, 1, false);
										}
									}
								});
							});
						});
					});
				});
			});
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity)) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.FEAR.get(), 400, 2, false, false));
					}
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(24 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Mr. Negative> Do you even know what is real?"), false);
				}
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 2 * ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 6)
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 3 * ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 6)
				&& (entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_stage) : 0) < 4) {
			if (entity instanceof MrNegativeEntity _datEntSetI)
				_datEntSetI.getEntityData().set(MrNegativeEntity.DATA_stage, 4);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 999999, 4, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 999999, 4, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 999999, 4, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 33, 0, false, false));
			if (world instanceof Level _level)
				_level.getScoreboard().addPlayerTeam("artteamsmrnegative");
			if (world instanceof Level _level) {
				PlayerTeam _pt = _level.getScoreboard().getPlayerTeam("artteamsmrnegative");
				if (_pt != null)
					_pt.setAllowFriendlyFire(false);
			}
			{
				Entity _entityTeam = entity;
				PlayerTeam _pt = _entityTeam.level().getScoreboard().getPlayerTeam("artteamsmrnegative");
				if (_pt != null) {
					if (_entityTeam instanceof Player _player)
						_entityTeam.level().getScoreboard().addPlayerToTeam(_player.getGameProfile().getName(), _pt);
					else
						_entityTeam.level().getScoreboard().addPlayerToTeam(_entityTeam.getStringUUID(), _pt);
				}
			}
			MrNegativeAura2Procedure.execute(world, entity);
			Art5019injusticeMod.queueServerWork(6, () -> {
				MrNegativeAura1Procedure.execute(world, entity);
				Art5019injusticeMod.queueServerWork(6, () -> {
					MrNegativeAura2Procedure.execute(world, entity);
					Art5019injusticeMod.queueServerWork(6, () -> {
						MrNegativeAura1Procedure.execute(world, entity);
						Art5019injusticeMod.queueServerWork(6, () -> {
							MrNegativeAura2Procedure.execute(world, entity);
							Art5019injusticeMod.queueServerWork(6, () -> {
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = EntityType.WARDEN.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setDeltaMovement(0, 0, 0);
									}
								}
								MrNegativeAura1Procedure.execute(world, entity);
								Art5019injusticeMod.queueServerWork(6, () -> {
									{
										final Vec3 _center = new Vec3(x, y, z);
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList();
										for (Entity entityiterator : _entfound) {
											if (entityiterator instanceof Warden && !(sourceentity == null)) {
												if (entityiterator instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
													_entity.setTarget(_ent);
												if (entityiterator instanceof LivingEntity _entity)
													_entity.setHealth(120);
												{
													Entity _entityTeam = entityiterator;
													PlayerTeam _pt = _entityTeam.level().getScoreboard().getPlayerTeam("artteamsmrnegative");
													if (_pt != null) {
														if (_entityTeam instanceof Player _player)
															_entityTeam.level().getScoreboard().addPlayerToTeam(_player.getGameProfile().getName(), _pt);
														else
															_entityTeam.level().getScoreboard().addPlayerToTeam(_entityTeam.getStringUUID(), _pt);
													}
												}
											}
										}
									}
									MrNegativeAura2Procedure.execute(world, entity);
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.HOSTILE, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.HOSTILE, 1, 1, false);
										}
									}
									entity.setNoGravity(true);
								});
							});
						});
					});
				});
			});
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Mr. Negative> The darkness will obliterate you!"), false);
				}
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 1 * ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 6)
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 2 * ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 6)
				&& (entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_stage) : 0) < 5) {
			if (entity instanceof MrNegativeEntity _datEntSetI)
				_datEntSetI.getEntityData().set(MrNegativeEntity.DATA_stage, 5);
			if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 200, 0, false, false));
			if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 200, 0, false, false));
			if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 200, 0, false, false));
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Mr. Negative> You defeated it... you're breaking trough the darkness... how..."), false);
				}
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0 * ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 6)
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 1 * ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 6)
				&& (entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_stage) : 0) < 6) {
			if (entity instanceof MrNegativeEntity _datEntSetI)
				_datEntSetI.getEntityData().set(MrNegativeEntity.DATA_stage, 6);
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY));
				entityToSpawn.setPickUpDelay(2400);
				entityToSpawn.setUnlimitedLifetime();
				_level.addFreshEntity(entityToSpawn);
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = ItemStack.EMPTY.copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 4800, 0, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 4800, 2, false, false));
			if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 300, 0, false, false));
			if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 300, 0, false, false));
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Mr. Negative> I don't need a blade to put you on your knees!"), false);
				}
			}
		}
	}
}
