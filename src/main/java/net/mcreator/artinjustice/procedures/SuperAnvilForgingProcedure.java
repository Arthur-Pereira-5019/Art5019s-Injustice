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
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.init.Art5019injusticeModEnchantments;
import net.mcreator.artinjustice.Art5019injusticeMod;

public class SuperAnvilForgingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity toBeManipulated, ItemStack itemstack) {
		if (entity == null || toBeManipulated == null)
			return;
		ItemStack toBeCreated = ItemStack.EMPTY;
		ItemStack forged = ItemStack.EMPTY;
		ItemStack manipulatedItem = ItemStack.EMPTY;
		double realpower = 0;
		if (!(entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem()))) {
			realpower = itemstack.getEnchantmentLevel(Art5019injusticeModEnchantments.OGUM_BLESSING.get()) * 1.5 + ReturnStrengthProcedure.execute(entity);
			manipulatedItem = (toBeManipulated instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY);
			forged = SuperAnvilProcedure.execute(world, x, y, z, entity, manipulatedItem, realpower);
			if (!(forged.getItem() == ItemStack.EMPTY.getItem())) {
				if (!(itemstack.getItem() == ItemStack.EMPTY.getItem())) {
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(itemstack.getItem(), (int) (800 / (itemstack.getEnchantmentLevel(Art5019injusticeModEnchantments.HAPHAESTUS_BLESSING.get()) + 1)));
					{
						ItemStack _ist = itemstack;
						if (_ist.hurt((int) (itemstack.getMaxDamage() / 120 - 3 * realpower), RandomSource.create(), null)) {
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
				Art5019injusticeMod.queueServerWork(40, () -> {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.FLASH, x, y, z, 22, 1, 1, 1, 1);
				});
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.LAVA, x, y, z, (int) (10 * realpower), 0.1, 0.1, 0.1, 1);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, x, y, z, (int) (7 * realpower), 0.5, 0.5, 0.5, 0.4);
			}
		}
	}
}
