
package net.mcreator.artinjustice.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class PotassiumSaltItem extends Item {
	public PotassiumSaltItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
