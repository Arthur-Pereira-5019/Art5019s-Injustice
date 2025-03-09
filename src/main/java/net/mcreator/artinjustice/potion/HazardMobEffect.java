
package net.mcreator.artinjustice.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.artinjustice.procedures.HazardOnEffectActiveTickProcedure;
import net.mcreator.artinjustice.procedures.HazardEffectStartedProcedure;
import net.mcreator.artinjustice.procedures.HazardEffectExpiresProcedure;
import net.mcreator.artinjustice.procedures.HazardActiveTickConditionProcedure;

public class HazardMobEffect extends MobEffect {
	public HazardMobEffect() {
		super(MobEffectCategory.HARMFUL, -65536);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		HazardEffectStartedProcedure.execute(entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		HazardOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, amplifier);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		HazardEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return HazardActiveTickConditionProcedure.execute(amplifier, duration);
	}
}
