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

    public BlockPos add(BlockPos blockPos) {
        return new BlockPos(blockPos.world, x + blockPos.x, y + blockPos.y, z + blockPos.z);
    }

    public BlockPos add(int x, int y, int z) {
        return new BlockPos(world, this.x + x, this.y + y, this.z + z);
    }

    public BlockPos subtract(BlockPos blockPos) {
        return blockPos.add(blockPos.negate());
    }

    public BlockPos subtract(int x, int y, int z) {
        return new BlockPos(world, this.x - x, this.y - y, this.z - z);
    }

    public BlockPos negate() {
        return new BlockPos(world, -x, -y, -z);
    }

    public Location getLocation() {
        return new Location(world, x + 0.5, y + 0.5, z + 0.5);
    }

    public static BlockPos fromLocation(Location location) {
        return new BlockPos(location);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlockPos pos = (BlockPos) o;
        return world.equals(pos.world) && x == pos.x && y == pos.y && z == pos.z;
    }
}
