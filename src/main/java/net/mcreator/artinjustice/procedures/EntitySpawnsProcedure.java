package net.mcreator.artinjustice.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Drowned;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EntitySpawnsProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Drowned && world.getBiome(BlockPos.containing(x, y, z)).is(TagKey.create(Registries.BIOME, new ResourceLocation("minecraft:is_deep_ocean")))) {
			if (Math.random() < 0.3) {
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(0, new ItemStack(Art5019injusticeModItems.ATLANTEAN_ARMOR_BOOTS.get()));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Art5019injusticeModItems.ATLANTEAN_ARMOR_BOOTS.get()));
					}
				}
				if (Math.random() < 0.3) {
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(0, (EnchantmentHelper.enchantItem(RandomSource.create(), new ItemStack(Art5019injusticeModItems.ATLANTEAN_ARMOR_BOOTS.get()), 10, false)));
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.FEET, (EnchantmentHelper.enchantItem(RandomSource.create(), new ItemStack(Art5019injusticeModItems.ATLANTEAN_ARMOR_BOOTS.get()), 10, false)));
						}
					}
				}
			}
			if (Math.random() < 0.3) {
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(1, new ItemStack(Art5019injusticeModItems.ATLANTEAN_ARMOR_LEGGINGS.get()));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Art5019injusticeModItems.ATLANTEAN_ARMOR_LEGGINGS.get()));
					}
				}
				if (Math.random() < 0.3) {
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(1, (EnchantmentHelper.enchantItem(RandomSource.create(), new ItemStack(Art5019injusticeModItems.ATLANTEAN_ARMOR_LEGGINGS.get()), 10, false)));
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.LEGS, (EnchantmentHelper.enchantItem(RandomSource.create(), new ItemStack(Art5019injusticeModItems.ATLANTEAN_ARMOR_LEGGINGS.get()), 10, false)));
						}
					}
				}
			}
			if (Math.random() < 0.3) {
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(2, new ItemStack(Art5019injusticeModItems.ATLANTEAN_ARMOR_CHESTPLATE.get()));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Art5019injusticeModItems.ATLANTEAN_ARMOR_CHESTPLATE.get()));
					}
				}
				if (Math.random() < 0.3) {
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(2, (EnchantmentHelper.enchantItem(RandomSource.create(), new ItemStack(Art5019injusticeModItems.ATLANTEAN_ARMOR_CHESTPLATE.get()), 10, false)));
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.CHEST, (EnchantmentHelper.enchantItem(RandomSource.create(), new ItemStack(Art5019injusticeModItems.ATLANTEAN_ARMOR_CHESTPLATE.get()), 10, false)));
						}
					}
				}
			}
		}
		if (entity instanceof Zombie && (entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("art5019injustice:earth_x"))) {
			if (Math.random() < 0.2) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.PILLAGER.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setDeltaMovement(0, 0, 0);
					}
				}
			}
		} else if (entity instanceof Creeper && (entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("art5019injustice:earth_x"))) {
			if (Math.random() < 0.2) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.VINDICATOR.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setDeltaMovement(0, 0, 0);
					}
				}
			}
		} else if (entity instanceof Skeleton && (entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("art5019injustice:earth_x"))) {
			if (Math.random() < 0.2) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.PILLAGER.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setDeltaMovement(0, 0, 0);
					}
				}
			}
		}
	}
}
