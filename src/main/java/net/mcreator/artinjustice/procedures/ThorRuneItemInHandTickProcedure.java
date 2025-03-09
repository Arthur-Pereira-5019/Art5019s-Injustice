package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class ThorRuneItemInHandTickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("cadency") > 0) {
			itemstack.getOrCreateTag().putDouble("cadency", (entity.getPersistentData().getDouble("cadency") - 1));
		}
	}
}
