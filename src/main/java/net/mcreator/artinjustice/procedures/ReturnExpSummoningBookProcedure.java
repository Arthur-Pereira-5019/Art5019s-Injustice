package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;

import java.util.function.Supplier;
import java.util.Map;

public class ReturnExpSummoningBookProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String name = "";
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == Items.TOTEM_OF_UNDYING) {
			return "Experience: 75";
		} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
				.getItem() == Art5019injusticeModItems.AMERICA_CONSTITUTION.get()) {
			return "Experience: 60";
		}
		return "";
	}
}
