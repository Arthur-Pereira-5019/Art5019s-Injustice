package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;

public class NewspaperItemInInventoryTickProcedure {
	public static void execute(LevelAccessor world, ItemStack itemstack) {
		if ((itemstack.getOrCreateTag().getString("news")).equals("")) {
			itemstack.getOrCreateTag().putString("news", ("" + Art5019injusticeModVariables.MapVariables.get(world).today_news));
			itemstack.getOrCreateTag().putString("event", ("" + Art5019injusticeModVariables.MapVariables.get(world).event_id));
			itemstack.getOrCreateTag().putString("eventm", ("" + Art5019injusticeModVariables.MapVariables.get(world).event_meter));
		}
	}
}
