package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;

public class StarryOrchidRightClickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.SUPER_FERTILIZER.get()) {
			SuperFertilizerRightclickedOnBlockProcedure.execute(world, x, y, z, entity);
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.GLOW, x, y, z, 40, 0.3, 0.5, 0.3, 0.4);
	}
}
