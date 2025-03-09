package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.artinjustice.init.Art5019injusticeModEntities;
import net.mcreator.artinjustice.Art5019injusticeMod;

import java.util.List;
import java.util.Comparator;

public class CellphoneCallToHelpCenterProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double probs = 0;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:item.cellphone.call")), SoundSource.NEUTRAL, (float) 0.5, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:item.cellphone.call")), SoundSource.NEUTRAL, (float) 0.5, 1, false);
			}
		}
		probs = Math.random();
		if (probs < 0.04) {
			Art5019injusticeMod.queueServerWork(260, () -> {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<Unknown Voice> Sending Help..."), false);
				Art5019injusticeMod.queueServerWork(20, () -> {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Second Unknown Voice> Wait, wait, wait! Where is this soldier calling from?"), false);
				});
				Art5019injusticeMod.queueServerWork(55, () -> {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Second Unknown Voice> Nearby the north target?"), false);
				});
				Art5019injusticeMod.queueServerWork(90, () -> {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Unknown Voice> Ok, I was suposed to go on that mission with them this morning, but the supriments..."), false);
				});
				Art5019injusticeMod.queueServerWork(150, () -> {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Red Skull> Shut up Ashley! It's a private call, no one will report us. Anyway, I'm two hundred kilometers away. See you in two seconds."), false);
				});
				Art5019injusticeMod.queueServerWork(190, () -> {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:earth_x_wrong_call"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				});
				Art5019injusticeMod.queueServerWork(240, () -> {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = Art5019injusticeModEntities.BLIETZ_KRIEG.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
						}
					}
				});
			});
		} else if (probs < 0.8) {
			Art5019injusticeMod.queueServerWork(260, () -> {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<Unknown Voice> Sending Help..."), false);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:item.airplane")), SoundSource.NEUTRAL, (float) 0.6, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:item.airplane")), SoundSource.NEUTRAL, (float) 0.6, 1, false);
					}
				}
				Art5019injusticeMod.queueServerWork(200, () -> {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 20), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"loot spawn ~ ~ ~ loot art5019injustice:gameplay/supply_crate_loot");
				});
			});
		} else {
			Art5019injusticeMod.queueServerWork(200, () -> {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<Unknown Voice> Sending Help..."), false);
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.PILLAGER.spawn(_level, BlockPos.containing(x, y + 10, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
					}
				}
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.VINDICATOR.spawn(_level, BlockPos.containing(x, y + 17, z - 3), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
					}
				}
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.PILLAGER.spawn(_level, BlockPos.containing(x + 4, y + 13, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
					}
				}
				{
					final Vec3 _center = new Vec3(x, (y + 14), z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof LivingEntity _livEnt24 && _livEnt24.getMobType() == MobType.ILLAGER) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 200, 0, false, false));
						}
					}
				}
			});
		}
	}
}
