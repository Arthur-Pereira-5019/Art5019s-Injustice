package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;

import java.util.List;
import java.util.Comparator;

public class KryptonianSuperSensesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		String entities = "";
		if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z))) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.WATER_BREATHING) ? _livEnt.getEffect(MobEffects.WATER_BREATHING).getDuration() : 0) <= 400) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 400, 0, false, false));
			}
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				entities = entities + "" + entityiterator.getDisplayName().getString() + ", ";
			}
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("I feel... " + entities.substring(0, (int) ((entities).length() - 1)) + ".")), false);
		{
			double _setval = 1600;
			entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.ability1cooldown = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
