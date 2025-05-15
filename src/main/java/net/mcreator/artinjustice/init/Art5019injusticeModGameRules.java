
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.artinjustice.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Art5019injusticeModGameRules {
	public static final GameRules.Key<GameRules.IntegerValue> ART_5019_SUPERMAN_NETHER_STAR_ABSORPTION = GameRules.register("art5019SupermanNetherStarAbsorption", GameRules.Category.PLAYER, GameRules.IntegerValue.create(9000));
	public static final GameRules.Key<GameRules.IntegerValue> CRIMINALITY_EVENT_CHANGE_PERCENTAGE = GameRules.register("criminalityEventChangePercentage", GameRules.Category.PLAYER, GameRules.IntegerValue.create(100));
	public static final GameRules.Key<GameRules.BooleanValue> ART_5019S_DO_DISEASES_APPEAR_NATURALLY = GameRules.register("art5019sDoDiseasesAppearNaturally", GameRules.Category.MISC, GameRules.BooleanValue.create(true));
}
