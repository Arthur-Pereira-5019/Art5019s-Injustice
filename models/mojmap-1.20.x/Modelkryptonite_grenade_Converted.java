// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelkryptonite_grenade_Converted<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "kryptonite_grenade_converted"), "main");
	private final ModelPart group;

	public Modelkryptonite_grenade_Converted(ModelPart root) {
		this.group = root.getChild("group");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition group = partdefinition.addOrReplaceChild("group",
				CubeListBuilder.create().texOffs(8, 6)
						.addBox(-9.0F, -1.0F, 7.0F, 2.0F, 0.5F, 2.0F, new CubeDeformation(0.0F)).texOffs(9, 8)
						.addBox(-9.0F, -5.0F, 7.0F, 2.0F, 0.5F, 2.0F, new CubeDeformation(0.0F)).texOffs(3, 0)
						.addBox(-9.5F, -4.5F, 6.5F, 3.0F, 3.5F, 3.0F, new CubeDeformation(0.0F)).texOffs(8, 9).mirror()
						.addBox(-8.25F, -5.5F, 9.0F, 0.5F, 0.5F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(1, 10).addBox(-8.25F, -6.5F, 9.0F, 0.5F, 0.5F, 1.0F, new CubeDeformation(0.0F))
						.texOffs(10, 10).addBox(-8.25F, -6.5F, 10.0F, 0.5F, 1.0F, 0.5F, new CubeDeformation(0.0F))
						.texOffs(10, 10).addBox(-8.25F, -6.0F, 8.5F, 0.5F, 1.0F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offset(8.0F, 24.0F, -8.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		group.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}