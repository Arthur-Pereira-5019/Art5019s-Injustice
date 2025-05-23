package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModItems;

public class BatmanNomex4ChestplateTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		ItemStack data = ItemStack.EMPTY;
		data = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY);
		if (!entity.isSprinting()) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(2, new ItemStack(Art5019injusticeModItems.BATMAN_NOMEX_3_CHESTPLATE.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Art5019injusticeModItems.BATMAN_NOMEX_3_CHESTPLATE.get()));
				}
			}
			{
				CompoundTag _nbtTag = data.getTag();
				if (_nbtTag != null)
					(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).setTag(_nbtTag.copy());
			}
		} else if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).runningt >= 90) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(2, new ItemStack(Art5019injusticeModItems.BATMAN_NOMEX_5_CHESTPLATE.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Art5019injusticeModItems.BATMAN_NOMEX_5_CHESTPLATE.get()));
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
