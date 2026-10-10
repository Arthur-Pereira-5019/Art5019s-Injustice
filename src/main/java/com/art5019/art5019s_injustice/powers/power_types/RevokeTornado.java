package com.art5019.art5019s_injustice.powers.power_types;

import com.art5019.art5019s_injustice.data.emissors.TornadoEmissor;
import com.art5019.art5019s_injustice.helper.EmissorHelper;
import com.art5019.art5019s_injustice.helper.GeoHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;

public class RevokeTornado extends PowerType{
    private int searchRadius;
    private int radius;
    public RevokeTornado(String defaultTranslatable, Identifier defaultIconSource, String defaultDescription, int defaultCooldownTicks, int searchRadius, int radius) {
        super(defaultTranslatable, defaultIconSource, defaultDescription, defaultCooldownTicks);
        this.searchRadius = searchRadius;
        this.radius = radius;
    }

    public RevokeTornado(int searchRadius, int radius) {
        super("art5019sinjustice.powertype.revoke_tornado.name",
                Identifier.fromNamespaceAndPath(MODID,""),
                "art5019sinjustice.powertype.revoke_tornado.description",
                1200);
        this.searchRadius = searchRadius;
        this.radius = radius;
    }

    @Override
    public boolean use(ServerPlayer serverPlayer) {
        if(serverPlayer.level() instanceof ServerLevel serverLevel) {
            Vec3 collision = GeoHelper.rayCastTillHit(searchRadius, 0.5F, serverPlayer, serverLevel);
            if(collision == null) {
                return false;
            }
            BlockPos hit = new BlockPos((int) collision.x, (int) collision.y, (int) collision.z);
            EmissorHelper.revokeEmissors(serverLevel, hit, radius, TornadoEmissor.class);
        }
        return true;    }
}
