
package net.mcreator.artinjustice.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class KryptiumDustItem extends Item {
	public KryptiumDustItem() {
		super(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.COMMON));
	}
}
