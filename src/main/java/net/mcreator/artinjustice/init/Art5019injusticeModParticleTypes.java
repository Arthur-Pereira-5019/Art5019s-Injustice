
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.artinjustice.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.artinjustice.Art5019injusticeMod;

public class Art5019injusticeModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Art5019injusticeMod.MODID);
	public static final RegistryObject<SimpleParticleType> PUZZLE_BREAK_PARTICLE = REGISTRY.register("puzzle_break_particle", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> PUZZLE_TURN_LEFT_PARTICLE = REGISTRY.register("puzzle_turn_left_particle", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> PUZZLE_INVESTIGATE = REGISTRY.register("puzzle_investigate", () -> new SimpleParticleType(true));
}
