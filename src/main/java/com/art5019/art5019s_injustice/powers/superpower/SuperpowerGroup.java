package com.art5019.art5019s_injustice.powers.superpower;

import com.art5019.art5019s_injustice.data.common.TextDecoration;
import com.art5019.art5019s_injustice.data.common.WeightedList;
import net.minecraft.server.level.ServerPlayer;

import java.util.ArrayList;
import java.util.List;

import static com.art5019.art5019s_injustice.data.DataAttachments.SUPERPOWER_ID;

public abstract class SuperpowerGroup extends UndeterminedSuperpower{
    private WeightedList<? extends UndeterminedSuperpower> possiblePowers;

    public SuperpowerGroup(TextDecoration textDecoration, String translatable, WeightedList<? extends UndeterminedSuperpower>
                             possiblePowers, int powerId) {
        super(textDecoration, translatable, powerId);
        this.possiblePowers = possiblePowers;
    }

    public static List<UndeterminedSuperpower> collapseReferences(UndeterminedSuperpower entryPower) {
        ArrayList<UndeterminedSuperpower> references = new ArrayList<>();
        references.add(entryPower);
        UndeterminedSuperpower currentPower;
        int i = 0;
        do {
            currentPower = references.get(i);
            if(currentPower instanceof SuperpowerGroup currentUnknown) {
                List<? extends UndeterminedSuperpower> newPowerList = currentUnknown.getPossiblePowers().getKeyList();
                for (UndeterminedSuperpower power : newPowerList) {
                    if (!references.contains(power)) {
                        references.add(power);
                    }
                }
            }
            i++;
        } while (i != references.size());
        return references;
    }

    public static List<Superpower> collapseFinalReferences(UndeterminedSuperpower power) {
        return collapseReferences(power).stream().filter(x -> x instanceof Superpower)
                .map(x -> (Superpower) x)
                .toList();
    }

    public WeightedList<? extends UndeterminedSuperpower> getPossiblePowers() {
        return possiblePowers;
    }

    @Override
    public void onGain(ServerPlayer serverPlayer) {
        serverPlayer.setData(SUPERPOWER_ID, possiblePowers.getRandom().getPowerId());
    }
}
