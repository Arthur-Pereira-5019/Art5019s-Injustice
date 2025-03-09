package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;
import net.mcreator.artinjustice.Art5019injusticeMod;

import java.util.List;
import java.util.Comparator;

public class FlashGrenadeThrownProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:item.grenade.hits")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:item.grenade.hits")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SMOKE, x, (y + 0.5), z, 15, 0.1, 0.4, 0.1, 0);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.LARGE_SMOKE, x, (y + 0.5), z, 15, 0.1, 0.4, 0.1, 0);
		Art5019injusticeMod.queueServerWork(20, () -> {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMOKE, x, (y + 0.5), z, 15, 0.1, 0.4, 0.1, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LARGE_SMOKE, x, (y + 0.5), z, 15, 0.1, 0.4, 0.1, 0);
		});
		Art5019injusticeMod.queueServerWork(40, () -> {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMOKE, x, (y + 0.5), z, 15, 0.1, 0.4, 0.1, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LARGE_SMOKE, x, (y + 0.5), z, 15, 0.1, 0.4, 0.1, 0);
		});
		Art5019injusticeMod.queueServerWork(60, () -> {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMOKE, x, (y + 0.5), z, 15, 0.1, 0.4, 0.1, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LARGE_SMOKE, x, (y + 0.5), z, 15, 0.1, 0.4, 0.1, 0);
		});
		Art5019injusticeMod.queueServerWork(80, () -> {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMOKE, x, (y + 0.5), z, 10, 0.1, 0.4, 0.1, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LARGE_SMOKE, x, (y + 0.5), z, 30, 0.1, 0.4, 0.1, 0);
		});
		Art5019injusticeMod.queueServerWork(100, () -> {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMOKE, x, (y + 0.5), z, 5, 0.1, 0.4, 0.1, 0);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LARGE_SMOKE, x, (y + 0.5), z, 45, 0.1, 0.4, 0.1, 0);
		});
		Art5019injusticeMod.queueServerWork(120, () -> {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FLASH, x, (y + 0.5), z, 1200, 4, 4, 4, 0);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(12 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("art5019injustice:eyeprotectors"))))) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.ATTACK_INABILITY.get(),
									(int) ((entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.ATTACK_INABILITY.get())
											? _livEnt.getEffect(Art5019injusticeModMobEffects.ATTACK_INABILITY.get()).getDuration()
											: 0) + 260),
									1, false, false));
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS,
									(int) ((entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DARKNESS) ? _livEnt.getEffect(MobEffects.DARKNESS).getDuration() : 0) + 720), 1, false, false));
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS,
									(int) ((entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.BLINDNESS) ? _livEnt.getEffect(MobEffects.BLINDNESS).getDuration() : 0) + 720), 1, false, false));
					}
				}
			}
		});
	}
}
