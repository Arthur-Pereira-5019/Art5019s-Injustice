package com.art5019.art5019s_injustice.event;

import com.art5019.art5019s_injustice.data.records.emissors.Emissor;
import com.art5019.art5019s_injustice.data.records.emissors.EmissorEffect;
import com.art5019.art5019s_injustice.data.records.emissors.EmissorHandler;
import com.art5019.art5019s_injustice.data.records.emissors.TornadoEmissorHandler;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.ticks.LevelChunkTicks;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.level.ChunkEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;
import static com.art5019.art5019s_injustice.data.DataAttachments.LEVEL_EMISSORS;

@Mod(MODID)
@EventBusSubscriber
public class ServerLevelTick {
    private static final Map<EmissorEffect, EmissorHandler> emissorHandler = Map.of(
            EmissorEffect.TORNADO, new TornadoEmissorHandler()
    );

    public static void handle(LevelTickEvent event) {
        Level level = event.getLevel();
        if(level instanceof ServerLevel serverLevel) {
            doEmissors(serverLevel);
        }
    }

    private static void doEmissors(ServerLevel serverLevel) {
        long currentTick = serverLevel.getGameTime();
        ArrayList<Emissor> emissors = new ArrayList<>(serverLevel.getData(LEVEL_EMISSORS));
        for(Emissor e: emissors) {
            if(e.expiryTick() <= currentTick) {
                emissors.remove(e);
            }
            emissorHandler.get(EmissorEffect.fromId(e.emissorEffectId())).handle(e, serverLevel);
        }
    }
}
