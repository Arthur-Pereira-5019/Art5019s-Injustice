package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;

public class SupermanSmashItemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		String firstblocky = "";
		String secondblocky = "";
		if (!world.isClientSide()) {
			if (itemstack.getItem() == Items.NAUTILUS_SHELL) {
				if (entity instanceof Player _player)
					_player.giveExperiencePoints(15);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.turtle.egg_crack")), SoundSource.PLAYERS, (float) 0.65, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.turtle.egg_crack")), SoundSource.PLAYERS, (float) 0.65, 1, false);
					}
				}
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = itemstack;
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(Art5019injusticeModItems.SUPERSONIC_WHISTLE.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				firstblocky = "red_terracota";
				secondblocky = "white_terracota";
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.EXPLOSION)), 4);
			} else if (itemstack.getItem() == Blocks.COAL_BLOCK.asItem() && entity.isInLava()) {
				if (entity instanceof Player _player)
					_player.giveExperiencePoints(10);
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = itemstack;
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.PLAYERS, 1, (float) 0.5);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.PLAYERS, 1, (float) 0.5, false);
					}
				}
				firstblocky = "coal_block";
				secondblocky = "coal_block";
				if (Math.random() < 0.1) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(Items.DIAMOND).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					secondblocky = "diamond_block";
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.levelup")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.levelup")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.FLASH, x, y, z, 10, 1, 1, 1, 1);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.EXPLOSION_EMITTER, x, y, z, 10, 1, 1, 1, 1);
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.EXPLOSION)), 4);
			} else if (itemstack.getItem() == Blocks.QUARTZ_BLOCK.asItem() && entity.isInLava()) {
				if (entity instanceof Player _player)
					_player.giveExperiencePoints(2);
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = itemstack;
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.PLAYERS, 1, (float) 0.5);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.PLAYERS, 1, (float) 0.5, false);
					}
				}
				firstblocky = "quartz_block";
				secondblocky = "quartz_block";
				if (Math.random() < 0.95) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(Items.AMETHYST_SHARD).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					secondblocky = "amethyst_block";
				} else {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.amethyst_block.resonate")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.amethyst_block.resonate")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
					if (Math.random() < 0.95) {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(Blocks.AMETHYST_BLOCK).copy();
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
						secondblocky = "amethyst_block";
					} else {
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(Blocks.BUDDING_AMETHYST).copy();
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
						secondblocky = "amethyst_block";
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, (y + 1.65), z, 100, 1, 1, 1, 1);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ui.toast.challenge_complete")), SoundSource.PLAYERS, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ui.toast.challenge_complete")), SoundSource.PLAYERS, 1, 1, false);
							}
						}
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.FLASH, x, y, z, 10, 1, 1, 1, 1);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.EXPLOSION_EMITTER, x, y, z, 10, 1, 1, 1, 1);
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.EXPLOSION)), 4);
			}
		}
		GenerateBlockyParticlesProcedure.execute(world, x, y + 1.65, z, firstblocky, "80", "0.5", "0.5", "0.5", "0.7");
		GenerateBlockyParticlesProcedure.execute(world, x, y + 1.65, z, secondblocky, "80", "0.5", "0.5", "0.5", "0.7");
	}
}
