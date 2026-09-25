package com.art5019.art5019s_injustice.network;

import com.art5019.art5019s_injustice.data.records.power.ClientPower;
import com.art5019.art5019s_injustice.network.packets.PlayerUsesPowerPacket;
import com.art5019.art5019s_injustice.network.packets.SkillGainXpPacket;
import com.art5019.art5019s_injustice.network.packets.SkillLevelUpPacket;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import java.util.List;

import static com.art5019.art5019s_injustice.data.DataAttachments.*;

public class ServerPayloadHandler {
    public static void handleDataOnMain(final SkillLevelUpPacket data, final IPayloadContext context) {
    }

    public static void handleDataOnMain(final SkillGainXpPacket data, final IPayloadContext context) {
    }

    public static void handleDataOnMain(final PlayerUsesPowerPacket data, final IPayloadContext context) {
        ServerPlayer player = (ServerPlayer) context.player();
        int powerListPos = player.getData(POWER_LIST_POS);
        List<ClientPower> clientPowerList  = player.getData(CLIENT_POWER);
        int actualAbilityPos = data.abilityNumber() + powerListPos;
        clientPowerList.get(actualAbilityPos);
    }

}
