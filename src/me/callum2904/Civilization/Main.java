package me.callum2904.Civilization;

import me.callum2904.Civilization.bukkit.listeners.BlockPlaceListener;
import me.callum2904.Civilization.bukkit.structures.listeners.StructurePlaceListener;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	private static Main main;

	public void onEnable() {
		main = this;
		
//		loadConfigDefaults();
		
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new BlockPlaceListener(), this);
		pm.registerEvents(new StructurePlaceListener(), this);
		
	}

	public void onDisable() {

	}

	public static Main getInstance() {
		return main;
	}

	public final static String getSchematicFolder() {
		return "plugins/WorldEdit/schematics/";
	}
	
	public void loadConfigDefaults(){
		Config config = new Config("config", this);
		if(!config.getConfig().contains("ID_List.Strucutre"))
			config.set("ID_List.Structure", 0);
		
		config.save();
	}

}
