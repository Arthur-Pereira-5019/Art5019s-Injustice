package com.art5019.art5019s_injustice.helper;

import com.art5019.art5019s_injustice.data.emissors.event.EmissorUpdatedStateEvent;
import com.art5019.art5019s_injustice.data.emissors.*;
import com.art5019.art5019s_injustice.data.emissors.MistEmissor;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.NeoForge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


import static com.art5019.art5019s_injustice.data.DataAttachments.EMISSORS_ATTACHMENT;

public class EmissorHelper {
    public static void appendEmissor(ServerLevel serverLevel, Emissor emissor) {
        ArrayList<Emissor> emissors = new ArrayList<>(serverLevel.getData(EMISSORS_ATTACHMENT));
        if(emissor instanceof Mergeable mergeable) {
            if((mergeable.optimizedQuery() && serverLevel.getGameTime() % 20 == 0) || !mergeable.optimizedQuery()) {
                Emissor emissorB = nearestEmissor(serverLevel, emissor.getBlockPos(), (int) mergeable.mergeDistance(), emissor.getClass());
                if(emissorB instanceof Mergeable mergeableB) {
                    mergeable.mergeWith(mergeableB, serverLevel);
                    removeEmissor(emissorB, serverLevel);
                }
            }
        }
        emissors.add(emissor);
        serverLevel.setData(EMISSORS_ATTACHMENT, emissors);
    }

    public static void removeEmissor(Emissor emissor, ServerLevel serverLevel) {
        ArrayList<Emissor> emissors = new ArrayList<>(serverLevel.getData(EMISSORS_ATTACHMENT));
        emissors.remove(emissor);
        serverLevel.setData(EMISSORS_ATTACHMENT, emissors);
    }

    public static void appendColdZone(ServerLevel serverLevel, BlockPos blockPos, int duration, int radius) {
        appendEmissor(serverLevel,
                new ColdZoneEmissor(expiryTick(duration, serverLevel), blockPos.getX(), blockPos.getY(), blockPos.getZ(), radius)
        );
    }


    public static void appendTornado(ServerLevel serverLevel, BlockPos blockPos, int tornadoDuration, float tornadoStrength, double rot) {
        float xComponent = GeoHelper.getComponentsDeg(rot).x;
        float zComponent = GeoHelper.getComponentsDeg(rot).y;
        appendEmissor(serverLevel,
                 new TornadoEmissor(expiryTick(tornadoDuration, serverLevel), blockPos.getX(), blockPos.getY(), blockPos.getZ(), tornadoStrength, xComponent, zComponent)
        );
    }

    public static void appendMist(ServerLevel serverLevel, BlockPos blockPos, int mistDuration, int mistRange, boolean visualEmissor) {
        appendEmissor(serverLevel,
             new MistEmissor(expiryTick(mistDuration, serverLevel), blockPos.getX(), blockPos.getY(), blockPos.getZ(), mistRange, visualEmissor)
        );
    }


    public static boolean revokeEmissors(ServerLevel serverLevel, BlockPos blockPos, int radius, Class<? extends Emissor> type) {
        ArrayList<Emissor> emissors = new ArrayList<>(serverLevel.getData(EMISSORS_ATTACHMENT));
        List<? extends Emissor> emissorsAt = filterEmissorsAt(emissors, blockPos, radius, type);
        boolean removed = emissors.removeAll(emissorsAt);
        serverLevel.setData(EMISSORS_ATTACHMENT, emissors);
        return removed;
    }

    public static boolean enhanceNearestEmissor(ServerLevel serverLevel, BlockPos blockPos, int radius, Class<? extends Emissor> type, int factor) {
        Emissor updated = nearestEmissor(serverLevel, blockPos, radius, type);
        if(updated == null) {
            return false;
        }
        System.out.println("not null");
        updated.evolve(factor, serverLevel);
        NeoForge.EVENT_BUS.post(new EmissorUpdatedStateEvent(updated, serverLevel));
        return true;
    }

    public static Emissor nearestEmissor(ServerLevel serverLevel, BlockPos blockPos, int radius, Class<? extends Emissor> type) {
        ArrayList<Emissor> emissors = new ArrayList<>(serverLevel.getData(EMISSORS_ATTACHMENT));
        ArrayList<? extends Emissor> emissorsAt = new ArrayList<> (filterEmissorsAt(emissors, blockPos, radius, type));
        if(emissorsAt.isEmpty()) {
            return null;
        }
        emissorsAt.sort(Comparator.comparingDouble((Emissor x) -> GeoHelper.distanceBetweenPos(x.getBlockPos(), blockPos)));
        return emissorsAt.getFirst();
    }

    public static List<? extends Emissor> findEmissorsAt(Level level, BlockPos blockPos, int radius, Class<? extends Emissor> type) {
        ArrayList<Emissor> emissors = new ArrayList<>(level.getData(EMISSORS_ATTACHMENT));
        return filterEmissorsAt(emissors, blockPos, radius, type);
    }

    public static boolean containsEmissorAt(Level level, BlockPos blockPos, int radius, Class<? extends Emissor> type) {
        List<? extends Emissor> emissors = findEmissorsAt(level, blockPos, radius, type);
        return !emissors.isEmpty();
    }

    public static List<? extends Emissor> filterEmissorsAt(ArrayList<Emissor> emissors, BlockPos blockPos, int radius, Class<? extends Emissor> type) {
        AABB aabb = GeoHelper.generateAABB(blockPos, radius);
        return emissors.stream().filter(x -> aabb.contains(new Vec3(x.getPosX(), x.getPosY(), x.getPosZ())) && type.isInstance(x)).toList();
    }

    public static long expiryTick(int tornadoDuration, ServerLevel serverLevel) {
        return serverLevel.getGameTime() + tornadoDuration;
    }
}
