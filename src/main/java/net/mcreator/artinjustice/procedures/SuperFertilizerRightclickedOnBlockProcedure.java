package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;

public class SuperFertilizerRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double d = 0;
		double dx = 0;
		double dy = 0;
		double dz = 0;
		double timer = 0;
		GreenEssenceAppliedProcedure.execute(world, x, y, z, entity);
		if (entity instanceof Player _player) {
			ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.SUPER_FERTILIZER.get());
			_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
		}
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(Art5019injusticeModItems.SUPER_FERTILIZER.get(), 100);
	}
}
