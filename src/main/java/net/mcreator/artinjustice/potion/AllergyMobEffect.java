
package net.mcreator.artinjustice.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.artinjustice.procedures.AllergyOnEffectActiveTickProcedure;
import net.mcreator.artinjustice.procedures.AllergyEffectStartedappliedProcedure;
import net.mcreator.artinjustice.procedures.AllergyActiveTickConditionProcedure;

public class AllergyMobEffect extends MobEffect {
	public AllergyMobEffect() {
		super(MobEffectCategory.HARMFUL, -16724992);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		AllergyEffectStartedappliedProcedure.execute(entity.level(), entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		AllergyOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return AllergyActiveTickConditionProcedure.execute(duration);
	}
}
