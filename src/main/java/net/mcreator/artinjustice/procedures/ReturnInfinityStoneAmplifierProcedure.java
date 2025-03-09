package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;

public class ReturnInfinityStoneAmplifierProcedure {
	public static double execute(Entity entity, double stone) {
		if (entity == null)
			return 0;
		if (stone == 6) {
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Art5019injusticeModItems.SOUL_STONE.get())) : false) {
				return 2;
			}
		}
		return 1;
	}
}
