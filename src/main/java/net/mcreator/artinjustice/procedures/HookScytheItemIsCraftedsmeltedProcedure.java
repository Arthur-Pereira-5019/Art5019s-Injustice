package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraftforge.common.ForgeMod;

import net.mcreator.artinjustice.Art5019injusticeMod;

import java.util.UUID;

public class HookScytheItemIsCraftedsmeltedProcedure {
    public static void execute(ItemStack itemstack) {
        if (itemstack != null) {
            AttributeModifier damageModifier = new AttributeModifier(
                UUID.fromString("d06446f0-396f-11ee-94c4-325096b39f47"),
                Art5019injusticeMod.MODID + "." + "hookdamage",
                6.0,
                AttributeModifier.Operation.ADDITION
            );
            
            AttributeModifier rangeModifier = new AttributeModifier(
                UUID.fromString("5bcbeae4-39da-11ee-9a7c-325096b39f47"),
                Art5019injusticeMod.MODID + "." + "hookrange",
                13.0,
                AttributeModifier.Operation.ADDITION
            );

            AttributeModifier agilityModifier = new AttributeModifier(
                UUID.fromString("646914c4-39da-11ee-856a-325096b39f47"),
                Art5019injusticeMod.MODID + "." + "hookattackspeed",
                -3.2,
                AttributeModifier.Operation.ADDITION
            );

            itemstack.addAttributeModifier(Attributes.ATTACK_DAMAGE, damageModifier, EquipmentSlot.MAINHAND);
            itemstack.addAttributeModifier(Attributes.ATTACK_SPEED, agilityModifier, EquipmentSlot.MAINHAND);

        }
    }
}