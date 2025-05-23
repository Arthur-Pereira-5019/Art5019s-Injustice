package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;

public class SuperAnvilBladeForgingProcedure {
	public static ItemStack execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack toBeChanged, double power) {
		if (entity == null)
			return ItemStack.EMPTY;
		ItemStack result = ItemStack.EMPTY;
		result = ItemStack.EMPTY;
		if (power > 9) {
			if (toBeChanged.getItem() == Art5019injusticeModItems.DWARF_STAR.get()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.FLAME, x, y, z, 100, 0.1, 0.1, 0.1, 1);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.FLASH, x, y, z, 1200, 6, 6, 6, 1);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.EFFECT, x, y, z, 400, 4, 4, 4, 1);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.GLOW_SQUID_INK, x, y, z, 400, 4, 4, 4, 1);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.spawn")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.spawn")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:cosmic_forger"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
				result = new ItemStack(Art5019injusticeModItems.ACTIVATED_DWARF_STAR.get());
			}
		}
		if (power > 2) {
			if (toBeChanged.getItem() == Items.IRON_INGOT) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.land")), SoundSource.BLOCKS, 1, (float) 1.4);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.land")), SoundSource.BLOCKS, 1, (float) 1.4, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.LAVA, x, y, z, 100, 0.1, 0.1, 0.1, 1);
				if (!world.isClientSide()) {
					if (Math.random() < 0.4) {
						result = new ItemStack(Art5019injusticeModItems.IRON_BLADE.get());
						result.setCount(2);
						if (Math.random() < 0.2) {
							result.setCount(3);
						}
					} else {
						result = new ItemStack(Items.IRON_NUGGET);
						result.setCount(8);
						if (Math.random() < 0.7) {
							result.setCount(9);
						}
					}
				}
			}
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.use")), SoundSource.BLOCKS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.use")), SoundSource.BLOCKS, 1, 1, false);
			}
		}
		return result;
	}
}
