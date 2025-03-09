package net.mcreator.artinjustice.client.renderer;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.artinjustice.entity.FlashGrenadeThrownEntity;
import net.mcreator.artinjustice.client.model.Modelgrenade_Flash;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class FlashGrenadeThrownRenderer extends EntityRenderer<FlashGrenadeThrownEntity> {
	private static final ResourceLocation texture = new ResourceLocation("art5019injustice:textures/entities/lightgrenade.png");
	private final Modelgrenade_Flash model;

	public FlashGrenadeThrownRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modelgrenade_Flash(context.bakeLayer(Modelgrenade_Flash.LAYER_LOCATION));
	}

	@Override
	public void render(FlashGrenadeThrownEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(FlashGrenadeThrownEntity entity) {
		return texture;
	}
}
