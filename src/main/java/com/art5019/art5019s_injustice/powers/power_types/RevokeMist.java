package com.art5019.art5019s_injustice.powers.power_types;

import com.art5019.art5019s_injustice.data.emissors.MistEmissor;
import net.minecraft.resources.Identifier;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;

public class RevokeMist extends RevokeEmissor{
    public RevokeMist(String defaultTranslatable, Identifier defaultIconSource, String defaultDescription, int defaultCooldownTicks, int searchRadius, int radius) {
        super(defaultTranslatable, defaultIconSource, defaultDescription, defaultCooldownTicks, searchRadius, radius, MistEmissor.class);
    }

    public RevokeMist(int searchRadius, int radius) {
        super("art5019sinjustice.powertype.revoke_mist.name",
                Identifier.fromNamespaceAndPath(MODID,""),
                "art5019sinjustice.powertype.revoke_mist.description",
                1200, searchRadius, radius, MistEmissor.class);
    }
}
