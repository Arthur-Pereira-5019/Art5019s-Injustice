
package net.mcreator.artinjustice.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class NeuroEmblemItem extends Item {
	public NeuroEmblemItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.UNCOMMON));
	}

	@Override
	public boolean hasCraftingRemainingItem() {
		return true;
	}

	@Override
	public ItemStack getCraftingRemainingItem(ItemStack itemstack) {
		return new ItemStack(this);
	}
}
