package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;

public class ReturnStrengthProcedure {
	public static double execute(Entity entity) {
	if (entity instanceof LivingEntity _livEntity1) {
		return  _livEntity1.getAttributeValue(Attributes.ATTACK_DAMAGE);
	}else {
		return 0;
	}
}
}