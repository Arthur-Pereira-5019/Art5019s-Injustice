package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class KryptoTheSuperdogOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		AttributeAdderProcedure.execute(entity, 1, "400", "KryptoHealt", "add", "150659fb-e716-4331-b040-f6d7e591ed97");
		if (entity instanceof LivingEntity _entity)
			_entity.setHealth(400);
	}
}
