
package net.mcreator.artinjustice.client.renderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.artinjustice.procedures.ReturnMrNegativeDisplayStage2Procedure;
import net.mcreator.artinjustice.procedures.ReturnMrNegativeDisplayStage1Procedure;
import net.mcreator.artinjustice.entity.MrNegativeEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MrNegativeRenderer extends HumanoidMobRenderer<MrNegativeEntity, HumanoidModel<MrNegativeEntity>> {
	public MrNegativeRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
		this.addLayer(new RenderLayer<MrNegativeEntity, HumanoidModel<MrNegativeEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("art5019injustice:textures/entities/martin_li_awaken_emissive.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, MrNegativeEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (ReturnMrNegativeDisplayStage1Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<MrNegativeEntity, HumanoidModel<MrNegativeEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("art5019injustice:textures/entities/mr_negative.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, MrNegativeEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (ReturnMrNegativeDisplayStage2Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<MrNegativeEntity, HumanoidModel<MrNegativeEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("art5019injustice:textures/entities/mr_negative_emissive.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, MrNegativeEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (ReturnMrNegativeDisplayStage2Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(MrNegativeEntity entity) {
		return new ResourceLocation("art5019injustice:textures/entities/martin_li_awaken.png");
	}
}
