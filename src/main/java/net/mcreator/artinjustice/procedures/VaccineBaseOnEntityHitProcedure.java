package net.mcreator.artinjustice.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;
import net.mcreator.artinjustice.init.Art5019injusticeModItems;

public class VaccineBaseOnEntityHitProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.IMMUNITY.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.IMMUNITY.get()).getDuration() : 0) < 36000
				&& entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(Art5019injusticeModMobEffects.IMMUNITY.get())) {
			if (sourceentity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(Art5019injusticeModItems.VACCINE_TYPE_I.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (sourceentity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.VACCINE_BASE.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
		} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.IMMUNITY_B.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.IMMUNITY_B.get()).getDuration() : 0) < 36000
				&& entity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(Art5019injusticeModMobEffects.IMMUNITY_B.get())) {
			if (sourceentity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(Art5019injusticeModItems.VACCINE_TYPE_II.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (sourceentity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.VACCINE_BASE.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
		} else if (entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(Art5019injusticeModMobEffects.IMMUNITY.get())) {
			if (sourceentity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(Art5019injusticeModItems.VACCINE_TYPE_I.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (sourceentity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.VACCINE_BASE.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
		} else if (entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(Art5019injusticeModMobEffects.IMMUNITY_B.get())) {
			if (sourceentity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(Art5019injusticeModItems.VACCINE_TYPE_II.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (sourceentity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.VACCINE_BASE.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
		}
	}
}
