package net.mcreator.artinjustice.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

public class MetalloEntityIsHurtProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource) {
		if (damagesource == null)
			return false;
		if (damagesource.is(DamageTypes.FREEZE) || damagesource.is(DamageTypes.CRAMMING) || damagesource.is(DamageTypes.IN_WALL)) {
			return false;
		} else if (damagesource.is(DamageTypes.MOB_ATTACK) || damagesource.is(DamageTypes.PLAYER_ATTACK)) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.attack_iron_door")), SoundSource.HOSTILE, (float) 0.35, (float) 0.7);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.attack_iron_door")), SoundSource.HOSTILE, (float) 0.35, (float) 0.7, false);
				}
			}
		} else if (damagesource.is(DamageTypes.GENERIC)) {
			return true;
		} else if (damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("art5019injustice:vibranium_blockable")))) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.HOSTILE, (float) 0.7, (float) 1.85);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.HOSTILE, (float) 0.7, (float) 1.85, false);
				}
			}
		}
		return true;
	}
}
