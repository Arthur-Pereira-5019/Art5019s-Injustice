package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.TamableAnimal;

public class KryptoSittingProcedure {
public static boolean execute(Entity entity) {
	if (entity instanceof TamableAnimal _entity) { 
if (_entity.isInSittingPose() == true) {
return true;
}
}
return false;
}
}