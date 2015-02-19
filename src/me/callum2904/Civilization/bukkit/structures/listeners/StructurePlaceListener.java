package me.callum2904.Civilization.bukkit.structures.listeners;

import me.callum2904.Civilization.bukkit.events.StructurePlaceEvent;
import me.callum2904.Civilization.bukkit.structures.House;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class StructurePlaceListener implements Listener{
	
	@EventHandler
	public void onStructurePlace(StructurePlaceEvent event){
		House house = new House(event.getPlayer().getUniqueId(), event.getLocation(), "House_v1");
		house.getClipboard().paste();
	}

}
