
package net.mcreator.artinjustice.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.procedures.ActivatedDwarfStarItemInInventoryTickProcedure;

public class ActivatedDwarfStarItem extends Item {
	public ActivatedDwarfStarItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.RARE));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		ActivatedDwarfStarItemInInventoryTickProcedure.execute(world, entity);
	}
}
