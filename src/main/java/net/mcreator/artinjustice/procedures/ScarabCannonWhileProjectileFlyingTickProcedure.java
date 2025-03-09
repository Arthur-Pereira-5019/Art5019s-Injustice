package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.List;
import java.util.Comparator;

public class ScarabCannonWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		if (immediatesourceentity.getPersistentData().getDouble("age") == 100) {
			if (!immediatesourceentity.level().isClientSide())
				immediatesourceentity.discard();
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SONIC_BOOM, x, y, z, 2, 0, 0, 0, 1);
		immediatesourceentity.setNoGravity(true);
		if (world instanceof ServerLevel _level)
			_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
					"fill ~2 ~2 ~2 ~-2 ~-2 ~-2 air replace fire");
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(9 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator == entity)) {
					entityiterator.setDeltaMovement(new Vec3((immediatesourceentity.getDeltaMovement().x()), (immediatesourceentity.getDeltaMovement().y()), (immediatesourceentity.getDeltaMovement().z())));
					if (Math.random() < 0.1) {
						VenomSoundWeaknessProcedure.execute(world, x, y, z, entity);
					}
				}
			}
		}
		immediatesourceentity.getPersistentData().putDouble("age", (immediatesourceentity.getPersistentData().getDouble("age") + 1));
	}
}
