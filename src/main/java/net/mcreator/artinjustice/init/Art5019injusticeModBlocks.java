
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.artinjustice.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.mcreator.artinjustice.block.YellowCattleyaBlock;
import net.mcreator.artinjustice.block.WineOrchidBlock;
import net.mcreator.artinjustice.block.WhiteOrchidBlock;
import net.mcreator.artinjustice.block.VibraniumOreBlock;
import net.mcreator.artinjustice.block.VenusFlyTrapBlock;
import net.mcreator.artinjustice.block.UraniumBlockBlock;
import net.mcreator.artinjustice.block.TrueKryptoniteBlockBlock;
import net.mcreator.artinjustice.block.TransmutationTableBlock;
import net.mcreator.artinjustice.block.TomatoStageFinalBlock;
import net.mcreator.artinjustice.block.TomatoStage7Block;
import net.mcreator.artinjustice.block.TomatoStage6Block;
import net.mcreator.artinjustice.block.TomatoStage5Block;
import net.mcreator.artinjustice.block.TomatoStage4Block;
import net.mcreator.artinjustice.block.TomatoStage3Block;
import net.mcreator.artinjustice.block.TomatoStage2Block;
import net.mcreator.artinjustice.block.TomatoStage1Block;
import net.mcreator.artinjustice.block.TitaniumOreBlock;
import net.mcreator.artinjustice.block.TitaniumBlockBlock;
import net.mcreator.artinjustice.block.ThinIceBlock;
import net.mcreator.artinjustice.block.ThinIce4Block;
import net.mcreator.artinjustice.block.ThinIce3Block;
import net.mcreator.artinjustice.block.ThinIce2Block;
import net.mcreator.artinjustice.block.TempLightBlockBlock;
import net.mcreator.artinjustice.block.SulphurNetherrackBlock;
import net.mcreator.artinjustice.block.SulfuricAcidBlock;
import net.mcreator.artinjustice.block.StilledWaterBlock;
import net.mcreator.artinjustice.block.StibniteNetherrackBlock;
import net.mcreator.artinjustice.block.StarryOrchidBlock;
import net.mcreator.artinjustice.block.SolventWebBlock;
import net.mcreator.artinjustice.block.SilverOreBlock;
import net.mcreator.artinjustice.block.SilverBlockBlock;
import net.mcreator.artinjustice.block.SignalMachinePillagerTempBlock;
import net.mcreator.artinjustice.block.SignalMachinePillagerBlock;
import net.mcreator.artinjustice.block.SignalMachineBlock;
import net.mcreator.artinjustice.block.SawmillBlock;
import net.mcreator.artinjustice.block.RubyOreBlock;
import net.mcreator.artinjustice.block.RubyBlockBlock;
import net.mcreator.artinjustice.block.RubikCubeBlock;
import net.mcreator.artinjustice.block.ReinforcedPackedIceLightBlock;
import net.mcreator.artinjustice.block.ReinforcedIceBlock;
import net.mcreator.artinjustice.block.RedBlockBlock;
import net.mcreator.artinjustice.block.RareBlueFlowerBlock;
import net.mcreator.artinjustice.block.RangedTNTBlock;
import net.mcreator.artinjustice.block.RainbowOrchidBlock;
import net.mcreator.artinjustice.block.QueenMaevePlushBlock;
import net.mcreator.artinjustice.block.PuzzleBlockBlock;
import net.mcreator.artinjustice.block.PurpleOrchidBlock;
import net.mcreator.artinjustice.block.PricklyPathBlock;
import net.mcreator.artinjustice.block.PoisonIvyBlock;
import net.mcreator.artinjustice.block.PetroleumBlock;
import net.mcreator.artinjustice.block.PetriTableBlockBlock;
import net.mcreator.artinjustice.block.PepperStageFinalBlock;
import net.mcreator.artinjustice.block.PepperStage7Block;
import net.mcreator.artinjustice.block.PepperStage6Block;
import net.mcreator.artinjustice.block.PepperStage5Block;
import net.mcreator.artinjustice.block.PepperStage4Block;
import net.mcreator.artinjustice.block.PepperStage3Block;
import net.mcreator.artinjustice.block.PepperStage2Block;
import net.mcreator.artinjustice.block.PepperStage1Block;
import net.mcreator.artinjustice.block.PalladiumOreBlock;
import net.mcreator.artinjustice.block.PalladiumBlockBlock;
import net.mcreator.artinjustice.block.MicroscopeBlock;
import net.mcreator.artinjustice.block.MeteoriteCobblestoneBlock;
import net.mcreator.artinjustice.block.MeteoriteBlock;
import net.mcreator.artinjustice.block.MarsBricksWallBlock;
import net.mcreator.artinjustice.block.MarsBricksStairsBlock;
import net.mcreator.artinjustice.block.MarsBricksSlabBlock;
import net.mcreator.artinjustice.block.MarsBricksBlock;
import net.mcreator.artinjustice.block.LockedDoorBlock;
import net.mcreator.artinjustice.block.LilacCattleyaBlock;
import net.mcreator.artinjustice.block.LeadOreBlock;
import net.mcreator.artinjustice.block.LeadBlockBlock;
import net.mcreator.artinjustice.block.LazarusPitWaterBlock;
import net.mcreator.artinjustice.block.KryptoniteBlockBlock;
import net.mcreator.artinjustice.block.KryptonianComputerBlock;
import net.mcreator.artinjustice.block.IceLenseBlock;
import net.mcreator.artinjustice.block.HomelanderPlushBlock;
import net.mcreator.artinjustice.block.HeartShapedHerbBlock;
import net.mcreator.artinjustice.block.GoldTitaniumBlockBlock;
import net.mcreator.artinjustice.block.FluoriteOreBlock;
import net.mcreator.artinjustice.block.DwarfStarDoorBlock;
import net.mcreator.artinjustice.block.DroppedKeyBlock;
import net.mcreator.artinjustice.block.CorpseBlock;
import net.mcreator.artinjustice.block.CopperGrateBlock;
import net.mcreator.artinjustice.block.CopperElectrifierBlock;
import net.mcreator.artinjustice.block.ContaminedWaterBlock;
import net.mcreator.artinjustice.block.ComputerBlock;
import net.mcreator.artinjustice.block.CompressedPackedIceBlock;
import net.mcreator.artinjustice.block.CompressedIceBlockBlock;
import net.mcreator.artinjustice.block.ChemistryTableBlock;
import net.mcreator.artinjustice.block.BromineSandBlock;
import net.mcreator.artinjustice.block.BlackNoirPlushBlock;
import net.mcreator.artinjustice.block.AtlanteanGoldOreBlock;
import net.mcreator.artinjustice.block.AloeVeraBlock;
import net.mcreator.artinjustice.Art5019injusticeMod;

