
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.artinjustice.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.artinjustice.potion.WebbedMobEffect;
import net.mcreator.artinjustice.potion.VenomEffectMobEffect;
import net.mcreator.artinjustice.potion.UncleSamPossessedMobEffect;
import net.mcreator.artinjustice.potion.TuberculosisMobEffect;
import net.mcreator.artinjustice.potion.TimeStoppedMobEffect;
import net.mcreator.artinjustice.potion.SunDippedMobEffect;
import net.mcreator.artinjustice.potion.StunMobEffect;
import net.mcreator.artinjustice.potion.SpiderLeapMobEffect;
import net.mcreator.artinjustice.potion.RushingMobEffect;
import net.mcreator.artinjustice.potion.RageMobEffect;
import net.mcreator.artinjustice.potion.RadiationMobEffect;
import net.mcreator.artinjustice.potion.PowerDependenceMobEffect;
import net.mcreator.artinjustice.potion.PolioMobEffect;
import net.mcreator.artinjustice.potion.PlagueMobEffect;
import net.mcreator.artinjustice.potion.PheromonesMobEffect;
import net.mcreator.artinjustice.potion.PhantomZoneEffectMobEffect;
import net.mcreator.artinjustice.potion.MonsterInfightingMobEffect;
import net.mcreator.artinjustice.potion.MeningitisMobEffect;
import net.mcreator.artinjustice.potion.MagicBlockingMobEffect;
import net.mcreator.artinjustice.potion.LifeDepletionMobEffect;
import net.mcreator.artinjustice.potion.KryptonitePoisoningMobEffect;
import net.mcreator.artinjustice.potion.InterferenceMobEffect;
import net.mcreator.artinjustice.potion.ImpulseMobEffect;
import net.mcreator.artinjustice.potion.ImmunityMobEffect;
import net.mcreator.artinjustice.potion.ImmunityBMobEffect;
import net.mcreator.artinjustice.potion.IllusionedMobEffect;
import net.mcreator.artinjustice.potion.HeroEnemyMobEffect;
import net.mcreator.artinjustice.potion.HazardMobEffect;
import net.mcreator.artinjustice.potion.GoldenKryptonitePoisoningMobEffect;
import net.mcreator.artinjustice.potion.FortuneMobEffect;
import net.mcreator.artinjustice.potion.FluMobEffect;
import net.mcreator.artinjustice.potion.FearMobEffect;
import net.mcreator.artinjustice.potion.ExtraPoisonResMobEffect;
import net.mcreator.artinjustice.potion.ElectricityMobEffect;
import net.mcreator.artinjustice.potion.DeafnessMobEffect;
import net.mcreator.artinjustice.potion.DashingMobEffect;
import net.mcreator.artinjustice.potion.CompoundVMobMobEffect;
import net.mcreator.artinjustice.potion.ChemistryKnowledgeMobEffect;
import net.mcreator.artinjustice.potion.BlockedNoseMobEffect;
import net.mcreator.artinjustice.potion.BleedingMobEffect;
import net.mcreator.artinjustice.potion.AwokenMobEffect;
import net.mcreator.artinjustice.potion.AttackInabilityMobEffect;
import net.mcreator.artinjustice.potion.AllergyMobEffect;
import net.mcreator.artinjustice.potion.AlcoholSterilizedMobEffect;
import net.mcreator.artinjustice.potion.AbsoluteImmunityMobEffect;
import net.mcreator.artinjustice.potion.AIDSMobEffect;
import net.mcreator.artinjustice.Art5019injusticeMod;

