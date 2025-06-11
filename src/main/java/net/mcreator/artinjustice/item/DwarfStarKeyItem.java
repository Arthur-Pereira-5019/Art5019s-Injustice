
package net.mcreator.artinjustice.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;

import net.mcreator.artinjustice.procedures.DwarfStarKeyItemIsDroppedByPlayerProcedure;

public class DwarfStarKeyItem extends Item {
	public DwarfStarKeyItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
	}

	@Override
	public boolean onDroppedByPlayer(ItemStack itemstack, Player entity) {
		DwarfStarKeyItemIsDroppedByPlayerProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
		return true;
	}
}
