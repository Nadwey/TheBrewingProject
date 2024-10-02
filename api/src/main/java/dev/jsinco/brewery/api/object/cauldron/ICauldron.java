package dev.jsinco.brewery.api.object.cauldron;

/**
 * Interface for implementing custom Cauldron blocks
 */
public interface ICauldron {
    CauldronData getCauldronData();

    /**
     * Fired every minute
     */
    void handleCookTick();

    /**
     * Fired every tick asynchronously
     */
    void handleAsyncTick();
}
