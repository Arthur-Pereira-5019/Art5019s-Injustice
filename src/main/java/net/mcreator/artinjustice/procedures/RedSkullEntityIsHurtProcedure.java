package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.artinjustice.Art5019injusticeMod;

import java.util.List;
import java.util.Comparator;

public class RedSkullEntityIsHurtProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double probs = 0;
		probs = Math.random();
		if (!(sourceentity instanceof LivingEntity _livEnt0 && _livEnt0.getMobType() == MobType.ILLAGER)) {
			if (probs < 0.05) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(sourceentity.getX(), sourceentity.getY(), sourceentity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.portal.trigger")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.portal.trigger")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"particle dust 0.000 0.333 0.671 1 ~ ~ ~ 0.3 0.3 0.3 1 90 normal");
				Art5019injusticeMod.queueServerWork(45, () -> {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
										.withSuppressedOutput(),
								"particle dust 0.000 1.000 0.933 1 ~ ~ ~ 0.3 0.3 0.3 1 90 normal");
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = EntityType.PILLAGER.spawn(_level, BlockPos.containing(sourceentity.getX(), sourceentity.getY(), sourceentity.getZ()), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setDeltaMovement(0, 0, 0);
						}
					}
				});
				Art5019injusticeMod.queueServerWork(90, () -> {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
										.withSuppressedOutput(),
								"particle dust 0.067 0.161 0.212 1 ~ ~ ~ 0.3 0.3 0.3 1 90 normal");
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = EntityType.PILLAGER.spawn(_level, BlockPos.containing(sourceentity.getX(), sourceentity.getY(), sourceentity.getZ()), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setDeltaMovement(0, 0, 0);
						}
					}
				});
				Art5019injusticeMod.queueServerWork(135, () -> {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
										.withSuppressedOutput(),
								"particle dust 0.000 0.196 0.659 1 ~ ~ ~ 0.3 0.3 0.3 1 90 normal");
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = EntityType.PILLAGER.spawn(_level, BlockPos.containing(sourceentity.getX(), sourceentity.getY(), sourceentity.getZ()), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setDeltaMovement(0, 0, 0);
						}
					}
				});
			} else if (probs < 0.1) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof LivingEntity _livEnt36 && _livEnt36.getMobType() == MobType.ILLAGER) {
							{
								Entity _ent = entityiterator;
								_ent.teleportTo((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()));
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), _ent.getYRot(), _ent.getXRot());
							}
						}
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
											.withSuppressedOutput(),
									"particle dust 0.000 0.933 1.000 1 ~ ~ ~ 0.3 0.3 0.3 1 200 normal");
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.enderman.teleport")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if (probs < 0.15) {
				{
					Entity _ent = sourceentity;
					_ent.teleportTo((sourceentity.getX() + 7 * Mth.nextDouble(RandomSource.create(), -1, 1)), (sourceentity.getY() + 7 * Mth.nextDouble(RandomSource.create(), -1, 1)),
							(sourceentity.getZ() + 7 * Mth.nextDouble(RandomSource.create(), -1, 1)));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport((sourceentity.getX() + 7 * Mth.nextDouble(RandomSource.create(), -1, 1)), (sourceentity.getY() + 7 * Mth.nextDouble(RandomSource.create(), -1, 1)),
								(sourceentity.getZ() + 7 * Mth.nextDouble(RandomSource.create(), -1, 1)), _ent.getYRot(), _ent.getXRot());
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if (probs < 0.2) {
				{
					Entity _ent = entity;
					_ent.teleportTo((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), _ent.getYRot(), _ent.getXRot());
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.chorus_fruit.teleport")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"particle dust 0.000 0.933 1.000 1 ~ ~ ~ 0.3 0.3 0.3 1 200 normal");
			}
		}
	}
}
