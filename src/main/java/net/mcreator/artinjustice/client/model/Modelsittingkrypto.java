package net.mcreator.artinjustice.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelsittingkrypto<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("art5019injustice", "modelsittingkrypto"), "main");
	public final ModelPart head;
	public final ModelPart body;
	public final ModelPart upperBody;
	public final ModelPart leg0;
	public final ModelPart leg1;
	public final ModelPart leg2;
	public final ModelPart leg3;
	public final ModelPart tail;

	public Modelsittingkrypto(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.upperBody = root.getChild("upperBody");
		this.leg0 = root.getChild("leg0");
		this.leg1 = root.getChild("leg1");
		this.leg2 = root.getChild("leg2");
		this.leg3 = root.getChild("leg3");
		this.tail = root.getChild("tail");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 4.0F, new CubeDeformation(0.4F)).texOffs(16, 14).addBox(-3.0F, -5.0F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.4F)).texOffs(16, 14)
						.addBox(1.0F, -5.0F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.4F)).texOffs(0, 10).addBox(-1.5F, -0.0156F, -6.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.4F)),
				PartPose.offset(-1.0F, 13.5F, -7.0F));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 14.0F, 2.0F, 1.5708F, 0.0F, 0.0F));
		PartDefinition body_r1 = body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(18, 14).addBox(-4.0F, -8.4645F, -13.1924F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.4F)),
				PartPose.offsetAndRotation(0.0F, 10.0F, -2.0F, -0.7854F, 0.0F, 0.0F));
		PartDefinition upperBody = partdefinition.addOrReplaceChild("upperBody", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 14.0F, 2.0F, -1.5708F, 0.0F, 0.0F));
		PartDefinition upperBody_r1 = upperBody.addOrReplaceChild("upperBody_r1", CubeListBuilder.create().texOffs(21, 0).addBox(-5.0F, -8.5F, -1.5F, 8.0F, 6.0F, 7.0F, new CubeDeformation(0.4F)),
				PartPose.offsetAndRotation(1.0F, 10.0F, -2.0F, -0.3927F, 0.0F, 0.0F));
		PartDefinition leg0 = partdefinition.addOrReplaceChild("leg0", CubeListBuilder.create(), PartPose.offset(-2.5F, 16.0F, 7.0F));
		PartDefinition leg0_r1 = leg0.addOrReplaceChild("leg0_r1", CubeListBuilder.create().texOffs(0, 18).addBox(-3.5F, -8.0F, 6.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(2.5F, 0.0F, -11.0F, -1.5708F, 0.0F, 0.0F));
		PartDefinition leg1 = partdefinition.addOrReplaceChild("leg1", CubeListBuilder.create(), PartPose.offset(0.5F, 16.0F, 7.0F));
		PartDefinition leg1_r1 = leg1.addOrReplaceChild("leg1_r1", CubeListBuilder.create().texOffs(0, 18).addBox(-0.5F, -8.0F, 6.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.4F)),
				PartPose.offsetAndRotation(-0.5F, 0.0F, -11.0F, -1.5708F, 0.0F, 0.0F));
		PartDefinition leg2 = partdefinition.addOrReplaceChild("leg2", CubeListBuilder.create(), PartPose.offset(-2.5F, 16.0F, -4.0F));
		PartDefinition leg2_r1 = leg2.addOrReplaceChild("leg2_r1", CubeListBuilder.create().texOffs(0, 18).addBox(-4.0F, -8.0F, -5.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.4F)),
				PartPose.offsetAndRotation(2.5F, 11.0F, -3.0F, -0.7854F, 0.0F, 0.0F));
		PartDefinition leg3 = partdefinition.addOrReplaceChild("leg3", CubeListBuilder.create(), PartPose.offset(0.5F, 16.0F, -4.0F));
		PartDefinition leg3_r1 = leg3.addOrReplaceChild("leg3_r1", CubeListBuilder.create().texOffs(0, 18).addBox(0.0F, -8.0F, -5.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.4F)),
				PartPose.offsetAndRotation(-0.5F, 11.0F, -3.0F, -0.7854F, 0.0F, 0.0F));
		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 12.0F, 8.0F, 0.9599F, 0.0F, 0.0F));
		PartDefinition tail_r1 = tail.addOrReplaceChild("tail_r1", CubeListBuilder.create().texOffs(9, 18).addBox(-2.0F, -3.0F, 6.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 12.0F, -8.0F, 1.1781F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		upperBody.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg0.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.leg0.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.leg1.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.leg2.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.leg3.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
	}
}
