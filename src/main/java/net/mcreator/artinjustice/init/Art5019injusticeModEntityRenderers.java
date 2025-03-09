
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.artinjustice.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.artinjustice.client.renderer.VoughtExecutiveRenderer;
import net.mcreator.artinjustice.client.renderer.VibraniumSilverfishRenderer;
import net.mcreator.artinjustice.client.renderer.VenomBossRenderer;
import net.mcreator.artinjustice.client.renderer.UncleSamRenderer;
import net.mcreator.artinjustice.client.renderer.TheNightmareRenderer;
import net.mcreator.artinjustice.client.renderer.TheNightmareCloneRenderer;
import net.mcreator.artinjustice.client.renderer.TestDummyRenderer;
import net.mcreator.artinjustice.client.renderer.TaskMasterRenderer;
import net.mcreator.artinjustice.client.renderer.StormfrontRenderer;
import net.mcreator.artinjustice.client.renderer.StanTheLegendRenderer;
import net.mcreator.artinjustice.client.renderer.SpecialSpiderRenderer;
import net.mcreator.artinjustice.client.renderer.ShadowsRenderer;
import net.mcreator.artinjustice.client.renderer.ShadowsRangeRenderer;
import net.mcreator.artinjustice.client.renderer.ScopoRenderer;
import net.mcreator.artinjustice.client.renderer.ScarecrowIRenderer;
import net.mcreator.artinjustice.client.renderer.ScarecrowIIRenderer;
import net.mcreator.artinjustice.client.renderer.RedSkullRenderer;
import net.mcreator.artinjustice.client.renderer.PlagueZombieRenderer;
import net.mcreator.artinjustice.client.renderer.PhonePillagerRenderer;
import net.mcreator.artinjustice.client.renderer.OrchidZombieRenderer;
import net.mcreator.artinjustice.client.renderer.NightmareSpiderRenderer;
import net.mcreator.artinjustice.client.renderer.NightmareRenderer;
import net.mcreator.artinjustice.client.renderer.MrNegativeRenderer;
import net.mcreator.artinjustice.client.renderer.MrNegativeOffRenderer;
import net.mcreator.artinjustice.client.renderer.MetalloRenderer;
import net.mcreator.artinjustice.client.renderer.MayParkerRenderer;
import net.mcreator.artinjustice.client.renderer.MartinLiRenderer;
import net.mcreator.artinjustice.client.renderer.LokiCloneRenderer;
import net.mcreator.artinjustice.client.renderer.LokiBossRenderer;
import net.mcreator.artinjustice.client.renderer.KryptoniteSilverfishRenderer;
import net.mcreator.artinjustice.client.renderer.KryptoniteGrenadeThrownRenderer;
import net.mcreator.artinjustice.client.renderer.KaleTheCaretakerRenderer;
import net.mcreator.artinjustice.client.renderer.HydraSoldierRenderer;
import net.mcreator.artinjustice.client.renderer.HydraSniperRenderer;
import net.mcreator.artinjustice.client.renderer.GrenadeThrownRenderer;
import net.mcreator.artinjustice.client.renderer.FlashGrenadeThrownRenderer;
import net.mcreator.artinjustice.client.renderer.FeastNPCRenderer;
import net.mcreator.artinjustice.client.renderer.EyesMutantRenderer;
import net.mcreator.artinjustice.client.renderer.EshuRenderer;
import net.mcreator.artinjustice.client.renderer.ElectricGrenadeThrownRenderer;
import net.mcreator.artinjustice.client.renderer.DeathstrokeRenderer;
import net.mcreator.artinjustice.client.renderer.CriminalRenderer;
import net.mcreator.artinjustice.client.renderer.ChrisTheMusicianRenderer;
import net.mcreator.artinjustice.client.renderer.BlietzKriegRenderer;
import net.mcreator.artinjustice.client.renderer.AtlanteanZombieRenderer;
import net.mcreator.artinjustice.client.renderer.ArtTheUnemployedRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class Art5019injusticeModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(Art5019injusticeModEntities.TASK_MASTER.get(), TaskMasterRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.DEATHSTROKE.get(), DeathstrokeRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.SHADOWS.get(), ShadowsRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.NIGHTMARE.get(), NightmareRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.NIGHTMARE_SPIDER.get(), NightmareSpiderRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.SPECIAL_SPIDER.get(), SpecialSpiderRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.SCARECROW_I.get(), ScarecrowIRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.SHADOWS_RANGE.get(), ShadowsRangeRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.LOKI_BOSS.get(), LokiBossRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.LOKI_CLONE.get(), LokiCloneRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.ATLANTEAN_ZOMBIE.get(), AtlanteanZombieRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.WEB_SHOOTER_TIER_1_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.WEB_SHOOTER_TIER_1M_2_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.PISTOL_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.SCARAB_CANNON_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.RANGED_WEB_GRENADE_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.WEB_SHOOTER_ELECTRIC_WEB_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.INSTA_KILL_SHOOT_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.INSTA_KILL_ELECTRICAL_WEB_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.SHURIKENS_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.SMOKE_BOMB_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.SCARAB_ENERGY_BLASTER_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.CAPTAIN_AMERICA_SHIELD_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.VIBRANIUM_SHIELD_THROWN_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.CAPTAIN_CARTER_SHIELD_THROWN_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.MUSTARD_GAS_BOMB_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.MAYO_SHOT_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.KETCHUP_SHOT_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.VINEGAR_SHOT_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.PEPPER_SHOT_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.MUSTARD_SHOT_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.MISSILE_RANGED_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.RED_SKULL.get(), RedSkullRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.TEST_DUMMY.get(), TestDummyRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.PHONE_PILLAGER.get(), PhonePillagerRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.BLIETZ_KRIEG.get(), BlietzKriegRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.PISTOL_MOBS.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.HYDRA_SOLDIER.get(), HydraSoldierRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.GRENADE_THROWN.get(), GrenadeThrownRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.ELECTRIC_GRENADE_THROWN.get(), ElectricGrenadeThrownRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.MOLOTOV_THROWN.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.ALCOHOL_SHOOT.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.FLASH_GRENADE_THROWN.get(), FlashGrenadeThrownRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.HEAVY_MISSILE_RANGED_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.STORMFRONT.get(), StormfrontRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.EYES_MUTANT.get(), EyesMutantRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.VOUGHT_EXECUTIVE.get(), VoughtExecutiveRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.UNCLE_SAM.get(), UncleSamRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.SUNFLOWER_SEED.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.ORCHID_ZOMBIE.get(), OrchidZombieRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.HYDRA_SNIPER.get(), HydraSniperRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.SNIPER_MOBS.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.VIBRANIUM_SILVERFISH.get(), VibraniumSilverfishRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.KRYPTONITE_SILVERFISH.get(), KryptoniteSilverfishRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.THE_NIGHTMARE.get(), TheNightmareRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.THE_NIGHTMARE_CLONE.get(), TheNightmareCloneRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.SCOPO.get(), ScopoRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.ESHU.get(), EshuRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.VENOM_BOSS.get(), VenomBossRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.METALLO.get(), MetalloRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.KRYPTONITE_PISTOL_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.KRYPTONITE_PISTOL_PROJECTILE_MOBS.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.CRIMINAL.get(), CriminalRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.SCARECROW_II.get(), ScarecrowIIRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.KRYPTONITE_GRENADE_THROWN.get(), KryptoniteGrenadeThrownRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.MARTIN_LI.get(), MartinLiRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.VENOM_TIER_1_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.VENOM_WEBBING_GENERIC_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.LIGHT_MOLOTOV_THROWN.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.FEAST_NPC.get(), FeastNPCRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.MR_NEGATIVE.get(), MrNegativeRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.MR_NEGATIVE_OFF.get(), MrNegativeOffRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.ANTI_VENOM_TIER_1_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.PLAGUE_ZOMBIE.get(), PlagueZombieRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.KALE_THE_CARETAKER.get(), KaleTheCaretakerRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.ART_THE_UNEMPLOYED.get(), ArtTheUnemployedRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.MAY_PARKER.get(), MayParkerRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.CHRIS_THE_MUSICIAN.get(), ChrisTheMusicianRenderer::new);
		event.registerEntityRenderer(Art5019injusticeModEntities.STAN_THE_LEGEND.get(), StanTheLegendRenderer::new);
	}
}
