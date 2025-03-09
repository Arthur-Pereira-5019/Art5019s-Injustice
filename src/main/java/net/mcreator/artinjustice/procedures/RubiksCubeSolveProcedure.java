package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.init.Art5019injusticeModBlocks;
import net.mcreator.artinjustice.Art5019injusticeMod;

public class RubiksCubeSolveProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:block.computer.writes")), SoundSource.PLAYERS, 1, (float) 0.5);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:block.computer.writes")), SoundSource.PLAYERS, 1, (float) 0.5, false);
			}
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("Solving..."), true);
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 1200);
		if (!world.isClientSide()) {
			Art5019injusticeMod.queueServerWork(270, () -> {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModBlocks.RUBIK_CUBE.get().asItem()) {
					if (Math.random() < 0.05 * ReturnDectetivePowerProcedure.execute(entity)) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.levelup")), SoundSource.PLAYERS, (float) 0.4, 0);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.levelup")), SoundSource.PLAYERS, (float) 0.4, 0, false);
							}
						}
						Art5019injusticeMod.queueServerWork(20, () -> {
							if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) < 10) {
								if (entity instanceof Player _player)
									_player.giveExperienceLevels(4);
							} else if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) < 20) {
								if (entity instanceof Player _player)
									_player.giveExperienceLevels(3);
							} else if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) < 30) {
								if (entity instanceof Player _player)
									_player.giveExperienceLevels(2);
							} else {
								if (entity instanceof Player _player)
									_player.giveExperienceLevels(1);
							}
						});
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7cFailed..."), true);
					}
				}
			});
		}
	}
}
