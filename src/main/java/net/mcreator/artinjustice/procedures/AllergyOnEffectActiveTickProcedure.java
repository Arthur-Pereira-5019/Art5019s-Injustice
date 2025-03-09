package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;

public class AllergyOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(Art5019injusticeModMobEffects.ATTACK_INABILITY.get()))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.ATTACK_INABILITY.get(),
						(int) (80 * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.ALLERGY.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.ALLERGY.get()).getAmplifier() : 0) + 1)), 0, false,
						false));
		}
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.ALLERGY.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.ALLERGY.get()).getAmplifier() : 0) >= 1) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 80,
						(int) (0 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.ALLERGY.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.ALLERGY.get()).getAmplifier() : 0)), false, false));
		}
		if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).toxicRes >= (entity instanceof LivingEntity _livEnt
				&& _livEnt.hasEffect(Art5019injusticeModMobEffects.ALLERGY.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.ALLERGY.get()).getAmplifier() : 0) + 1) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(Art5019injusticeModMobEffects.ALLERGY.get());
		}
	}
}
