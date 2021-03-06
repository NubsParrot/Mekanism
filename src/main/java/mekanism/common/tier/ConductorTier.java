package mekanism.common.tier;

import mekanism.api.heat.HeatAPI;
import mekanism.api.tier.BaseTier;
import mekanism.api.tier.ITier;
import mekanism.common.ColorRGBA;
import mekanism.common.config.value.CachedDoubleValue;
import mekanism.common.util.EnumUtils;

public enum ConductorTier implements ITier {
    BASIC(BaseTier.BASIC, 5, HeatAPI.DEFAULT_HEAT_CAPACITY, 10, new ColorRGBA(0.2, 0.2, 0.2, 1)),
    ADVANCED(BaseTier.ADVANCED, 5, HeatAPI.DEFAULT_HEAT_CAPACITY, 400, new ColorRGBA(0.2, 0.2, 0.2, 1)),
    ELITE(BaseTier.ELITE, 5, HeatAPI.DEFAULT_HEAT_CAPACITY, 8_000, new ColorRGBA(0.2, 0.2, 0.2, 1)),
    ULTIMATE(BaseTier.ULTIMATE, 5, HeatAPI.DEFAULT_HEAT_CAPACITY, 100_000, new ColorRGBA(0.2, 0.2, 0.2, 1));

    private final ColorRGBA baseColor;
    private final double baseConduction;
    private final double baseHeatCapacity;
    private final double baseConductionInsulation;
    private final BaseTier baseTier;
    private CachedDoubleValue conductionReference;
    private CachedDoubleValue capacityReference;
    private CachedDoubleValue insulationReference;

    ConductorTier(BaseTier tier, double conduction, double heatCapacity, double conductionInsulation, ColorRGBA color) {
        baseConduction = conduction;
        baseHeatCapacity = heatCapacity;
        baseConductionInsulation = conductionInsulation;

        baseColor = color;
        baseTier = tier;
    }

    public static ConductorTier get(BaseTier tier) {
        for (ConductorTier transmitter : EnumUtils.CONDUCTOR_TIERS) {
            if (transmitter.getBaseTier() == tier) {
                return transmitter;
            }
        }
        return BASIC;
    }

    @Override
    public BaseTier getBaseTier() {
        return baseTier;
    }

    public double getInverseConduction() {
        return conductionReference == null ? getBaseConduction() : conductionReference.get();
    }

    public double getInverseConductionInsulation() {
        return insulationReference == null ? getBaseConductionInsulation() : insulationReference.get();
    }

    public double getHeatCapacity() {
        return capacityReference == null ? getBaseHeatCapacity() : capacityReference.get();
    }

    public ColorRGBA getBaseColor() {
        return baseColor;
    }

    public double getBaseConduction() {
        return baseConduction;
    }

    public double getBaseHeatCapacity() {
        return baseHeatCapacity;
    }

    public double getBaseConductionInsulation() {
        return baseConductionInsulation;
    }

    /**
     * ONLY CALL THIS FROM TierConfig. It is used to give the BinTier a reference to the actual config value object
     */
    public void setConfigReference(CachedDoubleValue conductionReference, CachedDoubleValue capacityReference, CachedDoubleValue insulationReference) {
        this.conductionReference = conductionReference;
        this.capacityReference = capacityReference;
        this.insulationReference = insulationReference;
    }
}