package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;

public class ReturnBlindEntitiesProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(MobEffects.BLINDNESS)) {
			return true;
		}
		return false;
	}
}
