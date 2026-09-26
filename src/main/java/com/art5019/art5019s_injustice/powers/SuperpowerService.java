package com.art5019.art5019s_injustice.powers;

import com.art5019.art5019s_injustice.data.records.power.ClientPower;
import com.art5019.art5019s_injustice.powers.superpower.Superpower;
import com.art5019.art5019s_injustice.powers.superpower.SuperpowerGroup;
import com.art5019.art5019s_injustice.powers.superpower.UndeterminedSuperpower;
import com.art5019.art5019s_injustice.powers.superpower.mutant.AlphaMutant;
import com.art5019.art5019s_injustice.powers.superpower.mutant.BetaMutant;
import com.art5019.art5019s_injustice.powers.superpower.mutant.Mutant;
import com.art5019.art5019s_injustice.powers.superpower.mutant.OmegaMutant;
import com.art5019.art5019s_injustice.powers.superpower.storm.Cyclops;
import com.art5019.art5019s_injustice.powers.superpower.storm.Shadowcat;
import com.art5019.art5019s_injustice.powers.superpower.storm.Storm;
import com.art5019.art5019s_injustice.powers.superpower.storm.Wolverine;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.fml.common.Mod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;
import static com.art5019.art5019s_injustice.data.DataAttachments.SUPERPOWER_ID;

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

        superpowerMap.put(storm.getPowerId(), storm);
        superpowerMap.put(shadowcat.getPowerId(), shadowcat);
        superpowerMap.put(wolverine.getPowerId(), wolverine);
        superpowerMap.put(cyclops.getPowerId(), cyclops);

        superpowerMap.put(mutant.getPowerId(), mutant);
        superpowerMap.put(alphaMutant.getPowerId(), alphaMutant);
        superpowerMap.put(betaMutant.getPowerId(), betaMutant);
        superpowerMap.put(omegaMutant.getPowerId(), omegaMutant);
    }

    public static int applySuperpower(ServerPlayer serverPlayer, UndeterminedSuperpower superpower, boolean testHuman) {
        if(!testHuman || serverPlayer.getData(SUPERPOWER_ID) == 0) {
            UndeterminedSuperpower temp = superpower;
            while (temp instanceof SuperpowerGroup superpowerGroup) {
                temp = superpowerGroup.getPossiblePowers().getRandom();
            }
            temp = (Superpower) temp;
            serverPlayer.setData(SUPERPOWER_ID, temp.getPowerId());
            return temp.getPowerId();
        }
        return serverPlayer.getData(SUPERPOWER_ID);
    }

    public static void synchronizePowerList(ServerPlayer serverPlayer) {
        ArrayList<ClientPower> clientPowers = new ArrayList<>();
        int superpowerId = serverPlayer.getData(SUPERPOWER_ID);
        Superpower superpower = SuperpowerService.getSuperpower(superpowerId);
        superpower.getAvailablePowers(serverPlayer);
        // serverPlayer.setData(CLIENT_POWER, )
    }
}
