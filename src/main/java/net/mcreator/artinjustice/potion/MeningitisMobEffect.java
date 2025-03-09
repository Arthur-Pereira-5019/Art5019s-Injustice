
package net.mcreator.artinjustice.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.artinjustice.procedures.MeningitisOnEffectActiveTickProcedure;
import net.mcreator.artinjustice.procedures.MeningitisEffectStartedappliedProcedure;
import net.mcreator.artinjustice.procedures.FluEffectStartedappliedProcedure;

public class MeningitisMobEffect extends MobEffect {
	public MeningitisMobEffect() {
		super(MobEffectCategory.HARMFUL, -2539174);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		MeningitisEffectStartedappliedProcedure.execute(entity.level(), entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		MeningitisOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, amplifier);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return FluEffectStartedappliedProcedure.execute(amplifier, duration);
	}
}
