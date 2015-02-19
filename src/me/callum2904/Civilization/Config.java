package me.callum2904.Civilization;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class Config {
	private final Plugin PLUGIN;
	private final String FILENAME;
	private final File FOLDER;
	private FileConfiguration config;
	private File configFile;

	public Config(String filename, Plugin instance) {
		if (!filename.endsWith(".yml")) {
			filename += ".yml";
		}
		this.FILENAME = filename;
		this.PLUGIN = instance;
		this.FOLDER = this.PLUGIN.getDataFolder();
		this.config = null;
		this.configFile = null;
		reload();
	}

	public Config(File folder, String filename, Plugin instance) {
		if (!filename.endsWith(".yml")) {
			filename += ".yml";
		}
		this.FILENAME = filename;
		this.PLUGIN = instance;
		this.FOLDER = new File(this.PLUGIN.getDataFolder() + File.separator + folder);
		this.config = null;
		this.configFile = null;
		reload();
	}

	public FileConfiguration getConfig() {
		if (config == null) {
			reload();
		}
		return config;
	}

	public void reload() {
		if (!this.FOLDER.exists()) {
			try {
				if (this.FOLDER.mkdir()) {
					this.PLUGIN.getLogger().log(Level.INFO,
							"Folder " + this.FOLDER.getName() + " created.");
				} else {
					this.PLUGIN.getLogger().log(Level.WARNING,
							"Unable to create folder " + this.FOLDER.getName() + ".");
				}
			} catch (Exception e) {

			}
		}
		configFile = new File(this.FOLDER, this.FILENAME);
		if (!configFile.exists()) {
			try {
				configFile.createNewFile();
			} catch (IOException e) {

			}
		}
		config = YamlConfiguration.loadConfiguration(configFile);
	}

	public void saveDefaultConfig() {
		if (configFile == null) {
			configFile = new File(this.PLUGIN.getDataFolder(), this.FILENAME);
		}

		if (!configFile.exists()) {
			this.PLUGIN.saveResource(this.FILENAME, false);
		}
	}

	public void save() {
		if (config == null || configFile == null) {
			return;
		}
		try {
			getConfig().save(configFile);
		} catch (IOException ex) {
			this.PLUGIN.getLogger().log(Level.WARNING,
					"Could not save config to " + configFile.getName(), ex);
		}
	}
	
	public File getFile(){
		return configFile;
	}

	public void set(String path, Object o) {
		getConfig().set(path, o);
	}
	
	public static void createFolder(String name){
		File file = new File(name);
		if (!file.exists()) {
			if (file.mkdir()) {
				System.out.println("Directory is created!");
			} else {
				System.out.println("Failed to create directory!");
			}
		}
	}
}
