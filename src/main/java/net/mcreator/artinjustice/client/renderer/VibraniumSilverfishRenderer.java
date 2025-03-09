
package net.mcreator.artinjustice.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.SilverfishModel;

import net.mcreator.artinjustice.entity.VibraniumSilverfishEntity;

public class VibraniumSilverfishRenderer extends MobRenderer<VibraniumSilverfishEntity, SilverfishModel<VibraniumSilverfishEntity>> {
	public VibraniumSilverfishRenderer(EntityRendererProvider.Context context) {
		super(context, new SilverfishModel(context.bakeLayer(ModelLayers.SILVERFISH)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(VibraniumSilverfishEntity entity) {
		return new ResourceLocation("art5019injustice:textures/entities/vibranium_silverfish.png");
	}
}
