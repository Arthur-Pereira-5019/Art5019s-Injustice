package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.init.Art5019injusticeModEntities;
import net.mcreator.artinjustice.entity.AtlanteanZombieEntity;

public class ReturnModelTest5Procedure {
	public static Entity execute(LevelAccessor world) {
		Entity entitya = null;
		entitya = world instanceof Level _level ? new AtlanteanZombieEntity(Art5019injusticeModEntities.ATLANTEAN_ZOMBIE.get(), _level) : null;
		return entitya;
	}
}
