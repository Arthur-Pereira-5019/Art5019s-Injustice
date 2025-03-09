
package net.mcreator.artinjustice.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.artinjustice.procedures.MrNegativeOnEntityTickUpdateProcedure;
import net.mcreator.artinjustice.procedures.MrNegativeEntityIsHurtProcedure;
import net.mcreator.artinjustice.procedures.MrNegativeEntityDiesProcedure;
import net.mcreator.artinjustice.init.Art5019injusticeModItems;
import net.mcreator.artinjustice.init.Art5019injusticeModEntities;

public class MrNegativeEntity extends Monster {
	public static final EntityDataAccessor<Integer> DATA_stage = SynchedEntityData.defineId(MrNegativeEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_attackcycle = SynchedEntityData.defineId(MrNegativeEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_maxattackcycle = SynchedEntityData.defineId(MrNegativeEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_dialogues = SynchedEntityData.defineId(MrNegativeEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_dialogues2 = SynchedEntityData.defineId(MrNegativeEntity.class, EntityDataSerializers.INT);
	private final ServerBossEvent bossInfo = new ServerBossEvent(this.getDisplayName(), ServerBossEvent.BossBarColor.WHITE, ServerBossEvent.BossBarOverlay.NOTCHED_6);

	public MrNegativeEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(Art5019injusticeModEntities.MR_NEGATIVE.get(), world);
	}

	public MrNegativeEntity(EntityType<MrNegativeEntity> type, Level world) {
		super(type, world);
		setMaxUpStep(2f);
		xpReward = 0;
		setNoAi(false);
		setPersistenceRequired();
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Art5019injusticeModItems.KATANA.get()));
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_stage, 0);
		this.entityData.define(DATA_attackcycle, 0);
		this.entityData.define(DATA_maxattackcycle, 0);
		this.entityData.define(DATA_dialogues, 0);
		this.entityData.define(DATA_dialogues2, 0);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}
		});
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Player.class, false, false));
		this.targetSelector.addGoal(4, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(6, new FloatGoal(this));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
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

		MrNegativeEntityIsHurtProcedure.execute(world, x, y, z, entity, sourceentity);
		if (damagesource.is(DamageTypes.WITHER) || damagesource.is(DamageTypes.WITHER_SKULL))
			return false;
		return super.hurt(damagesource, amount);
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		MrNegativeEntityDiesProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ());
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("Datastage", this.entityData.get(DATA_stage));
		compound.putInt("Dataattackcycle", this.entityData.get(DATA_attackcycle));
		compound.putInt("Datamaxattackcycle", this.entityData.get(DATA_maxattackcycle));
		compound.putInt("Datadialogues", this.entityData.get(DATA_dialogues));
		compound.putInt("Datadialogues2", this.entityData.get(DATA_dialogues2));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Datastage"))
			this.entityData.set(DATA_stage, compound.getInt("Datastage"));
		if (compound.contains("Dataattackcycle"))
			this.entityData.set(DATA_attackcycle, compound.getInt("Dataattackcycle"));
		if (compound.contains("Datamaxattackcycle"))
			this.entityData.set(DATA_maxattackcycle, compound.getInt("Datamaxattackcycle"));
		if (compound.contains("Datadialogues"))
			this.entityData.set(DATA_dialogues, compound.getInt("Datadialogues"));
		if (compound.contains("Datadialogues2"))
			this.entityData.set(DATA_dialogues2, compound.getInt("Datadialogues2"));
	}

	@Override
	public void baseTick() {
		super.baseTick();
		MrNegativeOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
	}

	@Override
	public boolean canChangeDimensions() {
		return false;
	}

	@Override
	public void startSeenByPlayer(ServerPlayer player) {
		super.startSeenByPlayer(player);
		this.bossInfo.addPlayer(player);
	}

	@Override
	public void stopSeenByPlayer(ServerPlayer player) {
		super.stopSeenByPlayer(player);
		this.bossInfo.removePlayer(player);
	}

	@Override
	public void customServerAiStep() {
		super.customServerAiStep();
		this.bossInfo.setProgress(this.getHealth() / this.getMaxHealth());
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.35);
		builder = builder.add(Attributes.MAX_HEALTH, 580);
		builder = builder.add(Attributes.ARMOR, 9);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 64);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.3);
		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0.5);
		return builder;
	}
}
