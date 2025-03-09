package net.mcreator.artinjustice.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class OnTooltipRenderingProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getItemStack(), event.getToolTip());
	}

	public static void execute(ItemStack itemstack, List<Component> tooltip) {
		execute(null, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack, List<Component> tooltip) {
		if (tooltip == null)
			return;
		String upgrade = "";
		String upgrade2 = "";
		if (itemstack.getItem() == Art5019injusticeModItems.PISTOL_ITEM.get()) {
			upgrade = "None";
			upgrade2 = "None";
			if ((itemstack.getOrCreateTag().getString("upgrade")).equals("stabilizer")) {
				upgrade = "Stabilizer";
			}
			if ((itemstack.getOrCreateTag().getString("upgrade2")).equals("silencer")) {
				upgrade2 = "Silencer";
			} else if ((itemstack.getOrCreateTag().getString("upgrade2")).equals("goldskin")) {
				upgrade2 = "\u00A76Golden Skin";
			}
			tooltip.add(1, Component.literal("Requires a Pistol Magazine"));
			tooltip.add(2, Component.literal("Cadency: 1.75s"));
			tooltip.add(3, Component.literal(("Main Upgrade: " + upgrade)));
			tooltip.add(4, Component.literal(("Secondary Upgrade: " + upgrade2)));
		} else if (itemstack.getItem() == Art5019injusticeModItems.CONTAMINED_HUMAN_REMAINS.get()) {
			tooltip.add(1, Component.literal("Right Click with a Empty Syringe on the other hand to extract."));
		} else if (itemstack.getItem() == Items.ROTTEN_FLESH) {
			tooltip.add(Component.literal("\u00A7oCologne for: Multiple bacteria and viruses."));
		} else if (itemstack.getItem() == Items.SWEET_BERRIES) {
			tooltip.add(Component.literal("\u00A7oCologne for: Yeast fungi."));
		} else if (itemstack.getItem() == Art5019injusticeModItems.OLD_PISTOL.get()) {
			tooltip.add(1, Component.literal("Requires a Pistol Magazine"));
			tooltip.add(2, Component.literal("Cadency: 1.75s"));
		} else if (itemstack.getItem() == Items.MILK_BUCKET) {
			tooltip.add(1, Component.literal("Blocked to drink"));
		} else if (itemstack.getItem() == Art5019injusticeModItems.MAAT_FEATHER.get()) {
			tooltip.add(Component.literal("\u00A7oGet's heavier as your soul gets lighter..."));
			tooltip.add(Component.literal(("Weights: " + itemstack.getOrCreateTag().getDouble("weight") + "g")));
			tooltip.add(Component.literal("\u00A7cOnly one per soul..."));
		} else if (itemstack.getItem() == Art5019injusticeModItems.FOOD_PACKAGE.get()) {
			if (itemstack.getOrCreateTag().getDouble("sent") == 1) {
				tooltip.add(1, Component.literal("Address: FEAST Shelter Building]"));
			}
		} else if (itemstack.getItem() == Items.HONEYCOMB) {
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal(("Fingerprint 1: " + itemstack.getOrCreateTag().getString("target1"))));
				tooltip.add(Component.literal(("Owner Name: " + itemstack.getOrCreateTag().getString("target1name"))));
				tooltip.add(Component.literal(("Fingerprint 2: " + itemstack.getOrCreateTag().getString("target2"))));
				tooltip.add(Component.literal(("Owner Name: " + itemstack.getOrCreateTag().getString("target2name"))));
			} else {
				tooltip.add(Component.literal("\u00A77Press Shift to see Fingerprint details. "));
			}
		}
	}
}
