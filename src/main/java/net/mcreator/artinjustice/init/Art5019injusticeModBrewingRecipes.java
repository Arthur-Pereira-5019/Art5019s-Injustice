
package net.mcreator.artinjustice.init;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.recipe.vanilla.IVanillaRecipeFactory;
import mezz.jei.api.recipe.vanilla.IJeiBrewingRecipe;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.List;
import java.util.ArrayList;

@JeiPlugin
public class Art5019injusticeModBrewingRecipes implements IModPlugin {
	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("art5019injustice:brewing_recipes");
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		IVanillaRecipeFactory factory = registration.getVanillaRecipeFactory();
		List<IJeiBrewingRecipe> brewingRecipes = new ArrayList<>();
		ItemStack potion = new ItemStack(Items.POTION);
		ItemStack potion2 = new ItemStack(Items.POTION);
		List<ItemStack> ingredientStack = new ArrayList<>();
		List<ItemStack> inputStack = new ArrayList<>();
		ingredientStack.add(new ItemStack(Art5019injusticeModBlocks.RARE_BLUE_FLOWER.get()));
		PotionUtils.setPotion(potion, Potions.AWKWARD);
		PotionUtils.setPotion(potion2, Art5019injusticeModPotions.SCARECROW_FORMULA.get());
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), potion2.copy()));
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(Art5019injusticeModBlocks.POISON_IVY.get()));
		PotionUtils.setPotion(potion, Potions.WATER);
		PotionUtils.setPotion(potion2, Art5019injusticeModPotions.ALLERGY_POTION.get());
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), potion2.copy()));
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(Items.POISONOUS_POTATO));
		PotionUtils.setPotion(potion, Potions.AWKWARD);
		PotionUtils.setPotion(potion2, Art5019injusticeModPotions.HUNGER_POTION.get());
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), potion2.copy()));
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(Blocks.PITCHER_PLANT));
		inputStack.add(new ItemStack(Items.HONEY_BOTTLE));
		PotionUtils.setPotion(potion, Art5019injusticeModPotions.PHEROMONES_POTION.get());
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), List.copyOf(inputStack), potion.copy()));
		ingredientStack.clear();
		inputStack.clear();
		ingredientStack.add(new ItemStack(Art5019injusticeModItems.HUMAN_EYE.get()));
		PotionUtils.setPotion(potion, Art5019injusticeModPotions.SCARECROW_FORMULA.get());
		PotionUtils.setPotion(potion2, Art5019injusticeModPotions.SCARECROW_STRONGER_FORMULA.get());
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), potion2.copy()));
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(Items.PHANTOM_MEMBRANE));
		PotionUtils.setPotion(potion, Art5019injusticeModPotions.SCARECROW_FORMULA.get());
		PotionUtils.setPotion(potion2, Art5019injusticeModPotions.SCARECROW_NIGHTMARE_FORMULA.get());
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), potion2.copy()));
		ingredientStack.clear();
		ingredientStack.add(new ItemStack(Art5019injusticeModItems.WATER_FILTER.get()));
		PotionUtils.setPotion(potion, Potions.WATER);
		brewingRecipes.add(factory.createBrewingRecipe(List.copyOf(ingredientStack), potion.copy(), new ItemStack(Art5019injusticeModItems.FRESH_WATER.get())));
		ingredientStack.clear();
		registration.addRecipes(RecipeTypes.BREWING, brewingRecipes);
	}
}
