package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;

public class ReturnCurrentModeProcedure {
	public static String execute(ItemStack targetItem, double setmode) {
		String mode = "";
		if (targetItem.getItem() == Art5019injusticeModItems.T_WEB_SHOOTER_TIER_2.get()) {
			if (setmode == 0) {
				mode = "Default Web";
			} else if (setmode == 1) {
				mode = "Dashing Web";
			} else if (setmode == 2) {
				mode = "Web Grenade";
			} else if (setmode == 3) {
				mode = "Rapid Web";
			} else if (setmode == 4) {
				mode = "Impact Web";
			} else {
				mode = "Electrical Web";
			}
		} else if (targetItem.getItem() == Art5019injusticeModItems.T_WEB_SHOOTER_TIER_1.get()) {
			if (setmode == 0) {
				mode = "Default Web";
			} else if (setmode == 1) {
				mode = "Dashing Web";
			}
		} else if (targetItem.getItem() == Art5019injusticeModItems.MIND_STONE.get()) {
			if (setmode == 0) {
				mode = "Mind Blocking";
			} else if (setmode == 1) {
				mode = "Mind Boost";
			} else if (setmode == 2) {
				mode = "Experience Enhancer";
			} else if (setmode == 3) {
				mode = "Love Inducer";
			} else if (setmode == 4) {
				mode = "Telekinectic Flight";
			} else {
				mode = "Mind Liberator";
			}
		} else if (targetItem.getItem() == Art5019injusticeModItems.LOKI_SCEPTER.get()) {
			if (setmode == 0) {
				mode = "Mind Weakener Attack";
			} else if (setmode == 1) {
				mode = "-Mode 2: Mind Strengthener Attack";
			}
		} else if (targetItem.getItem() == Art5019injusticeModItems.MEDICAL_KIT.get()) {
			if (setmode == 0) {
				mode = "Self-Nursing";
			} else if (setmode == 1) {
				mode = "Self-Surgery";
			}
		} else if (targetItem.getItem() == Art5019injusticeModItems.SPACE_STONE.get()) {
			if (setmode == 0) {
				mode = "Portal Opening";
			} else if (setmode == 1) {
				mode = "Negative Gravity Shift";
			} else if (setmode == 2) {
				mode = "High Gravity Shift";
			} else if (setmode == 3) {
				mode = "Personal Physics Distortion";
			} else if (setmode == 4) {
				mode = "Repulsive Punch";
			} else {
				mode = "Teleport";
			}
		} else if (targetItem.getItem() == Art5019injusticeModItems.SOUL_STONE.get()) {
			if (setmode == 0) {
				mode = "Soul Word Opener";
			} else if (setmode == 1) {
				mode = "Vital Suction";
			} else if (setmode == 2) {
				mode = "Soul Punch";
			} else if (setmode == 3) {
				mode = "Soul Healing";
			} else if (setmode == 4) {
				mode = "Ecologic Cycle Shifting: Flourishing";
			} else {
				mode = "Ecologic Cycle Shifting: Extinction";
			}
		}
		return "" + mode;
	}
}
