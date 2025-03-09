package net.mcreator.artinjustice.init;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraft.world.item.crafting.RecipeSerializer;

import net.mcreator.artinjustice.jei_recipes.ContaminationRecipe;
import net.mcreator.artinjustice.jei_recipes.ChemistryTableRecipeTypeRecipe;
import net.mcreator.artinjustice.jei_recipes.ChemistingRecipe;
import net.mcreator.artinjustice.Art5019injusticeMod;

@Mod.EventBusSubscriber(modid = Art5019injusticeMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Art5019injusticeModRecipeTypes {
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, "art5019injustice");

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		event.enqueueWork(() -> {
			SERIALIZERS.register(bus);
			SERIALIZERS.register("chemistry_table_recipe_type", () -> ChemistryTableRecipeTypeRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("chemisting", () -> ChemistingRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("contamination", () -> ContaminationRecipe.Serializer.INSTANCE);
		});
	}
}
