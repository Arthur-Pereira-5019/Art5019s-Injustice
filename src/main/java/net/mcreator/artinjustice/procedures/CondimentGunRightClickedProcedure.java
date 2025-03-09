package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;
import net.mcreator.artinjustice.init.Art5019injusticeModEntities;
import net.mcreator.artinjustice.entity.VinegarShotProjectileEntity;
import net.mcreator.artinjustice.entity.PepperShotProjectileEntity;
import net.mcreator.artinjustice.entity.MustardShotProjectileEntity;
import net.mcreator.artinjustice.entity.MayoShotProjectileEntity;
import net.mcreator.artinjustice.entity.KetchupShotProjectileEntity;

public class CondimentGunRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean works = false;
		if (itemstack.getOrCreateTag().getDouble("cadency") == 0) {
			if (itemstack.getOrCreateTag().getDouble("shots") >= 1) {
				if (itemstack.getOrCreateTag().getDouble("sauce") == 1) {
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, float damage, int knockback) {
									AbstractArrow entityToSpawn = new MayoShotProjectileEntity(Art5019injusticeModEntities.MAYO_SHOT_PROJECTILE.get(), level);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, 0, 1);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 2, (float) 0.7);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
				} else if (itemstack.getOrCreateTag().getDouble("sauce") == 2) {
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, float damage, int knockback) {
									AbstractArrow entityToSpawn = new PepperShotProjectileEntity(Art5019injusticeModEntities.PEPPER_SHOT_PROJECTILE.get(), level);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, 0, 1);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 2, (float) 0.7);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
				} else if (itemstack.getOrCreateTag().getDouble("sauce") == 3) {
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, float damage, int knockback) {
									AbstractArrow entityToSpawn = new MustardShotProjectileEntity(Art5019injusticeModEntities.MUSTARD_SHOT_PROJECTILE.get(), level);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, 0, 1);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 2, (float) 0.7);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
				} else if (itemstack.getOrCreateTag().getDouble("sauce") == 4) {
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, float damage, int knockback) {
									AbstractArrow entityToSpawn = new KetchupShotProjectileEntity(Art5019injusticeModEntities.KETCHUP_SHOT_PROJECTILE.get(), level);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, 0, 1);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 2, (float) 0.7);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
				} else if (itemstack.getOrCreateTag().getDouble("sauce") == 5) {
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, float damage, int knockback) {
									AbstractArrow entityToSpawn = new VinegarShotProjectileEntity(Art5019injusticeModEntities.VINEGAR_SHOT_PROJECTILE.get(), level);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, 0, 1);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 2, (float) 0.7);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
				}
				if (Math.random() < 0.1 && (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.CONDIMENT_KING_SUIT_BOOTS.get()
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.CONDIMENT_KING_SUIT_LEGGINGS.get()
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.CONDIMENT_KING_SUIT_CHESTPLATE.get()
						&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.CONDIMENT_KING_SUIT_HELMET.get()) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 1, 0, false, false));
				}
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt(1, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.honey_block.place")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.honey_block.place")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				itemstack.getOrCreateTag().putDouble("shots", (itemstack.getOrCreateTag().getDouble("shots") - 1));
				itemstack.getOrCreateTag().putDouble("cadency", 30);
			} else {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.MAYO_FLASK.get()) {
					itemstack.getOrCreateTag().putDouble("shots", 18);
					itemstack.getOrCreateTag().putDouble("sauce", 1);
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.MAYO_FLASK.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.PEPPER_SAUCE_FLASK.get()) {
					itemstack.getOrCreateTag().putDouble("shots", 8);
					itemstack.getOrCreateTag().putDouble("sauce", 2);
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.PEPPER_SAUCE_FLASK.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.MUSTARD_GAS_BOMB.get()) {
					itemstack.getOrCreateTag().putDouble("shots", 26);
					itemstack.getOrCreateTag().putDouble("sauce", 3);
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.MUSTARD_GAS_BOMB.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.KETCHUP_FLASK.get()) {
					itemstack.getOrCreateTag().putDouble("shots", 26);
					itemstack.getOrCreateTag().putDouble("sauce", 4);
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.KETCHUP_FLASK.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.VINEGAR_FLASK.get()) {
					itemstack.getOrCreateTag().putDouble("shots", 18);
					itemstack.getOrCreateTag().putDouble("sauce", 5);
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.VINEGAR_FLASK.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				} else {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.MAYO_FLASK.get()) {
						itemstack.getOrCreateTag().putDouble("shots", 18);
						itemstack.getOrCreateTag().putDouble("sauce", 1);
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.MAYO_FLASK.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.PEPPER_SAUCE_FLASK.get()) {
						itemstack.getOrCreateTag().putDouble("shots", 8);
						itemstack.getOrCreateTag().putDouble("sauce", 2);
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.PEPPER_SAUCE_FLASK.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.MUSTARD_GAS_BOMB.get()) {
						itemstack.getOrCreateTag().putDouble("shots", 26);
						itemstack.getOrCreateTag().putDouble("sauce", 3);
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.MUSTARD_GAS_BOMB.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.KETCHUP_FLASK.get()) {
						itemstack.getOrCreateTag().putDouble("shots", 26);
						itemstack.getOrCreateTag().putDouble("sauce", 4);
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.KETCHUP_FLASK.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.VINEGAR_FLASK.get()) {
						itemstack.getOrCreateTag().putDouble("shots", 18);
						itemstack.getOrCreateTag().putDouble("sauce", 5);
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.VINEGAR_FLASK.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					} else {
						if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Art5019injusticeModItems.MAYO_FLASK.get())) : false) {
							itemstack.getOrCreateTag().putDouble("shots", 18);
							itemstack.getOrCreateTag().putDouble("sauce", 1);
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.MAYO_FLASK.get());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
							}
						} else if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Art5019injusticeModItems.PEPPER_SAUCE_FLASK.get())) : false) {
							itemstack.getOrCreateTag().putDouble("shots", 8);
							itemstack.getOrCreateTag().putDouble("sauce", 2);
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.PEPPER_SAUCE_FLASK.get());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
							}
						} else if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Art5019injusticeModItems.MUSTARD_GAS_BOMB.get())) : false) {
							itemstack.getOrCreateTag().putDouble("shots", 26);
							itemstack.getOrCreateTag().putDouble("sauce", 3);
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.MUSTARD_GAS_BOMB.get());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
							}
						} else if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Art5019injusticeModItems.KETCHUP_FLASK.get())) : false) {
							itemstack.getOrCreateTag().putDouble("shots", 26);
							itemstack.getOrCreateTag().putDouble("sauce", 4);
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.KETCHUP_FLASK.get());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
							}
						} else if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Art5019injusticeModItems.VINEGAR_FLASK.get())) : false) {
							itemstack.getOrCreateTag().putDouble("shots", 18);
							itemstack.getOrCreateTag().putDouble("sauce", 5);
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.VINEGAR_FLASK.get());
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
							}
						} else {
							works = true;
						}
					}
				}
				if (works == false) {
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(Items.GLASS_BOTTLE).copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
			}
		}
	}
}
