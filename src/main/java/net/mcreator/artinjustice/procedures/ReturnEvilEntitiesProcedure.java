package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class ReturnEvilEntitiesProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("art5019injustice:evil_mobs")))) {
			return true;
		}
		return false;
	}
}
