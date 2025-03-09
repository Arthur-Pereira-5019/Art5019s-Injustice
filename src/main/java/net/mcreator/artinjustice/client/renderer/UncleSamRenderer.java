
package net.mcreator.artinjustice.client.renderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.artinjustice.procedures.UncleSamModelVisualScaleProcedure;
import net.mcreator.artinjustice.entity.UncleSamEntity;
import net.mcreator.artinjustice.client.model.Modeluncle_sam;

import com.mojang.blaze3d.vertex.PoseStack;

public class UncleSamRenderer extends MobRenderer<UncleSamEntity, Modeluncle_sam<UncleSamEntity>> {
	public UncleSamRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeluncle_sam(context.bakeLayer(Modeluncle_sam.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(UncleSamEntity entity, PoseStack poseStack, float f) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		float scale = (float) UncleSamModelVisualScaleProcedure.execute(entity);
		poseStack.scale(scale, scale, scale);
	}

	@Override
	public ResourceLocation getTextureLocation(UncleSamEntity entity) {
		return new ResourceLocation("art5019injustice:textures/entities/uncle_sam.png");
	}
}
