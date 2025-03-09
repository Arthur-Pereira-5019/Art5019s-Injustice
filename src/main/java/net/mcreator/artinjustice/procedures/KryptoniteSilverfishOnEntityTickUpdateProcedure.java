package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;
import net.mcreator.artinjustice.entity.KryptoniteSilverfishEntity;

import java.util.List;
import java.util.Comparator;

public class KryptoniteSilverfishOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof KryptoniteSilverfishEntity _datEntI ? _datEntI.getEntityData().get(KryptoniteSilverfishEntity.DATA_timestillnextpulse) : 0) <= 0) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((entityiterator.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 23) {
						if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.KRYPTONITE_POISONING.get(), 120, 1));
					}
				}
			}
			if (entity instanceof KryptoniteSilverfishEntity _datEntSetI)
				_datEntSetI.getEntityData().set(KryptoniteSilverfishEntity.DATA_timestillnextpulse, 240);
		} else if ((entity instanceof KryptoniteSilverfishEntity _datEntI ? _datEntI.getEntityData().get(KryptoniteSilverfishEntity.DATA_timestillnextpulse) : 0) <= 40) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"particle dust 0.467 1.000 0.000 1 ~ ~ ~ 0.2 0.2 0.2 1 3 normal");
		}
		if (entity instanceof KryptoniteSilverfishEntity _datEntSetI)
			_datEntSetI.getEntityData().set(KryptoniteSilverfishEntity.DATA_timestillnextpulse,
					(int) ((entity instanceof KryptoniteSilverfishEntity _datEntI ? _datEntI.getEntityData().get(KryptoniteSilverfishEntity.DATA_timestillnextpulse) : 0) - 1));
	}
}
