package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.artinjustice.Art5019injusticeMod;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SuperpowerSetProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		ResetProcedure.execute(world, entity);
		Art5019injusticeMod.queueServerWork(2, () -> {
			if (DoubleArgumentType.getDouble(arguments, "powerId") == 0) {
				ResetProcedure.execute(world, entity);
			} else if (DoubleArgumentType.getDouble(arguments, "powerId") == 1) {
				BecomeSpiderManProcedure.execute(entity);
			} else if (DoubleArgumentType.getDouble(arguments, "powerId") == 3) {
				BecomeBlueBeetleProcedure.execute(entity);
			} else if (DoubleArgumentType.getDouble(arguments, "powerId") == 4) {
				BecomeScarecrowProcedure.execute(entity);
			} else if (DoubleArgumentType.getDouble(arguments, "powerId") == 5) {
				BecomeBlueBeetleDgProcedure.execute(entity);
			} else if (DoubleArgumentType.getDouble(arguments, "powerId") == 6) {
				BecomeCaptainAmericaProcedure.execute(entity);
			} else if (DoubleArgumentType.getDouble(arguments, "powerId") == 7) {
				BecomeDeadpoolProcedure.execute(entity);
			} else if (DoubleArgumentType.getDouble(arguments, "powerId") == 8) {
				BecomeQuicksilverProcedure.execute(entity);
			} else if (DoubleArgumentType.getDouble(arguments, "powerId") == 9) {
				BecomeDominoProcedure.execute(entity);
			} else if (DoubleArgumentType.getDouble(arguments, "powerId") == 10) {
				BecomeIronSoldierProcedure.execute(entity);
			} else if (DoubleArgumentType.getDouble(arguments, "powerId") == 11) {
				BecomeBlackPantherProcedure.execute(entity);
			} else if (DoubleArgumentType.getDouble(arguments, "powerId") == 12) {
				BecomeSpiderManProcedure.execute(entity);
				Art5019injusticeMod.queueServerWork(2, () -> {
					BecomeVenomizedSpiderProcedure.execute(entity);
				});
			} else if (DoubleArgumentType.getDouble(arguments, "powerId") == 13) {
				BecomeNeuroProcedure.execute(entity);
			} else if (DoubleArgumentType.getDouble(arguments, "powerId") == 14) {
				BecomeAtlanteanProcedure.execute(entity);
			} else if (DoubleArgumentType.getDouble(arguments, "powerId") == 15) {
				BecomeStormProcedure.execute(entity);
			} else if (DoubleArgumentType.getDouble(arguments, "powerId") == 16) {
				BecomeMathiasProcedure.execute(entity);
			} else if (DoubleArgumentType.getDouble(arguments, "powerId") == 17) {
				BecomeSupremeProcedure.execute(entity);
			} else if (DoubleArgumentType.getDouble(arguments, "powerId") == 18) {
				BecomeTranslucentProcedure.execute(entity);
			} else if (DoubleArgumentType.getDouble(arguments, "powerId") == 19) {
				BecomeVenomProcedure.execute(entity);
			} else if (DoubleArgumentType.getDouble(arguments, "powerId") == 20) {
				BecomeHomelanderProcedure.execute(entity);
			} else if (DoubleArgumentType.getDouble(arguments, "powerId") == 21) {
				BecomeDefaultSuperProcedure.execute(entity);
			} else if (DoubleArgumentType.getDouble(arguments, "powerId") == 22) {
				BecomePoisonIvyProcedure.execute(entity);
			} else if (DoubleArgumentType.getDouble(arguments, "powerId") == 23) {
				BecomeKryptonianProcedure.execute(entity);
			} else if (DoubleArgumentType.getDouble(arguments, "powerId") == 24) {
				BecomePSTVenomProcedure.execute(entity);
			} else if (DoubleArgumentType.getDouble(arguments, "powerId") == 25) {
				BecomeAntiVenomProcedure.execute(entity);
			} else if (DoubleArgumentType.getDouble(arguments, "powerId") == 69) {
				BecomeGodProcedure.execute(entity);
			}
		});
	}
}
