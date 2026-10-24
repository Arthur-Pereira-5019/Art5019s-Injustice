package com.art5019.art5019s_injustice.powers.power_types;

import com.art5019.art5019s_injustice.helper.EmissorHelper;
import com.art5019.art5019s_injustice.helper.GeoHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;

import static com.art5019.art5019s_injustice.Art5019sInjustice.MODID;

public class SummonMist extends PowerType {
    private int mistDuration;
    private int mistRange;

    public SummonMist(int mistDuration, int mistRange) {
        this.mistDuration = mistDuration;
        this.mistRange = mistRange;
        super("art5019sinjustice.powertype.summon_mist.name",
                Identifier.fromNamespaceAndPath(MODID,""),
                "art5019sinjustice.powertype.summon_mist.description",
                4800);
    }

    public SummonMist(String defaultTranslatable, Identifier defaultIconSource, String defaultDescription, int defaultCooldownTicks, int mistDuration) {
        super(defaultTranslatable, defaultIconSource, defaultDescription, defaultCooldownTicks);
        this.mistDuration = mistDuration;
    }

    @Override
    public int use(ServerPlayer serverPlayer) {
        if(serverPlayer.level() instanceof ServerLevel serverLevel) {
            Vec3 collision = GeoHelper.rayCastTillHit(300, 0.5F, serverPlayer, serverLevel);
            if(collision == null) {
                return 0;
            }
            BlockPos hit = new BlockPos((int) collision.x, (int) collision.y, (int) collision.z);
            EmissorHelper.appendMist(serverLevel, hit, mistDuration, mistRange);
            return getDefaultCooldownTicks();
        }
        return 0;
    }
}
