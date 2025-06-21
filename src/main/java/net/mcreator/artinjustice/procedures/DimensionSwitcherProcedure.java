package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;

public class DimensionSwitcherProcedure {
	public static void execute(Entity entity, String dimensionname) {
		if (entity == null || dimensionname == null)
			return;
		if ((dimensionname).equals("art5019injustice:phantom_zone")) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.PHANTOM_ZONE_EFFECT.get(), 99999999, 1, false, false));
		} else if ((dimensionname).equals("overworld")) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(Art5019injusticeModMobEffects.PHANTOM_ZONE_EFFECT.get());
		}
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("execute in " + dimensionname + " run tp @s ~ ~ ~"));
			}
		}
	}
}
