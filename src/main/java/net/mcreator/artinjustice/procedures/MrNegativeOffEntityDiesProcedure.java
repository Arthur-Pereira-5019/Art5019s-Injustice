package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;

public class MrNegativeOffEntityDiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		CriminalityRateChangeProcedure.execute(world, -0.01);
		AlignmentUpdateProcedure.execute(world, x, y, z, entity, sourceentity, 20);
		Art5019injusticeModVariables.MapVariables.get(world).event_meter = 0;
		Art5019injusticeModVariables.MapVariables.get(world).syncData(world);
		Art5019injusticeModVariables.MapVariables.get(world).event_id = 0;
		Art5019injusticeModVariables.MapVariables.get(world).syncData(world);
		Art5019injusticeModVariables.MapVariables.get(world).today_news = 47;
		Art5019injusticeModVariables.MapVariables.get(world).syncData(world);
		if (world instanceof ServerLevel _level)
			_level.addFreshEntity(new ExperienceOrb(_level, x, y, z, 50));
		if (sourceentity instanceof ServerPlayer _player) {
			Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:the_heartofthe_matter"));
			AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
			if (!_ap.isDone()) {
				for (String criteria : _ap.getRemainingCriteria())
					_player.getAdvancements().award(_adv, criteria);
			}
		}
		GenerateBlockyParticlesProcedure.execute(world, x, entity.getY() + 1, z, "minecraft:redstone_block", "400", "1", "1", "1", "1");
	}
}
