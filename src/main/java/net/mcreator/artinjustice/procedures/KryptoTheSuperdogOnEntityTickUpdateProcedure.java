package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;

import java.util.List;
import java.util.Comparator;

public class KryptoTheSuperdogOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (Math.random() < 0.06) {
				if (entity.getY() - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() > 5) {
					if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 120, 0, false, false));
						if (Math.random() < 0.25) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.DASHING.get(), 2, 0, false, false));
						}
					}
				} else {
					if (Math.random() < 0.25) {
						GenericLaserProcedure.execute(world, x, y, z, entity, 3);
					} else {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.howl")), SoundSource.HOSTILE, 2, 0);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.howl")), SoundSource.HOSTILE, 2, 0, false);
							}
						}
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("art5019injustice:sonic_damage")))),
										9);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.EXPLOSION_EMITTER, x, y, z, 20, 1, 1, 1, 1);
					}
				}
			}
		}
	}
}
