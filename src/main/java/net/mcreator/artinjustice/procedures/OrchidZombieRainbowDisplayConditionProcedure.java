package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.entity.OrchidZombieEntity;

public class OrchidZombieRainbowDisplayConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof OrchidZombieEntity _datEntI ? _datEntI.getEntityData().get(OrchidZombieEntity.DATA_orchidcolor) : 0) == 7) {
			return true;
		}
		return false;
	}
}
