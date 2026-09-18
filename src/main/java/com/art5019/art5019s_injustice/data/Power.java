package com.art5019.art5019s_injustice.data;

import com.art5019.art5019s_injustice.data.common.TextDecoration;
import com.art5019.art5019s_injustice.data.common.WeightedList;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;

/**
 * powerId = 0: No power.
 * powerId < 0: Power possibilites/set
 *
 */
public enum Power {
    NONE(0,"human", TextDecoration.NONE),

    CYCLOPS(1, "cyclops", TextDecoration.AQUA),
    STORM(2,"storm", TextDecoration.PURPLE),
    WOLVERINE(3,"wolverine",TextDecoration.YELLOW),
    SHADOWCAT(4,"shadowcat",TextDecoration.YELLOW),

    MUTANT_OMEGA(-2, new WeightedList<>(Map.of(STORM,1.0F)),"omega_mutant", TextDecoration.PURPLE),
    MUTANT_ALPHA(-3, new WeightedList<>(Map.of(CYCLOPS,1.0F)),"alpha_mutant", TextDecoration.AQUA),
    MUTANT_BETA(-4, new WeightedList<>(Map.of(SHADOWCAT,1.0F,WOLVERINE,1.0F)),"beta_mutant", TextDecoration.YELLOW),

    MUTANT(-1, new WeightedList<>(Map.of(MUTANT_OMEGA,1.0F,MUTANT_ALPHA,5.0F,MUTANT_BETA,15.0F)),"mutant",TextDecoration.NONE);


    public final int powerId;
    public final TextDecoration textDecoration;
    public final WeightedList<Power> weightedList;
    public final String translatable;

    Power(int powerId, WeightedList<Power> weightedList, String translatable, TextDecoration textDecoration) {
        this.powerId = powerId;
        this.weightedList = weightedList;
        this.translatable = translatable;
        this.textDecoration = textDecoration;
    }

    Power(int powerId, String translatable, TextDecoration textDecoration) {
        this.powerId = powerId;
        this.weightedList = new WeightedList<>(this);
        this.translatable = translatable;
        this.textDecoration = textDecoration;
    }

    public static Power fromId(int powerId) {
        for (Power value : Power.values()) {
            if(value.powerId == powerId) {
                return value;
            }
        }
        return NONE;
    }

    public static List<Power> collapseReferences(Power entryPower) {
        ArrayList<Power> references = new ArrayList<>();
        references.add(entryPower);
        Power currentPower;
        int i = 0;
        do {
            currentPower = references.get(i);
            List<Power> newPowerList = currentPower.weightedList.getKeyList();
            for (Power power : newPowerList) {
                if (!references.contains(power)) {
                    references.add(power);
                }
            }
            i++;
        } while (i != references.size());
        return references;
    }

    public static List<Power> collapseFinalReferences(Power power) {
        ArrayList<Integer> ids = new ArrayList<>();
        return collapseReferences(power).stream().filter(x -> x.powerId > 0).toList();
    }

    public MutableComponent getCompcientific() {
        return Component.translatable(MODID+".power.scientific."+translatable);
    }

    public MutableComponent getCompScientificDecorated() {
        if(textDecoration != null) {
            return getCompcientific().withColor(textDecoration.color);
        }
        return getCompcientific();
    }

    public MutableComponent getCompScientificDecoratedItalic() {
        return getCompScientificDecorated().withStyle(ChatFormatting.ITALIC);
    }
}
