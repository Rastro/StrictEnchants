package net.milkycraft.utilities;

import java.util.List;
import java.util.Map;

import net.milkycraft.StricterEnchant;
import net.milkycraft.configuration.Settings;

import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

/**
 * The Class Utility.
 */
public class Utility {
	
	/*
	 * Fill this class with utility methods that dont quite need to be in
	 * another class Access staticly, usually dont bother putting a method here
	 * unless its used in more then one class
	 */

	/**
	 * Notify player their enchantment was modified Tell them the difference.
	 * 
	 * @param player
	 *            the player
	 * @param original
	 *            the original
	 * @param result
	 *            the result
	 */
	public static void notify(Player player, Map<Enchantment, Integer> original,
			Map<Enchantment, Integer> result) {
		if (!Settings.anon) {
			player.sendMessage(ChatColor.GREEN
					+ "Your enchantment was modified with StrictEnchants");
			player.sendMessage(ChatColor.YELLOW
					+ "Enchantments are based off of the following");
			player.sendMessage(ChatColor.GOLD + "");
		}
	}

	/**
	 * Gets the difference between the original enchant naturally produced and
	 * the modded enchantment Produce it into a nice list for displaying to
	 * people if Anon. enchanting is disabled
	 * 
	 * @param original
	 *            the original
	 * @param result
	 *            the result
	 * @return the diff
	 */
	public static List<String> getDiff(Map<Enchantment, Integer> original,
			Map<Enchantment, Integer> result) {
		for (Enchantment en : original.keySet()) {
			for (Integer in : original.values()) {
				for (Enchantment en1 : result.keySet()) {
					for (Integer in1 : result.values()) {
						if (en.equals(en1)) {
							if (in == in1) {
								/*
								 * Enchants completely match? Usually wont
								 * happen but in this case dont compile a list
								 * because we bother listing no changes..
								 */
							}
							// Enchantment matches, level doesnt
						}
						// Enchantment doesnt match, check level too?
					}
				}
			}
		}
		return null;
	}
	
	public static void debug(String debug) {
		if(Settings.debug) {
			StricterEnchant.info("[Debug] " + debug);
		}
	}
}
