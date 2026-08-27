package com.art5019.art5019s_injustice.helper;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.attachment.AttachmentType;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import static com.art5019.art5019s_injustice.data.DataAttachments.LAST_QUERY;
import static com.art5019.art5019s_injustice.data.DataAttachments.STRESS;

/**
 * Should be used for counter-like data without ticked effects, in other words: If it's an integer, which
 * each tick subtracts this value by one, but it's value only matter during specific events, not every
 * single game tick, use this instead of ServerPlayer.getData() and ServerPlayer.setData()
 */
public class QueriedTickedCounterHelper {

    public static void setData(ServerPlayer player, Supplier<AttachmentType<Integer>> data, int value) {
        synchronizeData(player);
        player.setData(data, value);
    }

    public static int queryData(ServerPlayer player, Supplier<AttachmentType<Integer>> data) {
        synchronizeData(player);
        return player.getData(data);
    }

    public static void synchronizeData(ServerPlayer player) {
        Long currentGameTime = player.level().getGameTime();
        long lastQuery = player.getData(LAST_QUERY);
        int offset;
        try {
            offset = Math.toIntExact(currentGameTime - lastQuery);
        } catch (ArithmeticException exception) {
            Logger.getGlobal().log(new LogRecord(Level.ALL,"Holy AFK"));
            offset = Integer.MAX_VALUE;
        }
        player.setData(STRESS, Math.max(0,player.getData(STRESS)-offset));
        player.setData(LAST_QUERY, currentGameTime);
    }
}
