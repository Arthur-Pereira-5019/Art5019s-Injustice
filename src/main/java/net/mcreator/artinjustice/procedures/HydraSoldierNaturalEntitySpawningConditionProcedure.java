package net.mcreator.artinjustice.procedures;

import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.artinjustice.network.Art5019injusticeModVariables;

public class HydraSoldierNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world) {
		if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == Level.OVERWORLD && Art5019injusticeModVariables.MapVariables.get(world).event_id == 1) {
			return true;
		} else if ((world instanceof Level _lvl ? _lvl.dimension() : (world instanceof WorldGenLevel _wgl ? _wgl.getLevel().dimension() : Level.OVERWORLD)) == ResourceKey.create(Registries.DIMENSION,
				new ResourceLocation("art5019injustice:earth_x"))) {
			return true;
		}
		return false;
	}
}
