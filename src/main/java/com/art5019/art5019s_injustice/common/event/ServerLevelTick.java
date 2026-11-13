package com.art5019.art5019s_injustice.common.event;

import com.art5019.art5019s_injustice.data.emissors.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.util.thread.SidedThreadGroups;
import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;
import static com.art5019.art5019s_injustice.data.DataAttachments.EMISSORS_ATTACHMENT;
@Mod(MODID)
@EventBusSubscriber
public class ServerLevelTick {
    private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

    public static void queueServerWork(int tick, Runnable action) {
        if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
            workQueue.add(new AbstractMap.SimpleEntry<>(action, tick));
    }

    @SubscribeEvent
    public static void tick(ServerTickEvent.Post event) {
        List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
        workQueue.forEach(work -> {
            work.setValue(work.getValue() - 1);
            if (work.getValue() == 0)
                actions.add(work);
        });
        actions.forEach(e -> e.getKey().run());
        workQueue.removeAll(actions);
    }


    @SubscribeEvent
    public static void handle(LevelTickEvent.Post event) {
        Level level = event.getLevel();
        if(level instanceof ServerLevel serverLevel) {
            doEmissors(serverLevel);
        }
    }

    private static void doEmissors(ServerLevel serverLevel) {
        long currentTick = serverLevel.getGameTime();
        ArrayList<Emissor> emissors = new ArrayList<>(serverLevel.getData(EMISSORS_ATTACHMENT));
        Iterator<Emissor> iterator = emissors.iterator();
        while(iterator.hasNext()) {
            Emissor e = iterator.next();
            e.handle(serverLevel);
            if(e.getExpiryTick() <= currentTick) {
                iterator.remove();
            }
        }
        serverLevel.setData(EMISSORS_ATTACHMENT, emissors);
    }
}
