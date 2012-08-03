package net.milkycraft;

import java.util.Map;

import net.milkycraft.configuration.Settings;
import net.milkycraft.utilities.Group;
import net.milkycraft.utilities.ItemLookup;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

// TODO: Auto-generated Javadoc
/**
 * The Class Algorithm.
 */
public class Algorithm extends StricterEnchant {

	/** The alg. */
	public static Algorithm alg;

	/**
	 * Calculate the enchantments then call Ulility.enchant()
	 * 
	 * @param enchanter
	 *            the enchanter
	 * @param enchants
	 *            the enchants
	 * @param lvl
	 *            the lvl
	 * @param item
	 *            the item
	 */
	public void analyze(Player enchanter, Map<Enchantment, Integer> enchants,
			int lvl, ItemStack item) {
		if (ItemLookup.isDiamond(item)) {
			if (isHigh(enchanter.getName())) {
				if (isWild(Settings.wildhigh)) {

				} else {

				}
			} else if (isMedium(enchanter.getName())) {
				if (isWild(Settings.wildmed)) {

				} else {

				}
			} else if (isLow(enchanter.getName())) {
				if (isWild(Settings.wildlow)) {

				} else {

				}
			} else if (isDefault(enchanter.getName())) {
				if (isWild(Settings.wilddef)) {

				} else {

				}
			}
		} else if (ItemLookup.isIron(item)) {
			if (isHigh(enchanter.getName())) {
				if (isWild(Settings.wildhigh)) {

				} else {

				}
			} else if (isMedium(enchanter.getName())) {
				if (isWild(Settings.wildmed)) {

				} else {

				}
			} else if (isLow(enchanter.getName())) {
				if (isWild(Settings.wildlow)) {

				} else {

				}
			} else if (isDefault(enchanter.getName())) {
				if (isWild(Settings.wilddef)) {

				} else {

				}
			}
		} else if (ItemLookup.isGold(item)) {
			if (isHigh(enchanter.getName())) {
				if (isWild(Settings.wildhigh)) {

				} else {

				}
			} else if (isMedium(enchanter.getName())) {
				if (isWild(Settings.wildmed)) {

				} else {

				}
			} else if (isLow(enchanter.getName())) {
				if (isWild(Settings.wildlow)) {

				} else {

				}
			} else if (isDefault(enchanter.getName())) {
				if (isWild(Settings.wilddef)) {

				} else {

				}
			}
		} else if (ItemLookup.isStoneOrLeather(item)) {
			if (isHigh(enchanter.getName())) {
				if (isWild(Settings.wildhigh)) {

				} else {

				}
			} else if (isMedium(enchanter.getName())) {
				if (isWild(Settings.wildmed)) {

				} else {

				}
			} else if (isLow(enchanter.getName())) {
				if (isWild(Settings.wildlow)) {

				} else {

				}
			} else if (isDefault(enchanter.getName())) {
				if (isWild(Settings.wilddef)) {

				} else {

				}
			}
		} else if (ItemLookup.isWood(item)) {
			if (isHigh(enchanter.getName())) {
				if (isWild(Settings.wildhigh)) {

				} else {

				}
			} else if (isMedium(enchanter.getName())) {
				if (isWild(Settings.wildmed)) {

				} else {

				}
			} else if (isLow(enchanter.getName())) {
				if (isWild(Settings.wildlow)) {

				} else {

				}
			} else if (isDefault(enchanter.getName())) {
				if (isWild(Settings.wilddef)) {

				} else {

				}
			}
		} else if (ItemLookup.isChain(item)) {
			if (isHigh(enchanter.getName())) {
				if (isWild(Settings.wildhigh)) {

				} else {

				}
			} else if (isMedium(enchanter.getName())) {
				if (isWild(Settings.wildmed)) {

				} else {

				}
			} else if (isLow(enchanter.getName())) {
				if (isWild(Settings.wildlow)) {

				} else {

				}
			} else if (isDefault(enchanter.getName())) {
				if (isWild(Settings.wilddef)) {

				} else {

				}
			}
		}
	}

	/**
	 * A.
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
	public void a(Map<Enchantment, Integer> ens, ItemStack item, Boolean wild,
			Group group) {
		if (ItemLookup.isBow(item)) {
			if (wild) {
				if (ens.containsKey(Enchantment.ARROW_DAMAGE)) {
					int level = ens.get(Enchantment.ARROW_DAMAGE);
					if (level <= 2) {
						ens.remove(Enchantment.ARROW_DAMAGE);
						ens.put(Enchantment.ARROW_DAMAGE,
								level
										+ (int) (Math.random() * (1 + getMultiplier(group))));
					}
				} else if (ens.containsKey(Enchantment.ARROW_FIRE)
						&& (getMultiplier(group) >= 0.45)) {
					ens.remove(Enchantment.ARROW_FIRE);
					ens.put(Enchantment.ARROW_FIRE, 2);
				} else if (!ens.containsKey(Enchantment.ARROW_INFINITE)
						&& (getMultiplier(group) >= 0.65)) {
					ens.remove(Enchantment.ARROW_INFINITE);
					ens.put(Enchantment.ARROW_INFINITE, 1);
				} else if (!ens.containsKey(Enchantment.ARROW_KNOCKBACK)
						&& (getMultiplier(group) >= 0.30)) {
					ens.remove(Enchantment.ARROW_KNOCKBACK);
					ens.put(Enchantment.ARROW_KNOCKBACK, 1);
				}
			} else {
				if (getMultiplier(group) <= 10) {
					if (ens.containsKey(Enchantment.ARROW_DAMAGE)) {
						int level = ens.get(Enchantment.ARROW_DAMAGE);
						if (level == 5) {
							ens.remove(Enchantment.ARROW_DAMAGE);
							ens.put(Enchantment.ARROW_DAMAGE, 2);
						}
					} else if (ens.containsKey(Enchantment.ARROW_FIRE)) {
						ens.remove(Enchantment.ARROW_FIRE);
						ens.put(Enchantment.ARROW_FIRE, 2);
					} else if (ens.containsKey(Enchantment.ARROW_INFINITE)) {
						ens.remove(Enchantment.ARROW_INFINITE);
						ens.put(Enchantment.ARROW_INFINITE, 1);
					} else if (ens.containsKey(Enchantment.ARROW_KNOCKBACK)) {
						ens.remove(Enchantment.ARROW_KNOCKBACK);
						ens.put(Enchantment.ARROW_KNOCKBACK, 1);
					}
				} else if (getMultiplier(group) <= 20) {

				} else if (getMultiplier(group) <= 30) {

				} else if (getMultiplier(group) <= 40) {

				} else if (getMultiplier(group) <= 50) {

				} else if (getMultiplier(group) <= 60) {

				} else if (getMultiplier(group) <= 70) {

				} else if (getMultiplier(group) <= 80) {

				} else if (getMultiplier(group) <= 90) {

				} else if (getMultiplier(group) <= 100) {

				}
			}
		} else {
			if (wild) {

			} else {

			}
		}
	}

	/**
	 * Checks if is wildcard.
	 * 
	 * @param __
	 *            the __
	 * @return the boolean
	 */
	public static Boolean isWild(Double __) {
		double _ = (__ / 100);
		if (Math.random() <= (_ - (_ / 100))) {
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
	public static double getMultiplier(Group group) {
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
