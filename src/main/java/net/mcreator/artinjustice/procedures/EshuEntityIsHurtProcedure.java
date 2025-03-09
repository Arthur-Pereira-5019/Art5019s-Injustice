package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import java.util.List;
import java.util.Comparator;

public class EshuEntityIsHurtProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return false;
		double dy = 0;
		double newz = 0;
		double newy = 0;
		double newx = 0;
		boolean canskip = false;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Ma\u1E63e ronu nipa r\u1EB9 paapaa..."), false);
			}
		}
		for (int index0 = 0; index0 < 3; index0++) {
			newx = entity.getX() + Mth.nextDouble(RandomSource.create(), -70, 70);
			newy = entity.getY() + Mth.nextDouble(RandomSource.create(), 8, 20);
			newz = entity.getZ() + Mth.nextDouble(RandomSource.create(), -70, 70);
			while (!canskip) {
				if (dy >= -20) {
					if (world.getBlockState(BlockPos.containing(newx, newy + dy, newz)).canOcclude()) {
						{
							Entity _ent = sourceentity;
							_ent.teleportTo(newx, (newy + dy + 1), newz);
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(newx, (newy + dy + 1), newz, _ent.getYRot(), _ent.getXRot());
						}
						canskip = true;
					}
				} else {
					canskip = true;
				}
				dy = dy - 1;
			}
		}
		return false;
	}
}
