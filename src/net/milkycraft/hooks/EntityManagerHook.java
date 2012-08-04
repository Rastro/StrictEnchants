package net.milkycraft.hooks;

import net.milkycraft.api.EntityManagerAPI;
import net.milkycraft.configuration.Settings;
import net.milkycraft.listeners.EnchantListener;

import org.bukkit.Bukkit;

public class EntityManagerHook extends EnchantListener {

	public static EntityManagerAPI api;

	public static void hook() {
		if (Settings.hook) {
			if (Bukkit.getPluginManager().getPlugin("EntityManager") != null) {
				@SuppressWarnings("unused")
				EntityManagerAPI EntityManagerApi = api;
			}
			info("EntityManager was not found, didn't hook");
		}
	}
}
