
package net.mcreator.artinjustice.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class NuggetLeadItem extends Item {
	public NuggetLeadItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
