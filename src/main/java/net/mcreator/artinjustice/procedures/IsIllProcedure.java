package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;

public class IsIllProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(Art5019injusticeModMobEffects.FLU.get()) || entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(Art5019injusticeModMobEffects.MENINGITIS.get())
				|| entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(Art5019injusticeModMobEffects.TUBERCULOSIS.get()) || entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(Art5019injusticeModMobEffects.POLIO.get())
				|| entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(Art5019injusticeModMobEffects.PLAGUE.get()) || entity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(Art5019injusticeModMobEffects.AIDS.get())) {
			return true;
		}
		return false;
	}
}
