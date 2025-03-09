
package net.mcreator.artinjustice.jei_recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.mcreator.artinjustice.init.Art5019injusticeModJeiPlugin;
import net.mcreator.artinjustice.init.Art5019injusticeModBlocks;

import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;

public class ContaminationRecipeCategory implements IRecipeCategory<ContaminationRecipe> {
	public final static ResourceLocation UID = new ResourceLocation("art5019injustice", "contamination");
	public final static ResourceLocation TEXTURE = new ResourceLocation("art5019injustice", "textures/screens/jei_microbiology_gui.png");
	private final IDrawable background;
	private final IDrawable icon;

	public ContaminationRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 175, 84);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(Art5019injusticeModBlocks.PETRI_TABLE_BLOCK.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<ContaminationRecipe> getRecipeType() {
		return Art5019injusticeModJeiPlugin.Contamination_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Contamination");
	}

	@Override
	public IDrawable getBackground() {
		return this.background;
	}

	@Override
	public IDrawable getIcon() {
		return this.icon;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, ContaminationRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 79, 34).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.INPUT, 8, 34).addIngredients(recipe.getIngredients().get(1));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 58, 34).addItemStack(recipe.getResultItem(null));
	}
}
