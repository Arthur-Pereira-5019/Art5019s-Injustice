package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.entity.MetalloEntity;

public class Metallo6DisplayConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof MetalloEntity _datEntI ? _datEntI.getEntityData().get(MetalloEntity.DATA_part) : 0) == 6) {
			return true;
		}
		return false;
	}
}
