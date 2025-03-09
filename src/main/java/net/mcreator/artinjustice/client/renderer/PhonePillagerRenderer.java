
package net.mcreator.artinjustice.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.artinjustice.entity.PhonePillagerEntity;
import net.mcreator.artinjustice.client.model.Modelpillagermodel;

public class PhonePillagerRenderer extends MobRenderer<PhonePillagerEntity, Modelpillagermodel<PhonePillagerEntity>> {
	public PhonePillagerRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelpillagermodel(context.bakeLayer(Modelpillagermodel.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(PhonePillagerEntity entity) {
		return new ResourceLocation("art5019injustice:textures/entities/phone_guy.png");
	}
}
