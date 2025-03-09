
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.artinjustice.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.artinjustice.client.particle.PuzzleTurnLeftParticleParticle;
import net.mcreator.artinjustice.client.particle.PuzzleInvestigateParticle;
import net.mcreator.artinjustice.client.particle.PuzzleBreakParticleParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class Art5019injusticeModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(Art5019injusticeModParticleTypes.PUZZLE_BREAK_PARTICLE.get(), PuzzleBreakParticleParticle::provider);
		event.registerSpriteSet(Art5019injusticeModParticleTypes.PUZZLE_TURN_LEFT_PARTICLE.get(), PuzzleTurnLeftParticleParticle::provider);
		event.registerSpriteSet(Art5019injusticeModParticleTypes.PUZZLE_INVESTIGATE.get(), PuzzleInvestigateParticle::provider);
	}
}
