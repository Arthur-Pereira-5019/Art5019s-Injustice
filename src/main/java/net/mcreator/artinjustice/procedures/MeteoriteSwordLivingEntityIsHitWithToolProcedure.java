package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.artinjustice.Art5019injusticeMod;

public class MeteoriteSwordLivingEntityIsHitWithToolProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		double momentum = 0;
		if (!sourceentity.onGround() && !(sourceentity instanceof Player _plrCldCheck2 && _plrCldCheck2.getCooldowns().isOnCooldown(itemstack.getItem()))) {
			Art5019injusticeMod.queueServerWork(2, () -> {
				if (Math.random() < 0.15) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.EXPLOSION, x, y, z, 50, 1, 1, 1, 1);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.LAVA, x, y, z, 50, 1, 1, 1, 1);
					entity.setSecondsOnFire((int) (entity.getRemainingFireTicks() * 20 + 5));
					entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.EXPLOSION)), 3);
					sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.ON_FIRE)), 2);
					if (sourceentity instanceof Player _player)
						_player.getCooldowns().addCooldown(itemstack.getItem(), 400);
				}
			});
		}
	}
}
