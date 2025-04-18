package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;

public class GoldenKryptoniteKatanaLivingEntityIsHitWithToolProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (IsKryptonianProcedure.execute(entity)) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.GOLDEN_KRYPTONITE_POISONING.get(),
						(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.GOLDEN_KRYPTONITE_POISONING.get())
								? _livEnt.getEffect(Art5019injusticeModMobEffects.GOLDEN_KRYPTONITE_POISONING.get()).getDuration()
								: 0) + 360),
						1, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.POWER_DEPENDENCE.get(), 120, 1, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.ATTACK_INABILITY.get(), 220, 0, false, false));
		}
	}
}
