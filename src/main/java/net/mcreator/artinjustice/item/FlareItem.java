
package net.mcreator.artinjustice.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class FlareItem extends Item {
	public FlareItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON));
	}
}
