package com.art5019.art5019s_injustice.powers;

import com.art5019.art5019s_injustice.data.records.power.ClientPower;
import com.art5019.art5019s_injustice.powers.superpower.Superpower;
import net.minecraft.server.level.ServerPlayer;

import java.util.ArrayList;
import java.util.List;

import static com.art5019.art5019s_injustice.data.DataAttachments.*;

public class ClientPowerService {
    public static void invoke(int key, ServerPlayer serverPlayer, boolean secondary) {
        int superpowerId = serverPlayer.getData(SUPERPOWER_ID);
        if(superpowerId < 1) {
            return;
        }
        Superpower superpower = SuperpowerService.getSuperpower(superpowerId);
        List<ClientPower> powers = new ArrayList<>(serverPlayer.getData(CLIENT_POWER));
        int shift = serverPlayer.getData(POWER_LIST_POS);

        ClientPower targetedPower = powers.get((key + shift) % powers.size());
        if(targetedPower.cooldown() == 0) {
            Power actualPower = superpower.getPowerById(targetedPower.powerId());
            if(actualPower.canUse(serverPlayer)) {
                int cooldown = actualPower.use(serverPlayer,secondary);
                if(cooldown > 0) {
                    ClientPower updatedCooldown = new ClientPower(targetedPower.superpowerId(), targetedPower.powerId(), cooldown);
                    powers.remove(targetedPower);
                    powers.add(updatedCooldown);
                }
            }
        }
        serverPlayer.setData(CLIENT_POWER, powers);
    }
}
