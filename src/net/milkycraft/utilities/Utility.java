package net.milkycraft.utilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.milkycraft.StricterEnchant;
import net.milkycraft.configuration.Settings;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

/**
 * The Class Utility.
 */
public class Utility {
	public static Map<Enchantment, Integer> blocked;

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
	public static void notify(Player player,
			Map<Enchantment, Integer> original, Map<Enchantment, Integer> result) {
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
		if (Settings.debug) {
			StricterEnchant.info("[Debug] " + debug);
		}
	}

	public static Map<Enchantment, Integer> getBlocked(Group group) {
		if (blocked == null) {
			blocked = new HashMap<Enchantment, Integer>();
		}
		if (group == Group.HIGH) {
			for (String s : Settings.listhigh) {
				match(s);
			}
		} else if (group == Group.MEDIUM) {
			for (String s : Settings.listhigh) {
				match(s);
			}
		} else if (group == Group.LOW) {
			for (String s : Settings.listhigh) {
				match(s);
			}
		} else if (group == Group.DEFAULT) {
			for (String s : Settings.listhigh) {
				match(s);
			}
		}
		return blocked;
	}

	public static void match(String s) {
		if (blocked == null) {
			blocked = new HashMap<Enchantment, Integer>();
		}
		if (s.equalsIgnoreCase("Sharpness I")
				|| s.equalsIgnoreCase("Sharpness 1")) {
			blocked.put(Enchantment.DAMAGE_ALL, 1);
		} else if (s.equalsIgnoreCase("Sharpness II")
				|| s.equalsIgnoreCase("Sharpness 2")) {
			blocked.put(Enchantment.DAMAGE_ALL, 2);
		} else if (s.equalsIgnoreCase("Sharpness III")
				|| s.equalsIgnoreCase("Sharpness 3")) {
			blocked.put(Enchantment.DAMAGE_ALL, 3);
		} else if (s.equalsIgnoreCase("Sharpness IV")
				|| s.equalsIgnoreCase("Sharpness 4")) {
			blocked.put(Enchantment.DAMAGE_ALL, 4);
		} else if (s.equalsIgnoreCase("Sharpness V")
				|| s.equalsIgnoreCase("Sharpness 5")) {
			blocked.put(Enchantment.DAMAGE_ALL, 5);
		} else if (s.equalsIgnoreCase("Bane of arthopods I")
				|| s.equalsIgnoreCase("Bane of arthopods 1")) {
			blocked.put(Enchantment.DAMAGE_ARTHROPODS, 1);
		} else if (s.equalsIgnoreCase("Bane of arthopods II")
				|| s.equalsIgnoreCase("Bane of arthopods 2")) {
			blocked.put(Enchantment.DAMAGE_ARTHROPODS, 2);
		} else if (s.equalsIgnoreCase("Bane of arthopods III")
				|| s.equalsIgnoreCase("Bane of arthopods 3")) {
			blocked.put(Enchantment.DAMAGE_ARTHROPODS, 3);
		} else if (s.equalsIgnoreCase("Bane of arthopods IV")
				|| s.equalsIgnoreCase("Bane of arthopods 4")) {
			blocked.put(Enchantment.DAMAGE_ARTHROPODS, 4);
		} else if (s.equalsIgnoreCase("Bane of arthopods V")
				|| s.equalsIgnoreCase("Bane of arthopods 5")) {
			blocked.put(Enchantment.DAMAGE_ARTHROPODS, 5);
		} else if (s.equalsIgnoreCase("Smite I")
				|| s.equalsIgnoreCase("Smite 1")) {
			blocked.put(Enchantment.DAMAGE_UNDEAD, 1);
		} else if (s.equalsIgnoreCase("Smite II")
				|| s.equalsIgnoreCase("Smite 2")) {
			blocked.put(Enchantment.DAMAGE_UNDEAD, 2);
		} else if (s.equalsIgnoreCase("Smite III")
				|| s.equalsIgnoreCase("Smite 3")) {
			blocked.put(Enchantment.DAMAGE_UNDEAD, 3);
		} else if (s.equalsIgnoreCase("Smite IV")
				|| s.equalsIgnoreCase("Smite 4")) {
			blocked.put(Enchantment.DAMAGE_UNDEAD, 4);
		} else if (s.equalsIgnoreCase("Smite V")
				|| s.equalsIgnoreCase("Smite 5")) {
			blocked.put(Enchantment.DAMAGE_UNDEAD, 5);
		} else if (s.equalsIgnoreCase("Unbreaking I")
				|| s.equalsIgnoreCase("Unbreaking 1")) {
			blocked.put(Enchantment.DURABILITY, 1);
		} else if (s.equalsIgnoreCase("Unbreaking II")
				|| s.equalsIgnoreCase("Unbreaking 2")) {
			blocked.put(Enchantment.DURABILITY, 2);
		} else if (s.equalsIgnoreCase("Unbreaking III")
				|| s.equalsIgnoreCase("Unbreaking 3")) {
			blocked.put(Enchantment.DURABILITY, 3);
		} else if (s.equalsIgnoreCase("Unbreaking IV")
				|| s.equalsIgnoreCase("Unbreaking 4")) {
			blocked.put(Enchantment.DURABILITY, 4);
		} else if (s.equalsIgnoreCase("Unbreaking V")
				|| s.equalsIgnoreCase("Unbreaking 5")) {
			blocked.put(Enchantment.DURABILITY, 5);
		}
		// Add more enchantment compatibility
	}
}
