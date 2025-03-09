package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.init.Art5019injusticeModEntities;
import net.mcreator.artinjustice.Art5019injusticeMod;

public class CellPhoneCallToBigCenterProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double probs = 0;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:item.cellphone.call")), SoundSource.NEUTRAL, (float) 0.5, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:item.cellphone.call")), SoundSource.NEUTRAL, (float) 0.5, 1, false);
			}
		}
		if (entity instanceof ServerPlayer _plr1 && _plr1.level() instanceof ServerLevel
				&& _plr1.getAdvancements().getOrStartProgress(_plr1.server.getAdvancements().getAdvancement(new ResourceLocation("art5019injustice:defeat_stormfront"))).isDone()) {
			Art5019injusticeMod.queueServerWork(260, () -> {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<Unknown Voice> Sending Help..."), false);
				Art5019injusticeMod.queueServerWork(20, () -> {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Red Skull> Not this time."), false);
				});
				Art5019injusticeMod.queueServerWork(170, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:item.spacestone.portal")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("art5019injustice:item.spacestone.portal")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
				});
				Art5019injusticeMod.queueServerWork(300, () -> {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = Art5019injusticeModEntities.RED_SKULL.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
						}
					}
				});
			});
		} else {
			Art5019injusticeMod.queueServerWork(260, () -> {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("<Unknown Voice> Sending Help..."), false);
				Art5019injusticeMod.queueServerWork(20, () -> {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Second Unknown Voice> WIE KANN EIN VERDAMMTER SPEEDSTER SO SP\u00C4T KOMMEN?! WE WERE SUPOSED TO BE BURNING THAT SCHWEINESTALL BY NOW!"), false);
				});
				Art5019injusticeMod.queueServerWork(55, () -> {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Second Unknown Voice> Give that to me! Is that important?!"), false);
				});
				Art5019injusticeMod.queueServerWork(90, () -> {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Unknown Voice> No, no, almighty supreme ruler of the gods of pureness Stormfront... it's just some random soldier asking for supriments!"), false);
				});
				Art5019injusticeMod.queueServerWork(150, () -> {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("<Stormfront> Huh... Since Allen is late, I'll help that poor krieger myself."), false);
				});
				Art5019injusticeMod.queueServerWork(260, () -> {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = Art5019injusticeModEntities.STORMFRONT.get().spawn(_level, BlockPos.containing(x, y + 18, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
						}
					}
				});
			});
		}
	}
}
