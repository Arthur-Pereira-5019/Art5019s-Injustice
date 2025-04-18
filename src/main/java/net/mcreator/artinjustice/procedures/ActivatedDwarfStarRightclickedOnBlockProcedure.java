package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class ActivatedDwarfStarRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (IsKryptonianProcedure.execute(entity)) {
			SupermanDwarfStarUseProcedure.execute(world, x, y, z, entity, itemstack);
		}
	}
}
