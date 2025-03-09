
package net.mcreator.artinjustice.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.artinjustice.procedures.SunDippedOnEffectActiveTickProcedure;

public class SunDippedMobEffect extends MobEffect {
	public SunDippedMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -18432);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		SunDippedOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
