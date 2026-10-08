package com.art5019.art5019s_injustice.event;

import com.art5019.art5019s_injustice.data.records.emissors.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.ticks.LevelChunkTicks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.level.ChunkEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;
import static com.art5019.art5019s_injustice.data.records.emissors.EmissorCollection.EMISSOR_ID;

@Mod(MODID)
@EventBusSubscriber
public class ServerLevelTick {

    @SubscribeEvent
    public static void handle(LevelTickEvent.Post event) {
        Level level = event.getLevel();
        if(level instanceof ServerLevel serverLevel) {
            doEmissors(serverLevel);
        }
    }

    private static void doEmissors(ServerLevel serverLevel) {
        long currentTick = serverLevel.getGameTime();
        EmissorCollection emissorCollection = serverLevel.getDataStorage().computeIfAbsent(EMISSOR_ID);
        ArrayList<Emissor> emissors = new ArrayList<>(emissorCollection.getEmissors());
        Iterator<Emissor> iterator = emissors.iterator();
        while(iterator.hasNext()) {
            Emissor e = iterator.next();
            e.handle(serverLevel);
            if(e.getExpiryTick() <= currentTick) {
                iterator.remove();
            }
        }
        serverLevel.getDataStorage().computeIfAbsent(EMISSOR_ID).setEmissors(emissors);
    }
}
