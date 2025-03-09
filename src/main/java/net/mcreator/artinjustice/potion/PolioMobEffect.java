
package net.mcreator.artinjustice.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.artinjustice.procedures.PolioOnEffectActiveTickProcedure;
import net.mcreator.artinjustice.procedures.PolioEffectExpiresProcedure;
import net.mcreator.artinjustice.procedures.PolioAppliedProcedure;
import net.mcreator.artinjustice.procedures.PolioActiveTickConditionProcedure;

public class PolioMobEffect extends MobEffect {
	public PolioMobEffect() {
		super(MobEffectCategory.HARMFUL, -3889981);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		PolioAppliedProcedure.execute(entity.level(), entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		PolioOnEffectActiveTickProcedure.execute(entity.level(), entity, amplifier);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		PolioEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return PolioActiveTickConditionProcedure.execute(duration);
	}
}
