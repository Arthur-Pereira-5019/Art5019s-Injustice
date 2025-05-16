package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;

public class MassPunchProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double bulletres = 0;
		double dx = 0;
		double d = 0;
		double dy = 0;
		double dz = 0;
		double electricalcharge = 0;
		{
			double _setval = (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).masspunch - 3;
			sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.masspunch = _setval;
				capability.syncPlayerVariables(sourceentity);
			});
		}
		if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20, 4, true, false));
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, y, z, (float) (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).masspunch, Level.ExplosionInteraction.MOB);
		{
			double _setval = (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).masspunch * 600;
			sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.ability2cooldown = _setval;
				capability.syncPlayerVariables(sourceentity);
			});
		}
		{
			double _setval = (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).masspunch * 600;
			sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.ability2cooldown = _setval;
				capability.syncPlayerVariables(sourceentity);
			});
		}
		if (sourceentity instanceof Player _player)
			_player.getFoodData().setFoodLevel((int) ((sourceentity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0)
					- (sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).masspunch * 2));
		sourceentity.setSecondsOnFire((int) ((sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).masspunch * 4));
		AbilitySpeedsterUpdateProcedure.execute(world, x, y, z, entity);
		{
			double _setval = 0;
			sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.currentSpeed = _setval;
				capability.syncPlayerVariables(sourceentity);
			});
		}
		{
			double _setval = 0;
			sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.masspunch = _setval;
				capability.syncPlayerVariables(sourceentity);
			});
		}
		{
			Entity _ent = sourceentity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "attribute @s minecraft:generic.movement_speed modifier remove fe76b892-aa33-11ec-ae62-1b13846012fe");
			}
		}
		sourceentity.setMaxUpStep((float) 0.6);
	}
}
