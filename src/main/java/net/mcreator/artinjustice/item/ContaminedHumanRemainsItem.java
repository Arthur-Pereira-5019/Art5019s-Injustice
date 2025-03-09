
package net.mcreator.artinjustice.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.artinjustice.procedures.ContaminedHumanRemainsSpecialInformationProcedure;
import net.mcreator.artinjustice.procedures.ContaminedHumanRemainsItemInInventoryTickProcedure;

import java.util.List;

public class ContaminedHumanRemainsItem extends Item {
	public ContaminedHumanRemainsItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		Entity entity = itemstack.getEntityRepresentation();
		list.add(Component.literal(ContaminedHumanRemainsSpecialInformationProcedure.execute(itemstack)));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		ContaminedHumanRemainsItemInInventoryTickProcedure.execute(world, entity, itemstack);
	}
}
