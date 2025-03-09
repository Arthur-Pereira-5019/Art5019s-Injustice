package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class TrackerDeviceRightclickedProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getDouble("trackerF") < 10) {
			itemstack.getOrCreateTag().putDouble("trackerF", (itemstack.getOrCreateTag().getDouble("trackerF") + 1));
		} else {
			itemstack.getOrCreateTag().putDouble("trackerF", 0);
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal((new java.text.DecimalFormat("##").format(itemstack.getOrCreateTag().getDouble("trackerF")))), true);
	}
}
