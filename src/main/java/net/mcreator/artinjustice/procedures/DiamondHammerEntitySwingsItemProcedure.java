package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class DiamondHammerEntitySwingsItemProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double Scaling = 0;
		double lx = 0;
		double lz = 0;
		double ly = 0;
		HammerGenericRayCastProcedure.execute(world, entity, itemstack, 6);
	}
}
