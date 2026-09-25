package com.art5019.art5019s_injustice.powers.power_types;

import com.art5019.art5019s_injustice.helper.EmissorHelper;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;

import java.io.IOException;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;

public class SummonTornado extends PowerType {
    private int tornadoDuration;
    private float tornadoStrength;

    public SummonTornado(int tornadoDuration, float tornadoStrength) {
        this.tornadoDuration = tornadoDuration;
        this.tornadoStrength = tornadoStrength;
        super("art5019sinjustice.powertype.summon_tornado.name",
                Identifier.fromNamespaceAndPath(MODID,""),
                "art5019sinjustice.powertype.summon_tornado.description",
                6000);
    }

    @Override
    public boolean use(ServerPlayer serverPlayer) {
        try (ServerLevel serverLevel = serverPlayer.level()) {
            EmissorHelper.appendTornado(serverLevel, serverPlayer.blockPosition(), tornadoDuration, tornadoStrength);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
