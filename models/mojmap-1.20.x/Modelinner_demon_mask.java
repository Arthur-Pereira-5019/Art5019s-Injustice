// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelinner_demon_mask<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "inner_demon_mask"), "main");
	private final ModelPart Head;

	public Modelinner_demon_mask(ModelPart root) {
		this.Head = root.getChild("Head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(1.0F)).texOffs(32, 0)
						.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(1.5F)).texOffs(55, 29)
						.addBox(5.0F, -7.0F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(55, 29)
						.addBox(6.0F, -8.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(55, 29)
						.addBox(5.0F, -4.0F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(55, 29)
						.addBox(6.0F, -5.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(55, 29)
						.addBox(5.0F, -1.0F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(55, 29)
						.addBox(3.0F, 1.0F, -3.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(55, 29)
						.addBox(4.0F, 2.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(55, 29)
						.addBox(-4.0F, 2.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(55, 29)
						.addBox(-3.0F, 1.0F, -3.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(55, 29)
						.addBox(-1.0F, 2.0F, -4.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(55, 29)
						.addBox(-1.0F, 1.0F, -3.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(55, 29)
						.addBox(6.0F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(55, 29)
						.addBox(3.0F, -3.0F, -7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(54, 28)
						.addBox(3.0F, -2.0F, -7.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(54, 28)
						.addBox(-3.0F, -2.0F, -7.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(55, 29)
						.addBox(-3.0F, -3.0F, -7.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(55, 29)
						.addBox(-7.0F, -7.0F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(55, 29)
						.addBox(-7.0F, -8.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(55, 29)
						.addBox(-7.0F, -4.0F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(55, 29)
						.addBox(-7.0F, -5.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(55, 29)
						.addBox(-7.0F, -1.0F, -3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(55, 29)
						.addBox(-7.0F, -2.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}