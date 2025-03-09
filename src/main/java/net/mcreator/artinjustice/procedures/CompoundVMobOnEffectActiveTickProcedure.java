package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;

public class CompoundVMobOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double boost = 0;
		if (Math.random() < 0.7) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.RUSHING.get(), 60, 0, false, false));
		} else {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 180, 1, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 360, 0, false, false));
		}
		entity.setDeltaMovement(new Vec3(((-1) * Math.sin(Math.toRadians(entity.getYRot())) * Math.cos(Math.toRadians(entity.getXRot())) * 3), ((-1) * Math.sin(Math.toRadians(entity.getXRot())) * 3),
				(Math.cos(Math.toRadians(entity.getYRot())) * Math.cos(Math.toRadians(entity.getXRot())) * 3)));
	}
}
