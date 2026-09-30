package com.art5019.art5019s_injustice.powers;

import com.art5019.art5019s_injustice.data.records.power.ClientPower;
import com.art5019.art5019s_injustice.powers.superpower.Superpower;
import com.art5019.art5019s_injustice.powers.superpower.SuperpowerGroup;
import com.art5019.art5019s_injustice.powers.superpower.UndeterminedSuperpower;
import com.art5019.art5019s_injustice.powers.superpower.mutant.AlphaMutant;
import com.art5019.art5019s_injustice.powers.superpower.mutant.BetaMutant;
import com.art5019.art5019s_injustice.powers.superpower.mutant.Mutant;
import com.art5019.art5019s_injustice.powers.superpower.mutant.OmegaMutant;
import com.art5019.art5019s_injustice.powers.superpower.mutant.cyclops.Cyclops;
import com.art5019.art5019s_injustice.powers.superpower.mutant.shadowcat.Shadowcat;
import com.art5019.art5019s_injustice.powers.superpower.mutant.storm.Storm;
import com.art5019.art5019s_injustice.powers.superpower.mutant.wolverine.Wolverine;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.fml.common.Mod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;
import static com.art5019.art5019s_injustice.data.DataAttachments.*;

@Mod(MODID)
public class SuperpowerService {
    private static Map<Integer, UndeterminedSuperpower> superpowerMap = new HashMap<>();

    public static UndeterminedSuperpower getUndeterminedSuperpower(int key) {
        return superpowerMap.get(key);
    }

    public static Superpower getSuperpower(int key) {
        UndeterminedSuperpower undeterminedSuperpower = superpowerMap.get(key);
        if(undeterminedSuperpower instanceof Superpower superpower) {
            return superpower;
        }
        throw new RuntimeException("Provided id isn't a power");
    }

    {
        Storm storm = Storm.getInstance();
        Cyclops cyclops = Cyclops.getInstance();
        Wolverine wolverine = Wolverine.getInstance();
        Shadowcat shadowcat = Shadowcat.getInstance();

        Mutant mutant = Mutant.getInstance();
        BetaMutant betaMutant = BetaMutant.getInstance();
        AlphaMutant alphaMutant = AlphaMutant.getInstance();
        OmegaMutant omegaMutant = OmegaMutant.getInstance();

        superpowerMap.put(storm.getSuperpowerId(), storm);
        superpowerMap.put(shadowcat.getSuperpowerId(), shadowcat);
        superpowerMap.put(wolverine.getSuperpowerId(), wolverine);
        superpowerMap.put(cyclops.getSuperpowerId(), cyclops);

        superpowerMap.put(mutant.getSuperpowerId(), mutant);
        superpowerMap.put(alphaMutant.getSuperpowerId(), alphaMutant);
        superpowerMap.put(betaMutant.getSuperpowerId(), betaMutant);
        superpowerMap.put(omegaMutant.getSuperpowerId(), omegaMutant);
    }

    public static int applySuperpower(ServerPlayer serverPlayer, UndeterminedSuperpower superpower, boolean testHuman) {
        if(!testHuman || serverPlayer.getData(SUPERPOWER_ID) == 0) {
            UndeterminedSuperpower temp = superpower;
            while (temp instanceof SuperpowerGroup superpowerGroup) {
                temp = superpowerGroup.getPossiblePowers().getRandom();
            }
            serverPlayer.setData(SUPERPOWER_ID, temp.getSuperpowerId());
            synchronizePowerList(serverPlayer);
            return temp.getSuperpowerId();
        }
        return serverPlayer.getData(SUPERPOWER_ID);
    }

    // TODO: Optimize
    public static void synchronizePowerList(ServerPlayer serverPlayer) {
        List<ClientPower> clientPowers = new ArrayList<>(serverPlayer.getData(CLIENT_POWER));
        int superpowerId = serverPlayer.getData(SUPERPOWER_ID);
        Superpower superpower = SuperpowerService.getSuperpower(superpowerId);
        List<Power> powers = superpower.getAvailablePowers(serverPlayer);
        System.out.println(powers.get(0));
        for (int i = 0; i < powers.size(); i++) {
            Power currentPower = powers.get(i);
            int currentPowerId = currentPower.getId();
            boolean exists = false;
            for (int j = 0; j < clientPowers.size(); j++) {
                if(clientPowers.get(j).powerId() == currentPowerId) {
                    exists = true;
                }
            }
            if(!exists) {
                clientPowers.add(new ClientPower(superpower.getSuperpowerId(), currentPowerId, 0));
            }
        }
        serverPlayer.setData(CLIENT_POWER, clientPowers);
    }
}
