package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;

public class MedicalNanotechAppliedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(Art5019injusticeModMobEffects.ABSOLUTE_IMMUNITY.get())
				&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.ABSOLUTE_IMMUNITY.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.ABSOLUTE_IMMUNITY.get()).getAmplifier() : 0) < 2) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.ABSOLUTE_IMMUNITY.get(), 48000000,
						(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.ABSOLUTE_IMMUNITY.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.ABSOLUTE_IMMUNITY.get()).getAmplifier() : 0) + 1),
						false, false));
		} else if (!(entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(Art5019injusticeModMobEffects.ABSOLUTE_IMMUNITY.get()))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.ABSOLUTE_IMMUNITY.get(), 48000000, 0, false, false));
		} else {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.ABSOLUTE_IMMUNITY.get(), 48000000,
						entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.ABSOLUTE_IMMUNITY.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.ABSOLUTE_IMMUNITY.get()).getAmplifier() : 0, false, false));
		}
	}
}
