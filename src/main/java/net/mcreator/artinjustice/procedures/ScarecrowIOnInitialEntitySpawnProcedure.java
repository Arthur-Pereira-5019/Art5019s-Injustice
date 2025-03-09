package net.mcreator.artinjustice.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.ForgeMod;

import net.mcreator.artinjustice.init.Art5019injusticeModItems;
import net.mcreator.artinjustice.init.Art5019injusticeModEnchantments;

public class ScarecrowIOnInitialEntitySpawnProcedure {
    // Define the custom attribute name as a class-level constant
    private static final String CUSTOM_ATTACK_RANGE_ATTRIBUTE = "custom.attack_range";

    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof LivingEntity _entity) {
            ItemStack _setstack = new ItemStack(Art5019injusticeModItems.HOOK_SCYTHE.get());
            _setstack.setCount(1);

            CompoundTag nbt = new CompoundTag();
            nbt.putFloat("generic.attack_damage", 6.0f);
            nbt.putFloat("generic.attack_speed", -3.2f);
            nbt.putFloat(CUSTOM_ATTACK_RANGE_ATTRIBUTE, 12.0f);

            _setstack.getOrCreateTag().put("AttributeModifiers", nbt);

            // Retrieve the custom attack range attribute
            float attackRange = _setstack.getOrCreateTag().getFloat(CUSTOM_ATTACK_RANGE_ATTRIBUTE);

            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
            if (_entity instanceof Player _player)
                _player.getInventory().setChanged();
        }

        if (entity instanceof LivingEntity _livEnt) {
            ItemStack weapon = _livEnt.getMainHandItem();
            weapon.enchant(Art5019injusticeModEnchantments.SANDMAN_SPRINKLING.get(), 3);
        }
    }
}