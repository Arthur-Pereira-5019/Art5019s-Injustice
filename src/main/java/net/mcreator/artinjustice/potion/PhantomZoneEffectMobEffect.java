
package net.mcreator.artinjustice.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.artinjustice.procedures.PhantomZoneEffectEffectStartedappliedProcedure;
import net.mcreator.artinjustice.procedures.PhantomZoneEffectEffectExpiresProcedure;
import net.mcreator.artinjustice.procedures.PhantomZoneEffectActiveTickConditionProcedure;

public class PhantomZoneEffectMobEffect extends MobEffect {
	public PhantomZoneEffectMobEffect() {
		super(MobEffectCategory.NEUTRAL, -13888212);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		PhantomZoneEffectEffectStartedappliedProcedure.execute(entity.level(), entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		PhantomZoneEffectActiveTickConditionProcedure.execute(entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		PhantomZoneEffectEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
