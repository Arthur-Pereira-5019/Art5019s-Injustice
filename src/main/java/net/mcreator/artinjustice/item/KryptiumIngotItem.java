
package net.mcreator.artinjustice.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class KryptiumIngotItem extends Item {
	public KryptiumIngotItem() {
		super(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.COMMON));
	}
}
