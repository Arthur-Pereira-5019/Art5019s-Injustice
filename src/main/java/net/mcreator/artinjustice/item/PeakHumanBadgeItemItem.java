
package net.mcreator.artinjustice.item;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class PeakHumanBadgeItemItem extends Item {
	public PeakHumanBadgeItemItem() {
		super(new Item.Properties().durability(32).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	public boolean isCorrectToolForDrops(BlockState state) {
		return true;
	}
}
