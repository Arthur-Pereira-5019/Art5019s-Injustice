
package net.mcreator.artinjustice.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.artinjustice.procedures.RageOnEffectActiveTickProcedure;

public class RageMobEffect extends MobEffect {
	public RageMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -7794942);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		RageOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, amplifier);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
