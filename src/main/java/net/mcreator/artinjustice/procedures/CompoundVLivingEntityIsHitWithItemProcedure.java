package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class CompoundVLivingEntityIsHitWithItemProcedure {
	public static void execute(Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		CompoundVGenericHitProcedure.execute(entity, sourceentity, itemstack, 1);
	}
}
