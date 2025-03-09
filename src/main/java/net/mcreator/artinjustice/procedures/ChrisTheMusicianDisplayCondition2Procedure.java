package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.entity.ChrisTheMusicianEntity;

public class ChrisTheMusicianDisplayCondition2Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity instanceof ChrisTheMusicianEntity _datEntI ? _datEntI.getEntityData().get(ChrisTheMusicianEntity.DATA_quest) : 0) >= 2;
	}
}
