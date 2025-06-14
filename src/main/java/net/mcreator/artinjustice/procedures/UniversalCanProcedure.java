package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;

public class UniversalCanProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(Art5019injusticeModMobEffects.PHANTOM_ZONE_EFFECT.get())) {
			return false;
		}
		return true;
	}
}
