package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class AdrenalyneSyringeRightclickedProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean worked = false;
		double rest = 0;
		double amp = 0;
		double timefactor = 0;
		double ampfactor = 0;
		AdrenalyneGenericProcedure.execute(world, entity, itemstack, 0, 1);
	}
}
