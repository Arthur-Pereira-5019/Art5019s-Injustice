
package net.mcreator.artinjustice.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.artinjustice.procedures.FortuneOnEffectActiveTickProcedure;
import net.mcreator.artinjustice.procedures.FortuneEffectStartedappliedProcedure;
import net.mcreator.artinjustice.procedures.FortuneEffectExpiresProcedure;
import net.mcreator.artinjustice.procedures.FortuneActiveTickConditionProcedure;

public class FortuneMobEffect extends MobEffect {
	public FortuneMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16711936);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		FortuneEffectStartedappliedProcedure.execute(entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		FortuneOnEffectActiveTickProcedure.execute(entity, amplifier);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		FortuneEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return FortuneActiveTickConditionProcedure.execute(amplifier, duration);
	}
}
