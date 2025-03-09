
package net.mcreator.artinjustice.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;

import net.mcreator.artinjustice.procedures.LeadIngotItemIsCraftedsmeltedProcedure;

public class LeadIngotItem extends Item {
	public LeadIngotItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public void onCraftedBy(ItemStack itemstack, Level world, Player entity) {
		super.onCraftedBy(itemstack, world, entity);
		LeadIngotItemIsCraftedsmeltedProcedure.execute(entity);
	}
}
