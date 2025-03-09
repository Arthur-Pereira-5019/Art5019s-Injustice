package net.mcreator.artinjustice.procedures;

import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;

import java.util.function.Supplier;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;

public class ProduceSupremeSerumProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z, Entity entity, double ck) {
		if (entity == null)
			return 0;
		ItemStack serum = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			if ((new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					BlockEntity _ent = world.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
					return _retval.get();
				}
			}.getItemStack(world, BlockPos.containing(x, y, z), 10)).getItem() == Art5019injusticeModItems.FORMULA_SUPER_SOLDIER_SERUM.get()) {
				if (Math.random() < 0.7) {
					if (Math.random() < 0.35) {
						serum = new ItemStack(Art5019injusticeModItems.BIO_EVOLUTIVE_SERUM_BAD.get());
					} else {
						serum = new ItemStack(Art5019injusticeModItems.BIO_EVOLUTIVE_SERUM.get());
					}
				} else {
					if (Math.random() < 0.8) {
						serum = new ItemStack(Art5019injusticeModItems.BIO_EVOLUTIVE_SERUM_PERFECTED.get());
					} else {
						serum = new ItemStack(Art5019injusticeModItems.ADREN_V_3.get());
					}
				}
				if (ck >= 4) {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = serum.copy();
						_setstack.setCount((int) (new Object() {
							public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
								AtomicInteger _retval = new AtomicInteger(0);
								BlockEntity _ent = world.getBlockEntity(pos);
								if (_ent != null)
									_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
								return _retval.get();
							}
						}.getAmount(world, BlockPos.containing(x, y, z), 9) + 1));
						((Slot) _slots.get(9)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					return 1;
				}
			} else {
				if (Math.random() < 0.7) {
					if (Math.random() < 0.55) {
						serum = new ItemStack(Art5019injusticeModItems.BIO_EVOLUTIVE_SERUM_BAD.get());
					} else {
						serum = new ItemStack(Art5019injusticeModItems.BIO_EVOLUTIVE_SERUM.get());
					}
				} else {
					if (Math.random() < 0.6) {
						serum = new ItemStack(Art5019injusticeModItems.BIO_EVOLUTIVE_SERUM_PERFECTED.get());
					} else {
						serum = new ItemStack(Art5019injusticeModItems.ADREN_V_3.get());
					}
				}
				if (ck >= 5) {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = serum.copy();
						_setstack.setCount((int) (new Object() {
							public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
								AtomicInteger _retval = new AtomicInteger(0);
								BlockEntity _ent = world.getBlockEntity(pos);
								if (_ent != null)
									_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
								return _retval.get();
							}
						}.getAmount(world, BlockPos.containing(x, y, z), 9) + 1));
						((Slot) _slots.get(9)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
					return 1;
				}
			}
			return 2;
		}
		return 0;
	}
}
