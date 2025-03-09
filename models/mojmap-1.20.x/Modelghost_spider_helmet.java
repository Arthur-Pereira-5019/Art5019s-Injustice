// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelghost_spider_helmet<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "ghost_spider_helmet"), "main");
	private final ModelPart Head;

	public Modelghost_spider_helmet(ModelPart root) {
		this.Head = root.getChild("Head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(1.0F)).texOffs(45, 15)
						.addBox(5.5F, -10.0F, -6.0F, 1.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(45, 16)
						.addBox(4.5F, -10.0F, 0.0F, 1.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(1, 33)
						.addBox(-5.5F, -10.0F, 0.0F, 1.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(40, 32)
						.addBox(-4.5F, -9.0F, 5.0F, 9.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(45, 58)
						.addBox(-4.5F, -10.0F, 0.0F, 9.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(5, 57)
						.addBox(-5.5F, -11.0F, -6.0F, 11.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = Head
				.addOrReplaceChild("cube_r1",
						CubeListBuilder.create().texOffs(45, 15).addBox(5.5F, -10.0F, 0.0F, 1.0F, 11.0F, 6.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
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