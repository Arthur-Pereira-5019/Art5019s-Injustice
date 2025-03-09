package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;

public class BacteriaKillingProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (Math.random() < 0.45 / ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.PLAGUE.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.PLAGUE.get()).getAmplifier() : 0) + 1)) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(Art5019injusticeModMobEffects.PLAGUE.get());
			}
			if (Math.random() < 0.35) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(Art5019injusticeModMobEffects.MENINGITIS.get());
			}
			if (Math.random() < 0.9) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(Art5019injusticeModMobEffects.TUBERCULOSIS.get());
			}
			if (Math.random() < 0.1) {
				if (Math.random() < 0.2) {
					if (Math.random() < 0.3) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.AIDS.get(), 2400, 0, false, false));
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.ALLERGY.get(), 2400, 1, false, false));
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 2400, 1, false, false));
			}
		}
	}
}
