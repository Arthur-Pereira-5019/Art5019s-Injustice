package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.artinjustice.entity.MayParkerEntity;

public class MayParkerTaskManagementProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, double parsedalignment, double pc, double quest, double step) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof MayParkerEntity _datEntSetI)
			_datEntSetI.getEntityData().set(MayParkerEntity.DATA_step, (int) step);
		if (entity instanceof MayParkerEntity _datEntSetI)
			_datEntSetI.getEntityData().set(MayParkerEntity.DATA_quest, (int) quest);
		if (world instanceof ServerLevel _level)
			_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 20));
		AlignmentUpdateProcedure.execute(world, x, y, z, entity, sourceentity, parsedalignment);
		CriminalityRateChangeProcedure.execute(world, pc);
		if (sourceentity instanceof ServerPlayer _player) {
			Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:hope_beacon"));
			AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
			if (!_ap.isDone()) {
				for (String criteria : _ap.getRemainingCriteria())
					_player.getAdvancements().award(_adv, criteria);
			}
		}
	}
}
