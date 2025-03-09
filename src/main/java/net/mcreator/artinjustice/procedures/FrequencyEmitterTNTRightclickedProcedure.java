package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;

public class FrequencyEmitterTNTRightclickedProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(Art5019injusticeModMobEffects.INTERFERENCE.get()))) {
			if (itemstack.getOrCreateTag().getBoolean("tnttracking")) {
				itemstack.getOrCreateTag().putBoolean("tnttracking", false);
			} else {
				itemstack.getOrCreateTag().putBoolean("tnttracking", true);
			}
		}
	}
}
