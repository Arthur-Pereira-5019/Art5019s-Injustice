
package net.mcreator.artinjustice.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class PituitaryGlandItem extends Item {
	public PituitaryGlandItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON));
	}
}
