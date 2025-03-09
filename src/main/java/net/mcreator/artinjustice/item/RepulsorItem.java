
package net.mcreator.artinjustice.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class RepulsorItem extends Item {
	public RepulsorItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON));
	}
}
