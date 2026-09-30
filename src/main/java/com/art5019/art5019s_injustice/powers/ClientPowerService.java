package com.art5019.art5019s_injustice.powers;

import com.art5019.art5019s_injustice.data.records.power.ClientPower;
import com.art5019.art5019s_injustice.powers.superpower.Superpower;
import net.minecraft.server.level.ServerPlayer;

import java.util.List;

import static com.art5019.art5019s_injustice.data.DataAttachments.*;

public class ClientPowerService {
    public static void invoke(int key, ServerPlayer serverPlayer, boolean secondary) {
        Superpower superpower = SuperpowerService.getSuperpower(serverPlayer.getData(SUPERPOWER_ID));
        List<ClientPower> powers = serverPlayer.getData(CLIENT_POWER);
        int shift = serverPlayer.getData(POWER_LIST_POS);
        System.out.println(key);
        System.out.println(shift);
        System.out.println(powers.size());

        ClientPower targetedPower = powers.get((key + shift) % powers.size());
        if(targetedPower.cooldown() == 0) {
            Power actualPower = superpower.getPowerById(targetedPower.powerId());
            if(actualPower.canUse(serverPlayer)) {
                System.out.println(actualPower.getTranslatable());
                actualPower.use(serverPlayer,secondary);
            }
        }
    }
}
