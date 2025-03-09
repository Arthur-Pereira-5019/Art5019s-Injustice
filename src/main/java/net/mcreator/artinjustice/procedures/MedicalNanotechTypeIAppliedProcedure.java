package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;

public class MedicalNanotechTypeIAppliedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		MedicalNanotechAppliedProcedure.execute(entity);
		if (entity instanceof Player _player) {
			ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.MEDICAL_NANOTECH.get());
			_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
		}
	}
}
