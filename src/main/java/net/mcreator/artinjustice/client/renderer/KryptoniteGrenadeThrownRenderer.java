package net.mcreator.artinjustice.client.renderer;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.artinjustice.entity.KryptoniteGrenadeThrownEntity;
import net.mcreator.artinjustice.client.model.Modelkryptonite_grenade_Converted;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class KryptoniteGrenadeThrownRenderer extends EntityRenderer<KryptoniteGrenadeThrownEntity> {
	private static final ResourceLocation texture = new ResourceLocation("art5019injustice:textures/entities/kryptonite_grenade_thrown.png");
	private final Modelkryptonite_grenade_Converted model;

	public KryptoniteGrenadeThrownRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modelkryptonite_grenade_Converted(context.bakeLayer(Modelkryptonite_grenade_Converted.LAYER_LOCATION));
	}

	@Override
	public void render(KryptoniteGrenadeThrownEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(KryptoniteGrenadeThrownEntity entity) {
		return texture;
	}
}
