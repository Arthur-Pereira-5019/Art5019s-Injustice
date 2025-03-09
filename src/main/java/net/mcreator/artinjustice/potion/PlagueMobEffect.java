
package net.mcreator.artinjustice.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.artinjustice.procedures.PlagueOnEffectActiveTickProcedure;
import net.mcreator.artinjustice.procedures.PlagueAppliedProcedure;
import net.mcreator.artinjustice.procedures.PlagueActiveTickConditionProcedure;

public class PlagueMobEffect extends MobEffect {
	public PlagueMobEffect() {
		super(MobEffectCategory.HARMFUL, -16777216);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		PlagueAppliedProcedure.execute(entity.level(), entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		PlagueOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, amplifier);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return PlagueActiveTickConditionProcedure.execute(duration);
	}
}
