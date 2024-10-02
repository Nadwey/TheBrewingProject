package dev.jsinco.brewery.objects.cauldron;

import dev.jsinco.brewery.api.math.BlockPos;
import dev.jsinco.brewery.api.object.cauldron.CauldronData;
import dev.jsinco.brewery.api.object.cauldron.ICauldron;
import lombok.Getter;
import java.util.Random;

@Getter
public class BukkitCauldron implements ICauldron {
    private static final Random RANDOM = new Random();

    private final BlockPos position;
    private final CauldronData cauldronData;

    public BukkitCauldron(BlockPos position) {
        this.position = position;

        cauldronData = new CauldronData(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BukkitCauldron cauldron = (BukkitCauldron) obj;
        return cauldronData.getUid().equals(cauldron.cauldronData.getUid());
    }

    @Override
    public void handleCookTick() {
        // if (theBlockBelowIsAHeatingSource(currentRecipe))
        this.cauldronData.increaseCookTime();
    }

    @Override
    public void handleAsyncTick() {
        // particles and stuff
    }
}
