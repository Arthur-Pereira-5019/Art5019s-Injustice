package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;

public class ScarecrowIThisEntityKillsAnotherOneProcedure {
	public static void execute(Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (!sourceentity.level().isClientSide())
			sourceentity.discard();
	}
}
