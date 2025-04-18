
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.artinjustice.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

import net.mcreator.artinjustice.enchantment.SandmanSprinklingEnchantment;
import net.mcreator.artinjustice.enchantment.RoyaltyEnchantment;
import net.mcreator.artinjustice.enchantment.OgumBlessingEnchantment;
import net.mcreator.artinjustice.enchantment.OceanicMagicEnchantment;
import net.mcreator.artinjustice.enchantment.ModularFortuneEnchantment;
import net.mcreator.artinjustice.enchantment.HaphaestusBlessingEnchantment;
import net.mcreator.artinjustice.enchantment.EshuBindingEnchantment;
import net.mcreator.artinjustice.enchantment.DarkEnergyEnchantment;
import net.mcreator.artinjustice.Art5019injusticeMod;

public class Art5019injusticeModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, Art5019injusticeMod.MODID);
	public static final RegistryObject<Enchantment> SANDMAN_SPRINKLING = REGISTRY.register("sandman_sprinkling", () -> new SandmanSprinklingEnchantment());
	public static final RegistryObject<Enchantment> ROYALTY = REGISTRY.register("royalty", () -> new RoyaltyEnchantment());
	public static final RegistryObject<Enchantment> OCEANIC_MAGIC = REGISTRY.register("oceanic_magic", () -> new OceanicMagicEnchantment());
	public static final RegistryObject<Enchantment> MODULAR_FORTUNE = REGISTRY.register("modular_fortune", () -> new ModularFortuneEnchantment());
	public static final RegistryObject<Enchantment> ESHU_BINDING = REGISTRY.register("eshu_binding", () -> new EshuBindingEnchantment());
	public static final RegistryObject<Enchantment> DARK_ENERGY = REGISTRY.register("dark_energy", () -> new DarkEnergyEnchantment());
	public static final RegistryObject<Enchantment> HAPHAESTUS_BLESSING = REGISTRY.register("haphaestus_blessing", () -> new HaphaestusBlessingEnchantment());
	public static final RegistryObject<Enchantment> OGUM_BLESSING = REGISTRY.register("ogum_blessing", () -> new OgumBlessingEnchantment());
}
