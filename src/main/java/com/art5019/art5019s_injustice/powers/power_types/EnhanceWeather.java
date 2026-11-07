package com.art5019.art5019s_injustice.powers.power_types;

import com.art5019.art5019s_injustice.data.emissors.Emissor;
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

public class EnhanceWeather extends PowerType{
    private int searchRadius;
    private int radius;
    private final Class<? extends Emissor> searchFor;

    public EnhanceWeather(String defaultTranslatable, Identifier defaultIconSource, String defaultDescription, int defaultCooldownTicks, int searchRadius, int radius, Class<? extends Emissor> searchFor) {
        super(defaultTranslatable, defaultIconSource, defaultDescription, defaultCooldownTicks);
        this.searchRadius = searchRadius;
        this.radius = radius;
        this.searchFor = searchFor;
    }

    public EnhanceWeather(int searchRadius, int radius, Class<? extends Emissor> searchFor) {
        super("art5019sinjustice.powertype.enhance_weather.name", Identifier.fromNamespaceAndPath(MODID,""), "art5019sinjustice.powertype.revoke_tornado.description", 1200);
        this.searchRadius = searchRadius;
        this.radius = radius;
        this.searchFor = searchFor;
    }

    public int getRadius() {
        return radius;
    }

    public int getSearchRadius() {
        return searchRadius;
    }

    @Override
    public int use(ServerPlayer serverPlayer) {
        if(serverPlayer.level() instanceof ServerLevel serverLevel) {
            Vec3 collision = GeoHelper.rayCastTillHit(this.getSearchRadius(), 0.5F, serverPlayer, serverLevel);
            if(collision == null) {
                return 0;
            }
            BlockPos hit = new BlockPos((int) collision.x, (int) collision.y, (int) collision.z);

            return EmissorHelper.enhanceNearestEmissor(serverLevel, hit, this.getRadius(), searchFor, 1) ? this.getDefaultCooldownTicks() : 80;
        }
        return 0;
    }

    @Override
    public PowerTypeBooster getBooster() {
        return new EmptyPowerBooster();
    }
}
