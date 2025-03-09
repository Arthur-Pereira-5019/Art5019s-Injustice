package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class MrNegativeAura2Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		Entity targetting = null;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.GLOW_SQUID_INK, (entity.getX()), (entity.getY() + 1), (entity.getZ()), 40, 0.5, 1, 0.5, 0.2);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.FLAME, (entity.getX()), (entity.getY() + 1), (entity.getZ()), 90, 0.5, 1, 0.5, 0.2);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.GLOW, (entity.getX()), (entity.getY() + 1), (entity.getZ()), 90, 0.5, 1, 0.5, 0.2);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:effect.short_shock")), SoundSource.HOSTILE, 1, 1);
			} else {
				_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:effect.short_shock")), SoundSource.HOSTILE, 1, 1, false);
			}
		}
	}
}
