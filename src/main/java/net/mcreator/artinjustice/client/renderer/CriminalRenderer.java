
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

import net.mcreator.artinjustice.procedures.InnerDemon2DisplayConditionProcedure;
import net.mcreator.artinjustice.procedures.InnerDemon1DisplayConditionProcedure;
import net.mcreator.artinjustice.procedures.CriminalDisplayConditionProcedure;
import net.mcreator.artinjustice.procedures.CriminalDisplayCondition4Procedure;
import net.mcreator.artinjustice.procedures.CriminalDisplayCondition3Procedure;
import net.mcreator.artinjustice.procedures.CriminalDisplayCondition2Procedure;
import net.mcreator.artinjustice.entity.CriminalEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class CriminalRenderer extends HumanoidMobRenderer<CriminalEntity, HumanoidModel<CriminalEntity>> {
	public CriminalRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
		this.addLayer(new RenderLayer<CriminalEntity, HumanoidModel<CriminalEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("art5019injustice:textures/entities/3532df57fdd88f22.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, CriminalEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (CriminalDisplayConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<CriminalEntity, HumanoidModel<CriminalEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("art5019injustice:textures/entities/criminal_1.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, CriminalEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (CriminalDisplayCondition2Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<CriminalEntity, HumanoidModel<CriminalEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("art5019injustice:textures/entities/criminal_2.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, CriminalEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (CriminalDisplayCondition3Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<CriminalEntity, HumanoidModel<CriminalEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("art5019injustice:textures/entities/otis.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, CriminalEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (CriminalDisplayCondition4Procedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<CriminalEntity, HumanoidModel<CriminalEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("art5019injustice:textures/entities/inner_demon_1.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, CriminalEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (InnerDemon1DisplayConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<CriminalEntity, HumanoidModel<CriminalEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("art5019injustice:textures/entities/inner_demon_2.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, CriminalEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (InnerDemon2DisplayConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(CriminalEntity entity) {
		return new ResourceLocation("art5019injustice:textures/entities/criminal_1.png");
	}
}
