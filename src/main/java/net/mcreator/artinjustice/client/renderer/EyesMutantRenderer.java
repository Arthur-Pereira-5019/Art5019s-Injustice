
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

import net.mcreator.artinjustice.procedures.EyesMutantDisplayConditionProcedure;
import net.mcreator.artinjustice.procedures.EyesMutant4DisplayConditionProcedure;
import net.mcreator.artinjustice.procedures.EyesMutant3DisplayConditionProcedure;
import net.mcreator.artinjustice.entity.EyesMutantEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class EyesMutantRenderer extends HumanoidMobRenderer<EyesMutantEntity, HumanoidModel<EyesMutantEntity>> {
	public EyesMutantRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
		this.addLayer(new RenderLayer<EyesMutantEntity, HumanoidModel<EyesMutantEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("art5019injustice:textures/entities/mutant_2.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, EyesMutantEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (EyesMutantDisplayConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<EyesMutantEntity, HumanoidModel<EyesMutantEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("art5019injustice:textures/entities/mutant_3.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, EyesMutantEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (EyesMutant3DisplayConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
		this.addLayer(new RenderLayer<EyesMutantEntity, HumanoidModel<EyesMutantEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("art5019injustice:textures/entities/mutant_4.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, EyesMutantEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				Level world = entity.level();
				double x = entity.getX();
				double y = entity.getY();
				double z = entity.getZ();
				if (EyesMutant4DisplayConditionProcedure.execute(entity)) {
					VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
					this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
				}
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(EyesMutantEntity entity) {
		return new ResourceLocation("art5019injustice:textures/entities/mutant_1.png");
	}
}
