package net.milkycraft.configuration;

import java.util.List;

import net.milkycraft.StricterEnchant;

import org.bukkit.configuration.file.FileConfiguration;

// TODO: Auto-generated Javadoc
/**
 * The Class Settings.
 */
public class Settings extends Config {

	public static Double wildhigh, wildmed, wildlow, wilddef;
	public static Double qualhigh, qualmed, quallow, qualdef;
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
		if (!this.configFile.exists()) {
			this.dataFolder.mkdir();
			this.plugin.saveDefaultConfig();
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
		wildhigh = config.getDouble("Groups.High.WildcardChance");
		wildmed = config.getDouble("Groups.Medium.WildcardChance");
		wildlow = config.getDouble("Groups.Low.WildcardChance");
		wilddef = config.getDouble("Groups.Default.WildcardChance");
		qualhigh = config.getDouble("Groups.High.GeneralQualityOfEnchants");
		qualmed = config.getDouble("Groups.Medium.GeneralQualityOfEnchants");
		quallow = config.getDouble("Groups.Low.GeneralQualityOfEnchants");
		qualdef = config.getDouble("Groups.Default.GeneralQualityOfEnchants");
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