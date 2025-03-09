package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;

public class UniversalDiseaseRemovingProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(Art5019injusticeModMobEffects.TUBERCULOSIS.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(Art5019injusticeModMobEffects.POLIO.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(Art5019injusticeModMobEffects.PLAGUE.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(Art5019injusticeModMobEffects.DEAFNESS.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(Art5019injusticeModMobEffects.FEAR.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.POISON);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.WITHER);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(Art5019injusticeModMobEffects.MENINGITIS.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(Art5019injusticeModMobEffects.AIDS.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(Art5019injusticeModMobEffects.ALLERGY.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(Art5019injusticeModMobEffects.ATTACK_INABILITY.get());
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.BLINDNESS);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.DIG_SLOWDOWN);
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.HUNGER);
	}
}
