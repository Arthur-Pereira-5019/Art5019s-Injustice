
/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package net.mcreator.artinjustice.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicItemListing;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.npc.VillagerProfession;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Art5019injusticeModTrades {
	@SubscribeEvent
	public static void registerWanderingTrades(WandererTradesEvent event) {
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 29),

				new ItemStack(Art5019injusticeModItems.BOUNTY_PAPER.get()), 1, 4, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 5),

				new ItemStack(Art5019injusticeModItems.PEPPER_SEEDS.get()), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 7),

				new ItemStack(Art5019injusticeModItems.TOMATO_SEEDS.get()), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 33),

				new ItemStack(Art5019injusticeModItems.DICE.get()), 3, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 7),

				new ItemStack(Art5019injusticeModBlocks.LILAC_CATTLEYA.get()), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 7),

				new ItemStack(Art5019injusticeModBlocks.YELLOW_CATTLEYA.get()), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 7),

				new ItemStack(Art5019injusticeModBlocks.WHITE_ORCHID.get()), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 7),

				new ItemStack(Art5019injusticeModBlocks.PURPLE_ORCHID.get()), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD),

				new ItemStack(Art5019injusticeModBlocks.WINE_ORCHID.get()), 10, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 4),

				new ItemStack(Art5019injusticeModItems.NEWSPAPER.get()), 1, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 7),

				new ItemStack(Art5019injusticeModBlocks.VENUS_FLY_TRAP.get()), 10, 5, 0.05f));
	}

	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == Art5019injusticeModVillagerProfessions.CIENTIST.get()) {
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Art5019injusticeModBlocks.URANIUM_BLOCK.get()), new ItemStack(Items.EMERALD, 61), new ItemStack(Art5019injusticeModItems.ENRICHED_URANIUM.get()), 5, 5, 0.08f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Blocks.ANDESITE, 24),

					new ItemStack(Items.EMERALD), 22, 3, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Blocks.BONE_BLOCK, 11),

					new ItemStack(Items.EMERALD), 22, 4, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Art5019injusticeModItems.LEAD_INGOT.get(), 11),

					new ItemStack(Items.EMERALD), 22, 10, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 39),

					new ItemStack(Art5019injusticeModItems.WEB_CYLINDER.get()), 7, 20, 0.08f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.GUNPOWDER, 13),

					new ItemStack(Items.EMERALD), 22, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Art5019injusticeModItems.ADRENALYNE_SYRINGE.get()), new ItemStack(Blocks.EMERALD_BLOCK, 3), new ItemStack(Art5019injusticeModItems.ADREN_V_3.get()), 3, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Blocks.EMERALD_BLOCK, 2), new ItemStack(Items.PAPER, 4), new ItemStack(Art5019injusticeModItems.CHEMISTRY_FORMULA_KIT.get()), 2, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 7), new ItemStack(Art5019injusticeModItems.PETROLEUM_BUCKET.get()), new ItemStack(Art5019injusticeModItems.TEREPHTHALOYL_CHLORIDE.get(), 4), 10, 7, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 11), new ItemStack(Art5019injusticeModItems.CHLORINE_BOTTLE.get(), 3), new ItemStack(Art5019injusticeModItems.P_PHENYLENEDIAMINE.get(), 3), 10, 7, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 6), new ItemStack(Items.BOOK), new ItemStack(Art5019injusticeModItems.CHEMISTRY_BOOK_1.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 10), new ItemStack(Art5019injusticeModItems.CHEMISTRY_BOOK_1.get()), new ItemStack(Art5019injusticeModItems.CHEMISTRY_BOOK_2.get()), 10, 7, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 14), new ItemStack(Art5019injusticeModItems.CHEMISTRY_BOOK_2.get()), new ItemStack(Art5019injusticeModItems.CHEMISTRY_BOOK_3.get()), 10, 11, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 18), new ItemStack(Art5019injusticeModItems.CHEMISTRY_BOOK_3.get()), new ItemStack(Art5019injusticeModItems.CHEMISTRY_BOOK_4.get()), 10, 17, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 22), new ItemStack(Art5019injusticeModItems.CHEMISTRY_BOOK_4.get()), new ItemStack(Art5019injusticeModItems.CHEMISTRY_BOOK_5.get()), 10, 25, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 26), new ItemStack(Art5019injusticeModItems.CHEMISTRY_BOOK_5.get()), new ItemStack(Art5019injusticeModItems.CHEMISTRY_BOOK_6.get()), 10, 5, 0.05f));
		}
		if (event.getType() == Art5019injusticeModVillagerProfessions.ENGINEER.get()) {
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Blocks.REDSTONE_BLOCK, 3),

					new ItemStack(Items.EMERALD), 10, 10, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.IRON_INGOT, 13),

					new ItemStack(Items.EMERALD), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 37),

					new ItemStack(Art5019injusticeModItems.PISTOL_ITEM.get()), 10, 20, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.COMPARATOR, 5),

					new ItemStack(Items.EMERALD), 10, 15, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Art5019injusticeModItems.MICROCHIP.get()), new ItemStack(Items.EMERALD, 24), new ItemStack(Art5019injusticeModItems.ADVANCED_CIRCUIT_BOARD.get()), 10, 15, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 17),

					new ItemStack(Art5019injusticeModItems.PISTOL_MAGAZINE.get()), 10, 15, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 7),

					new ItemStack(Art5019injusticeModItems.SEWING_KIT.get()), 10, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 23), new ItemStack(Art5019injusticeModItems.UPGRADE_KIT.get()), new ItemStack(Art5019injusticeModItems.NANOTECH_KIT.get()), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 7), new ItemStack(Art5019injusticeModItems.EXPLOSIVE_CHARGE.get()), new ItemStack(Art5019injusticeModItems.MISSILE.get()), 10, 15, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Art5019injusticeModItems.PALLADIUM_INGOT.get()), new ItemStack(Items.EMERALD, 43), new ItemStack(Art5019injusticeModItems.BADASSIUM_CORE.get()), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 29),

					new ItemStack(Art5019injusticeModItems.PROBABILITY_FIELD_EMISSOR_DISRUPTOR.get()), 10, 20, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 34),

					new ItemStack(Art5019injusticeModItems.INTERDIMENSIONAL_EXTRAPOLATOR.get()), 1, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 23),

					new ItemStack(Art5019injusticeModItems.SHOOTING_DEVICE.get()), 2, 10, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), new ItemStack(Blocks.TNT), new ItemStack(Art5019injusticeModBlocks.RANGED_TNT.get()), 8, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 14),

					new ItemStack(Art5019injusticeModItems.RADIATION_MEASURER.get()), 3, 7, 0.05f));
		}
		if (event.getType() == VillagerProfession.LEATHERWORKER) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 5), new ItemStack(Items.LEATHER), new ItemStack(Art5019injusticeModItems.WHITE_FABRIC.get()), 10, 3, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 5), new ItemStack(Items.LEATHER), new ItemStack(Art5019injusticeModItems.FABRIC_BLACK.get()), 10, 3, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 7), new ItemStack(Items.LEATHER), new ItemStack(Art5019injusticeModItems.FABRIC_RED.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 7), new ItemStack(Items.LEATHER), new ItemStack(Art5019injusticeModItems.FABRIC_LIME.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 7), new ItemStack(Items.LEATHER), new ItemStack(Art5019injusticeModItems.FABRIC_BLUE.get()), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 11), new ItemStack(Items.LEATHER), new ItemStack(Art5019injusticeModItems.FABRIC_ORANGE.get()), 10, 8, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 11), new ItemStack(Items.LEATHER), new ItemStack(Art5019injusticeModItems.FABRIC_GREEN.get()), 10, 8, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 11), new ItemStack(Items.LEATHER), new ItemStack(Art5019injusticeModItems.FABRIC_BROWN.get()), 10, 8, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 11), new ItemStack(Items.LEATHER), new ItemStack(Art5019injusticeModItems.FABRIC_CYAN.get()), 10, 8, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 11), new ItemStack(Items.LEATHER), new ItemStack(Art5019injusticeModItems.FABRIC_LIGHT_BLUE.get()), 10, 8, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 11), new ItemStack(Items.LEATHER), new ItemStack(Art5019injusticeModItems.FABRIC_PURPLE.get()), 10, 8, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 7), new ItemStack(Items.LEATHER), new ItemStack(Art5019injusticeModItems.FABRIC_YELLOW.get()), 10, 5, 0.05f));
		}
		if (event.getType() == VillagerProfession.ARMORER) {
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 12), new ItemStack(Items.PAPER), new ItemStack(Art5019injusticeModItems.BANE_SUIT_SCHEME.get()), 10, 25, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 12), new ItemStack(Items.PAPER), new ItemStack(Art5019injusticeModItems.SCARECROW_SUIT_SCHEME.get()), 10, 25, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 12), new ItemStack(Items.PAPER), new ItemStack(Art5019injusticeModItems.SPIDER_BADGE.get()), 10, 25, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 12), new ItemStack(Items.PAPER), new ItemStack(Art5019injusticeModItems.ATLANTEAN_SUIT_SCHEME.get()), 10, 25, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 12), new ItemStack(Items.PAPER), new ItemStack(Art5019injusticeModItems.X_GENE_SUIT_SCHEME.get()), 10, 25, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 12), new ItemStack(Items.PAPER), new ItemStack(Art5019injusticeModItems.NEURO_SUIT_SCHEME.get()), 10, 25, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 12), new ItemStack(Items.PAPER), new ItemStack(Art5019injusticeModItems.BLACK_PANTHER_SUIT_SCHEME.get()), 10, 25, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 12), new ItemStack(Items.PAPER), new ItemStack(Art5019injusticeModItems.SUIT_SCHEME_SUPER_SOLDIER.get()), 10, 25, 0.05f));
		}
		if (event.getType() == VillagerProfession.WEAPONSMITH) {
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 18),

					new ItemStack(Art5019injusticeModItems.KATANA.get()), 3, 5, 0.05f));
		}
		if (event.getType() == VillagerProfession.CLERIC) {
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.TOTEM_OF_UNDYING), new ItemStack(Items.EMERALD, 24), new ItemStack(Art5019injusticeModItems.SUMMONING_BOOK.get()), 3, 5, 0.09f));
		}
		if (event.getType() == Art5019injusticeModVillagerProfessions.GENETICIST.get()) {
			event.getTrades().get(5)
					.add(new BasicItemListing(new ItemStack(Art5019injusticeModItems.VENOM_REMAINS.get()), new ItemStack(Art5019injusticeModItems.DIAMOND_LENSES.get(), 6), new ItemStack(Art5019injusticeModItems.SYMBIOTE.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Art5019injusticeModItems.BLOOD_SYRINGE_POISON.get()),

					new ItemStack(Items.EMERALD, 3), 10, 3, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.BONE, 21),

					new ItemStack(Items.EMERALD), 10, 3, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Art5019injusticeModItems.X_GENE_BLOOD_SYRINGE.get()),

					new ItemStack(Blocks.EMERALD_BLOCK, 15), 10, 7, 0.05f));
			event.getTrades().get(3)
					.add(new BasicItemListing(new ItemStack(Art5019injusticeModItems.EMPTY_SYRINGE.get()), new ItemStack(Art5019injusticeModItems.DIAMOND_LENSES.get(), 5), new ItemStack(Art5019injusticeModItems.ANTI_X_GENE.get()), 10, 10, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Art5019injusticeModItems.STRANGE_BONE.get()),

					new ItemStack(Blocks.EMERALD_BLOCK, 9), 10, 13, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Art5019injusticeModItems.SYMBIOTE.get()),

					new ItemStack(Blocks.EMERALD_BLOCK, 13), 10, 10, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Blocks.SNIFFER_EGG),

					new ItemStack(Blocks.EMERALD_BLOCK, 2), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 7),

					new ItemStack(Art5019injusticeModItems.ANTIBIOTICS.get()), 3, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Art5019injusticeModItems.VENOMIZED_SPIDER_REMAINS.get()), new ItemStack(Art5019injusticeModItems.DIAMOND_LENSES.get(), 6),
					new ItemStack(Art5019injusticeModItems.PSP_SYMBIOTE.get()), 10, 5, 0.05f));
		}
		if (event.getType() == VillagerProfession.FARMER) {
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 9),

					new ItemStack(Art5019injusticeModItems.PEANUT_BUTTER.get(), 2), 10, 7, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 2),

					new ItemStack(Art5019injusticeModItems.PINGO_DOCE.get()), 10, 5, 0.05f));
		}
		if (event.getType() == Art5019injusticeModVillagerProfessions.CIENTIST.get()) {
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 34), new ItemStack(Items.BOOK), new ItemStack(Art5019injusticeModItems.ARCHER_BOOK.get()), 10, 17, 0.05f));
		}
	}
}
