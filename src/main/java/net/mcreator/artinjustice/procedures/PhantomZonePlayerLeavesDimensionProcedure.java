package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;

public class PhantomZonePlayerLeavesDimensionProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(Art5019injusticeModMobEffects.PHANTOM_ZONE_EFFECT.get());
	}
}
