package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.entity.CriminalEntity;

public class CriminalDisplayCondition2Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof CriminalEntity _datEntI ? _datEntI.getEntityData().get(CriminalEntity.DATA_skin) : 0) == 1) {
			return true;
		}
		return false;
	}
}
