package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;

public class TaskMasterEntityIsHurtProcedure {
	public static void execute(Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.HERO_ENEMY.get(), 600, 0, false, false));
	}
}
