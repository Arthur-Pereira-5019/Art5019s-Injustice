package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.entity.VenomBossEntity;

public class VenomBossThisEntityKillsAnotherOneProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof VenomBossEntity _datEntSetL)
			_datEntSetL.getEntityData().set(VenomBossEntity.DATA_alreadyDefeated, false);
	}
}
