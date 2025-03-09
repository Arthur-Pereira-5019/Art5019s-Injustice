
package net.mcreator.artinjustice.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ChemistryKitItem extends Item {
	public ChemistryKitItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
