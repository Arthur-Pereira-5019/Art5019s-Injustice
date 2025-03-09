
package net.mcreator.artinjustice.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.artinjustice.entity.MrNegativeOffEntity;
import net.mcreator.artinjustice.client.model.Modelmrnegativefallen;

public class MrNegativeOffRenderer extends MobRenderer<MrNegativeOffEntity, Modelmrnegativefallen<MrNegativeOffEntity>> {
	public MrNegativeOffRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelmrnegativefallen(context.bakeLayer(Modelmrnegativefallen.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MrNegativeOffEntity entity) {
		return new ResourceLocation("art5019injustice:textures/entities/martin_li_off.png");
	}
}
