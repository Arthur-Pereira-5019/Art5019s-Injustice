package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class SpiderManTH2ChestplateTickEventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getBoolean("parachutes")) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (-1.1), (entity.getDeltaMovement().z())));
			entity.fallDistance = 0;
		}
		if (entity.getTicksFrozen() >= 1) {
			entity.setTicksFrozen((int) (entity.getTicksFrozen() - 0.5));
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMOKE, x, y, z, 1, 0.6, 1, 0.6, 0);
		}
	}
}
