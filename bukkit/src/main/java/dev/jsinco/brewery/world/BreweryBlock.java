package dev.jsinco.brewery.world;

import lombok.Getter;

@Getter
public abstract class BreweryBlock {
    private final int tickRate;

    public BreweryBlock() {
        this.tickRate = 0;
    }

    public BreweryBlock(int tickRate) {
        this.tickRate = tickRate;
    }

    public void handleTick() {

    }
}
