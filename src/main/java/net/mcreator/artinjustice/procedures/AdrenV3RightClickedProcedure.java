package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class AdrenV3RightClickedProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double amp = 0;
		double res = 0;
		AdrenalyneSyringeRightclickedProcedure.execute(world, entity, itemstack);
	}
}
