package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

public class IsSunExposedProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z)) && world instanceof Level _lvl1 && _lvl1.isDay()
				&& ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.OVERWORLD
						|| (world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == ResourceKey.create(Registries.DIMENSION,
								new ResourceLocation("art5019injustice:earth_x")))) {
			return true;
		}
		return false;
	}
}
