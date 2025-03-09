
package net.mcreator.artinjustice.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class FoodPackageItem extends Item {
	public FoodPackageItem() {
		super(new Item.Properties().stacksTo(16).fireResistant().rarity(Rarity.UNCOMMON));
	}
}
