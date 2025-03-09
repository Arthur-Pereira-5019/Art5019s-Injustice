package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;

public class PowerDependenceEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		AttributeRetrieverProcedure.execute(entity);
	}
}
