package dev.jsinco.brewery.listeners;

import dev.jsinco.brewery.TheBrewingProject;
import dev.jsinco.brewery.objects.Cauldron;
import dev.jsinco.brewery.objects.Tickable;
import dev.jsinco.brewery.util.Logging;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class BreweryEvents implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        // TODO: I think Cauldron instances are supposed to be created only when something is being cooked
        if (event.getBlock().getType() == Material.CAULDRON && event.getBlock().getMetadata("tickable").isEmpty()) {
            new Cauldron(event.getBlock());
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        Block block = event.getClickedBlock();

        if (block == null || block.getMetadata("tickable").isEmpty()) {
            return;
        }

        Logging.debugLog("Player interacted with a tickable block");

        for (Cauldron cauldron : Tickable.getActiveCauldrons()) {
            if (cauldron.getBlock().equals(block)) {
                cauldron.onEvent(event);
                return;
            }
        }
    }
}
