package dev.jsinco.brewery.listeners;

import dev.jsinco.brewery.TheBrewingProject;
import dev.jsinco.brewery.api.math.BlockPos;
import dev.jsinco.brewery.objects.cauldron.BukkitCauldron;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.material.Cauldron;

public class BreweryEvents implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (event.getBlock().getType() == Material.CAULDRON) {
            TheBrewingProject.getInstance().getCauldronManager().addCauldron(
                    new BukkitCauldron(
                            new BlockPos(event.getBlock().getLocation())
                    )
            );
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        TheBrewingProject.getInstance().getCauldronManager().removeCauldron(
                new BlockPos(event.getBlock().getLocation())
        );
    }

}
