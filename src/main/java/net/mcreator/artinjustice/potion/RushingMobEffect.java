
package net.mcreator.artinjustice.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.artinjustice.procedures.RushingOnEffectActiveTickProcedure;

public class RushingMobEffect extends MobEffect {
	public RushingMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16733441);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		RushingOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
