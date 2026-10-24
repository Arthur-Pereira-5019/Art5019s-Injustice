package com.art5019.art5019s_injustice.powers;

import com.art5019.art5019s_injustice.data.records.power.ClientPower;
import com.art5019.art5019s_injustice.powers.superpower.Superpower;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

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
        if(secondary) {
            if(targetedPower.secondaryCooldown() == 0) {
                Power actualPower = superpower.getPowerById(targetedPower.powerId());
                if(actualPower.canUse(serverPlayer)) {
                    int cooldown = actualPower.use(serverPlayer,true);
                    if(cooldown > 0) {
                        ClientPower updatedCooldown = new ClientPower(targetedPower.superpowerId(), targetedPower.powerId(), targetedPower.cooldown(), cooldown);
                        int pos = powers.indexOf(targetedPower);
                        powers.remove(targetedPower);
                        powers.add(pos, updatedCooldown);
                    }
                }
            }
        } else {
            if(targetedPower.cooldown() == 0) {
                Power actualPower = superpower.getPowerById(targetedPower.powerId());
                if(actualPower.canUse(serverPlayer)) {
                    int cooldown = actualPower.use(serverPlayer,false);
                    if(cooldown > 0) {
                        ClientPower updatedCooldown = new ClientPower(targetedPower.superpowerId(), targetedPower.powerId(), cooldown, targetedPower.secondaryCooldown());
                        int pos = powers.indexOf(targetedPower);
                        powers.remove(targetedPower);
                        powers.add(pos, updatedCooldown);
                    }
                }
            }
        }

        serverPlayer.setData(CLIENT_POWER, powers);
    }

    public static void resetCooldown(ServerPlayer player, int pos) {
        List<ClientPower> powers = player.getData(CLIENT_POWER);
        ClientPower targetedPower = powers.get(pos);
        ClientPower updatedCooldown = new ClientPower(targetedPower.superpowerId(), targetedPower.powerId(), 0, 0);
        powers.remove(targetedPower);
        powers.add(pos, updatedCooldown);
    }


}
