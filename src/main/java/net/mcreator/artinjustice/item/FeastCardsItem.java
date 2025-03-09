
package net.mcreator.artinjustice.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class FeastCardsItem extends Item {
	public FeastCardsItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("-Crime Solving Alternative:"));
		list.add(Component.literal("\u00A7a+5 Alignment"));
		list.add(Component.literal("\u00A7a-0,1% Criminality Strength"));
		list.add(Component.literal("\u00A7c-25% Success Rate (May change depending on your empathy and social related skills)"));
	}
}
