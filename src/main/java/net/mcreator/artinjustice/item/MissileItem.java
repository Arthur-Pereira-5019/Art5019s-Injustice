
package net.mcreator.artinjustice.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class MissileItem extends Item {
	public MissileItem() {
		super(new Item.Properties().stacksTo(8).rarity(Rarity.COMMON));
	}
}
