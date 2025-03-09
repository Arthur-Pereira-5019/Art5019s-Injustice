
package net.mcreator.artinjustice.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class ChemistryKnowledgeMobEffect extends MobEffect {
	public ChemistryKnowledgeMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -65301);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
