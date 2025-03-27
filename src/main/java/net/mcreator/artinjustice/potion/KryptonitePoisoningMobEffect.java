
package net.mcreator.artinjustice.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.artinjustice.procedures.KryptonitePoisoningOnEffectActiveTickProcedure;
import net.mcreator.artinjustice.procedures.KryptonitePoisoningEffectStartedappliedProcedure;
import net.mcreator.artinjustice.procedures.KryptonitePoisoningEffectExpiresProcedure;

public class KryptonitePoisoningMobEffect extends MobEffect {
	public KryptonitePoisoningMobEffect() {
		super(MobEffectCategory.NEUTRAL, -15270144);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		KryptonitePoisoningEffectStartedappliedProcedure.execute(entity.level(), entity, amplifier);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		KryptonitePoisoningOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, amplifier);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		KryptonitePoisoningEffectExpiresProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
