
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.artinjustice.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.artinjustice.entity.WebShooterTier1m2ProjectileEntity;
import net.mcreator.artinjustice.entity.WebShooterTier1ProjectileEntity;
import net.mcreator.artinjustice.entity.WebShooterElectricWebProjectileEntity;
import net.mcreator.artinjustice.entity.VoughtExecutiveEntity;
import net.mcreator.artinjustice.entity.VinegarShotProjectileEntity;
import net.mcreator.artinjustice.entity.VibraniumSilverfishEntity;
import net.mcreator.artinjustice.entity.VibraniumShieldThrownProjectileEntity;
import net.mcreator.artinjustice.entity.VenomWebbingGenericProjectileEntity;
import net.mcreator.artinjustice.entity.VenomTier1ProjectileEntity;
import net.mcreator.artinjustice.entity.VenomBossEntity;
import net.mcreator.artinjustice.entity.UncleSamEntity;
import net.mcreator.artinjustice.entity.TheNightmareEntity;
import net.mcreator.artinjustice.entity.TheNightmareCloneEntity;
import net.mcreator.artinjustice.entity.TestDummyEntity;
import net.mcreator.artinjustice.entity.TaskMasterEntity;
import net.mcreator.artinjustice.entity.SunflowerSeedEntity;
import net.mcreator.artinjustice.entity.StormfrontEntity;
import net.mcreator.artinjustice.entity.StanTheLegendEntity;
import net.mcreator.artinjustice.entity.SpecialSpiderEntity;
import net.mcreator.artinjustice.entity.SniperMobsEntity;
import net.mcreator.artinjustice.entity.SmokeBombProjectileEntity;
import net.mcreator.artinjustice.entity.ShurikensProjectileEntity;
import net.mcreator.artinjustice.entity.ShadowsRangeEntity;
import net.mcreator.artinjustice.entity.ShadowsEntity;
import net.mcreator.artinjustice.entity.ScopoEntity;
import net.mcreator.artinjustice.entity.ScarecrowIIEntity;
import net.mcreator.artinjustice.entity.ScarecrowIEntity;
import net.mcreator.artinjustice.entity.ScarabEnergyBlasterProjectileEntity;
import net.mcreator.artinjustice.entity.ScarabCannonProjectileEntity;
import net.mcreator.artinjustice.entity.RedSkullEntity;
import net.mcreator.artinjustice.entity.RangedWebGrenadeProjectileEntity;
import net.mcreator.artinjustice.entity.PlagueZombieEntity;
import net.mcreator.artinjustice.entity.PistolProjectileEntity;
import net.mcreator.artinjustice.entity.PistolMobsEntity;
import net.mcreator.artinjustice.entity.PhonePillagerEntity;
import net.mcreator.artinjustice.entity.PepperShotProjectileEntity;
import net.mcreator.artinjustice.entity.OrchidZombieEntity;
import net.mcreator.artinjustice.entity.NightmareSpiderEntity;
import net.mcreator.artinjustice.entity.NightmareEntity;
import net.mcreator.artinjustice.entity.MustardShotProjectileEntity;
import net.mcreator.artinjustice.entity.MustardGasBombProjectileEntity;
import net.mcreator.artinjustice.entity.MrNegativeOffEntity;
import net.mcreator.artinjustice.entity.MrNegativeEntity;
import net.mcreator.artinjustice.entity.MolotovThrownEntity;
import net.mcreator.artinjustice.entity.MissileRangedProjectileEntity;
import net.mcreator.artinjustice.entity.MetalloEntity;
import net.mcreator.artinjustice.entity.MayoShotProjectileEntity;
import net.mcreator.artinjustice.entity.MayParkerEntity;
import net.mcreator.artinjustice.entity.MartinLiEntity;
import net.mcreator.artinjustice.entity.LokiCloneEntity;
import net.mcreator.artinjustice.entity.LokiBossEntity;
import net.mcreator.artinjustice.entity.LightMolotovThrownEntity;
import net.mcreator.artinjustice.entity.KryptoniteSilverfishEntity;
import net.mcreator.artinjustice.entity.KryptonitePistolProjectileMobsEntity;
import net.mcreator.artinjustice.entity.KryptonitePistolProjectileEntity;
import net.mcreator.artinjustice.entity.KryptoniteGrenadeThrownEntity;
import net.mcreator.artinjustice.entity.KetchupShotProjectileEntity;
import net.mcreator.artinjustice.entity.KaleTheCaretakerEntity;
import net.mcreator.artinjustice.entity.InstaKillShootProjectileEntity;
import net.mcreator.artinjustice.entity.InstaKillElectricalWebProjectileEntity;
import net.mcreator.artinjustice.entity.HydraSoldierEntity;
import net.mcreator.artinjustice.entity.HydraSniperEntity;
import net.mcreator.artinjustice.entity.HeavyMissileRangedProjectileEntity;
import net.mcreator.artinjustice.entity.GrenadeThrownEntity;
import net.mcreator.artinjustice.entity.FlashGrenadeThrownEntity;
import net.mcreator.artinjustice.entity.FeastNPCEntity;
import net.mcreator.artinjustice.entity.EyesMutantEntity;
import net.mcreator.artinjustice.entity.EshuEntity;
import net.mcreator.artinjustice.entity.ElectricGrenadeThrownEntity;
import net.mcreator.artinjustice.entity.DeathstrokeEntity;
import net.mcreator.artinjustice.entity.CriminalEntity;
import net.mcreator.artinjustice.entity.ChrisTheMusicianEntity;
import net.mcreator.artinjustice.entity.CaptainCarterShieldThrownProjectileEntity;
import net.mcreator.artinjustice.entity.CaptainAmericaShieldProjectileEntity;
import net.mcreator.artinjustice.entity.BlietzKriegEntity;
import net.mcreator.artinjustice.entity.AtlanteanZombieEntity;
import net.mcreator.artinjustice.entity.ArtTheUnemployedEntity;
import net.mcreator.artinjustice.entity.AntiVenomTier1ProjectileEntity;
import net.mcreator.artinjustice.entity.AlcoholShootEntity;
import net.mcreator.artinjustice.Art5019injusticeMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Art5019injusticeModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Art5019injusticeMod.MODID);
	public static final RegistryObject<EntityType<TaskMasterEntity>> TASK_MASTER = register("task_master",
			EntityType.Builder.<TaskMasterEntity>of(TaskMasterEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TaskMasterEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<DeathstrokeEntity>> DEATHSTROKE = register("deathstroke",
			EntityType.Builder.<DeathstrokeEntity>of(DeathstrokeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(DeathstrokeEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ShadowsEntity>> SHADOWS = register("shadows",
			EntityType.Builder.<ShadowsEntity>of(ShadowsEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(48).setUpdateInterval(3).setCustomClientFactory(ShadowsEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NightmareEntity>> NIGHTMARE = register("nightmare", EntityType.Builder.<NightmareEntity>of(NightmareEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(NightmareEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NightmareSpiderEntity>> NIGHTMARE_SPIDER = register("nightmare_spider", EntityType.Builder.<NightmareSpiderEntity>of(NightmareSpiderEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NightmareSpiderEntity::new).fireImmune().sized(1.4f, 0.9f));
	public static final RegistryObject<EntityType<SpecialSpiderEntity>> SPECIAL_SPIDER = register("special_spider",
			EntityType.Builder.<SpecialSpiderEntity>of(SpecialSpiderEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SpecialSpiderEntity::new)

					.sized(1.4f, 0.9f));
	public static final RegistryObject<EntityType<ScarecrowIEntity>> SCARECROW_I = register("scarecrow_i", EntityType.Builder.<ScarecrowIEntity>of(ScarecrowIEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(ScarecrowIEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ShadowsRangeEntity>> SHADOWS_RANGE = register("shadows_range",
			EntityType.Builder.<ShadowsRangeEntity>of(ShadowsRangeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(48).setUpdateInterval(3).setCustomClientFactory(ShadowsRangeEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<LokiBossEntity>> LOKI_BOSS = register("loki_boss",
			EntityType.Builder.<LokiBossEntity>of(LokiBossEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LokiBossEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<LokiCloneEntity>> LOKI_CLONE = register("loki_clone", EntityType.Builder.<LokiCloneEntity>of(LokiCloneEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(LokiCloneEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<AtlanteanZombieEntity>> ATLANTEAN_ZOMBIE = register("atlantean_zombie", EntityType.Builder.<AtlanteanZombieEntity>of(AtlanteanZombieEntity::new, MobCategory.WATER_CREATURE)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AtlanteanZombieEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<WebShooterTier1ProjectileEntity>> WEB_SHOOTER_TIER_1_PROJECTILE = register("web_shooter_tier_1_projectile",
			EntityType.Builder.<WebShooterTier1ProjectileEntity>of(WebShooterTier1ProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(WebShooterTier1ProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<WebShooterTier1m2ProjectileEntity>> WEB_SHOOTER_TIER_1M_2_PROJECTILE = register("web_shooter_tier_1m_2_projectile",
			EntityType.Builder.<WebShooterTier1m2ProjectileEntity>of(WebShooterTier1m2ProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(WebShooterTier1m2ProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<PistolProjectileEntity>> PISTOL_PROJECTILE = register("pistol_projectile", EntityType.Builder.<PistolProjectileEntity>of(PistolProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(PistolProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ScarabCannonProjectileEntity>> SCARAB_CANNON_PROJECTILE = register("scarab_cannon_projectile", EntityType.Builder.<ScarabCannonProjectileEntity>of(ScarabCannonProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(ScarabCannonProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<RangedWebGrenadeProjectileEntity>> RANGED_WEB_GRENADE_PROJECTILE = register("ranged_web_grenade_projectile",
			EntityType.Builder.<RangedWebGrenadeProjectileEntity>of(RangedWebGrenadeProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(RangedWebGrenadeProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<WebShooterElectricWebProjectileEntity>> WEB_SHOOTER_ELECTRIC_WEB_PROJECTILE = register("web_shooter_electric_web_projectile",
			EntityType.Builder.<WebShooterElectricWebProjectileEntity>of(WebShooterElectricWebProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(WebShooterElectricWebProjectileEntity::new).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<InstaKillShootProjectileEntity>> INSTA_KILL_SHOOT_PROJECTILE = register("insta_kill_shoot_projectile",
			EntityType.Builder.<InstaKillShootProjectileEntity>of(InstaKillShootProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(InstaKillShootProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<InstaKillElectricalWebProjectileEntity>> INSTA_KILL_ELECTRICAL_WEB_PROJECTILE = register("insta_kill_electrical_web_projectile",
			EntityType.Builder.<InstaKillElectricalWebProjectileEntity>of(InstaKillElectricalWebProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(InstaKillElectricalWebProjectileEntity::new).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ShurikensProjectileEntity>> SHURIKENS_PROJECTILE = register("shurikens_projectile", EntityType.Builder.<ShurikensProjectileEntity>of(ShurikensProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(ShurikensProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SmokeBombProjectileEntity>> SMOKE_BOMB_PROJECTILE = register("smoke_bomb_projectile", EntityType.Builder.<SmokeBombProjectileEntity>of(SmokeBombProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(SmokeBombProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ScarabEnergyBlasterProjectileEntity>> SCARAB_ENERGY_BLASTER_PROJECTILE = register("scarab_energy_blaster_projectile",
			EntityType.Builder.<ScarabEnergyBlasterProjectileEntity>of(ScarabEnergyBlasterProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(ScarabEnergyBlasterProjectileEntity::new).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<CaptainAmericaShieldProjectileEntity>> CAPTAIN_AMERICA_SHIELD_PROJECTILE = register("captain_america_shield_projectile",
			EntityType.Builder.<CaptainAmericaShieldProjectileEntity>of(CaptainAmericaShieldProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(CaptainAmericaShieldProjectileEntity::new).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<VibraniumShieldThrownProjectileEntity>> VIBRANIUM_SHIELD_THROWN_PROJECTILE = register("vibranium_shield_thrown_projectile",
			EntityType.Builder.<VibraniumShieldThrownProjectileEntity>of(VibraniumShieldThrownProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(VibraniumShieldThrownProjectileEntity::new).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<CaptainCarterShieldThrownProjectileEntity>> CAPTAIN_CARTER_SHIELD_THROWN_PROJECTILE = register("captain_carter_shield_thrown_projectile",
			EntityType.Builder.<CaptainCarterShieldThrownProjectileEntity>of(CaptainCarterShieldThrownProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(CaptainCarterShieldThrownProjectileEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MustardGasBombProjectileEntity>> MUSTARD_GAS_BOMB_PROJECTILE = register("mustard_gas_bomb_projectile",
			EntityType.Builder.<MustardGasBombProjectileEntity>of(MustardGasBombProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(MustardGasBombProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MayoShotProjectileEntity>> MAYO_SHOT_PROJECTILE = register("mayo_shot_projectile", EntityType.Builder.<MayoShotProjectileEntity>of(MayoShotProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(MayoShotProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<KetchupShotProjectileEntity>> KETCHUP_SHOT_PROJECTILE = register("ketchup_shot_projectile", EntityType.Builder.<KetchupShotProjectileEntity>of(KetchupShotProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(KetchupShotProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<VinegarShotProjectileEntity>> VINEGAR_SHOT_PROJECTILE = register("vinegar_shot_projectile", EntityType.Builder.<VinegarShotProjectileEntity>of(VinegarShotProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(VinegarShotProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<PepperShotProjectileEntity>> PEPPER_SHOT_PROJECTILE = register("pepper_shot_projectile", EntityType.Builder.<PepperShotProjectileEntity>of(PepperShotProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(PepperShotProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MustardShotProjectileEntity>> MUSTARD_SHOT_PROJECTILE = register("mustard_shot_projectile", EntityType.Builder.<MustardShotProjectileEntity>of(MustardShotProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(MustardShotProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MissileRangedProjectileEntity>> MISSILE_RANGED_PROJECTILE = register("missile_ranged_projectile",
			EntityType.Builder.<MissileRangedProjectileEntity>of(MissileRangedProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(MissileRangedProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<RedSkullEntity>> RED_SKULL = register("red_skull",
			EntityType.Builder.<RedSkullEntity>of(RedSkullEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RedSkullEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TestDummyEntity>> TEST_DUMMY = register("test_dummy",
			EntityType.Builder.<TestDummyEntity>of(TestDummyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TestDummyEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<PhonePillagerEntity>> PHONE_PILLAGER = register("phone_pillager",
			EntityType.Builder.<PhonePillagerEntity>of(PhonePillagerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PhonePillagerEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BlietzKriegEntity>> BLIETZ_KRIEG = register("blietz_krieg",
			EntityType.Builder.<BlietzKriegEntity>of(BlietzKriegEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BlietzKriegEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<PistolMobsEntity>> PISTOL_MOBS = register("pistol_mobs",
			EntityType.Builder.<PistolMobsEntity>of(PistolMobsEntity::new, MobCategory.MISC).setCustomClientFactory(PistolMobsEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<HydraSoldierEntity>> HYDRA_SOLDIER = register("hydra_soldier",
			EntityType.Builder.<HydraSoldierEntity>of(HydraSoldierEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HydraSoldierEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<GrenadeThrownEntity>> GRENADE_THROWN = register("grenade_thrown",
			EntityType.Builder.<GrenadeThrownEntity>of(GrenadeThrownEntity::new, MobCategory.MISC).setCustomClientFactory(GrenadeThrownEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ElectricGrenadeThrownEntity>> ELECTRIC_GRENADE_THROWN = register("electric_grenade_thrown", EntityType.Builder.<ElectricGrenadeThrownEntity>of(ElectricGrenadeThrownEntity::new, MobCategory.MISC)
			.setCustomClientFactory(ElectricGrenadeThrownEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MolotovThrownEntity>> MOLOTOV_THROWN = register("molotov_thrown",
			EntityType.Builder.<MolotovThrownEntity>of(MolotovThrownEntity::new, MobCategory.MISC).setCustomClientFactory(MolotovThrownEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<AlcoholShootEntity>> ALCOHOL_SHOOT = register("alcohol_shoot",
			EntityType.Builder.<AlcoholShootEntity>of(AlcoholShootEntity::new, MobCategory.MISC).setCustomClientFactory(AlcoholShootEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FlashGrenadeThrownEntity>> FLASH_GRENADE_THROWN = register("flash_grenade_thrown", EntityType.Builder.<FlashGrenadeThrownEntity>of(FlashGrenadeThrownEntity::new, MobCategory.MISC)
			.setCustomClientFactory(FlashGrenadeThrownEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<HeavyMissileRangedProjectileEntity>> HEAVY_MISSILE_RANGED_PROJECTILE = register("heavy_missile_ranged_projectile",
			EntityType.Builder.<HeavyMissileRangedProjectileEntity>of(HeavyMissileRangedProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(HeavyMissileRangedProjectileEntity::new).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<StormfrontEntity>> STORMFRONT = register("stormfront", EntityType.Builder.<StormfrontEntity>of(StormfrontEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(StormfrontEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<EyesMutantEntity>> EYES_MUTANT = register("eyes_mutant",
			EntityType.Builder.<EyesMutantEntity>of(EyesMutantEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(EyesMutantEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<VoughtExecutiveEntity>> VOUGHT_EXECUTIVE = register("vought_executive",
			EntityType.Builder.<VoughtExecutiveEntity>of(VoughtExecutiveEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(VoughtExecutiveEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<UncleSamEntity>> UNCLE_SAM = register("uncle_sam",
			EntityType.Builder.<UncleSamEntity>of(UncleSamEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(UncleSamEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SunflowerSeedEntity>> SUNFLOWER_SEED = register("sunflower_seed",
			EntityType.Builder.<SunflowerSeedEntity>of(SunflowerSeedEntity::new, MobCategory.MISC).setCustomClientFactory(SunflowerSeedEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<OrchidZombieEntity>> ORCHID_ZOMBIE = register("orchid_zombie",
			EntityType.Builder.<OrchidZombieEntity>of(OrchidZombieEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(OrchidZombieEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<HydraSniperEntity>> HYDRA_SNIPER = register("hydra_sniper",
			EntityType.Builder.<HydraSniperEntity>of(HydraSniperEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HydraSniperEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SniperMobsEntity>> SNIPER_MOBS = register("sniper_mobs",
			EntityType.Builder.<SniperMobsEntity>of(SniperMobsEntity::new, MobCategory.MISC).setCustomClientFactory(SniperMobsEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<VibraniumSilverfishEntity>> VIBRANIUM_SILVERFISH = register("vibranium_silverfish", EntityType.Builder.<VibraniumSilverfishEntity>of(VibraniumSilverfishEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(32).setUpdateInterval(3).setCustomClientFactory(VibraniumSilverfishEntity::new).fireImmune().sized(0.4f, 0.3f));
	public static final RegistryObject<EntityType<KryptoniteSilverfishEntity>> KRYPTONITE_SILVERFISH = register("kryptonite_silverfish",
			EntityType.Builder.<KryptoniteSilverfishEntity>of(KryptoniteSilverfishEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(32).setUpdateInterval(3)
					.setCustomClientFactory(KryptoniteSilverfishEntity::new)

					.sized(0.4f, 0.3f));
	public static final RegistryObject<EntityType<TheNightmareEntity>> THE_NIGHTMARE = register("the_nightmare", EntityType.Builder.<TheNightmareEntity>of(TheNightmareEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TheNightmareEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TheNightmareCloneEntity>> THE_NIGHTMARE_CLONE = register("the_nightmare_clone", EntityType.Builder.<TheNightmareCloneEntity>of(TheNightmareCloneEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TheNightmareCloneEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ScopoEntity>> SCOPO = register("scopo",
			EntityType.Builder.<ScopoEntity>of(ScopoEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ScopoEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<EshuEntity>> ESHU = register("eshu",
			EntityType.Builder.<EshuEntity>of(EshuEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(EshuEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<VenomBossEntity>> VENOM_BOSS = register("venom_boss",
			EntityType.Builder.<VenomBossEntity>of(VenomBossEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(VenomBossEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<MetalloEntity>> METALLO = register("metallo",
			EntityType.Builder.<MetalloEntity>of(MetalloEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MetalloEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<KryptonitePistolProjectileEntity>> KRYPTONITE_PISTOL_PROJECTILE = register("kryptonite_pistol_projectile",
			EntityType.Builder.<KryptonitePistolProjectileEntity>of(KryptonitePistolProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(KryptonitePistolProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<KryptonitePistolProjectileMobsEntity>> KRYPTONITE_PISTOL_PROJECTILE_MOBS = register("kryptonite_pistol_projectile_mobs",
			EntityType.Builder.<KryptonitePistolProjectileMobsEntity>of(KryptonitePistolProjectileMobsEntity::new, MobCategory.MISC).setCustomClientFactory(KryptonitePistolProjectileMobsEntity::new).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<CriminalEntity>> CRIMINAL = register("criminal",
			EntityType.Builder.<CriminalEntity>of(CriminalEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CriminalEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ScarecrowIIEntity>> SCARECROW_II = register("scarecrow_ii", EntityType.Builder.<ScarecrowIIEntity>of(ScarecrowIIEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ScarecrowIIEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<KryptoniteGrenadeThrownEntity>> KRYPTONITE_GRENADE_THROWN = register("kryptonite_grenade_thrown",
			EntityType.Builder.<KryptoniteGrenadeThrownEntity>of(KryptoniteGrenadeThrownEntity::new, MobCategory.MISC).setCustomClientFactory(KryptoniteGrenadeThrownEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MartinLiEntity>> MARTIN_LI = register("martin_li",
			EntityType.Builder.<MartinLiEntity>of(MartinLiEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MartinLiEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<VenomTier1ProjectileEntity>> VENOM_TIER_1_PROJECTILE = register("venom_tier_1_projectile", EntityType.Builder.<VenomTier1ProjectileEntity>of(VenomTier1ProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(VenomTier1ProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<VenomWebbingGenericProjectileEntity>> VENOM_WEBBING_GENERIC_PROJECTILE = register("venom_webbing_generic_projectile",
			EntityType.Builder.<VenomWebbingGenericProjectileEntity>of(VenomWebbingGenericProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(VenomWebbingGenericProjectileEntity::new).setShouldReceiveVelocityUpdates(true)
					.setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<LightMolotovThrownEntity>> LIGHT_MOLOTOV_THROWN = register("light_molotov_thrown", EntityType.Builder.<LightMolotovThrownEntity>of(LightMolotovThrownEntity::new, MobCategory.MISC)
			.setCustomClientFactory(LightMolotovThrownEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<FeastNPCEntity>> FEAST_NPC = register("feast_npc",
			EntityType.Builder.<FeastNPCEntity>of(FeastNPCEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FeastNPCEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<MrNegativeEntity>> MR_NEGATIVE = register("mr_negative",
			EntityType.Builder.<MrNegativeEntity>of(MrNegativeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MrNegativeEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<MrNegativeOffEntity>> MR_NEGATIVE_OFF = register("mr_negative_off",
			EntityType.Builder.<MrNegativeOffEntity>of(MrNegativeOffEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MrNegativeOffEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<AntiVenomTier1ProjectileEntity>> ANTI_VENOM_TIER_1_PROJECTILE = register("anti_venom_tier_1_projectile",
			EntityType.Builder.<AntiVenomTier1ProjectileEntity>of(AntiVenomTier1ProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(AntiVenomTier1ProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
					.setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<PlagueZombieEntity>> PLAGUE_ZOMBIE = register("plague_zombie",
			EntityType.Builder.<PlagueZombieEntity>of(PlagueZombieEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PlagueZombieEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<KaleTheCaretakerEntity>> KALE_THE_CARETAKER = register("kale_the_caretaker",
			EntityType.Builder.<KaleTheCaretakerEntity>of(KaleTheCaretakerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(KaleTheCaretakerEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ArtTheUnemployedEntity>> ART_THE_UNEMPLOYED = register("art_the_unemployed",
			EntityType.Builder.<ArtTheUnemployedEntity>of(ArtTheUnemployedEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ArtTheUnemployedEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<MayParkerEntity>> MAY_PARKER = register("may_parker",
			EntityType.Builder.<MayParkerEntity>of(MayParkerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MayParkerEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ChrisTheMusicianEntity>> CHRIS_THE_MUSICIAN = register("chris_the_musician",
			EntityType.Builder.<ChrisTheMusicianEntity>of(ChrisTheMusicianEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ChrisTheMusicianEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<StanTheLegendEntity>> STAN_THE_LEGEND = register("stan_the_legend",
			EntityType.Builder.<StanTheLegendEntity>of(StanTheLegendEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(StanTheLegendEntity::new)

					.sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			TaskMasterEntity.init();
			DeathstrokeEntity.init();
			ShadowsEntity.init();
			NightmareEntity.init();
			NightmareSpiderEntity.init();
			SpecialSpiderEntity.init();
			ScarecrowIEntity.init();
			ShadowsRangeEntity.init();
			LokiBossEntity.init();
			LokiCloneEntity.init();
			AtlanteanZombieEntity.init();
			RedSkullEntity.init();
			TestDummyEntity.init();
			PhonePillagerEntity.init();
			BlietzKriegEntity.init();
			HydraSoldierEntity.init();
			StormfrontEntity.init();
			EyesMutantEntity.init();
			VoughtExecutiveEntity.init();
			UncleSamEntity.init();
			OrchidZombieEntity.init();
			HydraSniperEntity.init();
			VibraniumSilverfishEntity.init();
			KryptoniteSilverfishEntity.init();
			TheNightmareEntity.init();
			TheNightmareCloneEntity.init();
			ScopoEntity.init();
			EshuEntity.init();
			VenomBossEntity.init();
			MetalloEntity.init();
			CriminalEntity.init();
			ScarecrowIIEntity.init();
			MartinLiEntity.init();
			FeastNPCEntity.init();
			MrNegativeEntity.init();
			MrNegativeOffEntity.init();
			PlagueZombieEntity.init();
			KaleTheCaretakerEntity.init();
			ArtTheUnemployedEntity.init();
			MayParkerEntity.init();
			ChrisTheMusicianEntity.init();
			StanTheLegendEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(TASK_MASTER.get(), TaskMasterEntity.createAttributes().build());
		event.put(DEATHSTROKE.get(), DeathstrokeEntity.createAttributes().build());
		event.put(SHADOWS.get(), ShadowsEntity.createAttributes().build());
		event.put(NIGHTMARE.get(), NightmareEntity.createAttributes().build());
		event.put(NIGHTMARE_SPIDER.get(), NightmareSpiderEntity.createAttributes().build());
		event.put(SPECIAL_SPIDER.get(), SpecialSpiderEntity.createAttributes().build());
		event.put(SCARECROW_I.get(), ScarecrowIEntity.createAttributes().build());
		event.put(SHADOWS_RANGE.get(), ShadowsRangeEntity.createAttributes().build());
		event.put(LOKI_BOSS.get(), LokiBossEntity.createAttributes().build());
		event.put(LOKI_CLONE.get(), LokiCloneEntity.createAttributes().build());
		event.put(ATLANTEAN_ZOMBIE.get(), AtlanteanZombieEntity.createAttributes().build());
		event.put(RED_SKULL.get(), RedSkullEntity.createAttributes().build());
		event.put(TEST_DUMMY.get(), TestDummyEntity.createAttributes().build());
		event.put(PHONE_PILLAGER.get(), PhonePillagerEntity.createAttributes().build());
		event.put(BLIETZ_KRIEG.get(), BlietzKriegEntity.createAttributes().build());
		event.put(HYDRA_SOLDIER.get(), HydraSoldierEntity.createAttributes().build());
		event.put(STORMFRONT.get(), StormfrontEntity.createAttributes().build());
		event.put(EYES_MUTANT.get(), EyesMutantEntity.createAttributes().build());
		event.put(VOUGHT_EXECUTIVE.get(), VoughtExecutiveEntity.createAttributes().build());
		event.put(UNCLE_SAM.get(), UncleSamEntity.createAttributes().build());
		event.put(ORCHID_ZOMBIE.get(), OrchidZombieEntity.createAttributes().build());
		event.put(HYDRA_SNIPER.get(), HydraSniperEntity.createAttributes().build());
		event.put(VIBRANIUM_SILVERFISH.get(), VibraniumSilverfishEntity.createAttributes().build());
		event.put(KRYPTONITE_SILVERFISH.get(), KryptoniteSilverfishEntity.createAttributes().build());
		event.put(THE_NIGHTMARE.get(), TheNightmareEntity.createAttributes().build());
		event.put(THE_NIGHTMARE_CLONE.get(), TheNightmareCloneEntity.createAttributes().build());
		event.put(SCOPO.get(), ScopoEntity.createAttributes().build());
		event.put(ESHU.get(), EshuEntity.createAttributes().build());
		event.put(VENOM_BOSS.get(), VenomBossEntity.createAttributes().build());
		event.put(METALLO.get(), MetalloEntity.createAttributes().build());
		event.put(CRIMINAL.get(), CriminalEntity.createAttributes().build());
		event.put(SCARECROW_II.get(), ScarecrowIIEntity.createAttributes().build());
		event.put(MARTIN_LI.get(), MartinLiEntity.createAttributes().build());
		event.put(FEAST_NPC.get(), FeastNPCEntity.createAttributes().build());
		event.put(MR_NEGATIVE.get(), MrNegativeEntity.createAttributes().build());
		event.put(MR_NEGATIVE_OFF.get(), MrNegativeOffEntity.createAttributes().build());
		event.put(PLAGUE_ZOMBIE.get(), PlagueZombieEntity.createAttributes().build());
		event.put(KALE_THE_CARETAKER.get(), KaleTheCaretakerEntity.createAttributes().build());
		event.put(ART_THE_UNEMPLOYED.get(), ArtTheUnemployedEntity.createAttributes().build());
		event.put(MAY_PARKER.get(), MayParkerEntity.createAttributes().build());
		event.put(CHRIS_THE_MUSICIAN.get(), ChrisTheMusicianEntity.createAttributes().build());
		event.put(STAN_THE_LEGEND.get(), StanTheLegendEntity.createAttributes().build());
	}
}
