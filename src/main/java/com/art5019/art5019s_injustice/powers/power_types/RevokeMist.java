package com.art5019.art5019s_injustice.powers.power_types;

import com.art5019.art5019s_injustice.data.emissors.TornadoEmissor;
import com.art5019.art5019s_injustice.data.emissors.mist.MistEmissor;
import com.art5019.art5019s_injustice.helper.EmissorHelper;
import com.art5019.art5019s_injustice.helper.GeoHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;

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
