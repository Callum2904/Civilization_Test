package me.callum2904.Civilization.core.schematic;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import me.callum2904.Civilization.Main;
import me.callum2904.Civilization.core.jnbt.ByteArrayTag;
import me.callum2904.Civilization.core.jnbt.CompoundTag;
import me.callum2904.Civilization.core.jnbt.NBTInputStream;
import me.callum2904.Civilization.core.jnbt.ShortTag;
import me.callum2904.Civilization.core.jnbt.StringTag;
import me.callum2904.Civilization.core.jnbt.Tag;

public class SchematicUtils {

	public static Schematic load(String schematic) {
		File file = new File(Main.getSchematicFolder() + schematic + ".schematic");
		try {
			if (file.exists()) {
				NBTInputStream nbtStream = new NBTInputStream(new FileInputStream(file));
				CompoundTag compound = (CompoundTag) nbtStream.readTag();
				Map<String, Tag> tags = compound.getValue();
				Short width = ((ShortTag) tags.get("Width")).getValue();
				Short height = ((ShortTag) tags.get("Height")).getValue();
				Short length = ((ShortTag) tags.get("Length")).getValue();

				String materials = ((StringTag) tags.get("Materials")).getValue();

				byte[] blocks = ((ByteArrayTag) tags.get("Blocks")).getValue();
				byte[] data = ((ByteArrayTag) tags.get("Data")).getValue();

				nbtStream.close();

				return new Schematic(file.getName().replace(".schematic", ""), width, height,
						length, materials, blocks, data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static List<BlockData> getBlockDataList(Schematic schematic, int rotate) {
		if (rotate < 0 && rotate > 3)
			return null;

		byte[] blocks = schematic.getBlocks();
		byte[] blockData = schematic.getData();

		List<BlockData> bdata = new ArrayList<BlockData>();
		for (int x = 0; x < schematic.getWidth(); ++x) {
			for (int y = 0; y < schematic.getHeight(); ++y) {
				for (int z = 0; z < schematic.getLength(); ++z) {
					int index = y * schematic.getWidth() * schematic.getLength() + z
							* schematic.getWidth() + x;
					BlockData data = null;
					if (rotate == 0) {
						data = new BlockData(x - (schematic.getLength() / 2), y, z
								- (schematic.getWidth() / 2), index, blocks[index],
								blockData[index]);
					} else if (rotate == 1) {
						data = new BlockData(-z + (schematic.getLength() / 2) + 2, 0, -x
								+ (schematic.getWidth() / 2) - 1, index, blocks[index],
								blockData[index]);
					} else if (rotate == 2) {
						data = new BlockData(-x + (schematic.getWidth() / 2) - 1, y, -z
								+ (schematic.getLength() / 2) - 1, index, blocks[index],
								blockData[index]);
					} else if (rotate == 3) {
						data = new BlockData(-z - (schematic.getLength() / 2), y, -x
								- (schematic.getWidth() / 2), index, blocks[index],
								blockData[index]);
					}
					bdata.add(data);
				}
			}
		}
		return bdata;
	}

	public static boolean canBuild(Schematic schematic, Location location) {
		for (BlockData data : getBlockDataList(schematic, 0)) {
			Material mat = data.getMaterial();

			Block block = new Location(location.getWorld(), data.getX() + location.getX(),
					data.getY() + location.getY(), data.getZ() + location.getZ()).getBlock();

			if (block.getType() == Material.AIR || block.getType() == mat)
				return false;
		}
		return true;
	}

}
