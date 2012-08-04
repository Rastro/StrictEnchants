package net.milkycraft.utilities;

import java.util.List;
import java.util.Map;

import net.milkycraft.StricterEnchant;
import net.milkycraft.configuration.Settings;
import net.milkycraft.listeners.EnchantListener;

import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

// TODO: Auto-generated Javadoc
/**
 * The Class Algorithm.
 * 
 * Lets attempt to reduce the passing of parameters from method to method since
 * it would be more efficient Idea it to have a efficient, organized code
 * structure.
 */
public class Algorithm extends StricterEnchant {

	/** The alg. */
	public static Algorithm alg;

	/**
	 * Calculate the enchantments then call Ulility.enchant()
	 * 
	 * @param en
	 *            the enchanter
	 * @param e
	 *            the enchants
	 * @param l
	 *            the lvl
	 * @param i
	 *            the item
	 */
	public void cal(Player en, Map<Enchantment, Integer> e, int l, ItemStack i) {
		if (Settings.log) {
			EnchantListener.info(en.getName() + " enchanted a "
					+ i.getType().toString().toLowerCase() + " with " + l
					+ " levels");
		}
		if (isHigh(en.getName())) {
			b(e, i, isWild(Settings.wildhigh), Group.HIGH);
		} else if (isMedium(en.getName())) {
			b(e, i, isWild(Settings.wildmed), Group.MEDIUM);
		} else if (isLow(en.getName())) {
			b(e, i, isWild(Settings.wildlow), Group.LOW);
		} else if (isDefault(en.getName())) {
			b(e, i, isWild(Settings.wilddef), Group.DEFAULT);
		}
	}

	/**
	 * Determine proper path for enchant logic Make sure to check for wildcard
	 * if there is a wildcard then base the wildcard off their multiplier so a
	 * high multiplier + wildcard = really decent enchant
	 * 
	 * Idea is to generally reduce enchantments but allow for a chance for a
	 * really good enchantment, make sure the enchant isnt too hackish.
	 * something natural but good :)
	 * 
	 * @param ens
	 *            the ens
	 * @param item
	 *            the item
	 * @param wild
	 *            the wild
	 * @param group
	 *            the group
	 */
	private void b(Map<Enchantment, Integer> ens, ItemStack item, Boolean wild,
			Group group) {
		if (getMultiplier(group) <= 10) {
			c(ens, item, wild, group);
		} else if (getMultiplier(group) <= 20) {
			d(ens, item, wild, group);
		} else if (getMultiplier(group) <= 30) {
			e(ens, item, wild, group);
		} else if (getMultiplier(group) <= 40) {
			f(ens, item, wild, group);
		} else if (getMultiplier(group) <= 50) {
			g(ens, item, wild, group);
		} else if (getMultiplier(group) <= 60) {
			h(ens, item, wild, group);
		} else if (getMultiplier(group) <= 70) {
			i(ens, item, wild, group);
		} else if (getMultiplier(group) <= 80) {
			j(ens, item, wild, group);
		} else if (getMultiplier(group) <= 90) {
			k(ens, item, wild, group);
		} else if (getMultiplier(group) < 100) {
			l(ens, item, wild, group);
		}
	}

	/**
	 * Provide an enchantment 0-9% of vanilla enchant.
	 * 
	 * @param ens
	 *            the ens
	 * @param item
	 *            the item
	 * @param wild
	 *            the wild
	 * @param group
	 *            the group
	 */
	private void c(Map<Enchantment, Integer> ens, ItemStack item, Boolean wild,
			Group group) {
		if (ItemLookup.isDiamond(item)) {
		} else if (ItemLookup.isIron(item)) {
		} else if (ItemLookup.isGold(item)) {
		} else if (ItemLookup.isStoneOrLeather(item)) {
		} else if (ItemLookup.isWood(item)) {
		} else if (ItemLookup.isChain(item)) {
		}
		// Throw EnchantModifyEvent with the correct parameters
	}

