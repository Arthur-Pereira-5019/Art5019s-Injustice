
package net.mcreator.artinjustice.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class MagicBlockingMobEffect extends MobEffect {
	public MagicBlockingMobEffect() {
		super(MobEffectCategory.NEUTRAL, -65318);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
