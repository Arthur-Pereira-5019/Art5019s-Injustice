
package net.mcreator.artinjustice.client.renderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.SpiderModel;

import net.mcreator.artinjustice.procedures.SpecialSpiderEntityShakingConditionProcedure;
import net.mcreator.artinjustice.entity.SpecialSpiderEntity;

public class SpecialSpiderRenderer extends MobRenderer<SpecialSpiderEntity, SpiderModel<SpecialSpiderEntity>> {
	public SpecialSpiderRenderer(EntityRendererProvider.Context context) {
		super(context, new SpiderModel(context.bakeLayer(ModelLayers.SPIDER)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SpecialSpiderEntity entity) {
		return new ResourceLocation("art5019injustice:textures/entities/special_spider.png");
	}

	@Override
	protected boolean isShaking(SpecialSpiderEntity entity) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		return SpecialSpiderEntityShakingConditionProcedure.execute();
	}
}
