package net.milkycraft;

import java.util.HashMap;
import java.util.Map;

import net.milkycraft.utilities.Group;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class StricterEnchant extends JavaPlugin{

	public Map<String, Group> groups = null;
	public StricterEnchant main;
	@Override
	public void onEnable() {
		main = this;
		groups = new HashMap<String, Group>();
		getServer().getPluginManager().registerEvents(new EnchantListener(), this);
		getServer().getPluginManager().registerEvents(new SyncListener(), this);
	}
	
	@Override
	public void onDisable() {
		groups = null;
	}
	
	public static void info(String info) {
		Bukkit.getLogger().info("[StricterEnchant] " + info);
	}
}
