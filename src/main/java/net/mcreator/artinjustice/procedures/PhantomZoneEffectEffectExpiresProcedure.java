package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;

public class PhantomZoneEffectEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		IndividualAttributeRemoverProcedure.execute(entity, 2, "58a79215-a927-4319-b366-345b213c4b1d ");
		NoGravityManagerProcedure.execute(entity);
	}
}
