package com.art5019.art5019s_injustice.powers.power_types;

import com.art5019.art5019s_injustice.helper.EmissorHelper;
import com.art5019.art5019s_injustice.helper.GeoHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.monster.breeze.Breeze;
import net.minecraft.world.phys.Vec3;

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
        if(serverPlayer.level() instanceof ServerLevel serverLevel) {
            Vec3 collision = GeoHelper.rayCastTillHit(300, 0.5F, serverPlayer, serverLevel);
            if(collision == null) {
                return false;
            }
            BlockPos hit = new BlockPos((int) collision.x, (int) collision.y, (int) collision.z);
            EmissorHelper.appendTornado(serverLevel, hit, tornadoDuration, tornadoStrength);
        }
        return true;
    }
}
