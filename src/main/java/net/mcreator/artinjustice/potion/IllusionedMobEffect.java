
package net.mcreator.artinjustice.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class IllusionedMobEffect extends MobEffect {
	public IllusionedMobEffect() {
		super(MobEffectCategory.HARMFUL, -14518189);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
