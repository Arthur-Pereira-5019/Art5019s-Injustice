package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;

public class UniversalHealingProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(Art5019injusticeModMobEffects.AIDS.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(Art5019injusticeModMobEffects.ALLERGY.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(Art5019injusticeModMobEffects.COMPOUND_V_MOB.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(Art5019injusticeModMobEffects.DEAFNESS.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(Art5019injusticeModMobEffects.FEAR.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(Art5019injusticeModMobEffects.FLU.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(Art5019injusticeModMobEffects.GOLDEN_KRYPTONITE_POISONING.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(Art5019injusticeModMobEffects.KRYPTONITE_POISONING.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(Art5019injusticeModMobEffects.RAGE.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.WITHER);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.POISON);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(Art5019injusticeModMobEffects.POLIO.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(Art5019injusticeModMobEffects.PLAGUE.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(Art5019injusticeModMobEffects.RADIATION.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(Art5019injusticeModMobEffects.MENINGITIS.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(Art5019injusticeModMobEffects.TUBERCULOSIS.get());
	}
}
