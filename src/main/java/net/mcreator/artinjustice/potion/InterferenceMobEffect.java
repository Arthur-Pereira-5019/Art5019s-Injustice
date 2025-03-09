
package net.mcreator.artinjustice.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class InterferenceMobEffect extends MobEffect {
	public InterferenceMobEffect() {
		super(MobEffectCategory.NEUTRAL, -13098976);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
