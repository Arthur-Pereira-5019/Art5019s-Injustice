
package net.mcreator.artinjustice.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.artinjustice.procedures.TuberculosisOnEffectActiveTickProcedure;
import net.mcreator.artinjustice.procedures.TuberculosisAppliedProcedure;
import net.mcreator.artinjustice.procedures.FluEffectStartedappliedProcedure;

public class TuberculosisMobEffect extends MobEffect {
	public TuberculosisMobEffect() {
		super(MobEffectCategory.HARMFUL, -8242887);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		TuberculosisAppliedProcedure.execute(entity.level(), entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		TuberculosisOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, amplifier);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return FluEffectStartedappliedProcedure.execute(amplifier, duration);
	}
}
