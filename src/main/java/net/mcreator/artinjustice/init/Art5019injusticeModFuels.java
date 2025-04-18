
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.artinjustice.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

import net.minecraft.world.item.ItemStack;

@Mod.EventBusSubscriber
public class Art5019injusticeModFuels {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		ItemStack itemstack = event.getItemStack();
		if (itemstack.getItem() == Art5019injusticeModItems.ENRICHED_URANIUM.get())
			event.setBurnTime(40000);
		else if (itemstack.getItem() == Art5019injusticeModItems.KRYPTONITE.get())
			event.setBurnTime(8000);
		else if (itemstack.getItem() == Art5019injusticeModItems.ACTIVATED_DWARF_STAR.get())
			event.setBurnTime(2000000);
	}
}
