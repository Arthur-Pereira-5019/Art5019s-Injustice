package net.mcreator.artinjustice.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;

public class HazardOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double amplifier) {
		if (entity == null)
			return;
		double probs = 0;
		probs = Math.random();
		if (probs < 0.1) {
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));;
				_level.addFreshEntity(entityToSpawn);
			}
		} else if (probs < 0.3) {
			if (entity instanceof Player _player)
				_player.giveExperienceLevels(-((int) (3 * amplifier)));
		} else if (probs < 0.5) {
			if (entity instanceof Player _player)
				_player.getFoodData().setSaturation((float) ((entity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) - 3 * amplifier));
		} else if (probs < 0.7) {
			if (!(entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(Art5019injusticeModMobEffects.ELECTRICITY.get()))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.ELECTRICITY.get(), 360, 1, false, true));
			}
		} else if (probs < 0.8) {
			entity.setSecondsOnFire((int) (6 * amplifier));
		} else if (probs < 0.85) {
			entity.setAirSupply(-40);
		} else if (probs < 0.9) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.ATTACK_INABILITY.get(), 120, 1, false, false));
		} else if (probs < 0.97) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.POWER_DEPENDENCE.get(), 120, 1, false, false));
		} else {
			if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
				world.setBlock(BlockPos.containing(x, y + 20, z), Blocks.DAMAGED_ANVIL.defaultBlockState(), 3);
			}
		}
	}
}
