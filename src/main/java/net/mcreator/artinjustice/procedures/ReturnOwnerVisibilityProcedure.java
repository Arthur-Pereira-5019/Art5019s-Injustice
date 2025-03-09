package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;

public class ReturnOwnerVisibilityProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if (entity.isInvisible() || entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(MobEffects.INVISIBILITY)) {
			return 1;
		}
		return 0;
	}
}
