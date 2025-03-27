package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;

public class Ability2pProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double remainingbreath = 0;
		if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).ability1_toggle && IsSymbioteWallCrawlerProcedure.execute(entity)) {
			WallCrawlingProcedure.execute(world, entity);
		}
		if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 17) {
			FireBreathSmallProcedure.execute(world, entity);
		}
		if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 18) {
			if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).ability1_toggle
					&& (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).ability2toggle) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 60, 1, false, false));
			}
		}
		if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(Art5019injusticeModMobEffects.POWER_DEPENDENCE.get()))) {
			if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 23) {
				if (!entity.isShiftKeyDown()) {
					if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).ability5duration >= 1) {
						if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl >= 3) {
							GenericSuperBreathProcedure.execute(world, entity, 2 + ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl - 2) / 3);
							if (entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(MobEffects.WATER_BREATHING)) {
								remainingbreath = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.WATER_BREATHING) ? _livEnt.getEffect(MobEffects.WATER_BREATHING).getDuration() : 0;
								if (entity instanceof LivingEntity _entity)
									_entity.removeEffect(MobEffects.WATER_BREATHING);
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, (int) (remainingbreath - 2), 0, false, false));
							} else {
								entity.setAirSupply((int) (entity.getAirSupply() - 7));
							}
						}
					} else {
						if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl >= 3) {
							GenericSuperBreathProcedure.execute(world, entity,
									1.5 + ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl - 3) / 4);
							if (entity instanceof LivingEntity _livEnt9 && _livEnt9.hasEffect(MobEffects.WATER_BREATHING)) {
								remainingbreath = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.WATER_BREATHING) ? _livEnt.getEffect(MobEffects.WATER_BREATHING).getDuration() : 0;
								if (entity instanceof LivingEntity _entity)
									_entity.removeEffect(MobEffects.WATER_BREATHING);
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, (int) (remainingbreath - 2), 0, false, false));
							} else {
								entity.setAirSupply((int) (entity.getAirSupply() - 7));
							}
						}
					}
				} else {
					if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).ability5duration >= 1) {
						GenericColdBreathProcedure.execute(world, entity, 2 + ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl - 3) / 3);
						if (entity instanceof LivingEntity _livEnt15 && _livEnt15.hasEffect(MobEffects.WATER_BREATHING)) {
							remainingbreath = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.WATER_BREATHING) ? _livEnt.getEffect(MobEffects.WATER_BREATHING).getDuration() : 0;
							if (entity instanceof LivingEntity _entity)
								_entity.removeEffect(MobEffects.WATER_BREATHING);
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, (int) (remainingbreath - 2), 0, false, false));
						} else {
							entity.setAirSupply((int) (entity.getAirSupply() - 11));
						}
					} else {
						if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl >= 4) {
							GenericColdBreathProcedure.execute(world, entity, 1.5 + ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl - 4) / 4);
							if (entity instanceof LivingEntity _livEnt21 && _livEnt21.hasEffect(MobEffects.WATER_BREATHING)) {
								remainingbreath = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.WATER_BREATHING) ? _livEnt.getEffect(MobEffects.WATER_BREATHING).getDuration() : 0;
								if (entity instanceof LivingEntity _entity)
									_entity.removeEffect(MobEffects.WATER_BREATHING);
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, (int) (remainingbreath - 2), 0, false, false));
							} else {
								entity.setAirSupply((int) (entity.getAirSupply() - 11));
							}
						}
					}
				}
			}
		}
	}
}
