
package net.mcreator.artinjustice.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.artinjustice.procedures.FluOnEffectActiveTickProcedure;
import net.mcreator.artinjustice.procedures.FluEffectStartedappliedProcedure;
import net.mcreator.artinjustice.procedures.FluEffectExpiresProcedure;
import net.mcreator.artinjustice.procedures.FluAppliedProcedure;

public class FluMobEffect extends MobEffect {
	public FluMobEffect() {
		super(MobEffectCategory.NEUTRAL, -4043186);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		FluAppliedProcedure.execute(entity.level(), entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		FluOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, amplifier);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		FluEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return FluEffectStartedappliedProcedure.execute(amplifier, duration);
	}
}
