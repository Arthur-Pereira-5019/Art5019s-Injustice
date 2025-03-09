
package net.mcreator.artinjustice.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.artinjustice.procedures.GoldenKryptonitePoisoningOnEffectActiveTickProcedure;
import net.mcreator.artinjustice.procedures.GoldenKryptonitePoisoningEffectStartedappliedProcedure;
import net.mcreator.artinjustice.procedures.GoldenKryptonitePoisoningEffectExpiresProcedure;

public class GoldenKryptonitePoisoningMobEffect extends MobEffect {
	public GoldenKryptonitePoisoningMobEffect() {
		super(MobEffectCategory.HARMFUL, -13312);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		GoldenKryptonitePoisoningEffectStartedappliedProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, amplifier);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		GoldenKryptonitePoisoningOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, amplifier);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		GoldenKryptonitePoisoningEffectExpiresProcedure.execute(entity, amplifier);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
