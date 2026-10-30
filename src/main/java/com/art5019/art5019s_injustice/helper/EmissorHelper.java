package com.art5019.art5019s_injustice.helper;

import com.art5019.art5019s_injustice.data.emissors.*;
import com.art5019.art5019s_injustice.data.emissors.MistEmissor;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;


import static com.art5019.art5019s_injustice.data.DataAttachments.EMISSORS_ATTACHMENT;

public class EmissorHelper {
    private static void appendEmissor(ServerLevel serverLevel, Emissor emissor) {
        ArrayList<Emissor> emissors = new ArrayList<>(serverLevel.getData(EMISSORS_ATTACHMENT));
        emissors.add(emissor);
        serverLevel.setData(EMISSORS_ATTACHMENT, emissors);
    }

    public static void appendColdZone(ServerLevel serverLevel, BlockPos blockPos, int duration) {
        appendEmissor(serverLevel,
                new ColdZoneEmissor(expiryTick(duration, serverLevel), blockPos.getX(), blockPos.getY(), blockPos.getZ())
        );
    }


    public static void appendTornado(ServerLevel serverLevel, BlockPos blockPos, int tornadoDuration, float tornadoStrength) {
        appendEmissor(serverLevel,
                 new TornadoEmissor(expiryTick(tornadoDuration, serverLevel), blockPos.getX(), blockPos.getY(), blockPos.getZ(), tornadoStrength)
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
