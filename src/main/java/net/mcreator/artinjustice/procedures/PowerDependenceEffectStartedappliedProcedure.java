package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;

public class PowerDependenceEffectStartedappliedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		AttributeRemoverProcedure.execute(entity);
	}
}
