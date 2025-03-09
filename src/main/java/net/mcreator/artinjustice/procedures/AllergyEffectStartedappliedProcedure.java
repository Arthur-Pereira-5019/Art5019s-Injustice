package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;
import net.mcreator.artinjustice.Art5019injusticeMod;

public class AllergyEffectStartedappliedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).toxicRes > (entity instanceof LivingEntity _livEnt
				&& _livEnt.hasEffect(Art5019injusticeModMobEffects.ALLERGY.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.ALLERGY.get()).getAmplifier() : 0)) {
			Art5019injusticeMod.queueServerWork(2, () -> {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(Art5019injusticeModMobEffects.ALLERGY.get());
			});
		} else {
			if (0 == (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.ALLERGY.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.ALLERGY.get()).getAmplifier() : 0)) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A7c" + Component.translatable("line.allergy.scratch").getString())), true);
			}
		}
	}
}
