// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelcape_frame_4<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "cape_frame_4"), "main");
	private final ModelPart Body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;

	public Modelcape_frame_4(ModelPart root) {
		this.Body = root.getChild("Body");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 19).addBox(
				-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(1.01F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Capa = Body.addOrReplaceChild("Capa",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-10.0F, -1.0F, 3.0F, 20.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(22, 40)
						.addBox(-10.0F, 1.0F, 3.7F, 20.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(22, 40)
						.addBox(-10.0F, 3.0F, 4.7F, 20.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(22, 40)
						.addBox(-10.0F, 6.0F, 6.7F, 20.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(22, 40)
						.addBox(-7.0F, 1.0F, 4.7F, 14.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(22, 40)
						.addBox(-10.0F, 4.0F, 5.7F, 20.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(22, 40)
						.addBox(-8.0F, 4.0F, 6.7F, 16.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(22, 40)
						.addBox(-10.0F, 8.0F, 9.7F, 20.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(22, 40)
						.addBox(-10.0F, 7.0F, 8.7F, 20.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(22, 40)
						.addBox(-10.0F, 6.0F, 7.7F, 20.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(22, 40)
						.addBox(-10.0F, 10.0F, 11.7F, 20.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(21, 39)
						.addBox(-10.0F, 11.0F, 12.7F, 20.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(22, 40)
						.addBox(-10.0F, 11.0F, 14.7F, 20.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(20, 38)
						.addBox(-10.0F, 12.0F, 13.7F, 20.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(20, 38)
						.addBox(-10.0F, 13.0F, 15.7F, 20.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(22, 40)
						.addBox(-10.0F, 9.0F, 10.7F, 20.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(18, 49)
						.addBox(-8.0F, 15.0F, 19.5F, 16.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(19, 50)
						.addBox(-7.0F, 16.0F, 23.5F, 14.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(20, 51)
						.addBox(-10.0F, 14.0F, 17.5F, 20.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(21, 52)
						.addBox(-4.0F, 12.0F, 16.5F, 8.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(21, 52)
						.addBox(-4.0F, 14.0F, 20.5F, 8.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(21, 52)
						.addBox(-8.0F, 16.0F, 24.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(21, 52)
						.addBox(7.0F, 16.0F, 24.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(20, 51)
						.addBox(8.0F, 15.0F, 19.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(20, 51)
						.addBox(-9.0F, 15.0F, 19.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(21, 52)
						.addBox(-4.0F, 15.0F, 24.5F, 8.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(46, 1)
						.addBox(-10.0F, -1.0F, -4.0F, 7.0F, 0.0F, 8.0F, new CubeDeformation(-0.5F)).texOffs(46, 1)
						.addBox(3.0F, -1.0F, -4.0F, 7.0F, 0.0F, 8.0F, new CubeDeformation(-0.5F)).texOffs(60, 12)
						.addBox(-9.0F, -0.3F, -3.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(60, 12)
						.addBox(7.0F, -0.3F, -3.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(52, 8)
						.addBox(9.5F, -0.3F, -2.5F, 0.0F, 1.0F, 6.0F, new CubeDeformation(0.3F)).texOffs(58, 14)
						.addBox(-9.5F, 0.7F, 0.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.3F)).texOffs(55, 10)
						.addBox(-9.5F, 2.3F, 1.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.3F)).texOffs(58, 14)
						.addBox(9.5F, 0.7F, 0.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.3F)).texOffs(52, 9)
						.addBox(9.5F, -0.3F, -3.0F, 0.0F, 1.0F, 6.0F, new CubeDeformation(0.3F)).texOffs(55, 10)
						.addBox(9.5F, 2.3F, 1.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.3F)).texOffs(52, 9)
						.addBox(-9.5F, -0.3F, -3.0F, 0.0F, 1.0F, 6.0F, new CubeDeformation(0.3F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(24, 19)
				.addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)),
				PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm",
				CubeListBuilder.create().texOffs(24, 19).mirror()
						.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)).mirror(false),
				PartPose.offset(5.0F, 2.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.RightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.LeftArm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
	}
}