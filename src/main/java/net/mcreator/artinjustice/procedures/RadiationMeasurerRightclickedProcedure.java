package net.mcreator.artinjustice.procedures;

import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.init.Art5019injusticeModBlocks;

import java.util.concurrent.atomic.AtomicReference;

public class RadiationMeasurerRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean found = false;
		double foundRadiation = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (!(entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem()))) {
			sx = -10;
			found = false;
			for (int index0 = 0; index0 < 20; index0++) {
				sy = -10;
				for (int index1 = 0; index1 < 20; index1++) {
					sz = -10;
					for (int index2 = 0; index2 < 20; index2++) {
						if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Art5019injusticeModBlocks.URANIUM_BLOCK.get()) {
							foundRadiation = foundRadiation + 0.24;
						} else if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Art5019injusticeModBlocks.TRANSMUTATION_TABLE.get()) {
							foundRadiation = ReturnItemRadiationPointsProcedure.execute(new Object() {
								public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
									AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
									BlockEntity _ent = world.getBlockEntity(pos);
									if (_ent != null)
										_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
									return _retval.get();
								}
							}.getItemStack(world, BlockPos.containing(x + sx, y + sy, z + sz), 0));
						}
						sz = sz + 1;
					}
					sy = sy + 1;
				}
				sx = sx + 1;
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((Math.round(foundRadiation) + " miliCuries")), false);
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 300);
		}
	}
}
