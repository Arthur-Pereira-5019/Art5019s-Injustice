package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.init.Art5019injusticeModEntities;
import net.mcreator.artinjustice.init.Art5019injusticeModBlocks;
import net.mcreator.artinjustice.entity.OrchidZombieEntity;
import net.mcreator.artinjustice.Art5019injusticeMod;

import java.util.Comparator;

public class SuperFertilizerOrchidEffectProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double id = 0;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.BLUE_ORCHID) {
			id = 1;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Art5019injusticeModBlocks.WINE_ORCHID.get()) {
			id = 2;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Art5019injusticeModBlocks.YELLOW_CATTLEYA.get()) {
			id = 3;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Art5019injusticeModBlocks.WHITE_ORCHID.get()) {
			id = 4;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Art5019injusticeModBlocks.LILAC_CATTLEYA.get()) {
			id = 5;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Art5019injusticeModBlocks.PURPLE_ORCHID.get()) {
			id = 6;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Art5019injusticeModBlocks.RAINBOW_ORCHID.get()) {
			id = 7;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Art5019injusticeModBlocks.STARRY_ORCHID.get()) {
			id = 8;
		} else {
			id = 0;
		}
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = Art5019injusticeModEntities.ORCHID_ZOMBIE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
			}
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bone_meal.use")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bone_meal.use")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
		world.destroyBlock(BlockPos.containing(x, y, z), false);
		if (((Entity) world.getEntitiesOfClass(OrchidZombieEntity.class, AABB.ofSize(new Vec3(x, y, z), 2, 2, 2), e -> true).stream().sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
			}
		}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof OrchidZombieEntity _datEntSetI)
			_datEntSetI.getEntityData().set(OrchidZombieEntity.DATA_orchidcolor, (int) id);
		Art5019injusticeMod.queueServerWork(3, () -> {
			if (((Entity) world.getEntitiesOfClass(OrchidZombieEntity.class, AABB.ofSize(new Vec3(x, y, z), 3, 3, 3), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof TamableAnimal _toTame && entity instanceof Player _owner)
				_toTame.tame(_owner);
		});
	}
}
