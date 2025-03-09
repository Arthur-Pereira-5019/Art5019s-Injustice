package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.artinjustice.init.Art5019injusticeModParticleTypes;
import net.mcreator.artinjustice.entity.ChrisTheMusicianEntity;
import net.mcreator.artinjustice.Art5019injusticeMod;

public class ChrisJacksonTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (Math.random() < 0.0025) {
				if ((entity instanceof ChrisTheMusicianEntity _datEntI ? _datEntI.getEntityData().get(ChrisTheMusicianEntity.DATA_quest) : 0) > 3) {
					if (Math.random() < 0.025) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"stopsound @a[distance=..16] music");
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 180, 3, false, false));
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("music_disc.stal")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("music_disc.stal")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.NOTE, x, y, z, 40, 3, 3, 3, 1);
						Art5019injusticeMod.queueServerWork(40, () -> {
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.NOTE, x, y, z, 40, 0.5, 3, 0.5, 1);
						});
						Art5019injusticeMod.queueServerWork(80, () -> {
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.NOTE, x, y, z, 40, 0.5, 3, 0.5, 1);
						});
						Art5019injusticeMod.queueServerWork(120, () -> {
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.NOTE, x, y, z, 40, 0.5, 3, 0.5, 1);
						});
						Art5019injusticeMod.queueServerWork(160, () -> {
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.NOTE, x, y, z, 40, 0.5, 1, 0.5, 1);
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"stopsound @a neutral minecraft:music_disc.stal");
						});
					}
				} else if ((entity instanceof ChrisTheMusicianEntity _datEntI ? _datEntI.getEntityData().get(ChrisTheMusicianEntity.DATA_quest) : 0) == 3) {
					if (Math.random() < 0.33) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.note_block.cow_bell")), SoundSource.NEUTRAL, 1, (float) Math.random());
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.note_block.cow_bell")), SoundSource.NEUTRAL, 1, (float) Math.random(), false);
							}
						}
					} else {
						if (Math.random() < 0.5) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.note_block.bell")), SoundSource.NEUTRAL, 1, (float) Math.random());
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.note_block.bell")), SoundSource.NEUTRAL, 1, (float) Math.random(), false);
								}
							}
						} else {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.note_block.bass")), SoundSource.NEUTRAL, 1, (float) Math.random());
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.note_block.bass")), SoundSource.NEUTRAL, 1, (float) Math.random(), false);
								}
							}
						}
					}
				} else {
					entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((Mth.nextDouble(RandomSource.create(), -1, 1)), (Mth.nextDouble(RandomSource.create(), -1, 1)), (Mth.nextDouble(RandomSource.create(), -1, 1))));
					Art5019injusticeMod.queueServerWork(20, () -> {
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (Art5019injusticeModParticleTypes.PUZZLE_INVESTIGATE.get()), x, (y + 1.65), z, 60, 0.3, 0.5, 0.3, 0.1);
					});
				}
			}
		}
	}
}
