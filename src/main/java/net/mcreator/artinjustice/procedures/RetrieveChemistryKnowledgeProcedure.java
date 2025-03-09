package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;

public class RetrieveChemistryKnowledgeProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		double tempck = 0;
		if (entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:spider_science"))).isDone()
				|| (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 13
				|| (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 17) {
			tempck = 2;
		}
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.CHEMISTRY_KNOWLEDGE.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.CHEMISTRY_KNOWLEDGE.get()).getAmplifier() : 0) + 1 > tempck) {
			tempck = (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.CHEMISTRY_KNOWLEDGE.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.CHEMISTRY_KNOWLEDGE.get()).getAmplifier() : 0) + 1;
		}
		return tempck;
	}
}
