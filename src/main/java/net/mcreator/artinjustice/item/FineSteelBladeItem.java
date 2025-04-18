
package net.mcreator.artinjustice.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class FineSteelBladeItem extends Item {
	public FineSteelBladeItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
