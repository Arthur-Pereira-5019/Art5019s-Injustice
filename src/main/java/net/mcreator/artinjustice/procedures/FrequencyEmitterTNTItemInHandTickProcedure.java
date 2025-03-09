package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;

public class FrequencyEmitterTNTItemInHandTickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(Art5019injusticeModMobEffects.INTERFERENCE.get()))) {
			if (itemstack.getOrCreateTag().getBoolean("tnttracking")) {
				if (Math.random() < 0.01) {
					{
						ItemStack _ist = itemstack;
						if (_ist.hurt(1, RandomSource.create(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
				}
			}
		}
	}
}
