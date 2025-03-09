package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.Art5019injusticeMod;

public class GrenadeThrownProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:item.grenade.hits")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:item.grenade.hits")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SMOKE, x, (y + 0.5), z, 30, 0.1, 0.4, 0.1, 0);
		Art5019injusticeMod.queueServerWork(20, () -> {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMOKE, x, (y + 0.5), z, 30, 0.1, 0.4, 0.1, 0);
		});
		Art5019injusticeMod.queueServerWork(40, () -> {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMOKE, x, (y + 0.5), z, 30, 0.1, 0.4, 0.1, 0);
		});
		Art5019injusticeMod.queueServerWork(60, () -> {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMOKE, x, (y + 0.5), z, 30, 0.1, 0.4, 0.1, 0);
		});
		Art5019injusticeMod.queueServerWork(80, () -> {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMOKE, x, (y + 0.5), z, 30, 0.1, 0.4, 0.1, 0);
		});
		Art5019injusticeMod.queueServerWork(100, () -> {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMOKE, x, (y + 0.5), z, 30, 0.1, 0.4, 0.1, 0);
		});
		Art5019injusticeMod.queueServerWork(120, () -> {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMOKE, x, (y + 0.5), z, 30, 0.1, 0.4, 0.1, 0);
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, 2, Level.ExplosionInteraction.MOB);
		});
	}
}
