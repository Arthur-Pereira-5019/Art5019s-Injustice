package net.mcreator.artinjustice.procedures;

import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicInteger;

public class ReturnBlockChargePercentageProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		String colorcode = "";
		double percentage = 0;
		double dividend = 0;
		double divisor = 0;
		dividend = new Object() {
			public int getEnergyStored(LevelAccessor level, BlockPos pos) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
				return _retval.get();
			}
		}.getEnergyStored(world, BlockPos.containing(x, y, z));
		divisor = new Object() {
			public int getMaxEnergyStored(LevelAccessor level, BlockPos pos) {
				AtomicInteger _retval = new AtomicInteger(0);
				BlockEntity _ent = level.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> _retval.set(capability.getMaxEnergyStored()));
				return _retval.get();
			}
		}.getMaxEnergyStored(world, BlockPos.containing(x, y, z));
		percentage = (dividend / divisor) * 100;
		colorcode = "\u00A72";
		if (percentage < 33) {
			colorcode = "\u00A74";
		} else if (percentage < 66) {
			colorcode = "\u00A76";
		}
		return colorcode + "" + Math.round(percentage) + "%";
	}
}
