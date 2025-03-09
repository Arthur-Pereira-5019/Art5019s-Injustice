package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;

public class CellPhoneRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (Art5019injusticeModVariables.MapVariables.get(world).event_id == 1) {
			if ((itemstack.getOrCreateTag().getString("contact")).equals("HelpCenter")) {
				CellphoneCallToHelpCenterProcedure.execute(world, x, y, z, entity);
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = itemstack;
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
			} else if ((itemstack.getOrCreateTag().getString("contact")).equals("BigHelpCenter")) {
				CellPhoneCallToBigCenterProcedure.execute(world, x, y, z, entity);
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = itemstack;
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("<Unknown Voice> Unknown Number."), false);
		}
	}
}
