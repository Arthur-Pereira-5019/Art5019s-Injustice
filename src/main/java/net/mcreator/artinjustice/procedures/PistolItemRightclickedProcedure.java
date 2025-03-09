package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class PistolItemRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double soundid = 0;
		boolean couldupgrade = false;
		GenericShotProcedure.execute(world, x, y, z, entity, itemstack, 1.1);
	}
}
