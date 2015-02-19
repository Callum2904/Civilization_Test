package me.callum2904.Civilization.core.schematic;

import java.io.File;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

public class Clipboard {

	private Schematic schematic;
	private Location loc;

	public Clipboard(Location location, String schematic) {
		this.schematic = SchematicUtils.load(schematic);
		this.loc = location;
	}

	public Schematic getSchematic() {
		return this.schematic;
	}

	public File getFile() {
		return this.getFile();
	}

	public Location getLocation() {
		return this.loc;
	}

	public void setLocation(Location location) {
		this.loc = location;
	}

	public void paste() {
		for (BlockData data : SchematicUtils.getBlockDataList(this.schematic, 1)) {
			Block block = new Location(loc.getWorld(), data.getX() + loc.getBlockX(), data.getY()
					+ loc.getBlockY(), data.getZ() + loc.getBlockZ()).getBlock();
			data.setDataForBlock(block);
		}
	}

	public void paste(List<ItemStack> materials) {
		List<ItemStack> mats = materials;
		for (BlockData data : SchematicUtils.getBlockDataList(this.schematic, 0)) {

			Material mat = data.getMaterial();

			Block block = new Location(loc.getWorld(), data.getX() + loc.getX(), data.getY()
					+ loc.getY(), data.getZ() + loc.getZ()).getBlock();
			
			if(block.getType() == mat)
				continue;
			
			for (ItemStack stack : mats) {
				if(!stack.getType().isBlock())
					continue;
				
				if (mat != stack.getType())
					continue;

				if ((byte) stack.getDurability() != data.getBlockData())
					continue;

				data.setDataForBlock(block);
				mats.remove(stack);
				break;
			}
		}
	}
}
