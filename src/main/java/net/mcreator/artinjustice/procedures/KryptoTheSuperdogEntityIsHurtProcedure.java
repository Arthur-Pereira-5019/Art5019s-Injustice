package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;
import net.mcreator.artinjustice.entity.KryptoTheSuperdogEntity;
import net.mcreator.artinjustice.Art5019injusticeMod;

public class KryptoTheSuperdogEntityIsHurtProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (150 > (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) && (entity instanceof KryptoTheSuperdogEntity _datEntL1 && _datEntL1.getEntityData().get(KryptoTheSuperdogEntity.DATA_hascollar)) == true) {
			if (entity instanceof KryptoTheSuperdogEntity _datEntSetL)
				_datEntSetL.getEntityData().set(KryptoTheSuperdogEntity.DATA_hascollar, false);
			if (entity instanceof NeutralMob _entity) {
				_entity.forgetCurrentTargetAndRefreshUniversalAnger();
				_entity.stopBeingAngry();
				_entity.setLastHurtByMob(null);
				_entity.setLastHurtByPlayer(null);
				_entity.setTarget(null);
				_entity.setPersistentAngerTarget(null);
			}
			if (entity instanceof LivingEntity _entity) {
				_entity.getBrain().eraseMemory(MemoryModuleType.ANGRY_AT);
				_entity.getBrain().eraseMemory(MemoryModuleType.ATTACK_TARGET);
				_entity.getBrain().eraseMemory(MemoryModuleType.NEAREST_VISIBLE_ATTACKABLE_PLAYER);
			}
			if (entity instanceof Mob _entity) {
				_entity.targetSelector.getAvailableGoals().removeIf(goal -> goal.getGoal() instanceof NearestAttackableTargetGoal || goal.getGoal() instanceof HurtByTargetGoal);
			}
			Art5019injusticeMod.queueServerWork(5, () -> {
				if (entity instanceof Mob _entity) {
					_entity.targetSelector.addGoal(3, new HurtByTargetGoal(this));
				}
			});
			if (entity instanceof TamableAnimal _toTame && sourceentity instanceof Player _owner)
				_toTame.tame(_owner);
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Art5019injusticeModItems.RED_KRYPTONITE.get()));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.HEART, x, y, z, 20, 1, 1, 1, 1);
		}
	}
}
