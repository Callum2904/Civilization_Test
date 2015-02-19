package me.callum2904.Civilization.bukkit.structures;

import java.util.UUID;

import me.callum2904.Civilization.core.Structure;

import org.bukkit.Location;

public class House extends Structure {
	
	public House(UUID owner, Location location, String schematic){
		this.setClipboard(location, schematic);
		this.setOwnerID(owner);
	}
	
}