public class Art5019injusticeModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, Art5019injusticeMod.MODID);
	public static final RegistryObject<Block> URANIUM_BLOCK = REGISTRY.register("uranium_block", () -> new UraniumBlockBlock());
	public static final RegistryObject<Block> LEAD_ORE = REGISTRY.register("lead_ore", () -> new LeadOreBlock());
	public static final RegistryObject<Block> LEAD_BLOCK = REGISTRY.register("lead_block", () -> new LeadBlockBlock());
	public static final RegistryObject<Block> SOLVENT_WEB = REGISTRY.register("solvent_web", () -> new SolventWebBlock());
	public static final RegistryObject<Block> CHEMISTRY_TABLE = REGISTRY.register("chemistry_table", () -> new ChemistryTableBlock());
	public static final RegistryObject<Block> RARE_BLUE_FLOWER = REGISTRY.register("rare_blue_flower", () -> new RareBlueFlowerBlock());
	public static final RegistryObject<Block> CONTAMINED_WATER = REGISTRY.register("contamined_water", () -> new ContaminedWaterBlock());
	public static final RegistryObject<Block> VIBRANIUM_ORE = REGISTRY.register("vibranium_ore", () -> new VibraniumOreBlock());
	public static final RegistryObject<Block> METEORITE = REGISTRY.register("meteorite", () -> new MeteoriteBlock());
	public static final RegistryObject<Block> MICROSCOPE = REGISTRY.register("microscope", () -> new MicroscopeBlock());
	public static final RegistryObject<Block> HEART_SHAPED_HERB = REGISTRY.register("heart_shaped_herb", () -> new HeartShapedHerbBlock());
	public static final RegistryObject<Block> TOMATO_STAGE_1 = REGISTRY.register("tomato_stage_1", () -> new TomatoStage1Block());
	public static final RegistryObject<Block> TOMATO_STAGE_FINAL = REGISTRY.register("tomato_stage_final", () -> new TomatoStageFinalBlock());
	public static final RegistryObject<Block> TOMATO_STAGE_7 = REGISTRY.register("tomato_stage_7", () -> new TomatoStage7Block());
	public static final RegistryObject<Block> TOMATO_STAGE_6 = REGISTRY.register("tomato_stage_6", () -> new TomatoStage6Block());
	public static final RegistryObject<Block> TOMATO_STAGE_5 = REGISTRY.register("tomato_stage_5", () -> new TomatoStage5Block());
	public static final RegistryObject<Block> TOMATO_STAGE_4 = REGISTRY.register("tomato_stage_4", () -> new TomatoStage4Block());
	public static final RegistryObject<Block> TOMATO_STAGE_3 = REGISTRY.register("tomato_stage_3", () -> new TomatoStage3Block());
	public static final RegistryObject<Block> TOMATO_STAGE_2 = REGISTRY.register("tomato_stage_2", () -> new TomatoStage2Block());
	public static final RegistryObject<Block> PEPPER_STAGE_FINAL = REGISTRY.register("pepper_stage_final", () -> new PepperStageFinalBlock());
	public static final RegistryObject<Block> PEPPER_STAGE_7 = REGISTRY.register("pepper_stage_7", () -> new PepperStage7Block());
	public static final RegistryObject<Block> PEPPER_STAGE_6 = REGISTRY.register("pepper_stage_6", () -> new PepperStage6Block());
	public static final RegistryObject<Block> PEPPER_STAGE_5 = REGISTRY.register("pepper_stage_5", () -> new PepperStage5Block());
	public static final RegistryObject<Block> PEPPER_STAGE_4 = REGISTRY.register("pepper_stage_4", () -> new PepperStage4Block());
	public static final RegistryObject<Block> PEPPER_STAGE_3 = REGISTRY.register("pepper_stage_3", () -> new PepperStage3Block());
	public static final RegistryObject<Block> PEPPER_STAGE_2 = REGISTRY.register("pepper_stage_2", () -> new PepperStage2Block());
	public static final RegistryObject<Block> PEPPER_STAGE_1 = REGISTRY.register("pepper_stage_1", () -> new PepperStage1Block());
	public static final RegistryObject<Block> TITANIUM_ORE = REGISTRY.register("titanium_ore", () -> new TitaniumOreBlock());
	public static final RegistryObject<Block> TITANIUM_BLOCK = REGISTRY.register("titanium_block", () -> new TitaniumBlockBlock());
	public static final RegistryObject<Block> PALLADIUM_ORE = REGISTRY.register("palladium_ore", () -> new PalladiumOreBlock());
	public static final RegistryObject<Block> PALLADIUM_BLOCK = REGISTRY.register("palladium_block", () -> new PalladiumBlockBlock());
	public static final RegistryObject<Block> COMPUTER = REGISTRY.register("computer", () -> new ComputerBlock());
	public static final RegistryObject<Block> STILLED_WATER = REGISTRY.register("stilled_water", () -> new StilledWaterBlock());
	public static final RegistryObject<Block> ATLANTEAN_GOLD_ORE = REGISTRY.register("atlantean_gold_ore", () -> new AtlanteanGoldOreBlock());
	public static final RegistryObject<Block> RUBY_ORE = REGISTRY.register("ruby_ore", () -> new RubyOreBlock());
	public static final RegistryObject<Block> LAZARUS_PIT_WATER = REGISTRY.register("lazarus_pit_water", () -> new LazarusPitWaterBlock());
	public static final RegistryObject<Block> GOLD_TITANIUM_BLOCK = REGISTRY.register("gold_titanium_block", () -> new GoldTitaniumBlockBlock());
	public static final RegistryObject<Block> RUBY_BLOCK = REGISTRY.register("ruby_block", () -> new RubyBlockBlock());
	public static final RegistryObject<Block> SIGNAL_MACHINE = REGISTRY.register("signal_machine", () -> new SignalMachineBlock());
	public static final RegistryObject<Block> SIGNAL_MACHINE_PILLAGER = REGISTRY.register("signal_machine_pillager", () -> new SignalMachinePillagerBlock());
	public static final RegistryObject<Block> SIGNAL_MACHINE_PILLAGER_TEMP = REGISTRY.register("signal_machine_pillager_temp", () -> new SignalMachinePillagerTempBlock());
	public static final RegistryObject<Block> SILVER_ORE = REGISTRY.register("silver_ore", () -> new SilverOreBlock());
	public static final RegistryObject<Block> SILVER_BLOCK = REGISTRY.register("silver_block", () -> new SilverBlockBlock());
	public static final RegistryObject<Block> SAWMILL = REGISTRY.register("sawmill", () -> new SawmillBlock());
	public static final RegistryObject<Block> RANGED_TNT = REGISTRY.register("ranged_tnt", () -> new RangedTNTBlock());
	public static final RegistryObject<Block> KRYPTONITE_BLOCK = REGISTRY.register("kryptonite_block", () -> new KryptoniteBlockBlock());
	public static final RegistryObject<Block> LOCKED_DOOR = REGISTRY.register("locked_door", () -> new LockedDoorBlock());
	public static final RegistryObject<Block> ALOE_VERA = REGISTRY.register("aloe_vera", () -> new AloeVeraBlock());
	public static final RegistryObject<Block> HOMELANDER_PLUSH = REGISTRY.register("homelander_plush", () -> new HomelanderPlushBlock());
	public static final RegistryObject<Block> BLACK_NOIR_PLUSH = REGISTRY.register("black_noir_plush", () -> new BlackNoirPlushBlock());
	public static final RegistryObject<Block> QUEEN_MAEVE_PLUSH = REGISTRY.register("queen_maeve_plush", () -> new QueenMaevePlushBlock());
	public static final RegistryObject<Block> TEMP_LIGHT_BLOCK = REGISTRY.register("temp_light_block", () -> new TempLightBlockBlock());
	public static final RegistryObject<Block> WINE_ORCHID = REGISTRY.register("wine_orchid", () -> new WineOrchidBlock());
	public static final RegistryObject<Block> YELLOW_CATTLEYA = REGISTRY.register("yellow_cattleya", () -> new YellowCattleyaBlock());
	public static final RegistryObject<Block> PURPLE_ORCHID = REGISTRY.register("purple_orchid", () -> new PurpleOrchidBlock());
	public static final RegistryObject<Block> WHITE_ORCHID = REGISTRY.register("white_orchid", () -> new WhiteOrchidBlock());
	public static final RegistryObject<Block> LILAC_CATTLEYA = REGISTRY.register("lilac_cattleya", () -> new LilacCattleyaBlock());
	public static final RegistryObject<Block> POISON_IVY = REGISTRY.register("poison_ivy", () -> new PoisonIvyBlock());
	public static final RegistryObject<Block> RED_BLOCK = REGISTRY.register("red_block", () -> new RedBlockBlock());
	public static final RegistryObject<Block> RAINBOW_ORCHID = REGISTRY.register("rainbow_orchid", () -> new RainbowOrchidBlock());
	public static final RegistryObject<Block> STARRY_ORCHID = REGISTRY.register("starry_orchid", () -> new StarryOrchidBlock());
	public static final RegistryObject<Block> PRICKLY_PATH = REGISTRY.register("prickly_path", () -> new PricklyPathBlock());
	public static final RegistryObject<Block> VENUS_FLY_TRAP = REGISTRY.register("venus_fly_trap", () -> new VenusFlyTrapBlock());
	public static final RegistryObject<Block> CORPSE = REGISTRY.register("corpse", () -> new CorpseBlock());
	public static final RegistryObject<Block> METEORITE_COBBLESTONE = REGISTRY.register("meteorite_cobblestone", () -> new MeteoriteCobblestoneBlock());
	public static final RegistryObject<Block> PETRI_TABLE_BLOCK = REGISTRY.register("petri_table_block", () -> new PetriTableBlockBlock());
	public static final RegistryObject<Block> STIBNITE_NETHERRACK = REGISTRY.register("stibnite_netherrack", () -> new StibniteNetherrackBlock());
	public static final RegistryObject<Block> SULPHUR_NETHERRACK = REGISTRY.register("sulphur_netherrack", () -> new SulphurNetherrackBlock());
	public static final RegistryObject<Block> BROMINE_SAND = REGISTRY.register("bromine_sand", () -> new BromineSandBlock());
	public static final RegistryObject<Block> FLUORITE_ORE = REGISTRY.register("fluorite_ore", () -> new FluoriteOreBlock());
	public static final RegistryObject<Block> SULFURIC_ACID = REGISTRY.register("sulfuric_acid", () -> new SulfuricAcidBlock());
	public static final RegistryObject<Block> MARS_BRICKS = REGISTRY.register("mars_bricks", () -> new MarsBricksBlock());
	public static final RegistryObject<Block> MARS_BRICKS_SLAB = REGISTRY.register("mars_bricks_slab", () -> new MarsBricksSlabBlock());
	public static final RegistryObject<Block> MARS_BRICKS_STAIRS = REGISTRY.register("mars_bricks_stairs", () -> new MarsBricksStairsBlock());
	public static final RegistryObject<Block> MARS_BRICKS_WALL = REGISTRY.register("mars_bricks_wall", () -> new MarsBricksWallBlock());
	public static final RegistryObject<Block> PETROLEUM = REGISTRY.register("petroleum", () -> new PetroleumBlock());
	public static final RegistryObject<Block> TRUE_KRYPTONITE_BLOCK = REGISTRY.register("true_kryptonite_block", () -> new TrueKryptoniteBlockBlock());
	public static final RegistryObject<Block> THIN_ICE = REGISTRY.register("thin_ice", () -> new ThinIceBlock());
	public static final RegistryObject<Block> THIN_ICE_2 = REGISTRY.register("thin_ice_2", () -> new ThinIce2Block());
	public static final RegistryObject<Block> THIN_ICE_3 = REGISTRY.register("thin_ice_3", () -> new ThinIce3Block());
	public static final RegistryObject<Block> THIN_ICE_4 = REGISTRY.register("thin_ice_4", () -> new ThinIce4Block());
	public static final RegistryObject<Block> COMPRESSED_PACKED_ICE = REGISTRY.register("compressed_packed_ice", () -> new CompressedPackedIceBlock());
	public static final RegistryObject<Block> COMPRESSED_ICE_BLOCK = REGISTRY.register("compressed_ice_block", () -> new CompressedIceBlockBlock());
	public static final RegistryObject<Block> REINFORCED_ICE = REGISTRY.register("reinforced_ice", () -> new ReinforcedIceBlock());
	public static final RegistryObject<Block> TRANSMUTATION_TABLE = REGISTRY.register("transmutation_table", () -> new TransmutationTableBlock());
	public static final RegistryObject<Block> KRYPTONIAN_COMPUTER = REGISTRY.register("kryptonian_computer", () -> new KryptonianComputerBlock());
	public static final RegistryObject<Block> DWARF_STAR_DOOR = REGISTRY.register("dwarf_star_door", () -> new DwarfStarDoorBlock());
	public static final RegistryObject<Block> DROPPED_KEY = REGISTRY.register("dropped_key", () -> new DroppedKeyBlock());
	public static final RegistryObject<Block> REINFORCED_PACKED_ICE_LIGHT = REGISTRY.register("reinforced_packed_ice_light", () -> new ReinforcedPackedIceLightBlock());
	public static final RegistryObject<Block> COPPER_GRATE = REGISTRY.register("copper_grate", () -> new CopperGrateBlock());
	public static final RegistryObject<Block> COPPER_ELECTRIFIER = REGISTRY.register("copper_electrifier", () -> new CopperElectrifierBlock());
	public static final RegistryObject<Block> RUBIK_CUBE = REGISTRY.register("rubik_cube", () -> new RubikCubeBlock());
	public static final RegistryObject<Block> PUZZLE_BLOCK = REGISTRY.register("puzzle_block", () -> new PuzzleBlockBlock());
	public static final RegistryObject<Block> ICE_LENSE = REGISTRY.register("ice_lense", () -> new IceLenseBlock());

	// Start of user code block custom blocks
	// End of user code block custom blocks
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class BlocksClientSideHandler {
		@SubscribeEvent
		public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
			StilledWaterBlock.blockColorLoad(event);
			PoisonIvyBlock.blockColorLoad(event);
		}

		@SubscribeEvent
		public static void itemColorLoad(RegisterColorHandlersEvent.Item event) {
			PoisonIvyBlock.itemColorLoad(event);
		}
	}
}
