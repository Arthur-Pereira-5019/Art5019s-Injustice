package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;
import net.mcreator.artinjustice.entity.TaskMasterEntity;

public class IfIsNotSelfProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof TaskMasterEntity) && !((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Creeper)) {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Player) {
				if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(Art5019injusticeModMobEffects.HERO_ENEMY.get())
						|| ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new Art5019injusticeModVariables.PlayerVariables())).alignment < 0) {
					return true;
				} else {
					return false;
				}
			} else {
				return true;
			}
		}
		return false;
	}
}
