
package net.mcreator.artinjustice.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class BaseVaccineCarrierItem extends Item {
	public BaseVaccineCarrierItem() {
		super(new Item.Properties().stacksTo(8).rarity(Rarity.COMMON));
	}
}
