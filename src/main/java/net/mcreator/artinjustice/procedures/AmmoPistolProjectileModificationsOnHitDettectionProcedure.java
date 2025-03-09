package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModMobEffects;
import net.mcreator.artinjustice.init.Art5019injusticeModItems;
import net.mcreator.artinjustice.Art5019injusticeMod;

public class AmmoPistolProjectileModificationsOnHitDettectionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 9
				&& (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.DOMINO_SUIT_HELMET.get()
				&& (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.DOMINO_SUIT_CHESTPLATE.get()
				&& (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.DOMINO_SUIT_BOOTS.get()
				&& (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.DOMINO_SUIT_LEGGINGS.get()) {
			if (Math.random() < 0.6) {
				if (Math.random() < 0.5) {
					if (Math.random() < 0.3) {
						Art5019injusticeMod.queueServerWork(11, () -> {
							if (world instanceof Level _level && !_level.isClientSide())
								_level.explode(null, (entity.getX()), (entity.getY()), (entity.getZ()), 1, Level.ExplosionInteraction.NONE);
						});
					} else {
						entity.setSecondsOnFire((int) (entity.getRemainingFireTicks() + 5));
					}
				} else {
					if (Math.random() < 0.7) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(Art5019injusticeModMobEffects.ATTACK_INABILITY.get(),
									(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.ATTACK_INABILITY.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.ATTACK_INABILITY.get()).getDuration() : 0)
											+ 120),
									0, false, false));
					} else {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS,
									(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(Art5019injusticeModMobEffects.ATTACK_INABILITY.get()) ? _livEnt.getEffect(Art5019injusticeModMobEffects.ATTACK_INABILITY.get()).getDuration() : 0)
											+ 160),
									0, false, false));
					}
				}
			}
		} else if ((sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.INNER_DEMON_MASK_HELMET.get()) {
			if (0 > ReturnAlignmentTierProcedure.execute(sourceentity)) {
				Art5019injusticeMod.queueServerWork(11, () -> {
					entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.WITHER)), (float) ((-2) * ReturnAlignmentTierProcedure.execute(sourceentity)));
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x, y, z, (int) ((-10) * ReturnAlignmentTierProcedure.execute(sourceentity)), 0.5, 0.5, 0.5, 0.5);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.GLOW_SQUID_INK, x, y, z, (int) ((-5) * ReturnAlignmentTierProcedure.execute(sourceentity)), 0.5, 0.5, 0.5, 0.5);
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SMOKE, x, y, z, (int) ((-20) * ReturnAlignmentTierProcedure.execute(sourceentity)), 0.5, 0.5, 0.5, 0.5);
				});
			}
		}
	}
}
