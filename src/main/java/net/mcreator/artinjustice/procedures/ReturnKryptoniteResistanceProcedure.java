package net.mcreator.artinjustice.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;

public class ReturnKryptoniteResistanceProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		double kr = 0;
		if (entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel
				&& _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:st_superman_kryptonite_resistance_iv"))).isDone()) {
			return 4;
		} else if (entity instanceof ServerPlayer _plr1 && _plr1.level() instanceof ServerLevel
				&& _plr1.getAdvancements().getOrStartProgress(_plr1.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:st_superman_kryptonite_resistance_iii"))).isDone()) {
			return 3;
		} else if (entity instanceof ServerPlayer _plr2 && _plr2.level() instanceof ServerLevel
				&& _plr2.getAdvancements().getOrStartProgress(_plr2.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:st_superman_kryptonite_resistance_ii"))).isDone()) {
			return 2;
		} else if (entity instanceof ServerPlayer _plr3 && _plr3.level() instanceof ServerLevel
				&& _plr3.getAdvancements().getOrStartProgress(_plr3.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:st_superman_kryptonite_resistance"))).isDone()) {
			return 1;
		}
		return 0;
	}
}
