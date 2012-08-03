package net.milkycraft.configuration;

import java.util.List;


import net.milkycraft.StricterEnchant;

import org.bukkit.configuration.file.FileConfiguration;

// TODO: Auto-generated Javadoc
/**
 * The Class Settings.
 */
public class EasySettings extends EasyConfig {

	/** The hiuse. */
	public static int lowuse, meduse, hiuse;
	
	/** The hilist. */
	public static List<String> lowlist, medlist, hilist;
	
	/** The highdel. */
	public static Boolean lowdel, meddel, highdel;
	
	/** The tool. */
	public static String tool;
	
	/** The timer. */
	public static Long timer;

	/**
	 * Instantiates a new settings.
	 * 
	 * @param plugin
	 *            the plugin
	 */
	public EasySettings(StricterEnchant plugin) {
		super(plugin, "config.yml");
		config = plugin.getConfig();
		saveIfNotExist();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.milkycraft.configuration.ConfigLoader#load()
	 */
	@Override
	public void load() {
		// If it doesn't exist, copy it from the .jar
		if (!configFile.exists()) {
			dataFolder.mkdir();
			plugin.saveDefaultConfig();
		}
		addDefaults();
		loadKeys();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.milkycraft.configuration.ConfigLoader#loadKeys()
	 */
	@Override
	public void loadKeys() {
	}

	/**
	 * Gets the config.
	 * 
	 * @return Return the config
	 */
	public static FileConfiguration getConfig() {
		return config;
	}

}