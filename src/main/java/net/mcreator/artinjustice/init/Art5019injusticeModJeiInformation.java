
package net.mcreator.artinjustice.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.List;

@JeiPlugin
public class Art5019injusticeModJeiInformation implements IModPlugin {
	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("art5019injustice:information");
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		registration.addIngredientInfo(List.of(new ItemStack(Art5019injusticeModItems.HALOTHANE_FORMULA.get()), new ItemStack(Art5019injusticeModItems.FORMULA_KEVLAR.get()), new ItemStack(Art5019injusticeModItems.FORMULA_SUPER_SOLDIER_SERUM.get()),
				new ItemStack(Art5019injusticeModItems.FORMULA_BIO_EVOLUTIVE_SERUM.get()), new ItemStack(Art5019injusticeModItems.FORMULA_MUSTARD_BOTTLE.get()), new ItemStack(Art5019injusticeModItems.ADRENALYNE_FORMULA.get()),
				new ItemStack(Art5019injusticeModItems.PURE_MAGNESIUM_FORMULA.get()), new ItemStack(Art5019injusticeModItems.MINERAL_EXTRACTION_FORMULA.get()), new ItemStack(Art5019injusticeModItems.FORMULA_FERRIC_CHLORIDE.get()),
				new ItemStack(Art5019injusticeModItems.FORMULA_SIMPLE_ELECTROLYSIS.get()), new ItemStack(Art5019injusticeModItems.FORMULA_HYDROGEN_FLUORIDE.get()), new ItemStack(Art5019injusticeModItems.FORMULA_ANTIMONY_TRICHLORIDE.get()),
				new ItemStack(Art5019injusticeModItems.FORMULA_TRICHLOROETHYLENE.get()), new ItemStack(Art5019injusticeModItems.SULFUR_DICHLORIDE_FORMULA.get()), new ItemStack(Art5019injusticeModItems.VENOM_SCHEME.get()),
				new ItemStack(Art5019injusticeModItems.WEB_FLUID_SCHEME.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.art5019injustice.formulas"));
		registration.addIngredientInfo(List.of(new ItemStack(Art5019injusticeModItems.METALLO_NANITES.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.art5019injustice.metallo_nanites_info"));
		registration.addIngredientInfo(List.of(new ItemStack(Art5019injusticeModItems.CONTAMINED_HUMAN_REMAINS.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.art5019injustice.contamined_human_remains_help"));
	}
}
