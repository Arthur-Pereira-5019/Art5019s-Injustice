package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.registries.Registries;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;

import java.util.ArrayList;

public class MonsterInfightingOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if (entityiterator instanceof Player) {
				if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
					if (((entityiterator.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).targetid)
							.equals((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getStringUUID()) || !((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Monster)) {
						entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 2);
						MonsterInfightingEffectStartedappliedProcedure.execute(world, x, y, z, entity);
					}
				} else {
					entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 2);
					MonsterInfightingEffectStartedappliedProcedure.execute(world, x, y, z, entity);
				}
			} else {
				if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof Monster)) {
					entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 2);
					MonsterInfightingEffectStartedappliedProcedure.execute(world, x, y, z, entity);
				}
			}
		}
	}
}
