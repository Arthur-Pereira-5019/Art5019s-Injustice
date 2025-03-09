package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;

public class ArmorCapeTestChestplateTickEventProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		ItemStack data = ItemStack.EMPTY;
		data = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY);
		if (entity.isOnFire()) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(2, new ItemStack(Art5019injusticeModItems.ARMOR_CAPE_TEST_2_CHESTPLATE.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Art5019injusticeModItems.ARMOR_CAPE_TEST_2_CHESTPLATE.get()));
				}
			}
			{
				CompoundTag _nbtTag = data.getTag();
				if (_nbtTag != null)
					(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).setTag(_nbtTag.copy());
			}
		}
	}
}
