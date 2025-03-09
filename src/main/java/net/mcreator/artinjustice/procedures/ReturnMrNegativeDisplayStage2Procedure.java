package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.entity.MrNegativeEntity;

public class ReturnMrNegativeDisplayStage2Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof MrNegativeEntity _datEntI ? _datEntI.getEntityData().get(MrNegativeEntity.DATA_stage) : 0) > 2 && !entity.isInvisible()) {
			return true;
		}
		return false;
	}
}
