
package net.mcreator.artinjustice.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.procedures.NanotechKitItemInHandTickProcedure;

public class TheGreenSuitSchemeItem extends Item {
	public TheGreenSuitSchemeItem() {
		super(new Item.Properties().durability(32).rarity(Rarity.COMMON));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		NanotechKitItemInHandTickProcedure.execute(itemstack);
	}
}
