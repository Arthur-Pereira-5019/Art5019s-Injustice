
package net.mcreator.artinjustice.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.artinjustice.procedures.CompoundVMobOnEffectActiveTickProcedure;
import net.mcreator.artinjustice.procedures.CompoundVMobEffectStartedappliedProcedure;
import net.mcreator.artinjustice.procedures.CompoundVMobActiveTickConditionProcedure;

public class CompoundVMobMobEffect extends MobEffect {
	public CompoundVMobMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16759041);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		CompoundVMobEffectStartedappliedProcedure.execute(entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		CompoundVMobOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return CompoundVMobActiveTickConditionProcedure.execute(amplifier, duration);
	}
}
