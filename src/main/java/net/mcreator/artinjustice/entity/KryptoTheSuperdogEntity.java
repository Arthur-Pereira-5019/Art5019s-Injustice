
package net.mcreator.artinjustice.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.procedures.KryptoTheSuperdogRightClickedOnEntityProcedure;
import net.mcreator.artinjustice.procedures.KryptoTheSuperdogOnInitialEntitySpawnProcedure;
import net.mcreator.artinjustice.procedures.KryptoTheSuperdogOnEntityTickUpdateProcedure;
import net.mcreator.artinjustice.procedures.KryptoTheSuperdogEntityIsHurtProcedure;
import net.mcreator.artinjustice.procedures.IfKryptoHasCollarProcedure;
import net.mcreator.artinjustice.init.Art5019injusticeModEntities;

import javax.annotation.Nullable;

public class KryptoTheSuperdogEntity extends Wolf {
	public static final EntityDataAccessor<Boolean> DATA_hascollar = SynchedEntityData.defineId(KryptoTheSuperdogEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> DATA_attack = SynchedEntityData.defineId(KryptoTheSuperdogEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_attackticks = SynchedEntityData.defineId(KryptoTheSuperdogEntity.class, EntityDataSerializers.INT);

	public KryptoTheSuperdogEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(Art5019injusticeModEntities.KRYPTO_THE_SUPERDOG.get(), world);
	}

	public KryptoTheSuperdogEntity(EntityType<KryptoTheSuperdogEntity> type, Level world) {
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
		this.entityData.define(DATA_hascollar, true);
		this.entityData.define(DATA_attack, 0);
		this.entityData.define(DATA_attackticks, 0);
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
		this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, LivingEntity.class, false, false) {
			@Override
			public boolean canUse() {
				double x = KryptoTheSuperdogEntity.this.getX();
				double y = KryptoTheSuperdogEntity.this.getY();
				double z = KryptoTheSuperdogEntity.this.getZ();
				Entity entity = KryptoTheSuperdogEntity.this;
				Level world = KryptoTheSuperdogEntity.this.level();
				return super.canUse() && IfKryptoHasCollarProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(6, new FloatGoal(this));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.ambient"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.step")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.hurt"));
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

		KryptoTheSuperdogEntityIsHurtProcedure.execute(world, x, y, z, entity);
		if (damagesource.is(DamageTypes.IN_FIRE))
			return false;
		return super.hurt(damagesource, amount);
	}

	@Override
	public boolean fireImmune() {
		return true;
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
		KryptoTheSuperdogOnInitialEntitySpawnProcedure.execute(this);
		return retval;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("Datahascollar", this.entityData.get(DATA_hascollar));
		compound.putInt("Dataattack", this.entityData.get(DATA_attack));
		compound.putInt("Dataattackticks", this.entityData.get(DATA_attackticks));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Datahascollar"))
			this.entityData.set(DATA_hascollar, compound.getBoolean("Datahascollar"));
		if (compound.contains("Dataattack"))
			this.entityData.set(DATA_attack, compound.getInt("Dataattack"));
		if (compound.contains("Dataattackticks"))
			this.entityData.set(DATA_attackticks, compound.getInt("Dataattackticks"));
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());
		super.mobInteract(sourceentity, hand);
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level();
		return KryptoTheSuperdogRightClickedOnEntityProcedure.execute(entity);
	}

	@Override
	public void baseTick() {
		super.baseTick();
		KryptoTheSuperdogOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 200);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 8);
		builder = builder.add(Attributes.FOLLOW_RANGE, 64);
		return builder;
	}
}
