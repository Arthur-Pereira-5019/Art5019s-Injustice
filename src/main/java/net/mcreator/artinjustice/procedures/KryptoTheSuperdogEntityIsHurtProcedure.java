package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.entity.KryptoTheSuperdogEntity;

public class KryptoTheSuperdogEntityIsHurtProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (275 > (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) && (entity instanceof KryptoTheSuperdogEntity _datEntL1 && _datEntL1.getEntityData().get(KryptoTheSuperdogEntity.DATA_hascollar)) == true) {
			if (entity instanceof KryptoTheSuperdogEntity _datEntSetL)
				_datEntSetL.getEntityData().set(KryptoTheSuperdogEntity.DATA_hascollar, false);
		}
	}
}
