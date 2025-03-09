package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import java.util.List;
import java.util.Comparator;

public class SoulStoneInHandTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean worked = false;
		if (itemstack.getOrCreateTag().getDouble("cadency") == 0) {
			if (itemstack.getOrCreateTag().getDouble("soulPower") >= 1) {
				if (itemstack.getOrCreateTag().getDouble("mode") == 5) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(MobEffects.WITHER))) {
								if (!(entityiterator == entity)) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 0, false, false));
									worked = true;
								}
							}
						}
					}
				} else if (itemstack.getOrCreateTag().getDouble("mode") == 4) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator instanceof LivingEntity _livEnt12 && _livEnt12.hasEffect(MobEffects.REGENERATION))) {
								if (!(entityiterator == entity)) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 0, false, false));
									worked = true;
								}
							}
						}
					}
				} else if (itemstack.getOrCreateTag().getDouble("mode") == 3) {
					if (!(entity instanceof LivingEntity _livEnt18 && _livEnt18.hasEffect(MobEffects.REGENERATION))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1, false, false));
						worked = true;
					}
				}
				if (worked) {
					itemstack.getOrCreateTag().putDouble("soulPower", (itemstack.getOrCreateTag().getDouble("soulPower") - 2));
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SOUL, x, y, z, 40, 0.4, 1, 0.4, 0.4);
				}
			}
		}
		if (itemstack.getOrCreateTag().getDouble("cadency") >= 1) {
			itemstack.getOrCreateTag().putDouble("cadency", (itemstack.getOrCreateTag().getDouble("cadency") - 1));
		}
	}
}
