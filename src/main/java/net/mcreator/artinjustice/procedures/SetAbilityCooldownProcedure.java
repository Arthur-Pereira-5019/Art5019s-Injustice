package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SetAbilityCooldownProcedure {
	public static String execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return "";
		if (1 == DoubleArgumentType.getDouble(arguments, "keyId")) {
			{
				double _setval = DoubleArgumentType.getDouble(arguments, "cooldown");
				entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ability1cooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (2 == DoubleArgumentType.getDouble(arguments, "keyId")) {
			{
				double _setval = DoubleArgumentType.getDouble(arguments, "cooldown");
				entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ability2cooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (3 == DoubleArgumentType.getDouble(arguments, "keyId")) {
			{
				double _setval = DoubleArgumentType.getDouble(arguments, "cooldown");
				entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ability3cooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (4 == DoubleArgumentType.getDouble(arguments, "keyId")) {
			{
				double _setval = DoubleArgumentType.getDouble(arguments, "cooldown");
				entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ability4cooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (5 == DoubleArgumentType.getDouble(arguments, "keyId")) {
			{
				double _setval = DoubleArgumentType.getDouble(arguments, "cooldown");
				entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ability5cooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		return "Successfully changed power " + DoubleArgumentType.getDouble(arguments, "keyId") + " cooldown to " + DoubleArgumentType.getDouble(arguments, "cooldown");
	}
}
