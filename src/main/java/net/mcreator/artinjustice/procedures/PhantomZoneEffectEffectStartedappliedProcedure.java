package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;
import net.mcreator.artinjustice.Art5019injusticeMod;

public class PhantomZoneEffectEffectStartedappliedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.setNoGravity(true);
		AttributeAdderProcedure.execute(entity, 2, "-0.06", "PhantomGravity", "add", "58a79215-a927-4319-b366-345b213c4b1d ");
		Art5019injusticeMod.queueServerWork(2, () -> {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.PHANTOM_ZONE_EFFECT.get(), 999999, 0, false, false));
		});
	}
}
