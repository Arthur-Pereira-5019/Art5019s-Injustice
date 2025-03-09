package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.Art5019injusticeMod;

import java.util.List;
import java.util.Comparator;

public class KaleTheCaretakerActionsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (Math.random() < 0.004) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:pets")))) {
							if (entity instanceof Mob _entity)
								_entity.getNavigation().moveTo((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 1.1);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.HEART, x, y, z, 40, 0.5, 1, 0.5, 1);
						}
					}
				}
				Art5019injusticeMod.queueServerWork(60, () -> {
					{
						final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:pets")))) {
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.HEART, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 40, 0.5, 1, 0.5, 1);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.burp")),
												SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.burp")), SoundSource.NEUTRAL, 1, 1,
												false);
									}
								}
								if (entityiterator instanceof LivingEntity _entity)
									_entity.setHealth(entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
								if ((entityiterator.getDisplayName().getString()).toLowerCase().contains((ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).replace("minecraft:", ""))) {
									entityiterator.setCustomName(Component.literal(RandomNamingProcedure.execute(world, entityiterator)));
								}
							}
						}
					}
				});
			}
		}
	}
}
