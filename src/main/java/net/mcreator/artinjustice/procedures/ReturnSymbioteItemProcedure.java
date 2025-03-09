package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModItems;

public class ReturnSymbioteItemProcedure {
	public static ItemStack execute(Entity entity, double context) {
		if (entity == null)
			return ItemStack.EMPTY;
		if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 12
				|| (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 24
				|| (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 25) {
			if (context == 0) {
				return new ItemStack(Art5019injusticeModItems.PSP_SYMBIOTE.get());
			} else {
				return new ItemStack(Art5019injusticeModItems.VENOMIZED_SPIDER_REMAINS.get());
			}
		} else if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 19) {
			if (context == 0) {
				return new ItemStack(Art5019injusticeModItems.SYMBIOTE.get());
			} else {
				return new ItemStack(Art5019injusticeModItems.VENOM_REMAINS.get());
			}
		}
		return ItemStack.EMPTY;
	}
}
