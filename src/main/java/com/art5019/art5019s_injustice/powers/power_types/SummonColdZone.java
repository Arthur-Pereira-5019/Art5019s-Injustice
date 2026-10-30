package com.art5019.art5019s_injustice.powers.power_types;

import com.art5019.art5019s_injustice.helper.EmissorHelper;
import com.art5019.art5019s_injustice.helper.GeoHelper;
import com.art5019.art5019s_injustice.powers.booster.EmptyPowerBooster;
import com.art5019.art5019s_injustice.powers.booster.PowerTypeBooster;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;

public class SummonColdZone extends PowerType {
    private int zoneDuration;

    public SummonColdZone(int zoneDuration) {
        this.zoneDuration = zoneDuration;
        super("art5019sinjustice.powertype.summon_cold_zone.name",
                Identifier.fromNamespaceAndPath(MODID,""),
                "art5019sinjustice.powertype.summon_cold_zone.description",
                4800);
    }

    public SummonColdZone(String defaultTranslatable, Identifier defaultIconSource, String defaultDescription, int defaultCooldownTicks, int zoneDuration) {
        super(defaultTranslatable, defaultIconSource, defaultDescription, defaultCooldownTicks);
        this.zoneDuration = zoneDuration;
    }

    @Override
    public int use(ServerPlayer serverPlayer) {
        if(serverPlayer.level() instanceof ServerLevel serverLevel) {
            Vec3 collision = GeoHelper.rayCastTillHit(300, 0.5F, serverPlayer, serverLevel);
            if(collision == null) {
                return 0;
            }
            BlockPos hit = new BlockPos((int) collision.x, (int) collision.y, (int) collision.z);
            EmissorHelper.appendColdZone(serverLevel, hit, zoneDuration);
            return getDefaultCooldownTicks();
        }
        return 0;
    }

    @Override
    public PowerTypeBooster getBooster() {
        return new EmptyPowerBooster();
    }
}

