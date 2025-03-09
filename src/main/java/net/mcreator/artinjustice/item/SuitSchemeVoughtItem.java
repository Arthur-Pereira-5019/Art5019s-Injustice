
package net.mcreator.artinjustice.item;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class SuitSchemeVoughtItem extends Item {
	public SuitSchemeVoughtItem() {
		super(new Item.Properties().durability(32).rarity(Rarity.COMMON));
	}

	@Override
	public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
		return 0f;
	}
}
