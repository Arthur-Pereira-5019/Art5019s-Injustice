
package net.mcreator.artinjustice.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class IconWindItem extends Item {
	public IconWindItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
