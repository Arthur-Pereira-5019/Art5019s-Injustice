package net.mcreator.artinjustice.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;

public class AddMaatFatherProcedure {
	public static void execute(Entity sourceentity, double parsedalignment, double stored) {
		if (sourceentity == null)
			return;
		double storedalign = 0;
		ItemStack newfeather = ItemStack.EMPTY;
		newfeather = new ItemStack(Art5019injusticeModItems.MAAT_FEATHER.get());
		newfeather.getOrCreateTag().putDouble("weight", (stored + parsedalignment));
		if (sourceentity instanceof Player _player) {
			ItemStack _setstack = newfeather.copy();
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
	}
}
