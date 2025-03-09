package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;
import net.mcreator.artinjustice.init.Art5019injusticeModEntities;
import net.mcreator.artinjustice.entity.TaskMasterEntity;
import net.mcreator.artinjustice.entity.PistolMobsEntity;

import java.util.List;
import java.util.Comparator;

public class UncleSamOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity choosen = null;
		double distance = 0;
		double surroundedby = 0;
		double nx = 0;
		double ny = 0;
		double nz = 0;
		if (Math.random() < 0.04) {
			if (!(null == (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null))) {
				if (Math.random() < 0.6) {
					entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()),
							((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 2), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("summon firework_rocket ~ ~ ~ {LifeTime:90,ShotAtAngle:1b,Motion:[" + entity.getLookAngle().x * 1 + "," + entity.getLookAngle().y * 1 + "," + entity.getLookAngle().z * 1 + "],Rotation:[" + entity.getYRot() + "F,"
										+ entity.getXRot() + "F],FireworksItem:{id:\"firework_rocket\",Count:1,tag:{Fireworks:{Explosions:[{Type:1,Colors:[I;16711680]},{Type:2,Colors:[I;16777215]},{Type:1,Colors:[I;2228479]}]}}}}"));
				} else {
					if (Math.random() < 0.7) {
						if (Math.random() < 0.3) {
							entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()),
									((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.FIREWORK, x, y, z, 140, 0.6, 1, 0.6, 0.1);
							if (world instanceof ServerLevel projectileLevel) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
										AbstractArrow entityToSpawn = new PistolMobsEntity(Art5019injusticeModEntities.PISTOL_MOBS.get(), level);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										entityToSpawn.setKnockback(knockback);
										entityToSpawn.setSilent(true);
										entityToSpawn.setSecondsOnFire(100);
										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 5, 1);
								_entityToSpawn.setPos((entity.getLookAngle().x), (entity.getLookAngle().y), (entity.getLookAngle().z));
								_entityToSpawn.shoot(1, 1, 1, 1, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
						} else {
							if (Math.random() < 0.6) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 0, false, false));
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 200, 0, false, false));
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.FIREWORK, x, y, z, 140, 0.6, 1, 0.6, 0.1);
							} else {
								entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()),
										((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
								entity.setDeltaMovement(new Vec3((entity.getLookAngle().x * 3), (entity.getLookAngle().y * 3), (entity.getLookAngle().z * 3)));
							}
						}
					} else {
						surroundedby = 0;
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entity == (entityiterator instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
									surroundedby = surroundedby + 1;
								}
							}
						}
						if (surroundedby >= 5) {
							if (!(((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)) == null)) {
								choosen = (Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null);
							} else if (!(((Entity) world.getEntitiesOfClass(IronGolem.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)) == null)) {
								choosen = (Entity) world.getEntitiesOfClass(IronGolem.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null);
							} else if (!(((Entity) world.getEntitiesOfClass(TaskMasterEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)) == null)) {
								choosen = (Entity) world.getEntitiesOfClass(TaskMasterEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null);
							}
							if (!(choosen == null)) {
								if (!(choosen.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).possessed) {
									if (choosen instanceof Player _player && !_player.level().isClientSide())
										_player.displayClientMessage(Component.literal("<Uncle Sam> I WANT YOU!"), false);
									if (choosen instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.UNCLE_SAM_POSSESSED.get(), 12000, 0, false, false));
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.elder_guardian.curse")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.elder_guardian.curse")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									choosen.getPersistentData().putDouble("possessedHealth", (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1));
									choosen.getPersistentData().putBoolean("possessed", true);
									if (!entity.level().isClientSide())
										entity.discard();
								}
							} else {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20, 4, false, false));
								if (world instanceof Level _level && !_level.isClientSide())
									_level.explode(null, x, y, z, 4, Level.ExplosionInteraction.NONE);
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.FIREWORK, x, y, z, 140, 0.6, 1, 0.6, 0.1);
							}
						} else {
							entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()),
									((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ())));
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands()
										.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y + 2), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												("summon firework_rocket ~ ~ ~ {LifeTime:90,ShotAtAngle:1b,Motion:[" + entity.getLookAngle().x * 1 + "," + entity.getLookAngle().y * 1 + "," + entity.getLookAngle().z * 1 + "],Rotation:["
														+ entity.getYRot() + "F," + entity.getXRot()
														+ "F],FireworksItem:{id:\"firework_rocket\",Count:1,tag:{Fireworks:{Explosions:[{Type:1,Colors:[I;16711680]},{Type:2,Colors:[I;16777215]},{Type:1,Colors:[I;2228479]}]}}}}"));
						}
					}
				}
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Monster) {
							if (null == (entityiterator instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)) {
								if (!(entityiterator == entity)) {
									if (entityiterator instanceof Mob _entity && entity instanceof LivingEntity _ent)
										_entity.setTarget(_ent);
								}
							}
						}
					}
				}
			} else {
				if (Math.random() < 0.5) {
					entity.setDeltaMovement(new Vec3(0, (-5), 0));
				} else {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 1, false, false));
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.FIREWORK, x, y, z, 140, 0.6, 1, 0.6, 0.1);
				}
			}
			if (world.getBlockState(BlockPos.containing(x, y, z)).canOcclude()) {
				nx = entity.getX() + Mth.nextInt(RandomSource.create(), -10, 10);
				ny = entity.getY() + Mth.nextInt(RandomSource.create(), -10, 10);
				nz = entity.getZ() + Mth.nextInt(RandomSource.create(), -10, 10);
				if (!world.getBlockState(BlockPos.containing(nx, ny, nz)).canOcclude()) {
					{
						Entity _ent = entity;
						_ent.teleportTo(nx, ny, nz);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(nx, ny, nz, _ent.getYRot(), _ent.getXRot());
					}
				}
			}
		}
	}
}
