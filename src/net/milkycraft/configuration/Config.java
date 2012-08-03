package net.milkycraft.configuration;

import java.io.File;
import java.io.IOException;


import net.milkycraft.StricterEnchant;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

// TODO: Auto-generated Javadoc
/**
 * The Class Config.
 */
public abstract class Config {

	/** The file name. */
	protected String fileName;

	/** The config file. */
	protected File configFile;

	/** The data folder. */
	protected File dataFolder;

	/** The plugin. */
	protected final StricterEnchant plugin;

	/** The config. */
	protected static FileConfiguration config;

	/**
	 * Instantiates a new config loader.
	 * 
	 * @param plugin
	 *            the plugin
	 * @param fileName
	 *            the file name
	 */
	public Config(StricterEnchant plugin, String fileName) {
		this.plugin = plugin;
		this.fileName = fileName;
		dataFolder = plugin.getDataFolder();
		configFile = new File(dataFolder, File.separator + fileName);
		config = YamlConfiguration.loadConfiguration(configFile);
	}

	/**
	 * Load this config file.
	 */
	public void load() {
		if (!configFile.exists()) {
			dataFolder.mkdir();
			saveConfig();
		}
		addDefaults();
		loadKeys();
	}

	/**
	 * Save this config file.
	 */
	protected void saveConfig() {
		try {
			config.save(configFile);
		} catch (IOException ex) {
		}
	}

	/**
	 * Save if not exist.
	 */
	protected void saveIfNotExist() {
		if (!configFile.exists()) {
			if (plugin.getResource(fileName) != null) {
				plugin.saveResource(fileName, false);
			}
		}
		rereadFromDisk();
	}

	/**
	 * Reread from disk.
	 */
	protected void rereadFromDisk() {
		config = YamlConfiguration.loadConfiguration(configFile);
	}

	/**
	 * Add the defaults to this config file.
	 */
	protected void addDefaults() {
		config.options().copyDefaults(true);
		saveConfig();
	}

	/**
	 * Load the keys from this config file.
	 */
	protected abstract void loadKeys();

}