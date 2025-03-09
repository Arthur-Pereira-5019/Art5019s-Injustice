
package net.mcreator.artinjustice.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.procedures.IfIsInWaterProcedure;
import net.mcreator.artinjustice.procedures.IfIsInLandProcedure;
import net.mcreator.artinjustice.procedures.AtlanteanZombieSpawnProcedure;
import net.mcreator.artinjustice.procedures.AtlanteanZombieEntityDiesProcedure;
import net.mcreator.artinjustice.init.Art5019injusticeModEntities;

import javax.annotation.Nullable;

public class AtlanteanZombieEntity extends Monster {
	public AtlanteanZombieEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(Art5019injusticeModEntities.ATLANTEAN_ZOMBIE.get(), world);
	}

	public AtlanteanZombieEntity(EntityType<AtlanteanZombieEntity> type, Level world) {
		super(type, world);
		setMaxUpStep(0.6f);
		xpReward = 3;
		setNoAi(false);
		this.setPathfindingMalus(BlockPathTypes.WATER, 0);
		this.moveControl = new MoveControl(this) {
			@Override
			public void tick() {
				if (AtlanteanZombieEntity.this.isInWater())
					AtlanteanZombieEntity.this.setDeltaMovement(AtlanteanZombieEntity.this.getDeltaMovement().add(0, 0.005, 0));
				if (this.operation == MoveControl.Operation.MOVE_TO && !AtlanteanZombieEntity.this.getNavigation().isDone()) {
					double dx = this.wantedX - AtlanteanZombieEntity.this.getX();
					double dy = this.wantedY - AtlanteanZombieEntity.this.getY();
					double dz = this.wantedZ - AtlanteanZombieEntity.this.getZ();
					float f = (float) (Mth.atan2(dz, dx) * (double) (180 / Math.PI)) - 90;
					float f1 = (float) (this.speedModifier * AtlanteanZombieEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
					AtlanteanZombieEntity.this.setYRot(this.rotlerp(AtlanteanZombieEntity.this.getYRot(), f, 10));
					AtlanteanZombieEntity.this.yBodyRot = AtlanteanZombieEntity.this.getYRot();
					AtlanteanZombieEntity.this.yHeadRot = AtlanteanZombieEntity.this.getYRot();
					if (AtlanteanZombieEntity.this.isInWater()) {
						AtlanteanZombieEntity.this.setSpeed((float) AtlanteanZombieEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
						float f2 = -(float) (Mth.atan2(dy, (float) Math.sqrt(dx * dx + dz * dz)) * (180 / Math.PI));
						f2 = Mth.clamp(Mth.wrapDegrees(f2), -85, 85);
						AtlanteanZombieEntity.this.setXRot(this.rotlerp(AtlanteanZombieEntity.this.getXRot(), f2, 5));
						float f3 = Mth.cos(AtlanteanZombieEntity.this.getXRot() * (float) (Math.PI / 180.0));
						AtlanteanZombieEntity.this.setZza(f3 * f1);
						AtlanteanZombieEntity.this.setYya((float) (f1 * dy));
					} else {
						AtlanteanZombieEntity.this.setSpeed(f1 * 0.05F);
					}
				} else {
					AtlanteanZombieEntity.this.setSpeed(0);
					AtlanteanZombieEntity.this.setYya(0);
					AtlanteanZombieEntity.this.setZza(0);
				}
			}
		};
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new WaterBoundPathNavigation(this, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.3, true) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return 4;
			}
		});
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this).setAlertOthers());
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Player.class, false, false));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, Villager.class, false, false));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, IronGolem.class, false, false));
		this.goalSelector.addGoal(6, new RandomStrollGoal(this, 1) {
			@Override
			public boolean canUse() {
				double x = AtlanteanZombieEntity.this.getX();
				double y = AtlanteanZombieEntity.this.getY();
				double z = AtlanteanZombieEntity.this.getZ();
				Entity entity = AtlanteanZombieEntity.this;
				Level world = AtlanteanZombieEntity.this.level();
				return super.canUse() && IfIsInLandProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(7, new RandomSwimmingGoal(this, 2.1, 40) {
			@Override
			public boolean canUse() {
				double x = AtlanteanZombieEntity.this.getX();
				double y = AtlanteanZombieEntity.this.getY();
				double z = AtlanteanZombieEntity.this.getZ();
				Entity entity = AtlanteanZombieEntity.this;
				Level world = AtlanteanZombieEntity.this.level();
				return super.canUse() && IfIsInWaterProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEAD;
	}

	@Override
	public double getMyRidingOffset() {
		return -0.35D;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.drowned.ambient"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.drowned.step")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.drowned.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.drowned.death"));
	}

	@Override
	public boolean hurt(DamageSource damagesource, float amount) {
		if (damagesource.is(DamageTypes.IN_FIRE))
			return false;
		if (damagesource.is(DamageTypes.DROWN))
			return false;
		return super.hurt(damagesource, amount);
	}

	@Override
	public boolean fireImmune() {
		return true;
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		AtlanteanZombieEntityDiesProcedure.execute(source.getEntity());
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
		AtlanteanZombieSpawnProcedure.execute(this);
		return retval;
	}

	@Override
	public boolean checkSpawnObstruction(LevelReader world) {
		return world.isUnobstructed(this);
	}

	@Override
	public boolean canBreatheUnderwater() {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity entity = this;
		return true;
	}

	@Override
	public boolean isPushedByFluid() {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity entity = this;
		return false;
	}

	public static void init() {
		SpawnPlacements.register(Art5019injusticeModEntities.ATLANTEAN_ZOMBIE.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getBlockState(pos).is(Blocks.WATER) && world.getBlockState(pos.above()).is(Blocks.WATER)));
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 40);
		builder = builder.add(Attributes.ARMOR, 4);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 32);
		builder = builder.add(ForgeMod.SWIM_SPEED.get(), 0.3);
		return builder;
	}
}
