
package net.mcreator.artinjustice.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class HumanIconItem extends Item {
	public HumanIconItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
