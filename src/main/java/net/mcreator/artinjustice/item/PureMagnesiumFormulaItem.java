
package net.mcreator.artinjustice.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.artinjustice.procedures.NanotechKitItemInHandTickProcedure;

import java.util.List;

public class PureMagnesiumFormulaItem extends Item {
	public PureMagnesiumFormulaItem() {
		super(new Item.Properties().durability(256).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("Recipe: Pure Magnesium"));
		list.add(Component.literal(".Can be put on a Dust Case - Complexity: 1 Chemistry Kit"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			NanotechKitItemInHandTickProcedure.execute(itemstack);
	}
}
