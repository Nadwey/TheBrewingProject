package dev.jsinco.brewery.world;

import com.github.puregero.multilib.MultiLib;
import com.github.puregero.multilib.regionized.GlobalRegionScheduler;
import com.github.puregero.multilib.regionized.RegionizedTask;
import dev.jsinco.brewery.TheBrewingProject;

import java.util.ArrayList;
import java.util.List;

public class BreweryBlockManager {
    private final List<BreweryBlock> blocks = new ArrayList<>();
    private final RegionizedTask blockTickTask;
    private long tick = 0;

    public BreweryBlockManager() {
        GlobalRegionScheduler globalRegionScheduler = MultiLib.getGlobalRegionScheduler();

        this.blockTickTask = globalRegionScheduler.runAtFixedRate(TheBrewingProject.getInstance(), (task) -> {
            tick();
        },  1L, 1L);
    }

    public void disable() {
        this.blockTickTask.cancel();
    }

    public void registerBlock(BreweryBlock block) {
        blocks.add(block);
    }

    private void tick() {
        for (BreweryBlock block : blocks) {
            int tickRate = block.getTickRate();
            if (tickRate == 0)
                continue;

            int interval = 20 - tickRate;

            if (interval == 0 || tick % interval == 0)
                block.handleTick();
        }

        tick++;
    }
}
