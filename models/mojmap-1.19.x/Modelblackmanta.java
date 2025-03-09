// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelblackmanta<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "blackmanta"), "main");
	private final ModelPart Head;

	public Modelblackmanta(ModelPart root) {
		this.Head = root.getChild("Head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(7, 45)
						.addBox(7.0F, -6.0F, -3.0F, 2.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(47, 52)
						.addBox(-9.0F, -6.0F, -3.0F, 2.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(24, 50)
						.addBox(9.0F, -5.0F, -2.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(47, 32)
						.addBox(-10.0F, -5.0F, -2.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 28)
						.addBox(5.0F, -7.0F, -4.0F, 2.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(44, 4)
						.addBox(-7.0F, -7.0F, -4.0F, 2.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-5.0F, -8.0F, -5.0F, 10.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 13)
						.addBox(-4.0F, -7.0F, -6.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);
	}
}