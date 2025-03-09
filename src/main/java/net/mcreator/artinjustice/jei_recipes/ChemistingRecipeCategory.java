
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

public class ChemistingRecipeCategory implements IRecipeCategory<ChemistingRecipe> {
	public final static ResourceLocation UID = new ResourceLocation("art5019injustice", "chemisting");
	public final static ResourceLocation TEXTURE = new ResourceLocation("art5019injustice", "textures/screens/chemistry_table_jei_gui.png");
	private final IDrawable background;
	private final IDrawable icon;

	public ChemistingRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 195, 107);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(Art5019injusticeModBlocks.CHEMISTRY_TABLE.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<ChemistingRecipe> getRecipeType() {
		return Art5019injusticeModJeiPlugin.Chemisting_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Chemisting");
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
	public void setRecipe(IRecipeLayoutBuilder builder, ChemistingRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 90, 28).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.INPUT, 90, 46).addIngredients(recipe.getIngredients().get(1));
		builder.addSlot(RecipeIngredientRole.INPUT, 90, 64).addIngredients(recipe.getIngredients().get(2));
		builder.addSlot(RecipeIngredientRole.INPUT, 108, 28).addIngredients(recipe.getIngredients().get(3));
		builder.addSlot(RecipeIngredientRole.INPUT, 108, 46).addIngredients(recipe.getIngredients().get(4));
		builder.addSlot(RecipeIngredientRole.INPUT, 108, 64).addIngredients(recipe.getIngredients().get(5));
		builder.addSlot(RecipeIngredientRole.INPUT, 126, 28).addIngredients(recipe.getIngredients().get(6));
		builder.addSlot(RecipeIngredientRole.INPUT, 126, 46).addIngredients(recipe.getIngredients().get(7));
		builder.addSlot(RecipeIngredientRole.INPUT, 126, 64).addIngredients(recipe.getIngredients().get(8));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 162, 46).addItemStack(recipe.getResultItem(null));
		builder.addSlot(RecipeIngredientRole.INPUT, 45, 52).addIngredients(recipe.getIngredients().get(9));
	}
}
