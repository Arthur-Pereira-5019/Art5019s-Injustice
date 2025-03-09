package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.monster.Husk;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;
import net.mcreator.artinjustice.Art5019injusticeMod;

import java.util.Comparator;

public class SuperFertilizerTulipEffectProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double timer = 0;
		double dx = 0;
		double d = 0;
		double dy = 0;
		double dz = 0;
		world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.SAND.defaultBlockState()));
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bone_meal.use")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bone_meal.use")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 20, 0.5, 0.5, 0.5, 1);
		Art5019injusticeMod.queueServerWork(12, () -> {
			world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.SAND.defaultBlockState()));
			Art5019injusticeMod.queueServerWork(12, () -> {
				world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.SAND.defaultBlockState()));
				Art5019injusticeMod.queueServerWork(12, () -> {
					world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.SAND.defaultBlockState()));
					Art5019injusticeMod.queueServerWork(12, () -> {
						world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(Blocks.SAND.defaultBlockState()));
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.HUSK.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						Art5019injusticeMod.queueServerWork(7, () -> {
							if (((Entity) world.getEntitiesOfClass(Husk.class, AABB.ofSize(new Vec3(x, y, z), 7, 7, 7), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.MONSTER_INFIGHTING.get(), 3600, 0, false, false));
						});
					});
				});
			});
		});
	}
}
