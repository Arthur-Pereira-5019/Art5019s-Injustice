package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;

public class BlackMantaArmorHelmetTickEventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double Scaling = 0;
		if (itemstack.getOrCreateTag().getBoolean("lasering")) {
			if (entity.isShiftKeyDown()) {
				GenericConcussiveLaserProcedure.execute(world, x, y, z, entity, 4);
				if (Math.random() < 0.03) {
					{
						ItemStack _ist = itemstack;
						if (_ist.hurt(1, RandomSource.create(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
				}
			} else {
				GenericLaserProcedure.execute(world, x, y, z, entity, 4);
				if (Math.random() < 0.01) {
					{
						ItemStack _ist = itemstack;
						if (_ist.hurt(1, RandomSource.create(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
				}
			}
		}
	}
}
