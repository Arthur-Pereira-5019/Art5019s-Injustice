package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModItems;

public class XGeneSortProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double probs = 0;
		if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 0) {
			probs = Math.random();
			if (probs < 0.25) {
				BecomeQuicksilverProcedure.execute(entity);
			} else if (probs < 0.5) {
				BecomeDominoProcedure.execute(entity);
			} else if (probs < 0.75) {
				BecomeDeadpoolProcedure.execute(entity);
			} else {
				BecomeStormProcedure.execute(entity);
			}
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.BLOOD_SYRINGE.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
		}
	}
}
