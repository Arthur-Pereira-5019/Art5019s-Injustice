package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.artinjustice.entity.VenomBossEntity;

public class VenomBossOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if (!(entity instanceof VenomBossEntity _datEntL2 && _datEntL2.getEntityData().get(VenomBossEntity.DATA_alreadyDefeated))) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.roar")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (entity instanceof VenomBossEntity _datEntSetL)
					_datEntSetL.getEntityData().set(VenomBossEntity.DATA_alreadyDefeated, true);
			}
			if ((entity instanceof VenomBossEntity _datEntI ? _datEntI.getEntityData().get(VenomBossEntity.DATA_nextAttack) : 0) <= 0) {
				VenomVenomousBiteProcedure.execute(world, x, y, z, entity, 3);
				if (entity instanceof VenomBossEntity _datEntSetI)
					_datEntSetI.getEntityData().set(VenomBossEntity.DATA_nextAttack, 300);
			} else if ((entity instanceof VenomBossEntity _datEntI ? _datEntI.getEntityData().get(VenomBossEntity.DATA_nextAttack) : 0) == 150) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.angry")), SoundSource.HOSTILE, 1, (float) 1.4);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.angry")), SoundSource.HOSTILE, 1, (float) 1.4, false);
					}
				}
			}
			if (entity instanceof VenomBossEntity _datEntSetI)
				_datEntSetI.getEntityData().set(VenomBossEntity.DATA_nextAttack, (int) ((entity instanceof VenomBossEntity _datEntI ? _datEntI.getEntityData().get(VenomBossEntity.DATA_nextAttack) : 0) - 1));
		}
	}
}
