package net.mcreator.artinjustice.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;

public class RadioactiveTransmutationProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack, double slot) {
		ItemStack next = ItemStack.EMPTY;
		if (itemstack.getItem() == Art5019injusticeModItems.KRYPTONITE.get()) {
			next = new ItemStack(Art5019injusticeModItems.RED_KRYPTONITE.get());
		} else if (itemstack.getItem() == Art5019injusticeModItems.RAOLITE.get()) {
			next = new ItemStack(Art5019injusticeModItems.KRYPTONITE.get());
		} else if (itemstack.getItem() == Art5019injusticeModItems.RED_KRYPTONITE.get()) {
			next = new ItemStack(Art5019injusticeModItems.GOLDEN_KRYPTONITE.get());
		}
		{
			BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
			if (_ent != null) {
				final int _slotid = (int) slot;
				final ItemStack _setstack = next.copy();
				_setstack.setCount(1);
				_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable)
						((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
				});
			}
		}
	}
}
