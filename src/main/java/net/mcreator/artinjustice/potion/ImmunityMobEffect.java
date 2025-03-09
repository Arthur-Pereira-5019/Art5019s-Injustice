
package net.mcreator.artinjustice.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.artinjustice.procedures.ImmunityEffectStartedappliedProcedure;

public class ImmunityMobEffect extends MobEffect {
	public ImmunityMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -103);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		ImmunityEffectStartedappliedProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
