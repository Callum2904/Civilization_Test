package me.callum2904.Civilization.bukkit.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class StructurePlaceEvent extends Event implements Cancellable {

	private static final HandlerList handlers = new HandlerList();
	private boolean cancelled;

	private Player player;
	private String schematic;
	private Location location;

	public StructurePlaceEvent(Player player, String schematic, Location location) {
		this.player = player;
		this.schematic = schematic;
		this.location = location;
	}

	public Player getPlayer() {
		return this.player;
	}

	public String getSchematic() {
		return this.schematic;
	}

	public Location getLocation() {
		return this.location;
	}

	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancel) {
		cancelled = cancel;
	}

	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

}
