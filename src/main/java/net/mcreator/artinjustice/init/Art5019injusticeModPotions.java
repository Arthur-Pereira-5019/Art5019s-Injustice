
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.artinjustice.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.artinjustice.Art5019injusticeMod;

public class Art5019injusticeModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, Art5019injusticeMod.MODID);
	public static final RegistryObject<Potion> SCARECROW_FORMULA = REGISTRY.register("scarecrow_formula", () -> new Potion(new MobEffectInstance(Art5019injusticeModMobEffects.FEAR.get(), 24000, 1, false, false)));
	public static final RegistryObject<Potion> ALLERGY_POTION = REGISTRY.register("allergy_potion", () -> new Potion(new MobEffectInstance(Art5019injusticeModMobEffects.ALLERGY.get(), 3600, 0, false, true)));
	public static final RegistryObject<Potion> HUNGER_POTION = REGISTRY.register("hunger_potion", () -> new Potion(new MobEffectInstance(MobEffects.HUNGER, 900, 0, false, true)));
	public static final RegistryObject<Potion> PHEROMONES_POTION = REGISTRY.register("pheromones_potion",
			() -> new Potion(new MobEffectInstance(Art5019injusticeModMobEffects.PHEROMONES.get(), 1200, 0, false, true), new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 1200, 0, false, true)));
	public static final RegistryObject<Potion> SCARECROW_NIGHTMARE_FORMULA = REGISTRY.register("scarecrow_nightmare_formula", () -> new Potion(new MobEffectInstance(Art5019injusticeModMobEffects.FEAR.get(), 48000, 1, false, false)));
	public static final RegistryObject<Potion> SCARECROW_STRONGER_FORMULA = REGISTRY.register("scarecrow_stronger_formula", () -> new Potion(new MobEffectInstance(Art5019injusticeModMobEffects.FEAR.get(), 12000, 2, false, false)));
}
