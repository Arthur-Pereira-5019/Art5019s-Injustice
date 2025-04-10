package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class SuperAnvilForgingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity toBeManipulated, ItemStack itemstack, double power) {
		if (entity == null || toBeManipulated == null)
			return;
		ItemStack toBeCreated = ItemStack.EMPTY;
		ItemStack forged = ItemStack.EMPTY;
		ItemStack manipulatedItem = ItemStack.EMPTY;
		manipulatedItem = (toBeManipulated instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY);
		forged = SuperAnvilProcedure.execute(world, x, y, z, entity, manipulatedItem, power);
		if (!(forged.getItem() == ItemStack.EMPTY.getItem())) {
			if (!(itemstack.getItem() == ItemStack.EMPTY.getItem())) {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 800);
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt((int) (itemstack.getMaxDamage() / 120 - 3 * power), RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
			}
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, forged);
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
			if (manipulatedItem.getCount() > 1) {
				toBeCreated = manipulatedItem;
				toBeCreated.shrink(1);
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, toBeCreated);
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
			if (!toBeManipulated.level().isClientSide())
				toBeManipulated.discard();
		} else {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.hit")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.hit")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
	}
}