public class Art5019injusticeModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Art5019injusticeMod.MODID);
	public static final RegistryObject<MobEffect> RADIATION = REGISTRY.register("radiation", () -> new RadiationMobEffect());
	public static final RegistryObject<MobEffect> ELECTRICITY = REGISTRY.register("electricity", () -> new ElectricityMobEffect());
	public static final RegistryObject<MobEffect> VENOM_EFFECT = REGISTRY.register("venom_effect", () -> new VenomEffectMobEffect());
	public static final RegistryObject<MobEffect> WEBBED = REGISTRY.register("webbed", () -> new WebbedMobEffect());
	public static final RegistryObject<MobEffect> POWER_DEPENDENCE = REGISTRY.register("power_dependence", () -> new PowerDependenceMobEffect());
	public static final RegistryObject<MobEffect> FEAR = REGISTRY.register("fear", () -> new FearMobEffect());
	public static final RegistryObject<MobEffect> STUN = REGISTRY.register("stun", () -> new StunMobEffect());
	public static final RegistryObject<MobEffect> TIME_STOPPED = REGISTRY.register("time_stopped", () -> new TimeStoppedMobEffect());
	public static final RegistryObject<MobEffect> HAZARD = REGISTRY.register("hazard", () -> new HazardMobEffect());
	public static final RegistryObject<MobEffect> FORTUNE = REGISTRY.register("fortune", () -> new FortuneMobEffect());
	public static final RegistryObject<MobEffect> IMPULSE = REGISTRY.register("impulse", () -> new ImpulseMobEffect());
	public static final RegistryObject<MobEffect> ATTACK_INABILITY = REGISTRY.register("attack_inability", () -> new AttackInabilityMobEffect());
	public static final RegistryObject<MobEffect> RAGE = REGISTRY.register("rage", () -> new RageMobEffect());
	public static final RegistryObject<MobEffect> ILLUSIONED = REGISTRY.register("illusioned", () -> new IllusionedMobEffect());
	public static final RegistryObject<MobEffect> AWOKEN = REGISTRY.register("awoken", () -> new AwokenMobEffect());
	public static final RegistryObject<MobEffect> HERO_ENEMY = REGISTRY.register("hero_enemy", () -> new HeroEnemyMobEffect());
	public static final RegistryObject<MobEffect> BLEEDING = REGISTRY.register("bleeding", () -> new BleedingMobEffect());
	public static final RegistryObject<MobEffect> INTERFERENCE = REGISTRY.register("interference", () -> new InterferenceMobEffect());
	public static final RegistryObject<MobEffect> UNCLE_SAM_POSSESSED = REGISTRY.register("uncle_sam_possessed", () -> new UncleSamPossessedMobEffect());
	public static final RegistryObject<MobEffect> MONSTER_INFIGHTING = REGISTRY.register("monster_infighting", () -> new MonsterInfightingMobEffect());
	public static final RegistryObject<MobEffect> ALLERGY = REGISTRY.register("allergy", () -> new AllergyMobEffect());
	public static final RegistryObject<MobEffect> PHEROMONES = REGISTRY.register("pheromones", () -> new PheromonesMobEffect());
	public static final RegistryObject<MobEffect> RUSHING = REGISTRY.register("rushing", () -> new RushingMobEffect());
	public static final RegistryObject<MobEffect> COMPOUND_V_MOB = REGISTRY.register("compound_v_mob", () -> new CompoundVMobMobEffect());
	public static final RegistryObject<MobEffect> FLU = REGISTRY.register("flu", () -> new FluMobEffect());
	public static final RegistryObject<MobEffect> BLOCKED_NOSE = REGISTRY.register("blocked_nose", () -> new BlockedNoseMobEffect());
	public static final RegistryObject<MobEffect> AIDS = REGISTRY.register("aids", () -> new AIDSMobEffect());
	public static final RegistryObject<MobEffect> DASHING = REGISTRY.register("dashing", () -> new DashingMobEffect());
	public static final RegistryObject<MobEffect> KRYPTONITE_POISONING = REGISTRY.register("kryptonite_poisoning", () -> new KryptonitePoisoningMobEffect());
	public static final RegistryObject<MobEffect> CHEMISTRY_KNOWLEDGE = REGISTRY.register("chemistry_knowledge", () -> new ChemistryKnowledgeMobEffect());
	public static final RegistryObject<MobEffect> MAGIC_BLOCKING = REGISTRY.register("magic_blocking", () -> new MagicBlockingMobEffect());
	public static final RegistryObject<MobEffect> LIFE_DEPLETION = REGISTRY.register("life_depletion", () -> new LifeDepletionMobEffect());
	public static final RegistryObject<MobEffect> EXTRA_POISON_RES = REGISTRY.register("extra_poison_res", () -> new ExtraPoisonResMobEffect());
	public static final RegistryObject<MobEffect> PLAGUE = REGISTRY.register("plague", () -> new PlagueMobEffect());
	public static final RegistryObject<MobEffect> SUN_DIPPED = REGISTRY.register("sun_dipped", () -> new SunDippedMobEffect());
	public static final RegistryObject<MobEffect> GOLDEN_KRYPTONITE_POISONING = REGISTRY.register("golden_kryptonite_poisoning", () -> new GoldenKryptonitePoisoningMobEffect());
	public static final RegistryObject<MobEffect> IMMUNITY = REGISTRY.register("immunity", () -> new ImmunityMobEffect());
	public static final RegistryObject<MobEffect> MENINGITIS = REGISTRY.register("meningitis", () -> new MeningitisMobEffect());
	public static final RegistryObject<MobEffect> DEAFNESS = REGISTRY.register("deafness", () -> new DeafnessMobEffect());
	public static final RegistryObject<MobEffect> POLIO = REGISTRY.register("polio", () -> new PolioMobEffect());
	public static final RegistryObject<MobEffect> IMMUNITY_B = REGISTRY.register("immunity_b", () -> new ImmunityBMobEffect());
	public static final RegistryObject<MobEffect> TUBERCULOSIS = REGISTRY.register("tuberculosis", () -> new TuberculosisMobEffect());
	public static final RegistryObject<MobEffect> ABSOLUTE_IMMUNITY = REGISTRY.register("absolute_immunity", () -> new AbsoluteImmunityMobEffect());
	public static final RegistryObject<MobEffect> ALCOHOL_STERILIZED = REGISTRY.register("alcohol_sterilized", () -> new AlcoholSterilizedMobEffect());
	public static final RegistryObject<MobEffect> SPIDER_LEAP = REGISTRY.register("spider_leap", () -> new SpiderLeapMobEffect());
	public static final RegistryObject<MobEffect> PHANTOM_ZONE_EFFECT = REGISTRY.register("phantom_zone_effect", () -> new PhantomZoneEffectMobEffect());
}
