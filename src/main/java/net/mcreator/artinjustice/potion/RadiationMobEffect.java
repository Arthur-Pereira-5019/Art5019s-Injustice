
package net.mcreator.artinjustice.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.artinjustice.procedures.RadiationOnEffectActiveTickProcedure;
import net.mcreator.artinjustice.procedures.RadiationActiveTickConditionProcedure;

public class RadiationMobEffect extends MobEffect {
	public RadiationMobEffect() {
		super(MobEffectCategory.NEUTRAL, -10066432);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		RadiationOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, amplifier);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return RadiationActiveTickConditionProcedure.execute(amplifier, duration);
	}
}
