
package net.mcreator.artinjustice.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class BadgeItem extends Item {
	public BadgeItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
