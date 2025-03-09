package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;
import net.mcreator.artinjustice.Art5019injusticeMod;

public class GoldenKryptonitePoisoningEffectStartedappliedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double amplifier) {
		if (entity == null)
			return;
		if (!((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 23)) {
			Art5019injusticeMod.queueServerWork(2, () -> {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(Art5019injusticeModMobEffects.GOLDEN_KRYPTONITE_POISONING.get());
			});
		} else {
			GoldenKryptonitePoisoningOnEffectActiveTickProcedure.execute(world, x, y, z, entity, amplifier);
		}
	}
}
