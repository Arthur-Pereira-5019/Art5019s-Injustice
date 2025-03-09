package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;
import net.mcreator.artinjustice.init.Art5019injusticeModEntities;
import net.mcreator.artinjustice.entity.TheNightmareEntity;
import net.mcreator.artinjustice.entity.ScopoEntity;
import net.mcreator.artinjustice.entity.NightmareEntity;
import net.mcreator.artinjustice.Art5019injusticeMod;

import java.util.List;
import java.util.Comparator;

public class ScarecrowAbility1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).ability1cooldown <= 0) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.RAGE.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.RAGE.get()).getAmplifier() : 0) >= 4) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = Art5019injusticeModEntities.THE_NIGHTMARE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setDeltaMovement(0, 0, 0);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				{
					double _setval = 64200;
					entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ability1cooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				Art5019injusticeMod.queueServerWork(3, () -> {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof TheNightmareEntity) {
								if (entityiterator instanceof TamableAnimal _toTame && entity instanceof Player _owner)
									_toTame.tame(_owner);
							}
						}
					}
				});
			} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.RAGE.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.RAGE.get()).getAmplifier() : 0) >= 2) {
				if (Math.random() < 0.5) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = Art5019injusticeModEntities.SCOPO.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setDeltaMovement(0, 0, 0);
						}
					}
					{
						double _setval = 26000;
						entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ability1cooldown = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					Art5019injusticeMod.queueServerWork(3, () -> {
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof ScopoEntity) {
									if (entityiterator instanceof TamableAnimal _toTame && entity instanceof Player _owner)
										_toTame.tame(_owner);
								}
							}
						}
					});
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = Art5019injusticeModEntities.NIGHTMARE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setDeltaMovement(0, 0, 0);
						}
					}
					{
						double _setval = 7200;
						entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ability1cooldown = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					Art5019injusticeMod.queueServerWork(3, () -> {
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof NightmareEntity) {
									if (entityiterator instanceof TamableAnimal _toTame && entity instanceof Player _owner)
										_toTame.tame(_owner);
								}
							}
						}
					});
				}
			} else {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = Art5019injusticeModEntities.NIGHTMARE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setDeltaMovement(0, 0, 0);
					}
				}
				{
					double _setval = 7200;
					entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ability1cooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				Art5019injusticeMod.queueServerWork(3, () -> {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof NightmareEntity) {
								if (entityiterator instanceof TamableAnimal _toTame && entity instanceof Player _owner)
									_toTame.tame(_owner);
							}
						}
					}
				});
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Halucination Inducement still cooling down <"
						+ Math.round((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).ability1cooldown / 20) + "s>")), true);
		}
	}
}
