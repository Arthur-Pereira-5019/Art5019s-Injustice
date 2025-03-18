package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity;

public class KryptoTheSuperdogRightClickedOnEntityProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) == sourceentity) {
			if (entity instanceof TamableAnimal _entity) {
				if (_entity.isInSittingPose() == false) {
					_entity.setOrderedToSit(true);
					_entity.setInSittingPose(true);
				} else {
					_entity.setOrderedToSit(false);
					_entity.setInSittingPose(false);
				}
			}
		}
	}
}
