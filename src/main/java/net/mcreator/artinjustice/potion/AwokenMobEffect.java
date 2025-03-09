
package net.mcreator.artinjustice.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class AwokenMobEffect extends MobEffect {
	public AwokenMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16713985);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
