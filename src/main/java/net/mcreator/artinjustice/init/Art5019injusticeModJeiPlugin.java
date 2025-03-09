
package net.mcreator.artinjustice.init;

import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.artinjustice.jei_recipes.ContaminationRecipeCategory;
import net.mcreator.artinjustice.jei_recipes.ContaminationRecipe;
import net.mcreator.artinjustice.jei_recipes.ChemistryTableRecipeTypeRecipeCategory;
import net.mcreator.artinjustice.jei_recipes.ChemistryTableRecipeTypeRecipe;
import net.mcreator.artinjustice.jei_recipes.ChemistingRecipeCategory;
import net.mcreator.artinjustice.jei_recipes.ChemistingRecipe;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.Objects;
import java.util.List;

@JeiPlugin
public class Art5019injusticeModJeiPlugin implements IModPlugin {
	public static mezz.jei.api.recipe.RecipeType<ChemistryTableRecipeTypeRecipe> ChemistryTableRecipeType_Type = new mezz.jei.api.recipe.RecipeType<>(ChemistryTableRecipeTypeRecipeCategory.UID, ChemistryTableRecipeTypeRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<ChemistingRecipe> Chemisting_Type = new mezz.jei.api.recipe.RecipeType<>(ChemistingRecipeCategory.UID, ChemistingRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<ContaminationRecipe> Contamination_Type = new mezz.jei.api.recipe.RecipeType<>(ContaminationRecipeCategory.UID, ContaminationRecipe.class);

	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("art5019injustice:jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new ChemistryTableRecipeTypeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new ChemistingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new ContaminationRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
		List<ChemistryTableRecipeTypeRecipe> ChemistryTableRecipeTypeRecipes = recipeManager.getAllRecipesFor(ChemistryTableRecipeTypeRecipe.Type.INSTANCE);
		registration.addRecipes(ChemistryTableRecipeType_Type, ChemistryTableRecipeTypeRecipes);
		List<ChemistingRecipe> ChemistingRecipes = recipeManager.getAllRecipesFor(ChemistingRecipe.Type.INSTANCE);
		registration.addRecipes(Chemisting_Type, ChemistingRecipes);
		List<ContaminationRecipe> ContaminationRecipes = recipeManager.getAllRecipesFor(ContaminationRecipe.Type.INSTANCE);
		registration.addRecipes(Contamination_Type, ContaminationRecipes);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(Art5019injusticeModBlocks.CHEMISTRY_TABLE.get().asItem()), ChemistryTableRecipeType_Type);
		registration.addRecipeCatalyst(new ItemStack(Art5019injusticeModBlocks.CHEMISTRY_TABLE.get().asItem()), Chemisting_Type);
		registration.addRecipeCatalyst(new ItemStack(Art5019injusticeModBlocks.PETRI_TABLE_BLOCK.get().asItem()), Contamination_Type);
	}
}
