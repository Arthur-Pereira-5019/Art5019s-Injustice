
package net.mcreator.artinjustice.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.artinjustice.procedures.PowerDependenceOnEffectActiveTickProcedure;

public class AttackInabilityMobEffect extends MobEffect {
	public AttackInabilityMobEffect() {
		super(MobEffectCategory.HARMFUL, -11585457);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		PowerDependenceOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
