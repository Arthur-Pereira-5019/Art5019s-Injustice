
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.artinjustice.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.artinjustice.client.gui.VillagerPassScreen;
import net.mcreator.artinjustice.client.gui.VenomInventoryScreen;
import net.mcreator.artinjustice.client.gui.TransmutationGUIScreen;
import net.mcreator.artinjustice.client.gui.TodayProblemScreen;
import net.mcreator.artinjustice.client.gui.TodayProblemBackupScreen;
import net.mcreator.artinjustice.client.gui.Test5Screen;
import net.mcreator.artinjustice.client.gui.TesseractGUIScreen;
import net.mcreator.artinjustice.client.gui.SummoningBookGUIScreen;
import net.mcreator.artinjustice.client.gui.SuittableguiScreen;
import net.mcreator.artinjustice.client.gui.SuitSchemeMenuVoughtExecutiveScreen;
import net.mcreator.artinjustice.client.gui.SignalMachineBlockScreen;
import net.mcreator.artinjustice.client.gui.SawmillGuiScreen;
import net.mcreator.artinjustice.client.gui.PowerGuiSpidermanScreen;
import net.mcreator.artinjustice.client.gui.PowerGuiPeakHumanScreen;
import net.mcreator.artinjustice.client.gui.PetriTableGuiScreen;
import net.mcreator.artinjustice.client.gui.MicroscopeGUIScreen;
import net.mcreator.artinjustice.client.gui.MerchandiseMenuVoughtExecutiveScreen;
import net.mcreator.artinjustice.client.gui.MainMenuVoughtExecutiveScreen;
import net.mcreator.artinjustice.client.gui.LeadcaseScreen;
import net.mcreator.artinjustice.client.gui.InfluenceMenuVoughtExecutiveScreen;
import net.mcreator.artinjustice.client.gui.DeathstrokeTrainGUIScreen;
import net.mcreator.artinjustice.client.gui.CorpseGuiScreen;
import net.mcreator.artinjustice.client.gui.ComputerGUIScreen;
import net.mcreator.artinjustice.client.gui.CompoundVMenuVoughtExecutiveScreen;
import net.mcreator.artinjustice.client.gui.ChemistryTableGUI2Screen;
import net.mcreator.artinjustice.client.gui.BountyPaperGUIScreen;
import net.mcreator.artinjustice.client.gui.ArmorAssemblerScreen;
import net.mcreator.artinjustice.client.gui.AnnotationJeffersonJacksonScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class Art5019injusticeModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(Art5019injusticeModMenus.POWER_GUI_SPIDERMAN.get(), PowerGuiSpidermanScreen::new);
			MenuScreens.register(Art5019injusticeModMenus.LEADCASE.get(), LeadcaseScreen::new);
			MenuScreens.register(Art5019injusticeModMenus.SUITTABLEGUI.get(), SuittableguiScreen::new);
			MenuScreens.register(Art5019injusticeModMenus.DEATHSTROKE_TRAIN_GUI.get(), DeathstrokeTrainGUIScreen::new);
			MenuScreens.register(Art5019injusticeModMenus.POWER_GUI_PEAK_HUMAN.get(), PowerGuiPeakHumanScreen::new);
			MenuScreens.register(Art5019injusticeModMenus.BOUNTY_PAPER_GUI.get(), BountyPaperGUIScreen::new);
			MenuScreens.register(Art5019injusticeModMenus.MICROSCOPE_GUI.get(), MicroscopeGUIScreen::new);
			MenuScreens.register(Art5019injusticeModMenus.TESSERACT_GUI.get(), TesseractGUIScreen::new);
			MenuScreens.register(Art5019injusticeModMenus.SUMMONING_BOOK_GUI.get(), SummoningBookGUIScreen::new);
			MenuScreens.register(Art5019injusticeModMenus.COMPUTER_GUI.get(), ComputerGUIScreen::new);
			MenuScreens.register(Art5019injusticeModMenus.ARMOR_ASSEMBLER.get(), ArmorAssemblerScreen::new);
			MenuScreens.register(Art5019injusticeModMenus.SIGNAL_MACHINE_BLOCK.get(), SignalMachineBlockScreen::new);
			MenuScreens.register(Art5019injusticeModMenus.SAWMILL_GUI.get(), SawmillGuiScreen::new);
			MenuScreens.register(Art5019injusticeModMenus.VILLAGER_PASS.get(), VillagerPassScreen::new);
			MenuScreens.register(Art5019injusticeModMenus.MAIN_MENU_VOUGHT_EXECUTIVE.get(), MainMenuVoughtExecutiveScreen::new);
			MenuScreens.register(Art5019injusticeModMenus.COMPOUND_V_MENU_VOUGHT_EXECUTIVE.get(), CompoundVMenuVoughtExecutiveScreen::new);
			MenuScreens.register(Art5019injusticeModMenus.SUIT_SCHEME_MENU_VOUGHT_EXECUTIVE.get(), SuitSchemeMenuVoughtExecutiveScreen::new);
			MenuScreens.register(Art5019injusticeModMenus.MERCHANDISE_MENU_VOUGHT_EXECUTIVE.get(), MerchandiseMenuVoughtExecutiveScreen::new);
			MenuScreens.register(Art5019injusticeModMenus.INFLUENCE_MENU_VOUGHT_EXECUTIVE.get(), InfluenceMenuVoughtExecutiveScreen::new);
			MenuScreens.register(Art5019injusticeModMenus.TEST_5.get(), Test5Screen::new);
			MenuScreens.register(Art5019injusticeModMenus.CORPSE_GUI.get(), CorpseGuiScreen::new);
			MenuScreens.register(Art5019injusticeModMenus.PETRI_TABLE_GUI.get(), PetriTableGuiScreen::new);
			MenuScreens.register(Art5019injusticeModMenus.TODAY_PROBLEM.get(), TodayProblemScreen::new);
			MenuScreens.register(Art5019injusticeModMenus.CHEMISTRY_TABLE_GUI_2.get(), ChemistryTableGUI2Screen::new);
			MenuScreens.register(Art5019injusticeModMenus.VENOM_INVENTORY.get(), VenomInventoryScreen::new);
			MenuScreens.register(Art5019injusticeModMenus.ANNOTATION_JEFFERSON_JACKSON.get(), AnnotationJeffersonJacksonScreen::new);
			MenuScreens.register(Art5019injusticeModMenus.TODAY_PROBLEM_BACKUP.get(), TodayProblemBackupScreen::new);
			MenuScreens.register(Art5019injusticeModMenus.TRANSMUTATION_GUI.get(), TransmutationGUIScreen::new);
		});
	}
}
