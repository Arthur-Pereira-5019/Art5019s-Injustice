package com.art5019.art5019s_injustice.event;

import com.art5019.art5019s_injustice.data.records.power.ClientPower;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.ArrayList;
import java.util.List;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;
import static com.art5019.art5019s_injustice.data.DataAttachments.CLIENT_POWER;

@Mod(MODID)
@EventBusSubscriber
public class PlayerTick {
    @SubscribeEvent
    public static void handle(PlayerTickEvent.Post event) {
        if(event.getEntity() instanceof ServerPlayer serverPlayer) {
            List<ClientPower> powers = serverPlayer.getData(CLIENT_POWER);
            if(!powers.isEmpty()) {
                List<ClientPower> reducedCooldown = new ArrayList<>();
                powers.forEach(x -> reducedCooldown.add(new ClientPower(x.superpowerId(), x.powerId(), Math.max(x.cooldown()-1,0))));
                serverPlayer.setData(CLIENT_POWER, reducedCooldown);
            }
        }
    }
}
