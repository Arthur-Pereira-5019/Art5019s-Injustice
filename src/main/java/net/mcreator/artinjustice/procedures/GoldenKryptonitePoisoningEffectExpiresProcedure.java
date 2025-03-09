package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;

public class GoldenKryptonitePoisoningEffectExpiresProcedure {
	public static void execute(Entity entity, double amplifier) {
		if (entity == null)
			return;
		if (amplifier > 0) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.GOLDEN_KRYPTONITE_POISONING.get(), 1199, (int) (amplifier - 1), false, false));
		}
	}
}
