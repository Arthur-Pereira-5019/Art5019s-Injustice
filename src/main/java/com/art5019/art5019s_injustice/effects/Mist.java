package com.art5019.art5019s_injustice.effects;

import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;
import static net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE;

public class Mist extends MobEffect {
    public static final Identifier MIST_VIEW_MODIFIER = Identifier.fromNamespaceAndPath(MODID, "mist_view_modifier");
    public Mist(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int tickCount, int amplifier) {
        return tickCount % 2 == 0; // replace this with whatever check you want
    }

    @Override
    public void onEffectAdded(LivingEntity entity, int amplifier) {
        AttributeInstance instance = entity.getAttributes().getInstance(FOLLOW_RANGE);
        if(instance != null) {
            instance.addTransientModifier(new AttributeModifier(MIST_VIEW_MODIFIER, -16, AttributeModifier.Operation.ADD_VALUE));
        }
        super.onEffectAdded(entity, amplifier);
    }

    @Override
    public void onEffectStarted(LivingEntity entity, int amplifier) {
    }
}
