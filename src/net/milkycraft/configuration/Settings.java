package net.milkycraft.configuration;

import java.util.List;

import net.milkycraft.StricterEnchant;

import org.bukkit.configuration.file.FileConfiguration;

// TODO: Auto-generated Javadoc
/**
 * The Class Settings.
 */
public class Settings extends Config {

	public static int wildhigh, wildmed, wildlow, wilddef;
	public static int qualhigh, qualmed, quallow, qualdef;
	public static List<String> listhigh, listmed, listlow, listdef;
	/**
	 * Instantiates a new settings.
	 * 
	 * @param plugin
	 *            the plugin
	 */
	public Settings(StricterEnchant plugin) {
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
		wildhigh = config.getInt("Groups.High.WildcardChance");
		wildmed = config.getInt("Groups.Medium.WildcardChance");
		wildlow = config.getInt("Groups.Low.WildcardChance");
		wilddef = config.getInt("Groups.Default.WildcardChance");
		qualhigh = config.getInt("Groups.High.GeneralQualityOfEnchants");
		qualmed = config.getInt("Groups.Medium.GeneralQualityOfEnchants");
		quallow = config.getInt("Groups.Low.GeneralQualityOfEnchants");
		qualdef = config.getInt("Groups.Default.GeneralQualityOfEnchants");
		listhigh = config.getStringList("Groups.High.BlockedEnchants");
		listmed = config.getStringList("Groups.Medium.BlockedEnchants");
		listlow = config.getStringList("Groups.High.BlockedEnchants");
		listdef = config.getStringList("Groups.High.BlockedEnchants");
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