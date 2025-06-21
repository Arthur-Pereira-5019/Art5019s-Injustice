package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicInteger;

public class CapacitorRightClickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double sent = 0;
		double maximumSend = 0;
		double available = 0;
		double willSend = 0;
		if (entity.isShiftKeyDown() && !(entity instanceof Player _plrCldCheck2 && _plrCldCheck2.getCooldowns().isOnCooldown(itemstack.getItem()))) {
			sent = new Object() {
				public int receiveEnergySimulate(LevelAccessor level, BlockPos pos, int _amount) {
					AtomicInteger _retval = new AtomicInteger(0);
					BlockEntity _ent = level.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
					return _retval.get();
				}
			}.receiveEnergySimulate(world, BlockPos.containing(x, y, z), (int) (itemstack.getOrCreateTag().getDouble("rf") / 10));
			if (sent > 0) {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 180);
				{
					BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
					int _amount = (int) sent;
					if (_ent != null)
						_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> capability.receiveEnergy(_amount, false));
				}
				itemstack.getOrCreateTag().putDouble("rf", (itemstack.getOrCreateTag().getDouble("rf") - sent));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:effect.short_shock")), SoundSource.PLAYERS, (float) 0.3, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:effect.short_shock")), SoundSource.PLAYERS, (float) 0.3, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.ELECTRIC_SPARK, x, y, z, 40, 0.5, 0.5, 0.5, 1);
			}
		}
	}
}
