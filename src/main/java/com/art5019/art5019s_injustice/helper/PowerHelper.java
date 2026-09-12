package com.art5019.art5019s_injustice.helper;

import com.art5019.art5019s_injustice.data.Power;
import net.minecraft.server.level.ServerPlayer;

import static com.art5019.art5019s_injustice.data.DataAttachments.POWER_ID;

public class PowerHelper {

    public static int applyPower(ServerPlayer serverPlayer, Power power, boolean testHuman) {
        if(!testHuman || serverPlayer.getData(POWER_ID) == 0) {
            Power fpower = power;
            while (fpower.powerId < 0) {
                fpower = Power.fromId(power.weightedList.getRandom());
            }
            serverPlayer.setData(POWER_ID,fpower.powerId);
            return fpower.powerId;
        }
        return serverPlayer.getData(POWER_ID);
    }
}
