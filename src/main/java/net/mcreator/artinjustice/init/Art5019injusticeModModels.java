
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.artinjustice.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.artinjustice.client.model.Modelvenom_head;
import net.mcreator.artinjustice.client.model.Modeluncle_sam;
import net.mcreator.artinjustice.client.model.Modeltrident_thrown;
import net.mcreator.artinjustice.client.model.Modelsteve;
import net.mcreator.artinjustice.client.model.Modelspiderman_tm2_mask;
import net.mcreator.artinjustice.client.model.Modelspiderman_tm2_chest;
import net.mcreator.artinjustice.client.model.Modelspiderman_tm2_boots;
import net.mcreator.artinjustice.client.model.Modelqueenmaeve_chest;
import net.mcreator.artinjustice.client.model.Modelpillagermodel;
import net.mcreator.artinjustice.client.model.Modelmrnegativefallen;
import net.mcreator.artinjustice.client.model.Modelkryptonite_grenade_Converted;
import net.mcreator.artinjustice.client.model.Modelkrypto;
import net.mcreator.artinjustice.client.model.Modeliron_spider_th;
import net.mcreator.artinjustice.client.model.Modeliron_spider;
import net.mcreator.artinjustice.client.model.Modelinner_demon_mask;
import net.mcreator.artinjustice.client.model.Modelhazmat_helmet;
import net.mcreator.artinjustice.client.model.Modelgrenade_Flash;
import net.mcreator.artinjustice.client.model.Modelgrenade_Electric;
import net.mcreator.artinjustice.client.model.Modelgrenade_Converted;
import net.mcreator.artinjustice.client.model.Modelghost_spider_helmet_slim;
import net.mcreator.artinjustice.client.model.Modelghost_spider_helmet;
import net.mcreator.artinjustice.client.model.Modeldomino_head;
import net.mcreator.artinjustice.client.model.Modelcustom_model;
import net.mcreator.artinjustice.client.model.Modelcape_frame_5;
import net.mcreator.artinjustice.client.model.Modelcape_frame_4;
import net.mcreator.artinjustice.client.model.Modelcape_frame_3;
import net.mcreator.artinjustice.client.model.Modelcape_frame_2;
import net.mcreator.artinjustice.client.model.Modelcape_frame_1;
import net.mcreator.artinjustice.client.model.Modelblackmanta_legs;
import net.mcreator.artinjustice.client.model.Modelblackmanta_chest;
import net.mcreator.artinjustice.client.model.Modelblackmanta;
import net.mcreator.artinjustice.client.model.Modelblack_manta_layer_legs;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class Art5019injusticeModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelblackmanta_chest.LAYER_LOCATION, Modelblackmanta_chest::createBodyLayer);
		event.registerLayerDefinition(Modelcape_frame_2.LAYER_LOCATION, Modelcape_frame_2::createBodyLayer);
		event.registerLayerDefinition(Modeliron_spider_th.LAYER_LOCATION, Modeliron_spider_th::createBodyLayer);
		event.registerLayerDefinition(Modelcape_frame_3.LAYER_LOCATION, Modelcape_frame_3::createBodyLayer);
		event.registerLayerDefinition(Modelvenom_head.LAYER_LOCATION, Modelvenom_head::createBodyLayer);
		event.registerLayerDefinition(Modelinner_demon_mask.LAYER_LOCATION, Modelinner_demon_mask::createBodyLayer);
		event.registerLayerDefinition(Modelmrnegativefallen.LAYER_LOCATION, Modelmrnegativefallen::createBodyLayer);
		event.registerLayerDefinition(Modelcape_frame_1.LAYER_LOCATION, Modelcape_frame_1::createBodyLayer);
		event.registerLayerDefinition(Modelcape_frame_4.LAYER_LOCATION, Modelcape_frame_4::createBodyLayer);
		event.registerLayerDefinition(Modelspiderman_tm2_chest.LAYER_LOCATION, Modelspiderman_tm2_chest::createBodyLayer);
		event.registerLayerDefinition(Modelgrenade_Flash.LAYER_LOCATION, Modelgrenade_Flash::createBodyLayer);
		event.registerLayerDefinition(Modelghost_spider_helmet_slim.LAYER_LOCATION, Modelghost_spider_helmet_slim::createBodyLayer);
		event.registerLayerDefinition(Modeltrident_thrown.LAYER_LOCATION, Modeltrident_thrown::createBodyLayer);
		event.registerLayerDefinition(Modelgrenade_Electric.LAYER_LOCATION, Modelgrenade_Electric::createBodyLayer);
		event.registerLayerDefinition(Modelpillagermodel.LAYER_LOCATION, Modelpillagermodel::createBodyLayer);
		event.registerLayerDefinition(Modelblackmanta_legs.LAYER_LOCATION, Modelblackmanta_legs::createBodyLayer);
		event.registerLayerDefinition(Modelghost_spider_helmet.LAYER_LOCATION, Modelghost_spider_helmet::createBodyLayer);
		event.registerLayerDefinition(Modelsteve.LAYER_LOCATION, Modelsteve::createBodyLayer);
		event.registerLayerDefinition(Modelkrypto.LAYER_LOCATION, Modelkrypto::createBodyLayer);
		event.registerLayerDefinition(Modeldomino_head.LAYER_LOCATION, Modeldomino_head::createBodyLayer);
		event.registerLayerDefinition(Modelhazmat_helmet.LAYER_LOCATION, Modelhazmat_helmet::createBodyLayer);
		event.registerLayerDefinition(Modeluncle_sam.LAYER_LOCATION, Modeluncle_sam::createBodyLayer);
		event.registerLayerDefinition(Modelgrenade_Converted.LAYER_LOCATION, Modelgrenade_Converted::createBodyLayer);
		event.registerLayerDefinition(Modelblack_manta_layer_legs.LAYER_LOCATION, Modelblack_manta_layer_legs::createBodyLayer);
		event.registerLayerDefinition(Modelspiderman_tm2_boots.LAYER_LOCATION, Modelspiderman_tm2_boots::createBodyLayer);
		event.registerLayerDefinition(Modelcape_frame_5.LAYER_LOCATION, Modelcape_frame_5::createBodyLayer);
		event.registerLayerDefinition(Modelkryptonite_grenade_Converted.LAYER_LOCATION, Modelkryptonite_grenade_Converted::createBodyLayer);
		event.registerLayerDefinition(Modelcustom_model.LAYER_LOCATION, Modelcustom_model::createBodyLayer);
		event.registerLayerDefinition(Modelspiderman_tm2_mask.LAYER_LOCATION, Modelspiderman_tm2_mask::createBodyLayer);
		event.registerLayerDefinition(Modeliron_spider.LAYER_LOCATION, Modeliron_spider::createBodyLayer);
		event.registerLayerDefinition(Modelblackmanta.LAYER_LOCATION, Modelblackmanta::createBodyLayer);
		event.registerLayerDefinition(Modelqueenmaeve_chest.LAYER_LOCATION, Modelqueenmaeve_chest::createBodyLayer);
	}
}
