package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class SyringeRightclickedProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((itemstack.getOrCreateTag().getString("fluidid")).equals("Venom")) {
			VenomRightclickedProcedure.execute(entity);
		}
	}
}
