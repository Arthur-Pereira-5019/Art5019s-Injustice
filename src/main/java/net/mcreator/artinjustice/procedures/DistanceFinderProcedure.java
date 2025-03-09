package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;

public class DistanceFinderProcedure {
	public static double execute(Entity first, Entity second) {
		if (first == null || second == null)
			return 0;
		return Math.sqrt(Math.pow(first.getX() - second.getX(), 2) + Math.pow(first.getY() - second.getY(), 2) + Math.pow(first.getZ() - second.getZ(), 2));
	}
}
