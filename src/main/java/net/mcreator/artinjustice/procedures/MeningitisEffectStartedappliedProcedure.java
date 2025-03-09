package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;
import net.mcreator.artinjustice.Art5019injusticeMod;

public class MeningitisEffectStartedappliedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (ReturnImmunityProcedure.execute(entity, 1) >= 0) {
			Art5019injusticeMod.queueServerWork(2, () -> {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(Art5019injusticeModMobEffects.MENINGITIS.get());
			});
		}
	}
}
