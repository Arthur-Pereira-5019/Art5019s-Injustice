package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class BlackPantherSuitHelmetTickEventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.REVERSE_PORTAL, x, y, z, (int) (itemstack.getOrCreateTag().getDouble("kinecticenergy") / 4), 0.5, 1, 0.5, 0);
	}
}
