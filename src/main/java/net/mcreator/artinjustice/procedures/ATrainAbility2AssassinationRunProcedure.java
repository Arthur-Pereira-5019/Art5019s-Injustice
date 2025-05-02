package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;

import java.util.List;
import java.util.Comparator;

public class ATrainAbility2AssassinationRunProcedure {
	public static void execute(LevelAccessor world, double y, Entity entity) {
		if (entity == null)
			return;
		{
			final Vec3 _center = new Vec3(
					(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()), y,
					(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator == entity)) {
					{
						Entity _ent = entityiterator;
						_ent.teleportTo((entity.level().clip(new ClipContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(
										entity.getViewVector(1f).scale((1.5 + 0.2 * (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).currentSpeed))),
								ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()), y,
								(entity.level()
										.clip(new ClipContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f)
														.add(entity.getViewVector(1f)
																.scale((1.5 + 0.2 * (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).currentSpeed))),
												ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
										.getBlockPos().getZ()));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection
									.teleport(
											(entity.level()
													.clip(new ClipContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getViewVector(1f)
																	.scale((1.5 + 0.2 * (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).currentSpeed))),
															ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
													.getBlockPos().getX()),
											y,
											(entity.level()
													.clip(new ClipContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getViewVector(1f)
																	.scale((1.5 + 0.2 * (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).currentSpeed))),
															ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
													.getBlockPos().getZ()),
											_ent.getYRot(), _ent.getXRot());
					}
					if (!world.isClientSide()) {
						if (Math.random() < 0.2) {
							if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("art5019injustice:not_has_blood")))) {
								entityiterator.hurt(
										new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("art5019injustice:bleeding_damage"))), entity),
										2);
							}
						}
					}
				}
			}
		}
	}
}
