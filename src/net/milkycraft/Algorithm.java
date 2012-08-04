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
	 * @param en
	 *            the enchanter
	 * @param e
	 *            the enchants
	 * @param l
	 *            the lvl
	 * @param i
	 *            the item
	 */
	public void cal(Player en, Map<Enchantment, Integer> e,
			int l, ItemStack i) {
		if (ItemLookup.isDiamond(i)) {
			if (isHigh(en.getName())) {
				a(en, e, l, i, Group.HIGH, isWild(Settings.wildhigh)); 
			} else if (isMedium(en.getName())) {
				a(en, e, l, i, Group.MEDIUM, isWild(Settings.wildmed)); 
			} else if (isLow(en.getName())) {
				a(en, e, l, i, Group.LOW, isWild(Settings.wildlow)); 
			} else if (isDefault(en.getName())) {
				a(en, e, l, i, Group.DEFAULT, isWild(Settings.wilddef));  
			}
		} else if (ItemLookup.isIron(i)) {
			if (isHigh(en.getName())) {
				a(en, e, l, i, Group.HIGH, isWild(Settings.wildhigh));  
			} else if (isMedium(en.getName())) {
				a(en, e, l, i, Group.MEDIUM, isWild(Settings.wildmed));  
			} else if (isLow(en.getName())) {
				a(en, e, l, i, Group.LOW, isWild(Settings.wildlow)); 
			} else if (isDefault(en.getName())) {
				a(en, e, l, i, Group.DEFAULT, isWild(Settings.wilddef));  
			}
		} else if (ItemLookup.isGold(i)) {
			if (isHigh(en.getName())) {
				a(en, e, l, i, Group.HIGH, isWild(Settings.wildhigh));  
			} else if (isMedium(en.getName())) {
				a(en, e, l, i, Group.MEDIUM, isWild(Settings.wildmed));  
			} else if (isLow(en.getName())) {
				a(en, e, l, i, Group.LOW, isWild(Settings.wildlow));  
			} else if (isDefault(en.getName())) {
				a(en, e, l, i, Group.DEFAULT, isWild(Settings.wilddef)); 
			}
		} else if (ItemLookup.isStoneOrLeather(i)) {
			if (isHigh(en.getName())) {
				a(en, e, l, i, Group.HIGH, isWild(Settings.wildhigh));  
			} else if (isMedium(en.getName())) {
				a(en, e, l, i, Group.MEDIUM, isWild(Settings.wildmed));  
			} else if (isLow(en.getName())) {
				a(en, e, l, i, Group.LOW, isWild(Settings.wildlow));  
			} else if (isDefault(en.getName())) {
				a(en, e, l, i, Group.DEFAULT, isWild(Settings.wilddef));  
			}
		} else if (ItemLookup.isWood(i)) {
			if (isHigh(en.getName())) {
				a(en, e, l, i, Group.HIGH, isWild(Settings.wildhigh));  
			} else if (isMedium(en.getName())) {
				a(en, e, l, i, Group.MEDIUM, isWild(Settings.wildmed)); 
			} else if (isLow(en.getName())) {
				a(en, e, l, i, Group.LOW, isWild(Settings.wildlow)); 
			} else if (isDefault(en.getName())) {
				a(en, e, l, i, Group.DEFAULT, isWild(Settings.wilddef));  
			}
		} else if (ItemLookup.isChain(i)) {
			if (isHigh(en.getName())) {
				a(en, e, l, i, Group.HIGH, isWild(Settings.wildhigh)); 
			} else if (isMedium(en.getName())) {
				a(en, e, l, i, Group.MEDIUM, isWild(Settings.wildmed));
			} else if (isLow(en.getName())) {
				a(en, e, l, i, Group.LOW, isWild(Settings.wildlow));
			} else if (isDefault(en.getName())) {
				a(en, e, l, i, Group.DEFAULT, isWild(Settings.wilddef));
			}
		}
	}

	/**
	 * A.
	 * 
	 * @param enchanter
	 *            the enchanter
	 * @param enchants
	 *            the enchants
	 * @param lvl
	 *            the lvl
	 * @param item
	 *            the item
	 * @param group
	 *            the group
	 * @param wild
	 *            the wild
	 */
	private void a(Player enchanter, Map<Enchantment, Integer> enchants,
			int lvl, ItemStack item, Group group, Boolean wild) {
		EnchantListener.info(enchanter.getName() + " enchanted a "
				+ item.getType().toString().toLowerCase() + " with " + lvl
				+ " levels");
		b(enchants, item, wild, group);
	}
	
	/**
	 * B.
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
		if(getMultiplier(group) <= 10) {
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
	 * Provide an enchantment 0-9% of vanilla enchant
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
		
	}
	
	/**
	 * Provide an enchantment 10-19% of vanilla enchant
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
		
	}
	
	/**
	 * Provide an enchantment 20-29% of vanilla enchant
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
		
	}
	
	/**
	 * Provide an enchantment 30-39% of vanilla enchant
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
		
	}
	
	/**
	 * Provide an enchantment 40-49% of vanilla enchant
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
		
	}
	
	/**
	 * Provide an enchantment 50-59% of vanilla enchant
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
		
	}
	
	/**
	 * Provide an enchantment 60-69% of vanilla enchant
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
		
	}
	
	/**
	 * Provide an enchantment 70-79% of vanilla enchant
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
		
	}
	
	/**
	 * Provide an enchantment 80-89% of vanilla enchant
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
		
	}
	
	/**
	 * Provide an enchantment 90-99% of vanilla enchant
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
		
	}

	/**
	 * Checks if is wildcard.
	 * 
	 * @param __
	 *            the __
	 * @return the boolean
	 */
	private static Boolean isWild(Double __) {
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
