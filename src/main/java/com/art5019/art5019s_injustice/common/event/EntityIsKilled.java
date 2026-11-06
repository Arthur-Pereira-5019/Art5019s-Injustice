package com.art5019.art5019s_injustice.common.event;

import com.art5019.art5019s_injustice.helper.EmissorHelper;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.breeze.Breeze;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

import java.util.Random;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;

@Mod(MODID)
@EventBusSubscriber
public class EntityIsKilled {
    @SubscribeEvent
    public static void entityIsKilled(LivingDeathEvent deathEvent) {
        LivingEntity livingEntity = deathEvent.getEntity();
        Level level = livingEntity.level();
        if(level instanceof ServerLevel serverLevel) {
            RandomSource random = serverLevel.getRandom();
            if(livingEntity instanceof Breeze breeze) {
                if(random.nextFloat() < 0.02) {
                    EmissorHelper.appendTornado(serverLevel, livingEntity.blockPosition(), 240, 1, livingEntity.yHeadRot);
                }
            }
        }

    }
}
