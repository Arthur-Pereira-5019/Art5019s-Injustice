package net.mcreator.artinjustice.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.monster.Vex;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModItems;
import net.mcreator.artinjustice.entity.TaskMasterEntity;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class EntityTickProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity futuretarget = null;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MobEffects.BLINDNESS) && !(entity instanceof Warden)) {
			if (Math.random() < 0.01) {
				if (entity instanceof Mob _entity)
					_entity.getNavigation().moveTo((x + Mth.nextDouble(RandomSource.create(), -10, 10)), y, (z + Mth.nextDouble(RandomSource.create(), -10, 10)), 1);
			}
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				if (entity instanceof Mob _entity)
					_entity.setTarget(null);
			}
		}
		if (entity instanceof IronGolem) {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof TaskMasterEntity) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(15 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Monster) {
							if (!(entityiterator instanceof IronGolem) && !(entityiterator instanceof TaskMasterEntity)) {
								if (entity instanceof Mob _entity && entityiterator instanceof LivingEntity _ent)
									_entity.setTarget(_ent);
							} else {
								if (entity instanceof Mob _entity)
									_entity.setTarget(null);
							}
						} else {
							if (entity instanceof Mob _entity)
								_entity.setTarget(null);
						}
					}
				}
			}
		} else if (entity instanceof Vex) {
			if (((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.SOUL_STONE.get()
					|| ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.SOUL_STONE.get()) {
				if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)))) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if ((entityiterator.getStringUUID()).equals(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new Art5019injusticeModVariables.PlayerVariables())).targetid)) {
								if (entity instanceof Mob _entity && entityiterator instanceof LivingEntity _ent)
									_entity.setTarget(_ent);
							}
						}
					}
				} else {
					{
						Entity _ent = entity;
						_ent.teleportTo((x + Mth.nextInt(RandomSource.create(), 4, 12)), (y + Mth.nextInt(RandomSource.create(), 4, 12)), (z + Mth.nextInt(RandomSource.create(), 4, 12)));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport((x + Mth.nextInt(RandomSource.create(), 4, 12)), (y + Mth.nextInt(RandomSource.create(), 4, 12)), (z + Mth.nextInt(RandomSource.create(), 4, 12)), _ent.getYRot(), _ent.getXRot());
					}
				}
			}
		}
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:bosses")))) {
			if (entity.isInWall()) {
				if (Math.random() < 0.4 / (world.getBlockState(BlockPos.containing(x, y, z)).getDestroySpeed(world, BlockPos.containing(x, y, z)) * 4)) {
					{
						BlockPos _pos = BlockPos.containing(x, y, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
				if (Math.random() < 0.4 / (world.getBlockState(BlockPos.containing(x, y + 1, z)).getDestroySpeed(world, BlockPos.containing(x, y + 1, z)) * 4)) {
					{
						BlockPos _pos = BlockPos.containing(x, y + 1, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y + 1, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
		}
	}
}
