package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.entity.DeathstrokeEntity;

public class CanDeathstrokeAttackProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof DeathstrokeEntity _datEntI ? _datEntI.getEntityData().get(DeathstrokeEntity.DATA_blockcycle) : 0) >= 4) {
			return false;
		}
		return true;
	}
}
