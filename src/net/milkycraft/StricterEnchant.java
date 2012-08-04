package net.milkycraft;

import java.util.HashMap;
import java.util.Map;

import net.milkycraft.hooks.EntityManagerHook;
import net.milkycraft.listeners.EnchantListener;
import net.milkycraft.listeners.SyncListener;
import net.milkycraft.utilities.Group;
import net.milkycraft.utilities.Utility;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

// TODO: Auto-generated Javadoc
/**
 * The Class StricterEnchant.
 */
public class StricterEnchant extends JavaPlugin {

	/** The groups. */
	public Map<String, Group> groups = null;

	/** The main. */
	public StricterEnchant main;
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bukkit.plugin.java.JavaPlugin#onEnable()
	 */
	@Override
	public void onEnable() {
		this.main = this;
		this.groups = new HashMap<String, Group>();
		getServer().getPluginManager().registerEvents(new EnchantListener(),
				this);
		getServer().getPluginManager().registerEvents(new SyncListener(), this);
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Timer(), 20L,
				3600L);
		EntityManagerHook.hook();
		Utility.debug("Plugin loaded");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.bukkit.plugin.java.JavaPlugin#onDisable()
	 */
	@Override
	public void onDisable() {
		this.groups = null;
	}

	/**
	 * Info.
	 * 
	 * @param info
	 *            the info
	 */
	public static void info(String info) {
		Bukkit.getLogger().info("[StricterEnchant] " + info);
	}

/**
 * Checks if is high.
 * 
 * @param name
 *            the name
 * @return true, if is high
 */
public boolean isHigh(String name) {
	if (this.groups.containsKey(name)) {
		if (this.groups.get(name) == Group.HIGH) {
			return true;
		}
	}
	return false;
}

/**
 * Checks if is medium.
 * 
 * @param name
 *            the name
 * @return true, if is medium
 */
public boolean isMedium(String name) {
	if (this.groups.containsKey(name)) {
		if (this.groups.get(name) == Group.MEDIUM) {
			return true;
		}
	}
	return false;
}

/**
 * Checks if is low.
 * 
 * @param name
 *            the name
 * @return true, if is low
 */
public boolean isLow(String name) {
	if (this.groups.containsKey(name)) {
		if (this.groups.get(name) == Group.LOW) {
			return true;
		}
	}
	return false;
}

/**
 * Checks if is default.
 * 
 * @param name
 *            the name
 * @return true, if is default
 */
public boolean isDefault(String name) {
	if (this.groups.containsKey(name)) {
		if (this.groups.get(name) == Group.DEFAULT) {
			return true;
		}
	}
	return false;
}
}

class Timer extends SyncListener implements Runnable {

	@Override
	public void run() {
		Utility.debug("Syncing groups...");
		syncGroups();		
	}

}