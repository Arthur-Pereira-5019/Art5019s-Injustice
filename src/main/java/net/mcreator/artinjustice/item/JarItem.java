
package net.mcreator.artinjustice.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class JarItem extends Item {
	public JarItem() {
		super(new Item.Properties().stacksTo(8).rarity(Rarity.COMMON));
	}
}
