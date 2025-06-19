package net.mcreator.artinjustice.procedures;

import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicInteger;

public class CopperCapacitorRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double sent = 0;
		double maximumSend = 0;
		double available = 0;
		if (entity.isShiftKeyDown() && !(entity instanceof Player _plrCldCheck2 && _plrCldCheck2.getCooldowns().isOnCooldown(itemstack.getItem()))) {
			maximumSend = itemstack.getOrCreateTag().getDouble("rf") / 10;
			available = new Object() {
				public int getMaxEnergyStored(LevelAccessor level, BlockPos pos) {
					AtomicInteger _retval = new AtomicInteger(0);
					BlockEntity _ent = level.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> _retval.set(capability.getMaxEnergyStored()));
					return _retval.get();
				}
			}.getMaxEnergyStored(world, BlockPos.containing(x, y, z)) - new Object() {
				public int getEnergyStored(LevelAccessor level, BlockPos pos) {
					AtomicInteger _retval = new AtomicInteger(0);
					BlockEntity _ent = level.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
					return _retval.get();
				}
			}.getEnergyStored(world, BlockPos.containing(x, y, z));
			if (available >= maximumSend) {
				sent = maximumSend;
			} else {
				sent = available;
			}
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
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7cThis block can't receive any energy"), true);
			}
		}
	}
}
