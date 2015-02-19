package me.callum2904.Civilization.bukkit.listeners;

import me.callum2904.Civilization.bukkit.events.StructurePlaceEvent;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener{
	
	@EventHandler
	public void place(BlockPlaceEvent event){
		Block block = event.getBlock();
		Player player = event.getPlayer();
		
		if(block.getType() == Material.CHEST){
			StructurePlaceEvent e = new StructurePlaceEvent(player, "House_v1", block.getLocation());
			Bukkit.getPluginManager().callEvent(e);
		}
	}

}
