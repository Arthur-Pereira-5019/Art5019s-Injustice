
package net.mcreator.artinjustice.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.artinjustice.procedures.LifeDepletionEffectStartedappliedProcedure;
import net.mcreator.artinjustice.procedures.LifeDepletionEffectExpiresProcedure;

public class LifeDepletionMobEffect extends MobEffect {
	public LifeDepletionMobEffect() {
		super(MobEffectCategory.HARMFUL, -6750004);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		LifeDepletionEffectStartedappliedProcedure.execute(entity, amplifier);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		LifeDepletionEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
