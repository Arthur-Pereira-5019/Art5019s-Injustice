package net.mcreator.artinjustice.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.components.EditBox;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;

import java.util.List;
import java.util.HashMap;
import java.util.Comparator;

public class QuickTravelTeleportButtonProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		double bestHeight = 0;
		double tempHeight = 0;
		double maxTravelDistance = 0;
		double newX = 0;
		double newZ = 0;
		if (!((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 23)) {
			maxTravelDistance = (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).maxSpeed * 750;
			if (Math.abs(new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(guistate.containsKey("text:travelX") ? ((EditBox) guistate.get("text:travelX")).getValue() : "")) < maxTravelDistance && Math.abs(new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(guistate.containsKey("text:travelZ") ? ((EditBox) guistate.get("text:travelZ")).getValue() : "")) < maxTravelDistance) {
				newX = x + new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(guistate.containsKey("text:travelX") ? ((EditBox) guistate.get("text:travelX")).getValue() : "");
				newZ = z + new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(guistate.containsKey("text:travelZ") ? ((EditBox) guistate.get("text:travelZ")).getValue() : "");
				tempHeight = 100;
				while (!world.getBlockState(BlockPos.containing(newX, tempHeight, newZ)).canOcclude() && tempHeight > 40) {
					tempHeight = tempHeight - 1;
					if (world.getBlockState(BlockPos.containing(newX, tempHeight - 1, newZ)).canOcclude()) {
						bestHeight = tempHeight;
					}
				}
				tempHeight = 321;
				while (!world.getBlockState(BlockPos.containing(newX, tempHeight, newZ)).canOcclude() && tempHeight > -64) {
					tempHeight = tempHeight - 1;
					if (world.getBlockState(BlockPos.containing(newX, tempHeight - 1, newZ)).canOcclude()) {
						bestHeight = tempHeight;
					}
				}
				if (tempHeight < -62) {
					bestHeight = 62;
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.EXPLOSION, x, y, z, 30, 1, 1, 1, 1);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE, x, y, z, 30, 1, 1, 1, 1);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("intentionally_empty")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("intentionally_empty")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1.5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						{
							Entity _ent = entityiterator;
							_ent.teleportTo(newX, (bestHeight + 1), newZ);
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(newX, (bestHeight + 1), newZ, _ent.getYRot(), _ent.getXRot());
						}
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(newX, bestHeight + 1, newZ), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("intentionally_empty")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(newX, (bestHeight + 1), newZ, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("intentionally_empty")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (Math.abs(new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(guistate.containsKey("text:travelX") ? ((EditBox) guistate.get("text:travelX")).getValue() : "")) > 2000 || Math.abs(new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(guistate.containsKey("text:travelZ") ? ((EditBox) guistate.get("text:travelZ")).getValue() : "")) > 2000) {
					if (entity instanceof Player _player)
						_player.getFoodData().setFoodLevel((int) ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) - 16));
					{
						double _setval = 6000;
						entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ability3cooldown = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else {
					if (entity instanceof Player _player)
						_player.getFoodData().setFoodLevel((int) ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) - 8));
					{
						double _setval = 4000;
						entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ability3cooldown = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7dToo far!"), true);
			}
			if (entity instanceof Player _player)
				_player.closeContainer();
		} else {
			QuickTravelFlyButtonProcedure.execute(world, x, y, z, entity, new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(guistate.containsKey("text:travelX") ? ((EditBox) guistate.get("text:travelX")).getValue() : ""), new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(guistate.containsKey("text:travelZ") ? ((EditBox) guistate.get("text:travelZ")).getValue() : ""));
		}
	}
}
