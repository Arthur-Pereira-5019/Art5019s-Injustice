package com.art5019.art5019s_injustice.event;

import com.art5019.art5019s_injustice.powers.ClientPowerService;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;
import static com.art5019.art5019s_injustice.powers.SuperpowerService.synchronizePowerList;

@EventBusSubscriber
@Mod(MODID)
public class PlayerJoinsEvent {
    @SubscribeEvent
    public static void playerJoins(PlayerEvent.PlayerLoggedInEvent event) {
        if(event.getEntity() instanceof ServerPlayer serverPlayer) {
            synchronizePowerList(serverPlayer);
        }
    }
}
