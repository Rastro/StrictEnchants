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
}

class Timer extends SyncListener implements Runnable {

	@Override
	public void run() {
		Utility.debug("Syncing groups...");
		syncGroups();		
	}

}