package dev.jsinco.brewery.objects.cauldron;

import dev.jsinco.brewery.api.math.BlockPos;
import dev.jsinco.brewery.api.object.cauldron.Cauldron;
import lombok.Getter;
import java.util.Random;

@Getter
public class BukkitCauldron extends Cauldron {
    private static final Random RANDOM = new Random();

    private final BlockPos position;

    public BukkitCauldron(BlockPos position) {
        super();
        
        this.position = position;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BukkitCauldron cauldron = (BukkitCauldron) obj;
        return getUid().equals(cauldron.getUid());
    }

    @Override
    public void handleCookTick() {
        // if (theBlockBelowIsAHeatingSource(currentRecipe))
        this.increaseCookTime();
    }

    @Override
    public void handleAsyncTick() {
        // particles and stuff
    }
}
