
package net.mcreator.artinjustice.client.renderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.artinjustice.procedures.NotHasCollarProcedure;
import net.mcreator.artinjustice.procedures.IfKryptoHasCollarProcedure;
import net.mcreator.artinjustice.entity.KryptoTheSuperdogEntity;
import net.mcreator.artinjustice.client.model.Modelkrypto;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class KryptoTheSuperdogRenderer extends MobRenderer<KryptoTheSuperdogEntity, Modelkrypto<KryptoTheSuperdogEntity>> {
	public KryptoTheSuperdogRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelkrypto(context.bakeLayer(Modelkrypto.LAYER_LOCATION)), 0.5f);
		this.addLayer(new RenderLayer<KryptoTheSuperdogEntity, Modelkrypto<KryptoTheSuperdogEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("art5019injustice:textures/entities/wolf.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, KryptoTheSuperdogEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (NotHasCollarProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<KryptoTheSuperdogEntity, Modelkrypto<KryptoTheSuperdogEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("art5019injustice:textures/entities/kryptonitecollar.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, KryptoTheSuperdogEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (IfKryptoHasCollarProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<KryptoTheSuperdogEntity, Modelkrypto<KryptoTheSuperdogEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("art5019injustice:textures/entities/kryptonite_collar_glow.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, KryptoTheSuperdogEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (IfKryptoHasCollarProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(KryptoTheSuperdogEntity entity) {
		return new ResourceLocation("art5019injustice:textures/entities/wolf.png");
	}
}
