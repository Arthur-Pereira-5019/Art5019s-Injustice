package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;
import net.mcreator.artinjustice.init.Art5019injusticeModEntities;
import net.mcreator.artinjustice.entity.KryptoTheSuperdogEntity;

import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;

public class SupersonicWhistleRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double rx = 0;
		double ry = 0;
		double rz = 0;
		double iteration = 0;
		boolean sucess = false;
		boolean found = false;
		if (!(entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem()))
				&& (entity.getCapability(Art5019injusticeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new Art5019injusticeModVariables.PlayerVariables())).powerid == 23) {
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if (HaveSuperHearingProcedure.execute(entityiterator)) {
					PlaysoundManagerProcedure.execute(entityiterator, "1", "art5019injustice:entity.superman.whistle", "player", "4");
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(120 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof KryptoTheSuperdogEntity) {
						found = true;
						if (entityiterator instanceof Mob _entity && entity instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
						if (entity instanceof Player _player)
							_player.getCooldowns().addCooldown(itemstack.getItem(), 400);
					}
				}
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 220);
			if (entity instanceof ServerPlayer _plr10 && _plr10.level() instanceof ServerLevel
					&& _plr10.getAdvancements().getOrStartProgress(_plr10.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:aliens_best_friend"))).isDone() && !found) {
				if (Math.random() < 0.4) {
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(itemstack.getItem(), 400);
					while (iteration <= 15 && sucess == false) {
						ry = Mth.nextInt(RandomSource.create(), 0, 6) + y;
						rz = Mth.nextInt(RandomSource.create(), -10, 10) + z;
						rx = Mth.nextInt(RandomSource.create(), -10, 10) + x;
						if (!world.getBlockState(BlockPos.containing(rx, ry, rz)).canOcclude() && !world.getBlockState(BlockPos.containing(rx, ry + 1, rz)).canOcclude()) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = Art5019injusticeModEntities.KRYPTO_THE_SUPERDOG.get().spawn(_level, BlockPos.containing(rx, ry, rz), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
							sucess = true;
						} else {
							iteration = iteration + 1;
						}
					}
				}
			}
			if (!world.isClientSide()) {
				if (Math.random() < 0.25) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.break")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					GenerateBlockyParticlesProcedure.execute(world, x, 1.65 + y, z, "red_terracota", "60", "0.5", "0.5", "0.5", "0.75");
					GenerateBlockyParticlesProcedure.execute(world, x, 1.65 + y, z, "white_terracota", "60", "0.5", "0.5", "0.5", "0.75");
				}
			}
		}
	}
}
