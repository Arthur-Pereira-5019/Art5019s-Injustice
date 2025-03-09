package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;

public class MartinLiEntityIsHurtProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return false;
		double dy = 0;
		double newz = 0;
		double newy = 0;
		double newx = 0;
		boolean canskip = false;
		if (Art5019injusticeModVariables.MapVariables.get(world).event_meter < 1 && sourceentity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel
				&& _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:hidden_agenda"))).isDone() && Art5019injusticeModVariables.MapVariables.get(world).event_id == 2) {
			Art5019injusticeModVariables.MapVariables.get(world).event_meter = 1;
			Art5019injusticeModVariables.MapVariables.get(world).syncData(world);
			Art5019injusticeModVariables.MapVariables.get(world).today_news = 46;
			Art5019injusticeModVariables.MapVariables.get(world).syncData(world);
			if (!entity.level().isClientSide())
				entity.discard();
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.GLOW_SQUID_INK, x, y, z, 40, 1, 1, 1, 1);
		for (int index0 = 0; index0 < 3; index0++) {
			newx = entity.getX() + Mth.nextDouble(RandomSource.create(), -70, 70);
			newy = entity.getY() + Mth.nextDouble(RandomSource.create(), 8, 20);
			newz = entity.getZ() + Mth.nextDouble(RandomSource.create(), -70, 70);
			while (!canskip) {
				if (dy >= -20) {
					if (world.getBlockState(BlockPos.containing(newx, newy + dy, newz)).canOcclude()) {
						{
							Entity _ent = sourceentity;
							_ent.teleportTo(newx, (newy + dy + 1), newz);
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(newx, (newy + dy + 1), newz, _ent.getYRot(), _ent.getXRot());
						}
						canskip = true;
					}
				} else {
					canskip = true;
				}
				dy = dy - 1;
			}
		}
		if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 100, 9, false, false));
		return false;
	}
}
