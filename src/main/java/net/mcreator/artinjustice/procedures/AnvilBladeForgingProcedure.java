package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;

public class AnvilBladeForgingProcedure {
	public static ItemStack execute(LevelAccessor world, ItemStack toBeChanged) {
		ItemStack toBeReturned = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			if (Math.random() < 0.5) {
				if (toBeChanged.getItem() == Items.IRON_INGOT) {
					toBeReturned = new ItemStack(Items.IRON_NUGGET);
				} else if (toBeChanged.getItem() == Art5019injusticeModItems.STEEL_INGOT.get()) {
					toBeReturned = new ItemStack(Art5019injusticeModItems.STEEL_NUGGET.get());
				} else if (toBeChanged.getItem() == Art5019injusticeModItems.KRYPTONITE.get()) {
					toBeReturned = new ItemStack(Art5019injusticeModItems.KRYPTONITE_SHARD.get());
				} else if (toBeChanged.getItem() == Art5019injusticeModItems.GOLDEN_KRYPTONITE.get()) {
					toBeReturned = new ItemStack(Art5019injusticeModItems.GOLDEN_KRYPTONITE_SHARD.get());
				}
				toBeReturned.setCount(8);
				if (Math.random() < 0.7) {
					toBeReturned.setCount(9);
				}
			} else {
				if (toBeChanged.getItem() == Items.IRON_INGOT) {
					toBeReturned = new ItemStack(Art5019injusticeModItems.LONG_IRON_BLADE.get());
				} else if (toBeChanged.getItem() == Art5019injusticeModItems.STEEL_INGOT.get()) {
					toBeReturned = new ItemStack(Art5019injusticeModItems.LONG_STEEL_BLADE.get());
				} else if (toBeChanged.getItem() == Art5019injusticeModItems.KRYPTONITE.get()) {
					toBeReturned = new ItemStack(Art5019injusticeModItems.LONG_KRYPTONITE_BLADE.get());
				} else if (toBeChanged.getItem() == Art5019injusticeModItems.GOLDEN_KRYPTONITE.get()) {
					toBeReturned = new ItemStack(Art5019injusticeModItems.LONG_GOLDEN_KRYPTONITE_BLADE.get());
				}
				toBeReturned.setCount(1);
			}
		}
		return toBeReturned;
	}
}
