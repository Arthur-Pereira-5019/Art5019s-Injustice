package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;

public class AnvilFineBladeForgingProcedure {
	public static ItemStack execute(LevelAccessor world, ItemStack toBeChanged) {
		ItemStack toBeReturned = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			if (Math.random() < 0.55) {
				if (toBeChanged.getItem() == Art5019injusticeModItems.LONG_IRON_BLADE.get()) {
					toBeReturned = new ItemStack(Items.IRON_INGOT);
				} else if (toBeChanged.getItem() == Art5019injusticeModItems.LONG_STEEL_BLADE.get()) {
					toBeReturned = new ItemStack(Art5019injusticeModItems.STEEL_INGOT.get());
				} else if (toBeChanged.getItem() == Art5019injusticeModItems.LONG_KRYPTONITE_BLADE.get()) {
					toBeReturned = new ItemStack(Art5019injusticeModItems.KRYPTONITE.get());
				} else if (toBeChanged.getItem() == Art5019injusticeModItems.LONG_GOLDEN_KRYPTONITE_BLADE.get()) {
					toBeReturned = new ItemStack(Art5019injusticeModItems.GOLDEN_KRYPTONITE.get());
				}
				toBeReturned.setCount(1);
			} else {
				if (toBeChanged.getItem() == Art5019injusticeModItems.LONG_IRON_BLADE.get()) {
					toBeReturned = new ItemStack(Art5019injusticeModItems.FINE_IRON_BLADE.get());
				} else if (toBeChanged.getItem() == Art5019injusticeModItems.LONG_STEEL_BLADE.get()) {
					toBeReturned = new ItemStack(Art5019injusticeModItems.FINE_STEEL_BLADE.get());
				} else if (toBeChanged.getItem() == Art5019injusticeModItems.LONG_KRYPTONITE_BLADE.get()) {
					toBeReturned = new ItemStack(Art5019injusticeModItems.FINE_KRYPTONITE_BLADE.get());
				} else if (toBeChanged.getItem() == Art5019injusticeModItems.LONG_GOLDEN_KRYPTONITE_BLADE.get()) {
					toBeReturned = new ItemStack(Art5019injusticeModItems.GOLDEN_KRYPTONITE_FINE_BLADE.get());
				}
				toBeReturned.setCount(1);
			}
		}
		return toBeReturned;
	}
}
