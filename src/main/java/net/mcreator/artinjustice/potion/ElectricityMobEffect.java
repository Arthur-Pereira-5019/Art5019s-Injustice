
package net.mcreator.artinjustice.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.artinjustice.procedures.ElectricityOnEffectActiveTickProcedure;
import net.mcreator.artinjustice.procedures.ElectricityActiveTickConditionProcedure;

public class ElectricityMobEffect extends MobEffect {
	public ElectricityMobEffect() {
		super(MobEffectCategory.HARMFUL, -13312);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		ElectricityOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, amplifier);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return ElectricityActiveTickConditionProcedure.execute(amplifier, duration);
	}
}
