package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;
import net.mcreator.artinjustice.Art5019injusticeMod;

public class SoulStoneLivingEntityIsHitWithItemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double propel = 0;
		double distance = 0;
		double impact = 0;
		double power = 0;
		double radius = 0;
		if (itemstack.getOrCreateTag().getDouble("mode") == 2) {
			if (itemstack.getOrCreateTag().getDouble("soulPower") >= 45) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"particle dust 1.000 0.635 0.000 1 ~ ~ ~ 0.4 0.4 0.4 1 600 normal");
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.ENCHANT, x, (y + 1), z, 400, 0.4, 1, 0.4, 0.2);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SOUL, x, (y + 1), z, 30, 0.4, 1, 0.4, 0.2);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.MAGIC_BLOCKING.get(), 1200, 1, false, false));
				Art5019injusticeMod.queueServerWork(2, () -> {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 180, 1, false, false));
					entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)), 6);
				});
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				itemstack.getOrCreateTag().putDouble("cadency", 200);
				itemstack.getOrCreateTag().putDouble("soulPower", (itemstack.getOrCreateTag().getDouble("soulPower") - 45));
			}
		} else if (itemstack.getOrCreateTag().getDouble("mode") == 1) {
			if (itemstack.getOrCreateTag().getDouble("soulPower") >= 40) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"particle dust 1.000 0.635 0.000 1 ~ ~ ~ 0.4 0.4 0.4 1 600 normal");
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.ENCHANT, x, (y + 1), z, 400, 0.4, 1, 0.4, 0.2);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SOUL, x, (y + 1), z, 30, 0.4, 1, 0.4, 0.2);
				if (entity instanceof LivingEntity _livEnt26 && _livEnt26.hasEffect(Art5019injusticeModMobEffects.LIFE_DEPLETION.get())) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.LIFE_DEPLETION.get(), 240,
								(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.LIFE_DEPLETION.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.LIFE_DEPLETION.get()).getAmplifier() : 0) + 1),
								false, false));
				} else {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.LIFE_DEPLETION.get(), 240, 0, false, false));
				}
				Art5019injusticeMod.queueServerWork(2, () -> {
					entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)), 3);
				});
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				itemstack.getOrCreateTag().putDouble("cadency", 120);
				itemstack.getOrCreateTag().putDouble("soulPower", (itemstack.getOrCreateTag().getDouble("soulPower") - 40));
			}
		}
	}
}
