// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modeliron_spider<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "iron_spider"), "main");
	private final ModelPart Body;
	private final ModelPart Right_Armor;
	private final ModelPart Left_Armor;

	public Modeliron_spider(ModelPart root) {
		this.Body = root.getChild("Body");
		this.Right_Armor = root.getChild("Right_Armor");
		this.Left_Armor = root.getChild("Left_Armor");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(16, 16).addBox(
				-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(1.01F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition arm_left_up = Body.addOrReplaceChild("arm_left_up",
				CubeListBuilder.create().texOffs(1, 1)
						.addBox(-4.0F, 0.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(1, 1)
						.addBox(-5.0F, -2.0F, 4.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(1, 1)
						.addBox(-6.0F, -5.0F, 5.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(1, 1)
						.addBox(-7.0F, -8.0F, 6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(1, 1)
						.addBox(-8.0F, -9.0F, 5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-9.0F, -10.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(-1, -1)
						.addBox(-10.0F, -11.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-11.0F, -11.0F, -6.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(-2, -2)
						.addBox(-11.0F, -12.0F, -4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition claw_left_down = Body.addOrReplaceChild("claw_left_down", CubeListBuilder.create(),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = claw_left_down.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(1, 1)
						.addBox(3.0F, -8.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(1, 1)
						.addBox(4.0F, -10.0F, 4.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(1, 1)
						.addBox(5.0F, -13.0F, 5.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(1, 1)
						.addBox(6.0F, -16.0F, 6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(1, 1)
						.addBox(7.0F, -17.0F, 5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(8.0F, -18.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(-1, -1)
						.addBox(9.0F, -19.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(-2, -2)
						.addBox(8.0F, -20.0F, -4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(8.0F, -19.0F, -6.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition claw_right_up = Body.addOrReplaceChild("claw_right_up",
				CubeListBuilder.create().texOffs(1, 1)
						.addBox(3.0F, 0.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(1, 1)
						.addBox(4.0F, -2.0F, 4.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(1, 1)
						.addBox(5.0F, -5.0F, 5.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(1, 1)
						.addBox(6.0F, -8.0F, 6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(1, 1)
						.addBox(7.0F, -9.0F, 5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(8.0F, -10.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(-1, -1)
						.addBox(9.0F, -11.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(8.0F, -11.0F, -6.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(-2, -2)
						.addBox(8.0F, -12.0F, -4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition arm_right_down = Body.addOrReplaceChild("arm_right_down",
				CubeListBuilder.create().texOffs(1, 1)
						.addBox(-4.0F, 0.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(1, 1)
						.addBox(-5.0F, -2.0F, 4.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(1, 1)
						.addBox(-6.0F, -5.0F, 5.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(1, 1)
						.addBox(-7.0F, -8.0F, 6.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(1, 1)
						.addBox(-8.0F, -9.0F, 5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-9.0F, -10.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(-1, -1)
						.addBox(-10.0F, -11.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-11.0F, -11.0F, -6.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(-2, -2)
						.addBox(-11.0F, -12.0F, -4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Right_Armor = partdefinition.addOrReplaceChild("Right_Armor", CubeListBuilder.create()
				.texOffs(40, 16).addBox(-8.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Left_Armor = partdefinition.addOrReplaceChild("Left_Armor",
				CubeListBuilder.create().texOffs(40, 16).mirror()
						.addBox(4.0F, -24.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)).mirror(false),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Armor.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Armor.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.Right_Armor.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.Left_Armor.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
	}
}