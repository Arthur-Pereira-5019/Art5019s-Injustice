package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;

public class RageOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double amplifier) {
		if (entity == null)
			return;
		if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).ability3duration > amplifier + 2) {
			Ability3DurationProcedure.execute(world, x, y, z, entity);
			{
				double _setval = (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).ability3duration - (1 * amplifier + 1);
				entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ability3duration = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).ability4duration > amplifier + 2) {
			Ability4DurationProcedure.execute(world, x, y, z, entity);
			{
				double _setval = (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).ability4duration - (1 * amplifier + 1);
				entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ability4duration = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).ability5duration > amplifier + 2) {
			Ability5DurationProcedure.execute(world, x, y, z, entity);
			{
				double _setval = (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).ability5duration - (1 * amplifier + 1);
				entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ability5duration = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).ability1cooldown > amplifier + 2) {
			{
				double _setval = (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).ability1cooldown - (1 * amplifier + 1);
				entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ability1cooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).ability2cooldown > amplifier + 2) {
			{
				double _setval = (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).ability2cooldown - (1 * amplifier + 1);
				entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ability2cooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).ability3cooldown > amplifier + 2) {
			{
				double _setval = (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).ability3cooldown - (1 * amplifier + 1);
				entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ability3cooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).ability4cooldown > amplifier + 2) {
			{
				double _setval = (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).ability4cooldown - (1 * amplifier + 1);
				entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ability4cooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).ability5cooldown > amplifier + 2) {
			{
				double _setval = (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).ability5cooldown - (1 * amplifier + 1);
				entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ability5cooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).ability6cooldown > amplifier + 2) {
			{
				double _setval = (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).ability6cooldown - (1 * amplifier + 1);
				entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ability6cooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			Ability6pProcedure.execute(world, x, y, z, entity);
		}
		if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 4) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SOUL, x, y, z, 1, 1, 1, 1, 1);
		} else if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 23) {
			if (!world.isClientSide()) {
				if (Math.random() < 0.005 / (ReturnKryptoniteResistanceProcedure.execute(entity) + 1)) {
					if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerlvl >= 3) {
						{
							boolean _setval = true;
							entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ability4holding = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:entity.generic.laser")), SoundSource.PLAYERS, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:entity.generic.laser")), SoundSource.PLAYERS, 1, 1, false);
							}
						}
					}
				}
			}
		}
	}
}
