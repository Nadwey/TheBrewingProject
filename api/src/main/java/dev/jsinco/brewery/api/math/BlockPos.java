package dev.jsinco.brewery.api.math;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

@Getter
@AllArgsConstructor
public class BlockPos {
    private final World world;
    private final int x;
    private final int y;
    private final int z;

    public BlockPos(Location location) {
        this.world = location.getWorld();
        this.x = location.getBlockX();
        this.y = location.getBlockY();
        this.z = location.getBlockZ();
    }

    public BlockPos(Block block) {
        this.world = block.getWorld();
        this.x = block.getX();
        this.y = block.getY();
        this.z = block.getZ();
    }

    public Location getLocation() {
        return new Location(world, x, y, z);
    }
}
