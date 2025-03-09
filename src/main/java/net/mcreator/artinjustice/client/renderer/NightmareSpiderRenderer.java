
package net.mcreator.artinjustice.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.SpiderModel;

import net.mcreator.artinjustice.entity.NightmareSpiderEntity;

public class NightmareSpiderRenderer extends MobRenderer<NightmareSpiderEntity, SpiderModel<NightmareSpiderEntity>> {
	public NightmareSpiderRenderer(EntityRendererProvider.Context context) {
		super(context, new SpiderModel(context.bakeLayer(ModelLayers.SPIDER)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(NightmareSpiderEntity entity) {
		return new ResourceLocation("art5019injustice:textures/entities/allblacktexture.png");
	}
}
