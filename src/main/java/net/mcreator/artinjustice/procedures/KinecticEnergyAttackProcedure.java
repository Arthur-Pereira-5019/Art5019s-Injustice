package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class KinecticEnergyAttackProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double propel = 0;
		double distance = 0;
		double impact = 0;
		double power = 0;
		double radius = 0;
		power = entity.getPersistentData().getDouble("kinecticenergy") / 133;
		radius = power * 2;
		propel = 1;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(radius / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator == entity)) {
					distance = Math.sqrt(Math.pow(entity.getZ() - entityiterator.getZ(), 2) + Math.pow(entity.getX() - entityiterator.getX(), 2) + Math.pow(entity.getY() - entityiterator.getY(), 2));
					impact = (1 - distance / radius) * 1;
					entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_EXPLOSION)), (float) Math.floor((impact * impact + impact) * 7 * power + 1));
					if (entityiterator.getZ() >= entity.getZ()) {
						entityiterator.setDeltaMovement(new Vec3((entityiterator.getDeltaMovement().x()), (entityiterator.getDeltaMovement().y()), (propel * (1 / impact))));
					} else {
						entityiterator.setDeltaMovement(new Vec3((entityiterator.getDeltaMovement().x()), (entityiterator.getDeltaMovement().y()), (propel * ((-1) / impact))));
					}
					if (entityiterator.getY() >= entity.getY()) {
						entityiterator.setDeltaMovement(new Vec3((entityiterator.getDeltaMovement().x()), (propel * (1 / impact)), (entityiterator.getDeltaMovement().z())));
					} else {
						entityiterator.setDeltaMovement(new Vec3((entityiterator.getDeltaMovement().x()), (propel * ((-1) / impact)), (entityiterator.getDeltaMovement().z())));
					}
					if (entityiterator.getX() >= entity.getX()) {
						entityiterator.setDeltaMovement(new Vec3((propel * (1 / impact)), (entityiterator.getDeltaMovement().y()), (entityiterator.getDeltaMovement().z())));
					} else {
						entityiterator.setDeltaMovement(new Vec3((propel * ((-1) / impact)), (entityiterator.getDeltaMovement().y()), (entityiterator.getDeltaMovement().z())));
					}
				}
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.REVERSE_PORTAL, x, y, z, (int) (entity.getPersistentData().getDouble("kinecticenergy") * 4), 1, 1, 1, 0.5);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
	}
}
