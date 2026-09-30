package com.art5019.art5019s_injustice.network;

import com.art5019.art5019s_injustice.data.records.power.ClientPower;
import com.art5019.art5019s_injustice.network.packets.PlayerUsesPowerPacket;
import com.art5019.art5019s_injustice.network.packets.SkillGainXpPacket;
import com.art5019.art5019s_injustice.network.packets.SkillLevelUpPacket;
import com.art5019.art5019s_injustice.powers.ClientPowerService;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import java.util.List;

import static com.art5019.art5019s_injustice.data.DataAttachments.*;

public class ServerPayloadHandler {
    public static void handleDataOnMain(final SkillLevelUpPacket data, final IPayloadContext context) {
    }

    public static void handleDataOnMain(final SkillGainXpPacket data, final IPayloadContext context) {
    }

    public static void handleDataOnMain(final PlayerUsesPowerPacket data, final IPayloadContext context) {
        Player player = context.player();
        if(player instanceof ServerPlayer serverPlayer) {
            ClientPowerService.invoke(data.abilityNumber(), serverPlayer, data.modified());
        }
    }

}
