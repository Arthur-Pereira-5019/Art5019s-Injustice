package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.entity.EyesMutantEntity;

public class EyesMutantDisplayConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_stats) : 0) == 4 && (entity instanceof EyesMutantEntity _datEntI ? _datEntI.getEntityData().get(EyesMutantEntity.DATA_type) : 0) == 1) {
			return true;
		}
		return false;
	}
}
