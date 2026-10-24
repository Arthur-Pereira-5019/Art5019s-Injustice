package com.art5019.art5019s_injustice.effects.events;

import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;
import static com.art5019.art5019s_injustice.effects.Effects.MIST_EFFECT;
import static com.art5019.art5019s_injustice.effects.Mist.MIST_VIEW_MODIFIER;
import static net.minecraft.world.effect.MobEffects.BLINDNESS;
import static net.minecraft.world.effect.MobEffects.DARKNESS;
import static net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE;

@Mod(MODID)
@EventBusSubscriber
public class EffectExpiresEvent {
    public static final Identifier BLINDNESS_DARKNESS_MODIFIER = Identifier.fromNamespaceAndPath(MODID, "blindness_darkness_modifier");


    @SubscribeEvent
    public static void effectExpires(MobEffectEvent.Expired event) {
        if(event.getEffectInstance().getEffect().value().equals(MIST_EFFECT.get())) {
            mistEnds(event.getEntity());
        }
    }

    @SubscribeEvent
    public static void effectAdded(MobEffectEvent.Added event) {
        if(event.getEffectInstance().getEffect().value().equals(BLINDNESS.value())) {
            blindnessDarknessAdded(event.getEntity());
        }
    }

    @SubscribeEvent
    public static void effectRemoved(MobEffectEvent.Remove event) {
        MobEffect effect = event.getEffectInstance().getEffect().value();
        if(effect.equals(MIST_EFFECT.get())) {
            mistEnds(event.getEntity());
        }
        if(effect.equals(BLINDNESS.value())) {
            blindnessDarknessEnds(event.getEntity());
        }
        if(effect.equals(DARKNESS.value())) {
            blindnessDarknessEnds(event.getEntity());
        }
    }

    public static void mistEnds(LivingEntity entity) {
        AttributeInstance instance = entity.getAttributes().getInstance(FOLLOW_RANGE);
        if(instance != null) {
            instance.removeModifier(MIST_VIEW_MODIFIER);
        }
    }

    public static void blindnessDarknessAdded(LivingEntity entity) {
        AttributeInstance instance = entity.getAttributes().getInstance(FOLLOW_RANGE);
        if(instance != null) {
            instance.addTransientModifier(new AttributeModifier(BLINDNESS_DARKNESS_MODIFIER, -24, AttributeModifier.Operation.ADD_VALUE));
        }
    }

    public static void blindnessDarknessEnds(LivingEntity entity) {
        AttributeInstance instance = entity.getAttributes().getInstance(FOLLOW_RANGE);
        if(instance != null) {
            instance.removeModifier(BLINDNESS_DARKNESS_MODIFIER);
        }
    }
}
