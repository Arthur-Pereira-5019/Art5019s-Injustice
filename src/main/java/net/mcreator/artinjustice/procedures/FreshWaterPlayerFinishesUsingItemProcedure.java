package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class FreshWaterPlayerFinishesUsingItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getRemainingFireTicks() > 80) {
			entity.clearFire();
			entity.setSecondsOnFire((int) (entity.getRemainingFireTicks() / 20 - 4));
		} else {
			entity.clearFire();
		}
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.WEAKNESS) ? _livEnt.getEffect(MobEffects.WEAKNESS).getDuration() : 0) > 140) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.HUNGER);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, (int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.WEAKNESS) ? _livEnt.getEffect(MobEffects.WEAKNESS).getDuration() : 0) - 140),
						entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.WEAKNESS) ? _livEnt.getEffect(MobEffects.WEAKNESS).getAmplifier() : 0));
		} else {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.WEAKNESS);
		}
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.HUNGER) ? _livEnt.getEffect(MobEffects.HUNGER).getDuration() : 0) > 140) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.HUNGER);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, (int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.HUNGER) ? _livEnt.getEffect(MobEffects.HUNGER).getDuration() : 0) - 140),
						entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.HUNGER) ? _livEnt.getEffect(MobEffects.HUNGER).getAmplifier() : 0));
		} else {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.HUNGER);
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 0, false, false));
	}
}