	/**
	 * Provide an enchantment 10-19% of vanilla enchant.
	 * 
	 * @param ens
	 *            the ens
	 * @param item
	 *            the item
	 * @param wild
	 *            the wild
	 * @param group
	 *            the group
	 */
	private void d(Map<Enchantment, Integer> ens, ItemStack item, Boolean wild,
			Group group) {
		if (ItemLookup.isDiamond(item)) {
		} else if (ItemLookup.isIron(item)) {
		} else if (ItemLookup.isGold(item)) {
		} else if (ItemLookup.isStoneOrLeather(item)) {
		} else if (ItemLookup.isWood(item)) {
		} else if (ItemLookup.isChain(item)) {
		}
		// Throw EnchantModifyEvent with the correct parameters
	}

	/**
	 * Provide an enchantment 20-29% of vanilla enchant.
	 * 
	 * @param ens
	 *            the ens
	 * @param item
	 *            the item
	 * @param wild
	 *            the wild
	 * @param group
	 *            the group
	 */
	private void e(Map<Enchantment, Integer> ens, ItemStack item, Boolean wild,
			Group group) {
		if (ItemLookup.isDiamond(item)) {
		} else if (ItemLookup.isIron(item)) {
		} else if (ItemLookup.isGold(item)) {
		} else if (ItemLookup.isStoneOrLeather(item)) {
		} else if (ItemLookup.isWood(item)) {
		} else if (ItemLookup.isChain(item)) {
		}
		// Throw EnchantModifyEvent with the correct parameters
	}

	/**
	 * Provide an enchantment 30-39% of vanilla enchant.
	 * 
	 * @param ens
	 *            the ens
	 * @param item
	 *            the item
	 * @param wild
	 *            the wild
	 * @param group
	 *            the group
	 */
	private void f(Map<Enchantment, Integer> ens, ItemStack item, Boolean wild,
			Group group) {
		if (ItemLookup.isDiamond(item)) {
		} else if (ItemLookup.isIron(item)) {
		} else if (ItemLookup.isGold(item)) {
		} else if (ItemLookup.isStoneOrLeather(item)) {
		} else if (ItemLookup.isWood(item)) {
		} else if (ItemLookup.isChain(item)) {
		}
		// Throw EnchantModifyEvent with the correct parameters
	}

	/**
	 * Provide an enchantment 40-49% of vanilla enchant.
	 * 
	 * @param ens
	 *            the ens
	 * @param item
	 *            the item
	 * @param wild
	 *            the wild
	 * @param group
	 *            the group
	 */
	private void g(Map<Enchantment, Integer> ens, ItemStack item, Boolean wild,
			Group group) {
		if (ItemLookup.isDiamond(item)) {
		} else if (ItemLookup.isIron(item)) {
		} else if (ItemLookup.isGold(item)) {
		} else if (ItemLookup.isStoneOrLeather(item)) {
		} else if (ItemLookup.isWood(item)) {
		} else if (ItemLookup.isChain(item)) {
		} // Throw EnchantModifyEvent with the correct parameters
	}

	/**
	 * Provide an enchantment 50-59% of vanilla enchant.
	 * 
	 * @param ens
	 *            the ens
	 * @param item
	 *            the item
	 * @param wild
	 *            the wild
	 * @param group
	 *            the group
	 */
	private void h(Map<Enchantment, Integer> ens, ItemStack item, Boolean wild,
			Group group) {
		if (ItemLookup.isDiamond(item)) {
		} else if (ItemLookup.isIron(item)) {
		} else if (ItemLookup.isGold(item)) {
		} else if (ItemLookup.isStoneOrLeather(item)) {
		} else if (ItemLookup.isWood(item)) {
		} else if (ItemLookup.isChain(item)) {
		} // Throw EnchantModifyEvent with the correct parameters
	}

	/**
	 * Provide an enchantment 60-69% of vanilla enchant.
	 * 
	 * @param ens
	 *            the ens
	 * @param item
	 *            the item
	 * @param wild
	 *            the wild
	 * @param group
	 *            the group
	 */
	private void i(Map<Enchantment, Integer> ens, ItemStack item, Boolean wild,
			Group group) {
		if (ItemLookup.isDiamond(item)) {
		} else if (ItemLookup.isIron(item)) {
		} else if (ItemLookup.isGold(item)) {
		} else if (ItemLookup.isStoneOrLeather(item)) {
		} else if (ItemLookup.isWood(item)) {
		} else if (ItemLookup.isChain(item)) {
		} // Throw EnchantModifyEvent with the correct parameters
	}

