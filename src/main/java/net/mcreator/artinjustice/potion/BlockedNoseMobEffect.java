
package net.mcreator.artinjustice.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.artinjustice.procedures.BlockedNoseOnEffectActiveTickProcedure;

public class BlockedNoseMobEffect extends MobEffect {
	public BlockedNoseMobEffect() {
		super(MobEffectCategory.NEUTRAL, -4201763);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		BlockedNoseOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
