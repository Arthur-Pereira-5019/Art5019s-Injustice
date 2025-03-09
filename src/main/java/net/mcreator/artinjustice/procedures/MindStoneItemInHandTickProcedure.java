package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;

public class MindStoneItemInHandTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getDouble("cadency") >= 1) {
			itemstack.getOrCreateTag().putDouble("cadency", (itemstack.getOrCreateTag().getDouble("cadency") - 1));
		}
		if (entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(Art5019injusticeModMobEffects.ATTACK_INABILITY.get())) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(Art5019injusticeModMobEffects.ATTACK_INABILITY.get());
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("art5019injustice:radiation_damage")))), 3);
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"particle dust 1.000 0.933 0.000 1 ~ ~1 ~ 0.6 0.6 0.6 1 2 normal");
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		} else if (entity instanceof LivingEntity _livEnt12 && _livEnt12.hasEffect(Art5019injusticeModMobEffects.POWER_DEPENDENCE.get())) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(Art5019injusticeModMobEffects.POWER_DEPENDENCE.get());
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("art5019injustice:radiation_damage")))), 3);
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"particle dust 1.000 0.933 0.000 1 ~ ~1 ~ 0.6 0.6 0.6 1 2 normal");
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		} else if (entity instanceof LivingEntity _livEnt18 && _livEnt18.hasEffect(Art5019injusticeModMobEffects.FEAR.get())) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(Art5019injusticeModMobEffects.FEAR.get());
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("art5019injustice:radiation_damage")))), 3);
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"particle dust 1.000 0.933 0.000 1 ~ ~1 ~ 0.6 0.6 0.6 1 2 normal");
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie_villager.converted")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
		if (itemstack.getOrCreateTag().getDouble("mode") == 4) {
			if (!(entity instanceof Player _plrCldCheck27 && _plrCldCheck27.getCooldowns().isOnCooldown(itemstack.getItem()))) {
				FlyMindStoneProcedure.execute(entity);
				if (!(entity instanceof LivingEntity _livEnt28 && _livEnt28.hasEffect(Art5019injusticeModMobEffects.RADIATION.get()))) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.RADIATION.get(), 200, 0, false, false));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"particle dust 1.000 0.933 0.000 1 ~ ~1 ~ 0.6 0.6 0.6 1 2 normal");
				}
			}
		}
	}
}
