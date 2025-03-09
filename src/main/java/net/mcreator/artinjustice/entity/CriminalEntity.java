
package net.mcreator.artinjustice.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FollowMobGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
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
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.Difficulty;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.artinjustice.procedures.CriminalThisEntityKillsAnotherOneProcedure;
import net.mcreator.artinjustice.procedures.CriminalOnInitialEntitySpawnProcedure;
import net.mcreator.artinjustice.procedures.CriminalOnEntityTickUpdateProcedure;
import net.mcreator.artinjustice.procedures.CriminalEntityIsHurtProcedure;
import net.mcreator.artinjustice.procedures.CriminalEntityDiesProcedure;
import net.mcreator.artinjustice.init.Art5019injusticeModEntities;

import javax.annotation.Nullable;

public class CriminalEntity extends Monster {
	public static final EntityDataAccessor<Integer> DATA_gun = SynchedEntityData.defineId(CriminalEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_affiliation = SynchedEntityData.defineId(CriminalEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_skin = SynchedEntityData.defineId(CriminalEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_nextAttack = SynchedEntityData.defineId(CriminalEntity.class, EntityDataSerializers.INT);

	public CriminalEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(Art5019injusticeModEntities.CRIMINAL.get(), world);
	}

	public CriminalEntity(EntityType<CriminalEntity> type, Level world) {
		super(type, world);
		setMaxUpStep(0.6f);
		xpReward = 0;
		setNoAi(false);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_gun, 0);
		this.entityData.define(DATA_affiliation, 0);
		this.entityData.define(DATA_skin, 0);
		this.entityData.define(DATA_nextAttack, 80);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, true) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}
		});
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1));
		this.targetSelector.addGoal(3, new HurtByTargetGoal(this).setAlertOthers());
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, Villager.class, false, false));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, Player.class, false, false));
		this.targetSelector.addGoal(6, new NearestAttackableTargetGoal(this, TaskMasterEntity.class, false, false));
		this.goalSelector.addGoal(7, new FollowMobGoal(this, 1, (float) 10, (float) 5));
		this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(9, new FloatGoal(this));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public double getMyRidingOffset() {
		return -0.35D;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
	}

	@Override
	public boolean hurt(DamageSource damagesource, float amount) {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity entity = this;
		Entity sourceentity = damagesource.getEntity();
		Entity immediatesourceentity = damagesource.getDirectEntity();

		CriminalEntityIsHurtProcedure.execute(world, entity, sourceentity);
		return super.hurt(damagesource, amount);
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		CriminalEntityDiesProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this, source.getEntity());
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
		CriminalOnInitialEntitySpawnProcedure.execute(world, this.getX(), this.getY(), this.getZ(), this);
		return retval;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("Datagun", this.entityData.get(DATA_gun));
		compound.putInt("Dataaffiliation", this.entityData.get(DATA_affiliation));
		compound.putInt("Dataskin", this.entityData.get(DATA_skin));
		compound.putInt("DatanextAttack", this.entityData.get(DATA_nextAttack));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Datagun"))
			this.entityData.set(DATA_gun, compound.getInt("Datagun"));
		if (compound.contains("Dataaffiliation"))
			this.entityData.set(DATA_affiliation, compound.getInt("Dataaffiliation"));
		if (compound.contains("Dataskin"))
			this.entityData.set(DATA_skin, compound.getInt("Dataskin"));
		if (compound.contains("DatanextAttack"))
			this.entityData.set(DATA_nextAttack, compound.getInt("DatanextAttack"));
	}

	@Override
	public void awardKillScore(Entity entity, int score, DamageSource damageSource) {
		super.awardKillScore(entity, score, damageSource);
		CriminalThisEntityKillsAnotherOneProcedure.execute(this.level());
	}

	@Override
	public void baseTick() {
		super.baseTick();
		CriminalOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
	}

	public static void init() {
		SpawnPlacements.register(Art5019injusticeModEntities.CRIMINAL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getDifficulty() != Difficulty.PEACEFUL && Monster.isDarkEnoughToSpawn(world, pos, random) && Mob.checkMobSpawnRules(entityType, world, reason, pos, random)));
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 20);
		builder = builder.add(Attributes.ARMOR, 8);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 4);
		builder = builder.add(Attributes.FOLLOW_RANGE, 32);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 1);
		return builder;
	}
}
