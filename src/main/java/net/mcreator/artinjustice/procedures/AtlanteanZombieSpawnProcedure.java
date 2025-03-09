package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;

public class AtlanteanZombieSpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < 0.3) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(0, new ItemStack(Art5019injusticeModItems.ATLANTEAN_ARMOR_BOOTS.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Art5019injusticeModItems.ATLANTEAN_ARMOR_BOOTS.get()));
				}
			}
			if (Math.random() < 0.3) {
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(0, (EnchantmentHelper.enchantItem(RandomSource.create(), new ItemStack(Art5019injusticeModItems.ATLANTEAN_ARMOR_BOOTS.get()), 10, false)));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.FEET, (EnchantmentHelper.enchantItem(RandomSource.create(), new ItemStack(Art5019injusticeModItems.ATLANTEAN_ARMOR_BOOTS.get()), 10, false)));
					}
				}
			}
		}
		if (Math.random() < 0.3) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(1, new ItemStack(Art5019injusticeModItems.ATLANTEAN_ARMOR_LEGGINGS.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Art5019injusticeModItems.ATLANTEAN_ARMOR_LEGGINGS.get()));
				}
			}
			if (Math.random() < 0.3) {
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(1, (EnchantmentHelper.enchantItem(RandomSource.create(), new ItemStack(Art5019injusticeModItems.ATLANTEAN_ARMOR_LEGGINGS.get()), 10, false)));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.LEGS, (EnchantmentHelper.enchantItem(RandomSource.create(), new ItemStack(Art5019injusticeModItems.ATLANTEAN_ARMOR_LEGGINGS.get()), 10, false)));
					}
				}
			}
		}
		if (Math.random() < 0.3) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(2, new ItemStack(Art5019injusticeModItems.ATLANTEAN_ARMOR_CHESTPLATE.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Art5019injusticeModItems.ATLANTEAN_ARMOR_CHESTPLATE.get()));
				}
			}
			if (Math.random() < 0.3) {
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(2, (EnchantmentHelper.enchantItem(RandomSource.create(), new ItemStack(Art5019injusticeModItems.ATLANTEAN_ARMOR_CHESTPLATE.get()), 10, false)));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.CHEST, (EnchantmentHelper.enchantItem(RandomSource.create(), new ItemStack(Art5019injusticeModItems.ATLANTEAN_ARMOR_CHESTPLATE.get()), 10, false)));
					}
				}
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "attribute @s forge:swim_speed base set 7");
			}
		}
		if (Math.random() < 0.5) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "attribute @s forge:swim_speed base set 8");
				}
			}
			if (Math.random() < 0.3) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "attribute @s forge:swim_speed base set 9");
					}
				}
			}
		}
	}
}
