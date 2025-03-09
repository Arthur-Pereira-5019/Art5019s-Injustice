
package net.mcreator.artinjustice.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.artinjustice.procedures.PheromonesOnEffectActiveTickProcedure;

public class PheromonesMobEffect extends MobEffect {
	public PheromonesMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -65377);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		PheromonesOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
