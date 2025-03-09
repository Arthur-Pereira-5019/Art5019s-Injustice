package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;
import net.mcreator.artinjustice.init.Art5019injusticeModEntities;
import net.mcreator.artinjustice.entity.PistolProjectileEntity;
import net.mcreator.artinjustice.entity.KryptonitePistolProjectileEntity;
import net.mcreator.artinjustice.Art5019injusticeMod;

public class GenericShotProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack, double power) {
		if (entity == null)
			return;
		double soundid = 0;
		boolean couldupgrade = false;
		if ((itemstack.getOrCreateTag().getString("upgrade")).equals("")) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.PISTOL_STABILIZER_UPGRADE.get()) {
				couldupgrade = true;
				Art5019injusticeMod.queueServerWork(4, () -> {
					itemstack.getOrCreateTag().putString("upgrade", "stabilizer");
				});
			}
		}
		if ((itemstack.getOrCreateTag().getString("upgrade2")).equals("")) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.PISTOL_UPGRADE_SILENCER.get()) {
				Art5019injusticeMod.queueServerWork(4, () -> {
					itemstack.getOrCreateTag().putString("upgrade2", "silencer");
				});
				couldupgrade = true;
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Art5019injusticeModItems.PISTOL_UPGRADE_GOLDEN_SKIN.get()) {
				Art5019injusticeMod.queueServerWork(4, () -> {
					itemstack.getOrCreateTag().putString("upgrade2", "goldskin");
				});
				couldupgrade = true;
			}
		}
		if (!couldupgrade) {
			if (itemstack.getOrCreateTag().getDouble("cadency") == 0) {
				if (itemstack.getOrCreateTag().getDouble("ammo") == 0) {
					if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Art5019injusticeModItems.KRYPTONITE_MAGAZINE.get())) : false) {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.KRYPTONITE_MAGAZINE.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
						itemstack.getOrCreateTag().putDouble("ammo", 20);
						itemstack.getOrCreateTag().putDouble("ammoType", 1);
						soundid = 0;
					} else if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Art5019injusticeModItems.PISTOL_MAGAZINE.get())) : false) {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Art5019injusticeModItems.PISTOL_MAGAZINE.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
						itemstack.getOrCreateTag().putDouble("ammo", 20);
						itemstack.getOrCreateTag().putDouble("ammoType", 0);
						soundid = 0;
					} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getOrCreateTag().getDouble("magazines") >= 1) {
						(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getOrCreateTag().putDouble("magazines",
								((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getOrCreateTag().getDouble("magazines") - 1));
						itemstack.getOrCreateTag().putDouble("ammo", 20);
						soundid = 0;
					} else {
						soundid = 1;
					}
				} else {
					itemstack.getOrCreateTag().putDouble("ammo", (itemstack.getOrCreateTag().getDouble("ammo") - 1));
					itemstack.getOrCreateTag().putDouble("cadency", 35);
					{
						ItemStack _ist = itemstack;
						if (_ist.hurt(1, RandomSource.create(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
					if (itemstack.getOrCreateTag().getDouble("ammoType") == 0) {
						if (!(itemstack.getOrCreateTag().getString("upgrade")).equals("stabilizer")) {
							{
								Entity _shootFrom = entity;
								Level projectileLevel = _shootFrom.level();
								if (!projectileLevel.isClientSide()) {
									Projectile _entityToSpawn = new Object() {
										public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
											AbstractArrow entityToSpawn = new PistolProjectileEntity(Art5019injusticeModEntities.PISTOL_PROJECTILE.get(), level);
											entityToSpawn.setOwner(shooter);
											entityToSpawn.setBaseDamage(damage);
											entityToSpawn.setKnockback(knockback);
											entityToSpawn.setSilent(true);
											entityToSpawn.setPierceLevel(piercing);
											return entityToSpawn;
										}
									}.getArrow(projectileLevel, entity, 1, 0, (byte) 0.5);
									_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
									_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, (float) (5.4 * power), (float) 0.25);
									projectileLevel.addFreshEntity(_entityToSpawn);
								}
							}
							{
								Entity _ent = entity;
								_ent.setYRot((float) (entity.getYRot() + Mth.nextDouble(RandomSource.create(), -1, 1)));
								_ent.setXRot((float) (entity.getXRot() - Mth.nextDouble(RandomSource.create(), 3, 12)));
								_ent.setYBodyRot(_ent.getYRot());
								_ent.setYHeadRot(_ent.getYRot());
								_ent.yRotO = _ent.getYRot();
								_ent.xRotO = _ent.getXRot();
								if (_ent instanceof LivingEntity _entity) {
									_entity.yBodyRotO = _entity.getYRot();
									_entity.yHeadRotO = _entity.getYRot();
								}
							}
						} else {
							{
								Entity _shootFrom = entity;
								Level projectileLevel = _shootFrom.level();
								if (!projectileLevel.isClientSide()) {
									Projectile _entityToSpawn = new Object() {
										public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
											AbstractArrow entityToSpawn = new PistolProjectileEntity(Art5019injusticeModEntities.PISTOL_PROJECTILE.get(), level);
											entityToSpawn.setOwner(shooter);
											entityToSpawn.setBaseDamage(damage);
											entityToSpawn.setKnockback(knockback);
											entityToSpawn.setSilent(true);
											entityToSpawn.setPierceLevel(piercing);
											return entityToSpawn;
										}
									}.getArrow(projectileLevel, entity, 1, 0, (byte) 0.5);
									_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
									_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, (float) (5.4 * power), 0);
									projectileLevel.addFreshEntity(_entityToSpawn);
								}
							}
						}
					} else if (itemstack.getOrCreateTag().getDouble("ammoType") == 1) {
						if (!(itemstack.getOrCreateTag().getString("upgrade")).equals("stabilizer")) {
							{
								Entity _shootFrom = entity;
								Level projectileLevel = _shootFrom.level();
								if (!projectileLevel.isClientSide()) {
									Projectile _entityToSpawn = new Object() {
										public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
											AbstractArrow entityToSpawn = new KryptonitePistolProjectileEntity(Art5019injusticeModEntities.KRYPTONITE_PISTOL_PROJECTILE.get(), level);
											entityToSpawn.setOwner(shooter);
											entityToSpawn.setBaseDamage(damage);
											entityToSpawn.setKnockback(knockback);
											entityToSpawn.setSilent(true);
											entityToSpawn.setPierceLevel(piercing);
											return entityToSpawn;
										}
									}.getArrow(projectileLevel, entity, 1, 0, (byte) 0.5);
									_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
									_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, (float) (5.4 * power), (float) 0.25);
									projectileLevel.addFreshEntity(_entityToSpawn);
								}
							}
							{
								Entity _ent = entity;
								_ent.setYRot((float) (entity.getYRot() + Mth.nextDouble(RandomSource.create(), -1, 1)));
								_ent.setXRot((float) (entity.getXRot() - Mth.nextDouble(RandomSource.create(), 3, 12)));
								_ent.setYBodyRot(_ent.getYRot());
								_ent.setYHeadRot(_ent.getYRot());
								_ent.yRotO = _ent.getYRot();
								_ent.xRotO = _ent.getXRot();
								if (_ent instanceof LivingEntity _entity) {
									_entity.yBodyRotO = _entity.getYRot();
									_entity.yHeadRotO = _entity.getYRot();
								}
							}
						} else {
							{
								Entity _shootFrom = entity;
								Level projectileLevel = _shootFrom.level();
								if (!projectileLevel.isClientSide()) {
									Projectile _entityToSpawn = new Object() {
										public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
											AbstractArrow entityToSpawn = new KryptonitePistolProjectileEntity(Art5019injusticeModEntities.KRYPTONITE_PISTOL_PROJECTILE.get(), level);
											entityToSpawn.setOwner(shooter);
											entityToSpawn.setBaseDamage(damage);
											entityToSpawn.setKnockback(knockback);
											entityToSpawn.setSilent(true);
											entityToSpawn.setPierceLevel(piercing);
											return entityToSpawn;
										}
									}.getArrow(projectileLevel, entity, 1, 0, (byte) 0.5);
									_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
									_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, (float) (5.4 * power), 0);
									projectileLevel.addFreshEntity(_entityToSpawn);
								}
							}
						}
					}
					if ((itemstack.getOrCreateTag().getString("upgrade2")).equals("goldskin")) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.END_ROD, x, (y + 1.65), z, 20, 0.4, 0.4, 0.4, 0.2);
						soundid = 4;
					} else {
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SMOKE, x, (y + 1.65), z, 20, 0.4, 0.4, 0.4, 0.2);
						soundid = 2;
					}
				}
			} else {
				soundid = 3;
			}
		} else {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			soundid = 0;
		}
		if (!(itemstack.getOrCreateTag().getString("upgrade2")).equals("silencer")) {
			if (world.isClientSide()) {
				if (soundid == 0) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:item.pistol.reload")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:item.pistol.reload")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
				} else if (soundid == 1) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.dispenser.fail")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.dispenser.fail")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
				} else if (soundid == 2) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:item.pistol.shoots")), SoundSource.PLAYERS, (float) 0.9, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:item.pistol.shoots")), SoundSource.PLAYERS, (float) 0.9, 1, false);
						}
					}
				} else if (soundid == 4) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bell.use")), SoundSource.PLAYERS, 1, (float) 1.6);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.bell.use")), SoundSource.PLAYERS, 1, (float) 1.6, false);
						}
					}
				}
			}
		}
	}
}
