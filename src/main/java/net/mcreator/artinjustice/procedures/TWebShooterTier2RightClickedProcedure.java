package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;
import net.mcreator.artinjustice.init.Art5019injusticeModEntities;
import net.mcreator.artinjustice.entity.WebShooterTier1m2ProjectileEntity;
import net.mcreator.artinjustice.entity.WebShooterTier1ProjectileEntity;
import net.mcreator.artinjustice.entity.WebShooterElectricWebProjectileEntity;
import net.mcreator.artinjustice.entity.RangedWebGrenadeProjectileEntity;
import net.mcreator.artinjustice.Art5019injusticeMod;

public class TWebShooterTier2RightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean recharge = false;
		double wait = 0;
		double boost = 0;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.SPIDER_MAN_TM_2_BOOTS.get()) {
			boost = 3.5;
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.SPIDER_MAN_TM_2_LEGGINGS.get()) {
			boost = boost + 3.5;
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.SPIDER_MAN_TM_2_HELMET.get()) {
			boost = boost + 3.5;
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.SPIDER_MAN_TM_2_CHESTPLATE.get()) {
			boost = boost + 3.5;
		}
		if (itemstack.getOrCreateTag().getDouble("mode") == 0) {
			if (itemstack.getOrCreateTag().getDouble("webFluid") >= 1) {
				itemstack.getOrCreateTag().putDouble("webFluid", (itemstack.getOrCreateTag().getDouble("webFluid") - 1));
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new WebShooterTier1ProjectileEntity(Art5019injusticeModEntities.WEB_SHOOTER_TIER_1_PROJECTILE.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, 0, 0);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 3, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt(1, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
				itemstack.getOrCreateTag().putDouble("cadency", 4);
			} else {
				recharge = true;
			}
		} else if (itemstack.getOrCreateTag().getDouble("mode") == 1) {
			if (itemstack.getOrCreateTag().getDouble("webFluid") >= 4) {
				itemstack.getOrCreateTag().putDouble("webFluid", (itemstack.getOrCreateTag().getDouble("webFluid") - 4));
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt(1, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
				itemstack.getOrCreateTag().putDouble("cadency", 5);
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new WebShooterTier1m2ProjectileEntity(Art5019injusticeModEntities.WEB_SHOOTER_TIER_1M_2_PROJECTILE.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, 0, 0);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 4, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				if (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((55 + boost))), ClipContext.Block.OUTLINE, ClipContext.Fluid.ANY, entity))
						.getType() == HitResult.Type.BLOCK) {
					WebPropelTier2Procedure.execute(entity);
				}
			} else {
				recharge = true;
			}
		} else if (itemstack.getOrCreateTag().getDouble("mode") == 2) {
			if (itemstack.getOrCreateTag().getDouble("webFluid") >= 30) {
				itemstack.getOrCreateTag().putDouble("webFluid", (itemstack.getOrCreateTag().getDouble("webFluid") - 30));
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt(2, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 8);
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new RangedWebGrenadeProjectileEntity(Art5019injusticeModEntities.RANGED_WEB_GRENADE_PROJECTILE.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, 0, 0);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 4, (float) 0.4);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			} else {
				recharge = true;
			}
		} else if (itemstack.getOrCreateTag().getDouble("mode") == 3) {
			if (itemstack.getOrCreateTag().getDouble("webFluid") >= 15) {
				itemstack.getOrCreateTag().putDouble("webFluid", (itemstack.getOrCreateTag().getDouble("webFluid") - 15));
				itemstack.getOrCreateTag().putDouble("cadency", 40);
				for (int index0 = 0; index0 < 14; index0++) {
					Art5019injusticeMod.queueServerWork((int) wait, () -> {
						TWebShooterRapidWebProcedure.execute(world, x, y, z, entity);
						{
							ItemStack _ist = itemstack;
							if (_ist.hurt(1, RandomSource.create(), null)) {
								_ist.shrink(1);
								_ist.setDamageValue(0);
							}
						}
					});
					wait = wait + 2;
				}
			} else {
				recharge = true;
			}
		} else if (itemstack.getOrCreateTag().getDouble("mode") == 4) {
			if (itemstack.getOrCreateTag().getDouble("webFluid") >= 2) {
				itemstack.getOrCreateTag().putDouble("webFluid", (itemstack.getOrCreateTag().getDouble("webFluid") - 2));
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt(2, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
				itemstack.getOrCreateTag().putDouble("cadency", 8);
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new WebShooterTier1ProjectileEntity(Art5019injusticeModEntities.WEB_SHOOTER_TIER_1_PROJECTILE.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, 0, 3);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 4, (float) 0.6);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			} else {
				recharge = true;
			}
		} else if (itemstack.getOrCreateTag().getDouble("mode") == 5) {
			if (itemstack.getOrCreateTag().getDouble("webFluid") >= 1) {
				itemstack.getOrCreateTag().putDouble("webFluid", (itemstack.getOrCreateTag().getDouble("webFluid") - 1));
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
								AbstractArrow entityToSpawn = new WebShooterElectricWebProjectileEntity(Art5019injusticeModEntities.WEB_SHOOTER_ELECTRIC_WEB_PROJECTILE.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, 0, 0);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 3, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt(3, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
				itemstack.getOrCreateTag().putDouble("cadency", 14);
			} else {
				recharge = true;
			}
		} else {
			recharge = true;
		}
		if (recharge) {
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Art5019injusticeModItems.WEB_CYLINDER.get())) : false) {
				WebShooterRechargeTier2Procedure.execute(world, x, y, z, entity, itemstack);
			} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getOrCreateTag().getDouble("cylinders") >= 1) {
				WebShooterRechargeTier2Procedure.execute(world, x, y, z, entity, itemstack);
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getOrCreateTag().putDouble("cylinders",
						((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getOrCreateTag().getDouble("cylinders") - 1));
			}
		} else {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:spider.shoot")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:spider.shoot")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
	}
}
