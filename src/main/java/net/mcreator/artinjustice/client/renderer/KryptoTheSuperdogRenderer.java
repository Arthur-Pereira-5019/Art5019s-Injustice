
package net.mcreator.artinjustice.client.renderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.Minecraft;

import net.mcreator.artinjustice.procedures.KryptoRender3ConditionProcedure;
import net.mcreator.artinjustice.procedures.KryptoRender2ConditionProcedure;
import net.mcreator.artinjustice.procedures.KryptoRender1ConditionProcedure;
import net.mcreator.artinjustice.entity.KryptoTheSuperdogEntity;
import net.mcreator.artinjustice.client.model.Modelsittingkrypto;
import net.mcreator.artinjustice.client.model.Modelkrypto;
import net.mcreator.artinjustice.client.model.Modelemptymodel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class KryptoTheSuperdogRenderer extends MobRenderer<KryptoTheSuperdogEntity, Modelemptymodel<KryptoTheSuperdogEntity>> {
	public KryptoTheSuperdogRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelemptymodel(context.bakeLayer(Modelemptymodel.LAYER_LOCATION)), 0.5f);
		this.addLayer(new RenderLayer<KryptoTheSuperdogEntity, Modelemptymodel<KryptoTheSuperdogEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("art5019injustice:textures/entities/wolf.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, KryptoTheSuperdogEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (KryptoRender1ConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					EntityModel model = new Modelkrypto(Minecraft.getInstance().getEntityModels().bakeLayer(Modelkrypto.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<KryptoTheSuperdogEntity, Modelemptymodel<KryptoTheSuperdogEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("art5019injustice:textures/entities/kryptonitecollar.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, KryptoTheSuperdogEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (KryptoRender2ConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					EntityModel model = new Modelkrypto(Minecraft.getInstance().getEntityModels().bakeLayer(Modelkrypto.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<KryptoTheSuperdogEntity, Modelemptymodel<KryptoTheSuperdogEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("art5019injustice:textures/entities/kryptonite_collar_glow.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, KryptoTheSuperdogEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (KryptoRender2ConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
					EntityModel model = new Modelkrypto(Minecraft.getInstance().getEntityModels().bakeLayer(Modelkrypto.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<KryptoTheSuperdogEntity, Modelemptymodel<KryptoTheSuperdogEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("art5019injustice:textures/entities/wolf.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, KryptoTheSuperdogEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (KryptoRender3ConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					EntityModel model = new Modelsittingkrypto(Minecraft.getInstance().getEntityModels().bakeLayer(Modelsittingkrypto.LAYER_LOCATION));
					this.getParentModel().copyPropertiesTo(model);
					model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
					model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(KryptoTheSuperdogEntity entity) {
		return new ResourceLocation("art5019injustice:textures/entities/wolf.png");
	}
}
