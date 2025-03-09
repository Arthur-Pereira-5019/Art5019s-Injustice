package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.entity.KryptoTheSuperdogEntity;

public class NotHasCollarProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return !(entity instanceof KryptoTheSuperdogEntity _datEntL0 && _datEntL0.getEntityData().get(KryptoTheSuperdogEntity.DATA_hascollar));
	}
}
