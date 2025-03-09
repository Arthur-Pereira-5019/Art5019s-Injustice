
package net.mcreator.artinjustice.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class HamburguerItem extends Item {
	public HamburguerItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(20).saturationMod(7f).build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 64;
	}
}
