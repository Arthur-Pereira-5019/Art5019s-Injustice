package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;

import java.util.List;
import java.util.Comparator;

public class BleedingOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("art5019injustice:not_has_blood")))) {
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("art5019injustice:bleeding_damage")))), 1);
			{
				double _setval = (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).lost_blood + 1;
				entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.lost_blood = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"particle block redstone_block ~ ~ ~ 0.3 1 0.3 0.1 16 normal");
			if (entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(Art5019injusticeModMobEffects.AIDS.get())) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(Art5019injusticeModMobEffects.BLEEDING.get())
								&& !(entityiterator instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(Art5019injusticeModMobEffects.AIDS.get()))) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.AIDS.get(), 96000, 0, false, false));
						}
					}
				}
			}
		} else {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(Art5019injusticeModMobEffects.BLEEDING.get());
		}
	}
}
