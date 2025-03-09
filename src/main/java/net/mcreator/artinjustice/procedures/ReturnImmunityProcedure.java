package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;

public class ReturnImmunityProcedure {
	public static double execute(Entity entity, double context) {
		if (entity == null)
			return 0;
		double overallimmunity = 0;
		double specificimmunity = 0;
		overallimmunity = -1;
		if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 25) {
			overallimmunity = 4;
		} else if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(Art5019injusticeModMobEffects.ABSOLUTE_IMMUNITY.get())) {
			overallimmunity = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.ABSOLUTE_IMMUNITY.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.ABSOLUTE_IMMUNITY.get()).getAmplifier() : 0;
		}
		if (2 == context) {
			if (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(Art5019injusticeModMobEffects.IMMUNITY.get())) {
				specificimmunity = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.IMMUNITY.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.IMMUNITY.get()).getAmplifier() : 0;
				if (specificimmunity > overallimmunity) {
					return specificimmunity;
				}
			}
		} else if (3 == context) {
			if (entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(Art5019injusticeModMobEffects.IMMUNITY_B.get())) {
				specificimmunity = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.IMMUNITY_B.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.IMMUNITY_B.get()).getAmplifier() : 0;
				if (specificimmunity > overallimmunity) {
					return specificimmunity;
				}
			}
		}
		return overallimmunity;
	}
}
