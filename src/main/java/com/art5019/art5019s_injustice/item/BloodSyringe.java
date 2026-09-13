package com.art5019.art5019s_injustice.item;

import com.art5019.art5019s_injustice.data.Power;
import com.art5019.art5019s_injustice.data.records.blood_syringe.BloodSyringeData;
import com.art5019.art5019s_injustice.data.records.blood_syringe.BloodSyringeEffect;
import com.art5019.art5019s_injustice.helper.PowerHelper;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static com.art5019.art5019s_injustice.data.item.ItemDataComponents.BLOOD_TYPE_COMPONENT;
import static com.art5019.art5019s_injustice.item.Items.EMPTY_SYRINGE;
import static net.minecraft.world.effect.MobEffects.POISON;
import static net.minecraft.world.effect.MobEffects.REGENERATION;

public class BloodSyringe extends Item {
    public BloodSyringe(Properties properties) {
        super(properties);
    }

    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        BloodSyringeData bloodData = player.getItemInHand(hand).get(BLOOD_TYPE_COMPONENT);
        if(level instanceof ServerLevel sl && player instanceof ServerPlayer sp) {
            if(bloodData != null) {
                applyBlood(bloodData, sl, sp);
                sp.addItem(new ItemStack(EMPTY_SYRINGE.get()));
                return InteractionResult.CONSUME;
            }
        }
        return InteractionResult.SUCCESS;
    }



    public void applyBlood(BloodSyringeData blood, ServerLevel serverLevel, ServerPlayer serverPlayer) {
        BloodSyringeEffect effect = BloodSyringeEffect.fromId(blood.bloodEffectId());
        switch (effect) {
            case POISON:
                serverPlayer.addEffect(new MobEffectInstance(POISON,600,1));
            case HEALTHY:
                serverPlayer.addEffect(new MobEffectInstance(REGENERATION,600,0));
            case MUTANT:
                PowerHelper.applyPower(serverPlayer, Power.MUTANT, true);
        }
    }
}
