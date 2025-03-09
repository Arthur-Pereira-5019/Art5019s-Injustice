
package net.mcreator.artinjustice.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;
import net.minecraft.network.chat.Component;

import net.mcreator.artinjustice.procedures.AdrenalyneSyringeRightclickedProcedure;

import java.util.List;

public class AdrenalyneSyringeItem extends Item {
	public AdrenalyneSyringeItem() {
		super(new Item.Properties().stacksTo(8).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("-Fluid: Liquid Adrenalyne"));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		AdrenalyneSyringeRightclickedProcedure.execute(context.getLevel(), context.getPlayer(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}
}
