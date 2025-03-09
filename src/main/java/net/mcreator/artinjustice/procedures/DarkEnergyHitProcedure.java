package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.artinjustice.Art5019injusticeMod;

public class DarkEnergyHitProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity, double power) {
		if (entity == null || sourceentity == null)
			return;
		if (ReturnAlignmentTierProcedure.execute(sourceentity) < 0) {
			Art5019injusticeMod.queueServerWork(11, () -> {
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_ATTACK)), (float) ((-0.7) * power * ReturnAlignmentTierProcedure.execute(sourceentity)));
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SMOKE, (entity.getX()), (entity.getY()), (entity.getZ()), (int) ((-10) * power * ReturnAlignmentTierProcedure.execute(sourceentity)), 0.5, 1, 0.5, 0.4);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, (entity.getX()), (entity.getY()), (entity.getZ()), (int) ((-20) * power * ReturnAlignmentTierProcedure.execute(sourceentity)), 0.5, 1, 0.5, 0.4);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SOUL, (entity.getX()), (entity.getY()), (entity.getZ()), (int) ((-10) * power * ReturnAlignmentTierProcedure.execute(sourceentity)), 0.5, 1, 0.5, 0.4);
			});
		}
	}
}
