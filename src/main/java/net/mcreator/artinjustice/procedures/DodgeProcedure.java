package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;

public class DodgeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean canTeleport = false;
		double dx = 0;
		double dz = 0;
		double attempts = 0;
		if (!world.isClientSide()) {
			if ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) > 6) {
				if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).ability4cooldown == 0) {
					while (!canTeleport && attempts < 10) {
						dx = x + 3 * Mth.nextDouble(RandomSource.create(), -1, 1);
						dz = z + 3 * Mth.nextDouble(RandomSource.create(), -1, 1);
						if (!(world.getBlockState(BlockPos.containing(dx, y - 1, dz))).is(BlockTags.create(new ResourceLocation("forge:any_air")))
								&& (world.getBlockState(BlockPos.containing(dx, y + 1, dz))).is(BlockTags.create(new ResourceLocation("forge:any_air")))
								&& (world.getBlockState(BlockPos.containing(dx, y, dz))).is(BlockTags.create(new ResourceLocation("forge:any_air")))) {
							canTeleport = true;
						}
						attempts = attempts + 1;
						if ((world.getBlockState(BlockPos.containing(dx, y + 1, dz))).is(BlockTags.create(new ResourceLocation("forge:any_air")))
								&& (world.getBlockState(BlockPos.containing(dx, y, dz))).is(BlockTags.create(new ResourceLocation("forge:any_air")))) {
							{
								Entity _ent = entity;
								_ent.teleportTo(dx, y, dz);
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport(dx, y, dz, _ent.getYRot(), _ent.getXRot());
							}
						}
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10, 4, false, false));
						{
							double _setval = 20;
							entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ability4cooldown = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				} else {
					AbilityTeleportProcedure.execute(world, x, y, z, entity, (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).ability4cooldown, 4, 2);
					if (entity instanceof Player _player)
						_player.getFoodData().setFoodLevel((int) ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) - 1));
				}
			}
		}
	}
}
