
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.artinjustice.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.artinjustice.world.inventory.VillagerPassMenu;
import net.mcreator.artinjustice.world.inventory.VenomInventoryMenu;
import net.mcreator.artinjustice.world.inventory.TransmutationGUIMenu;
import net.mcreator.artinjustice.world.inventory.TodayProblemMenu;
import net.mcreator.artinjustice.world.inventory.TodayProblemBackupMenu;
import net.mcreator.artinjustice.world.inventory.Test5Menu;
import net.mcreator.artinjustice.world.inventory.TesseractGUIMenu;
import net.mcreator.artinjustice.world.inventory.SummoningBookGUIMenu;
import net.mcreator.artinjustice.world.inventory.SuittableguiMenu;
import net.mcreator.artinjustice.world.inventory.SuitSchemeMenuVoughtExecutiveMenu;
import net.mcreator.artinjustice.world.inventory.SignalMachineBlockMenu;
import net.mcreator.artinjustice.world.inventory.SawmillGuiMenu;
import net.mcreator.artinjustice.world.inventory.QuicksilverQuickTravelGUIMenu;
import net.mcreator.artinjustice.world.inventory.PowerGuiSpidermanMenu;
import net.mcreator.artinjustice.world.inventory.PowerGuiPeakHumanMenu;
import net.mcreator.artinjustice.world.inventory.PetriTableGuiMenu;
import net.mcreator.artinjustice.world.inventory.MicroscopeGUIMenu;
import net.mcreator.artinjustice.world.inventory.MerchandiseMenuVoughtExecutiveMenu;
import net.mcreator.artinjustice.world.inventory.MainMenuVoughtExecutiveMenu;
import net.mcreator.artinjustice.world.inventory.LeadcaseMenu;
import net.mcreator.artinjustice.world.inventory.InfluenceMenuVoughtExecutiveMenu;
import net.mcreator.artinjustice.world.inventory.DeathstrokeTrainGUIMenu;
import net.mcreator.artinjustice.world.inventory.CorpseGuiMenu;
import net.mcreator.artinjustice.world.inventory.ComputerGUIMenu;
import net.mcreator.artinjustice.world.inventory.CompoundVMenuVoughtExecutiveMenu;
import net.mcreator.artinjustice.world.inventory.ChemistryTableGUI2Menu;
import net.mcreator.artinjustice.world.inventory.BountyPaperGUIMenu;
import net.mcreator.artinjustice.world.inventory.ArmorAssemblerMenu;
import net.mcreator.artinjustice.world.inventory.AnnotationJeffersonJacksonMenu;
import net.mcreator.artinjustice.Art5019injusticeMod;

