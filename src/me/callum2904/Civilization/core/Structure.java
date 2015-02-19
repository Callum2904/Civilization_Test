package me.callum2904.Civilization.core;

import java.util.UUID;

import me.callum2904.Civilization.bukkit.structures.type.Style;
import me.callum2904.Civilization.bukkit.structures.type.Type;
import me.callum2904.Civilization.core.schematic.Clipboard;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public abstract class Structure {
	
	private UUID owner;
	private String schematic;
	private Location location;
	private Clipboard clipboard;
	
	public int buildId;
	
	public UUID getOwnerId(){
		return this.owner;
	}
	
	public void setOwnerID(UUID uuid){
		this.owner = uuid;
	}
	
	public Player getOwner(){
		return Bukkit.getPlayer(owner);
	}
	
	public String getSchematic(){
		return this.schematic;
	}
	
	private void setSchematic(String string){
		this.schematic = string;
	}
	
	public Location getLocation(){
		return this.location;
	}
	
	private void setLocation(Location location){
		this.location = location;
	}
	
	public Clipboard getClipboard(){
		return this.clipboard;
	}
	
	public Style getStyle() {
		String[] args = this.getSchematic().split("_");
		return Style.fromString(args[1]);
	}

	public Type getType() {
		String[] args = this.getSchematic().split("_");
		return Type.fromString(args[0]);
	}
	
	public void setClipboard(Location location, String schematic){
		setLocation(location);
		setSchematic(schematic);
		this.clipboard = new Clipboard(location, schematic);
	}

}
