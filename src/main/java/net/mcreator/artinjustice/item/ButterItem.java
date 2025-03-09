
package net.mcreator.artinjustice.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class ButterItem extends Item {
	public ButterItem() {
		super(new Item.Properties().stacksTo(8).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(4).saturationMod(5f).build()));
	}
}