public class Art5019injusticeModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, Art5019injusticeMod.MODID);
	public static final RegistryObject<MenuType<PowerGuiSpidermanMenu>> POWER_GUI_SPIDERMAN = REGISTRY.register("power_gui_spiderman", () -> IForgeMenuType.create(PowerGuiSpidermanMenu::new));
	public static final RegistryObject<MenuType<LeadcaseMenu>> LEADCASE = REGISTRY.register("leadcase", () -> IForgeMenuType.create(LeadcaseMenu::new));
	public static final RegistryObject<MenuType<SuittableguiMenu>> SUITTABLEGUI = REGISTRY.register("suittablegui", () -> IForgeMenuType.create(SuittableguiMenu::new));
	public static final RegistryObject<MenuType<DeathstrokeTrainGUIMenu>> DEATHSTROKE_TRAIN_GUI = REGISTRY.register("deathstroke_train_gui", () -> IForgeMenuType.create(DeathstrokeTrainGUIMenu::new));
	public static final RegistryObject<MenuType<PowerGuiPeakHumanMenu>> POWER_GUI_PEAK_HUMAN = REGISTRY.register("power_gui_peak_human", () -> IForgeMenuType.create(PowerGuiPeakHumanMenu::new));
	public static final RegistryObject<MenuType<BountyPaperGUIMenu>> BOUNTY_PAPER_GUI = REGISTRY.register("bounty_paper_gui", () -> IForgeMenuType.create(BountyPaperGUIMenu::new));
	public static final RegistryObject<MenuType<MicroscopeGUIMenu>> MICROSCOPE_GUI = REGISTRY.register("microscope_gui", () -> IForgeMenuType.create(MicroscopeGUIMenu::new));
	public static final RegistryObject<MenuType<TesseractGUIMenu>> TESSERACT_GUI = REGISTRY.register("tesseract_gui", () -> IForgeMenuType.create(TesseractGUIMenu::new));
	public static final RegistryObject<MenuType<SummoningBookGUIMenu>> SUMMONING_BOOK_GUI = REGISTRY.register("summoning_book_gui", () -> IForgeMenuType.create(SummoningBookGUIMenu::new));
	public static final RegistryObject<MenuType<ComputerGUIMenu>> COMPUTER_GUI = REGISTRY.register("computer_gui", () -> IForgeMenuType.create(ComputerGUIMenu::new));
	public static final RegistryObject<MenuType<ArmorAssemblerMenu>> ARMOR_ASSEMBLER = REGISTRY.register("armor_assembler", () -> IForgeMenuType.create(ArmorAssemblerMenu::new));
	public static final RegistryObject<MenuType<SignalMachineBlockMenu>> SIGNAL_MACHINE_BLOCK = REGISTRY.register("signal_machine_block", () -> IForgeMenuType.create(SignalMachineBlockMenu::new));
	public static final RegistryObject<MenuType<SawmillGuiMenu>> SAWMILL_GUI = REGISTRY.register("sawmill_gui", () -> IForgeMenuType.create(SawmillGuiMenu::new));
	public static final RegistryObject<MenuType<VillagerPassMenu>> VILLAGER_PASS = REGISTRY.register("villager_pass", () -> IForgeMenuType.create(VillagerPassMenu::new));
	public static final RegistryObject<MenuType<MainMenuVoughtExecutiveMenu>> MAIN_MENU_VOUGHT_EXECUTIVE = REGISTRY.register("main_menu_vought_executive", () -> IForgeMenuType.create(MainMenuVoughtExecutiveMenu::new));
	public static final RegistryObject<MenuType<CompoundVMenuVoughtExecutiveMenu>> COMPOUND_V_MENU_VOUGHT_EXECUTIVE = REGISTRY.register("compound_v_menu_vought_executive", () -> IForgeMenuType.create(CompoundVMenuVoughtExecutiveMenu::new));
	public static final RegistryObject<MenuType<SuitSchemeMenuVoughtExecutiveMenu>> SUIT_SCHEME_MENU_VOUGHT_EXECUTIVE = REGISTRY.register("suit_scheme_menu_vought_executive", () -> IForgeMenuType.create(SuitSchemeMenuVoughtExecutiveMenu::new));
	public static final RegistryObject<MenuType<MerchandiseMenuVoughtExecutiveMenu>> MERCHANDISE_MENU_VOUGHT_EXECUTIVE = REGISTRY.register("merchandise_menu_vought_executive", () -> IForgeMenuType.create(MerchandiseMenuVoughtExecutiveMenu::new));
	public static final RegistryObject<MenuType<InfluenceMenuVoughtExecutiveMenu>> INFLUENCE_MENU_VOUGHT_EXECUTIVE = REGISTRY.register("influence_menu_vought_executive", () -> IForgeMenuType.create(InfluenceMenuVoughtExecutiveMenu::new));
	public static final RegistryObject<MenuType<Test5Menu>> TEST_5 = REGISTRY.register("test_5", () -> IForgeMenuType.create(Test5Menu::new));
	public static final RegistryObject<MenuType<CorpseGuiMenu>> CORPSE_GUI = REGISTRY.register("corpse_gui", () -> IForgeMenuType.create(CorpseGuiMenu::new));
	public static final RegistryObject<MenuType<PetriTableGuiMenu>> PETRI_TABLE_GUI = REGISTRY.register("petri_table_gui", () -> IForgeMenuType.create(PetriTableGuiMenu::new));
	public static final RegistryObject<MenuType<TodayProblemMenu>> TODAY_PROBLEM = REGISTRY.register("today_problem", () -> IForgeMenuType.create(TodayProblemMenu::new));
	public static final RegistryObject<MenuType<ChemistryTableGUI2Menu>> CHEMISTRY_TABLE_GUI_2 = REGISTRY.register("chemistry_table_gui_2", () -> IForgeMenuType.create(ChemistryTableGUI2Menu::new));
	public static final RegistryObject<MenuType<VenomInventoryMenu>> VENOM_INVENTORY = REGISTRY.register("venom_inventory", () -> IForgeMenuType.create(VenomInventoryMenu::new));
	public static final RegistryObject<MenuType<AnnotationJeffersonJacksonMenu>> ANNOTATION_JEFFERSON_JACKSON = REGISTRY.register("annotation_jefferson_jackson", () -> IForgeMenuType.create(AnnotationJeffersonJacksonMenu::new));
	public static final RegistryObject<MenuType<TodayProblemBackupMenu>> TODAY_PROBLEM_BACKUP = REGISTRY.register("today_problem_backup", () -> IForgeMenuType.create(TodayProblemBackupMenu::new));
	public static final RegistryObject<MenuType<TransmutationGUIMenu>> TRANSMUTATION_GUI = REGISTRY.register("transmutation_gui", () -> IForgeMenuType.create(TransmutationGUIMenu::new));
	public static final RegistryObject<MenuType<QuicksilverQuickTravelGUIMenu>> QUICKSILVER_QUICK_TRAVEL_GUI = REGISTRY.register("quicksilver_quick_travel_gui", () -> IForgeMenuType.create(QuicksilverQuickTravelGUIMenu::new));
}
