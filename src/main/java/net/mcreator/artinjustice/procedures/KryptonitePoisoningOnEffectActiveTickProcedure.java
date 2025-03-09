package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;

public class KryptonitePoisoningOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, Entity entity, double amplifier) {
		if (entity == null)
			return;
		double kr = 0;
		if ((entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 23) {
			kr = ReturnKryptoniteResistanceProcedure.execute(entity);
			{
				double _setval = (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powermeter - 5 * (amplifier + 1);
				entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.powermeter = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (Math.random() < 0.0045 - 0.00099 * kr) {
				KryptonianUpdateProcedure.execute(entity);
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("art5019injustice:kryptonite_radiation")))),
						(float) (2 * (amplifier + 1)));
				{
					double _setval = 0;
					entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.regenerationlevel = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (Math.random() < 0.003 - 0.00066 * kr) {
				KryptonianUpdateProcedure.execute(entity);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.POWER_DEPENDENCE.get(), (int) (300 * amplifier), 1, false, false));
				{
					double _setval = 0;
					entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ability33toggle = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (Math.random() < 0.003 - 0.00066 * kr) {
				KryptonianUpdateProcedure.execute(entity);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.ATTACK_INABILITY.get(), (int) (300 * amplifier), 1, false, false));
			}
		}
	}
}