	/**
	 * Provide an enchantment 70-79% of vanilla enchant.
	 * 
	 * @param ens
	 *            the ens
	 * @param item
	 *            the item
	 * @param wild
	 *            the wild
	 * @param group
	 *            the group
	 */
	private void j(Map<Enchantment, Integer> ens, ItemStack item, Boolean wild,
			Group group) {
		if (ItemLookup.isDiamond(item)) {
		} else if (ItemLookup.isIron(item)) {
		} else if (ItemLookup.isGold(item)) {
		} else if (ItemLookup.isStoneOrLeather(item)) {
		} else if (ItemLookup.isWood(item)) {
		} else if (ItemLookup.isChain(item)) {
		} // Throw EnchantModifyEvent with the correct parameters
	}

	/**
	 * Provide an enchantment 80-89% of vanilla enchant.
	 * 
	 * @param ens
	 *            the ens
	 * @param item
	 *            the item
	 * @param wild
	 *            the wild
	 * @param group
	 *            the group
	 */
	private void k(Map<Enchantment, Integer> ens, ItemStack item, Boolean wild,
			Group group) {
		if (ItemLookup.isDiamond(item)) {
		} else if (ItemLookup.isIron(item)) {
		} else if (ItemLookup.isGold(item)) {
		} else if (ItemLookup.isStoneOrLeather(item)) {
		} else if (ItemLookup.isWood(item)) {
		} else if (ItemLookup.isChain(item)) {
		} // Throw EnchantModifyEvent with the correct parameters
	}

	/**
	 * Provide an enchantment 90-99% of vanilla enchant.
	 * 
	 * @param ens
	 *            the ens
	 * @param item
	 *            the item
	 * @param wild
	 *            the wild
	 * @param group
	 *            the group
	 */
	private void l(Map<Enchantment, Integer> ens, ItemStack item, Boolean wild,
			Group group) {
		if (ItemLookup.isDiamond(item)) {
		} else if (ItemLookup.isIron(item)) {
		} else if (ItemLookup.isGold(item)) {
		} else if (ItemLookup.isStoneOrLeather(item)) {
		} else if (ItemLookup.isWood(item)) {
		} else if (ItemLookup.isChain(item)) {
		}
		// Throw EnchantModifyEvent with the correct parameters
	}

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
	@SuppressWarnings("unused")
	private void notify(Player player, Map<Enchantment, Integer> original,
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
	@SuppressWarnings("unused")
	private List<String> getDiff(Map<Enchantment, Integer> original,
			Map<Enchantment, Integer> result) {

		return null;
	}

	/**
	 * Checks if its the enchanters lucky day Uses some random to generate a
	 * chance I added a small difference to prevent the same exact wildcard
	 * chance Approximently .02 - .04 difference typically
	 * 
	 * @param __
	 *            the __
	 * @return the boolean
	 */
	private static Boolean isWild(Double __) {
		double _ = (__ / 100);
		if (Math.random() <= (_ - (_ / 87))) {
			return true;
		}
		return false;
	}

	/**
	 * Gets the multiplier.
	 * 
	 * @param group
	 *            the group
	 * @return the multiplier
	 */
	private static double getMultiplier(Group group) {
		if (group == Group.HIGH) {
			return Settings.qualhigh / 100;
		} else if (group == Group.MEDIUM) {
			return Settings.qualmed / 100;
		} else if (group == Group.LOW) {
			return Settings.quallow / 100;
		} else if (group == Group.DEFAULT) {
			return Settings.qualdef / 100;
		}
		return 0;
	}

	/**
	 * Checks if is high.
	 * 
	 * @param name
	 *            the name
	 * @return true, if is high
	 */
	private boolean isHigh(String name) {
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
	private boolean isMedium(String name) {
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
	private boolean isLow(String name) {
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
	private boolean isDefault(String name) {
		if (this.groups.containsKey(name)) {
			if (this.groups.get(name) == Group.DEFAULT) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Gets the.
	 * 
	 * @return the algorithm
	 */
	public static Algorithm get() {
		if (alg == null) {
			alg = new Algorithm();
		}
		return alg;
	}
}
