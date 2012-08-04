package net.milkycraft.utilities;

import java.util.HashMap;
import java.util.Map;

import net.milkycraft.StricterEnchant;
import net.milkycraft.configuration.Settings;
import net.milkycraft.events.EnchantModifyEvent;
import net.milkycraft.listeners.EnchantListener;
import net.milkycraft.utilities.Utility;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

// TODO: Add better javadoc
// TODO: Add more debugging
// TODO: Add the wildcard code 
// TODO: Test and adjust the numbers
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
	public Map<Enchantment, Integer> res;
	public static Player enchanter;
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
		Algorithm.setEnchanter(en);
		if (isHigh(en.getName())) {
			b(e, i, isWild(Settings.wildhigh), l, Group.HIGH);
			Utility.debug("Wild: " + isWild(Settings.wildhigh));
		} else if (isMedium(en.getName())) {
			b(e, i, isWild(Settings.wildmed), l, Group.MEDIUM);
			Utility.debug("Wild: " + isWild(Settings.wildmed));
		} else if (isLow(en.getName())) {
			b(e, i, isWild(Settings.wildlow), l, Group.LOW);
			Utility.debug("Wild: " + isWild(Settings.wildlow));
		} else if (isDefault(en.getName())) {
			b(e, i, isWild(Settings.wilddef), l, Group.DEFAULT);
			Utility.debug("Wild: " + isWild(Settings.wilddef));
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
			int l, Group group) {
		if (getMultiplier(group) <= 10) {
			c(ens, item, l, wild, group);
			Utility.debug("Multiplier <= 10");
		} else if (getMultiplier(group) <= 20) {
			d(ens, item, l, wild, group);
			Utility.debug("Multiplier <= 20");
		} else if (getMultiplier(group) <= 30) {
			e(ens, item, l, wild, group);
			Utility.debug("Multiplier <= 30");
		} else if (getMultiplier(group) <= 40) {
			f(ens, item, l, wild, group);
			Utility.debug("Multiplier <= 40");
		} else if (getMultiplier(group) <= 50) {
			g(ens, item, l, wild, group);
			Utility.debug("Multiplier <= 50");
		} else if (getMultiplier(group) <= 60) {
			h(ens, item, l, wild, group);
			Utility.debug("Multiplier <= 60");
		} else if (getMultiplier(group) <= 70) {
			i(ens, item, l, wild, group);
			Utility.debug("Multiplier <= 70");
		} else if (getMultiplier(group) <= 80) {
			j(ens, item, l, wild, group);
			Utility.debug("Multiplier <= 80");
		} else if (getMultiplier(group) <= 90) {
			k(ens, item, l, wild, group);
			Utility.debug("Multiplier <= 90");
		} else if (getMultiplier(group) < 100) {
			l(ens, item, l, wild, group);
			Utility.debug("Multiplier < 100");
		}
	}

	/**
	 * Provide an enchantment 0-9% of vanilla enchant. A wildcard at this level
	 * should be bad, but still lucky for the circumstance
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
	private void c(Map<Enchantment, Integer> ens, ItemStack item, int l,
			Boolean wild, Group group) {
		if (this.res == null) {
			this.res = new HashMap<Enchantment, Integer>();
		}
		if (ItemLookup.isDiamond(item)) {
			if (!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
							if(item.getType() == Material.DIAMOND_CHESTPLATE) {
								this.res.put(Enchantment.PROTECTION_EXPLOSIONS, 1);
							} else if(item.getType() == Material.DIAMOND_SWORD) {
								this.res.put(Enchantment.DAMAGE_ARTHROPODS, 1);
							}
						} else if (in == 2) {
							this.res.put(en, 1);
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 2);
						} else if (in == 5) {
							this.res.put(en, 3);
						}
					}
				}
			} else {
				// Add nifty wild card code 
			}
		} else if (ItemLookup.isIron(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 2);
						} else if (in == 5) {
							this.res.put(en, 2);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isGold(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
							this.res.put(en, 1);
						} else if (in == 3) {
							this.res.put(en, 2);
						} else if (in == 4) {
							this.res.put(en, 3);
						} else if (in == 5) {
							this.res.put(en, 4);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isStoneOrLeather(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 2);
						} else if (in == 5) {
							this.res.put(en, 2);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isWood(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 1);
						} else if (in == 5) {
							this.res.put(en, 2);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isChain(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {							
						} else if (in == 2) {
							this.res.put(en, 1);
						} else if (in == 3) {
							this.res.put(en, 2);
						} else if (in == 4) {
							this.res.put(en, 3);
						} else if (in == 5) {
							this.res.put(en, 4);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isBow(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 2);
						} else if (in == 5) {
							this.res.put(en, 2);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		}

		EnchantModifyEvent event = new EnchantModifyEvent(item, l, ens,
				this.res);
		Bukkit.getPluginManager().callEvent(event);
		this.res.clear();
	}

	/**
	 * Provide an enchantment 10-19% of vanilla enchant.
	 * 
	 * @param ens
	 *            the ens
	 * @param item
	 *            the item
	 * @param l
	 * @param wild
	 *            the wild
	 * @param group
	 *            the group
	 */
	private void d(Map<Enchantment, Integer> ens, ItemStack item, int l,
			Boolean wild, Group group) {
		if (this.res == null) {
			this.res = new HashMap<Enchantment, Integer>();
		}
		if (ItemLookup.isDiamond(item)) {
			if (!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
							if(item.getType() == Material.DIAMOND_CHESTPLATE) {
								this.res.put(Enchantment.PROTECTION_EXPLOSIONS, 1);
							} else if(item.getType() == Material.DIAMOND_SWORD) {
								this.res.put(Enchantment.DAMAGE_ARTHROPODS, 1);
							}
						} else if (in == 2) {
							this.res.put(en, 1);
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 2);
						} else if (in == 5) {
							this.res.put(en, 3);
						}
					}
				}
			} else {
				// Add nifty wild card code 
			}
		} else if (ItemLookup.isIron(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 2);
						} else if (in == 5) {
							this.res.put(en, 2);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isGold(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
							this.res.put(en, 1);
						} else if (in == 3) {
							this.res.put(en, 2);
						} else if (in == 4) {
							this.res.put(en, 3);
						} else if (in == 5) {
							this.res.put(en, 4);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isStoneOrLeather(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 2);
						} else if (in == 5) {
							this.res.put(en, 2);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isWood(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 1);
						} else if (in == 5) {
							this.res.put(en, 2);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isChain(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {							
						} else if (in == 2) {
							this.res.put(en, 1);
						} else if (in == 3) {
							this.res.put(en, 2);
						} else if (in == 4) {
							this.res.put(en, 3);
						} else if (in == 5) {
							this.res.put(en, 4);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isBow(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 2);
						} else if (in == 5) {
							this.res.put(en, 2);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		}

		EnchantModifyEvent event = new EnchantModifyEvent(item, l, ens,
				this.res);
		Bukkit.getPluginManager().callEvent(event);
		this.res.clear();
	}

	/**
	 * Provide an enchantment 20-29% of vanilla enchant.
	 * 
	 * @param ens
	 *            the ens
	 * @param item
	 *            the item
	 * @param l
	 * @param wild
	 *            the wild
	 * @param group
	 *            the group
	 */
	private void e(Map<Enchantment, Integer> ens, ItemStack item, int l,
			Boolean wild, Group group) {
		if (this.res == null) {
			this.res = new HashMap<Enchantment, Integer>();
		}
		if (ItemLookup.isDiamond(item)) {
			if (!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
							if(item.getType() == Material.DIAMOND_CHESTPLATE) {
								this.res.put(Enchantment.PROTECTION_EXPLOSIONS, 1);
							} else if(item.getType() == Material.DIAMOND_SWORD) {
								this.res.put(Enchantment.DAMAGE_ARTHROPODS, 1);
							}
						} else if (in == 2) {
							this.res.put(en, 1);
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 2);
						} else if (in == 5) {
							this.res.put(en, 3);
						}
					}
				}
			} else {
				// Add nifty wild card code 
			}
		} else if (ItemLookup.isIron(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 2);
						} else if (in == 5) {
							this.res.put(en, 2);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isGold(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
							this.res.put(en, 1);
						} else if (in == 3) {
							this.res.put(en, 2);
						} else if (in == 4) {
							this.res.put(en, 3);
						} else if (in == 5) {
							this.res.put(en, 4);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isStoneOrLeather(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 2);
						} else if (in == 5) {
							this.res.put(en, 2);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isWood(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 1);
						} else if (in == 5) {
							this.res.put(en, 2);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isChain(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {							
						} else if (in == 2) {
							this.res.put(en, 1);
						} else if (in == 3) {
							this.res.put(en, 2);
						} else if (in == 4) {
							this.res.put(en, 3);
						} else if (in == 5) {
							this.res.put(en, 4);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isBow(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 2);
						} else if (in == 5) {
							this.res.put(en, 2);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		}

		EnchantModifyEvent event = new EnchantModifyEvent(item, l, ens,
				this.res);
		Bukkit.getPluginManager().callEvent(event);
		this.res.clear();
	}

	/**
	 * Provide an enchantment 30-39% of vanilla enchant.
	 * 
	 * @param ens
	 *            the ens
	 * @param item
	 *            the item
	 * @param l
	 * @param wild
	 *            the wild
	 * @param group
	 *            the group
	 */
	private void f(Map<Enchantment, Integer> ens, ItemStack item, int l,
			Boolean wild, Group group) {
		if (this.res == null) {
			this.res = new HashMap<Enchantment, Integer>();
		}
		if (ItemLookup.isDiamond(item)) {
			if (!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
							if(item.getType() == Material.DIAMOND_CHESTPLATE) {
								this.res.put(Enchantment.PROTECTION_EXPLOSIONS, 1);
							} else if(item.getType() == Material.DIAMOND_SWORD) {
								this.res.put(Enchantment.DAMAGE_ARTHROPODS, 1);
							}
						} else if (in == 2) {
							this.res.put(en, 1);
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 2);
						} else if (in == 5) {
							this.res.put(en, 3);
						}
					}
				}
			} else {
				// Add nifty wild card code 
			}
		} else if (ItemLookup.isIron(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 2);
						} else if (in == 5) {
							this.res.put(en, 2);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isGold(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
							this.res.put(en, 1);
						} else if (in == 3) {
							this.res.put(en, 2);
						} else if (in == 4) {
							this.res.put(en, 3);
						} else if (in == 5) {
							this.res.put(en, 4);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isStoneOrLeather(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 2);
						} else if (in == 5) {
							this.res.put(en, 2);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isWood(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 1);
						} else if (in == 5) {
							this.res.put(en, 2);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isChain(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {							
						} else if (in == 2) {
							this.res.put(en, 1);
						} else if (in == 3) {
							this.res.put(en, 2);
						} else if (in == 4) {
							this.res.put(en, 3);
						} else if (in == 5) {
							this.res.put(en, 4);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isBow(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 2);
						} else if (in == 5) {
							this.res.put(en, 2);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		}

		EnchantModifyEvent event = new EnchantModifyEvent(item, l, ens,
				this.res);
		Bukkit.getPluginManager().callEvent(event);
		this.res.clear();
	}

	/**
	 * Provide an enchantment 40-49% of vanilla enchant.
	 * 
	 * @param ens
	 *            the ens
	 * @param item
	 *            the item
	 * @param l
	 * @param wild
	 *            the wild
	 * @param group
	 *            the group
	 */
	private void g(Map<Enchantment, Integer> ens, ItemStack item, int l,
			Boolean wild, Group group) {
		if (this.res == null) {
			this.res = new HashMap<Enchantment, Integer>();
		}
		if (ItemLookup.isDiamond(item)) {
			if (!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
							if(item.getType() == Material.DIAMOND_CHESTPLATE) {
								this.res.put(Enchantment.PROTECTION_EXPLOSIONS, 1);
							} else if(item.getType() == Material.DIAMOND_SWORD) {
								this.res.put(Enchantment.DAMAGE_ARTHROPODS, 1);
							}
						} else if (in == 2) {
							this.res.put(en, 1);
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 2);
						} else if (in == 5) {
							this.res.put(en, 3);
						}
					}
				}
			} else {
				// Add nifty wild card code 
			}
		} else if (ItemLookup.isIron(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 2);
						} else if (in == 5) {
							this.res.put(en, 2);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isGold(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
							this.res.put(en, 1);
						} else if (in == 3) {
							this.res.put(en, 2);
						} else if (in == 4) {
							this.res.put(en, 3);
						} else if (in == 5) {
							this.res.put(en, 4);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isStoneOrLeather(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 2);
						} else if (in == 5) {
							this.res.put(en, 2);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isWood(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 1);
						} else if (in == 5) {
							this.res.put(en, 2);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isChain(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {							
						} else if (in == 2) {
							this.res.put(en, 1);
						} else if (in == 3) {
							this.res.put(en, 2);
						} else if (in == 4) {
							this.res.put(en, 3);
						} else if (in == 5) {
							this.res.put(en, 4);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isBow(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 2);
						} else if (in == 5) {
							this.res.put(en, 2);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		}

		EnchantModifyEvent event = new EnchantModifyEvent(item, l, ens,
				this.res);
		Bukkit.getPluginManager().callEvent(event);
		this.res.clear();
	}

	/**
	 * Provide an enchantment 50-59% of vanilla enchant.
	 * 
	 * @param ens
	 *            the ens
	 * @param item
	 *            the item
	 * @param l
	 * @param wild
	 *            the wild
	 * @param group
	 *            the group
	 */
	private void h(Map<Enchantment, Integer> ens, ItemStack item, int l,
			Boolean wild, Group group) {
		if (this.res == null) {
			this.res = new HashMap<Enchantment, Integer>();
		}
		if (ItemLookup.isDiamond(item)) {
			if (!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
							if(item.getType() == Material.DIAMOND_CHESTPLATE) {
								this.res.put(Enchantment.PROTECTION_EXPLOSIONS, 1);
							} else if(item.getType() == Material.DIAMOND_SWORD) {
								this.res.put(Enchantment.DAMAGE_ARTHROPODS, 1);
							}
						} else if (in == 2) {
							this.res.put(en, 1);
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 2);
						} else if (in == 5) {
							this.res.put(en, 3);
						}
					}
				}
			} else {
				// Add nifty wild card code 
			}
		} else if (ItemLookup.isIron(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 2);
						} else if (in == 5) {
							this.res.put(en, 2);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isGold(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
							this.res.put(en, 1);
						} else if (in == 3) {
							this.res.put(en, 2);
						} else if (in == 4) {
							this.res.put(en, 3);
						} else if (in == 5) {
							this.res.put(en, 4);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isStoneOrLeather(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 2);
						} else if (in == 5) {
							this.res.put(en, 2);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isWood(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 1);
						} else if (in == 5) {
							this.res.put(en, 2);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isChain(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {							
						} else if (in == 2) {
							this.res.put(en, 1);
						} else if (in == 3) {
							this.res.put(en, 2);
						} else if (in == 4) {
							this.res.put(en, 3);
						} else if (in == 5) {
							this.res.put(en, 4);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isBow(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 2);
						} else if (in == 5) {
							this.res.put(en, 2);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		}

		EnchantModifyEvent event = new EnchantModifyEvent(item, l, ens,
				this.res);
		Bukkit.getPluginManager().callEvent(event);
		this.res.clear();
	}

	/**
	 * Provide an enchantment 60-69% of vanilla enchant.
	 * 
	 * @param ens
	 *            the ens
	 * @param item
	 *            the item
	 * @param l
	 * @param wild
	 *            the wild
	 * @param group
	 *            the group
	 */
	private void i(Map<Enchantment, Integer> ens, ItemStack item, int l,
			Boolean wild, Group group) {
		if (this.res == null) {
			this.res = new HashMap<Enchantment, Integer>();
		}
		if (ItemLookup.isDiamond(item)) {
			if (!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
							if(item.getType() == Material.DIAMOND_CHESTPLATE) {
								this.res.put(Enchantment.PROTECTION_EXPLOSIONS, 1);
							} else if(item.getType() == Material.DIAMOND_SWORD) {
								this.res.put(Enchantment.DAMAGE_ARTHROPODS, 1);
							}
						} else if (in == 2) {
							this.res.put(en, 1);
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 2);
						} else if (in == 5) {
							this.res.put(en, 3);
						}
					}
				}
			} else {
				// Add nifty wild card code 
			}
		} else if (ItemLookup.isIron(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 2);
						} else if (in == 5) {
							this.res.put(en, 2);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isGold(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
							this.res.put(en, 1);
						} else if (in == 3) {
							this.res.put(en, 2);
						} else if (in == 4) {
							this.res.put(en, 3);
						} else if (in == 5) {
							this.res.put(en, 4);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isStoneOrLeather(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 2);
						} else if (in == 5) {
							this.res.put(en, 2);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isWood(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 1);
						} else if (in == 5) {
							this.res.put(en, 2);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isChain(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {							
						} else if (in == 2) {
							this.res.put(en, 1);
						} else if (in == 3) {
							this.res.put(en, 2);
						} else if (in == 4) {
							this.res.put(en, 3);
						} else if (in == 5) {
							this.res.put(en, 4);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isBow(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 2);
						} else if (in == 5) {
							this.res.put(en, 2);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		}

		EnchantModifyEvent event = new EnchantModifyEvent(item, l, ens,
				this.res);
		Bukkit.getPluginManager().callEvent(event);
		this.res.clear();
	}

	/**
	 * Provide an enchantment 70-79% of vanilla enchant.
	 * 
	 * @param ens
	 *            the ens
	 * @param item
	 *            the item
	 * @param l
	 * @param wild
	 *            the wild
	 * @param group
	 *            the group
	 */
	private void j(Map<Enchantment, Integer> ens, ItemStack item, int l,
			Boolean wild, Group group) {
		if (this.res == null) {
			this.res = new HashMap<Enchantment, Integer>();
		}
		if (ItemLookup.isDiamond(item)) {
			if (!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
							if(item.getType() == Material.DIAMOND_CHESTPLATE) {
								this.res.put(Enchantment.PROTECTION_EXPLOSIONS, 1);
							} else if(item.getType() == Material.DIAMOND_SWORD) {
								this.res.put(Enchantment.DAMAGE_ARTHROPODS, 1);
							}
						} else if (in == 2) {
							this.res.put(en, 1);
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 2);
						} else if (in == 5) {
							this.res.put(en, 3);
						}
					}
				}
			} else {
				// Add nifty wild card code 
			}
		} else if (ItemLookup.isIron(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 2);
						} else if (in == 5) {
							this.res.put(en, 2);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isGold(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
							this.res.put(en, 1);
						} else if (in == 3) {
							this.res.put(en, 2);
						} else if (in == 4) {
							this.res.put(en, 3);
						} else if (in == 5) {
							this.res.put(en, 4);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isStoneOrLeather(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 2);
						} else if (in == 5) {
							this.res.put(en, 2);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isWood(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 1);
						} else if (in == 5) {
							this.res.put(en, 2);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isChain(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {							
						} else if (in == 2) {
							this.res.put(en, 1);
						} else if (in == 3) {
							this.res.put(en, 2);
						} else if (in == 4) {
							this.res.put(en, 3);
						} else if (in == 5) {
							this.res.put(en, 4);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isBow(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
						} else if (in == 2) {
						} else if (in == 3) {
							this.res.put(en, 1);
						} else if (in == 4) {
							this.res.put(en, 2);
						} else if (in == 5) {
							this.res.put(en, 2);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		}

		EnchantModifyEvent event = new EnchantModifyEvent(item, l, ens,
				this.res);
		Bukkit.getPluginManager().callEvent(event);
		this.res.clear();
	}

	/**
	 * Provide an enchantment 80-89% of vanilla enchant.
	 * 
	 * @param ens
	 *            the ens
	 * @param item
	 *            the item
	 * @param l
	 * @param wild
	 *            the wild
	 * @param group
	 *            the group
	 */
	private void k(Map<Enchantment, Integer> ens, ItemStack item, int l,
			Boolean wild, Group group) {
		if (this.res == null) {
			this.res = new HashMap<Enchantment, Integer>();
		}
		if (ItemLookup.isDiamond(item)) {
			if (!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
							this.res.put(en, 1);
						} else if (in == 2) {
							this.res.put(en, 1);
						} else if (in == 3) {
							this.res.put(en, 2);
						} else if (in == 4) {
							this.res.put(en, 3);
						} else if (in == 5) {
							this.res.put(en, 4);
						}
					}
				}
			} else {
				// Add nifty wild card code 
			}
		} else if (ItemLookup.isIron(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
							this.res.put(en, 1);
						} else if (in == 2) {
							this.res.put(en, 1);
						} else if (in == 3) {
							this.res.put(en, 2);
						} else if (in == 4) {
							this.res.put(en, 3);
						} else if (in == 5) {
							this.res.put(en, 4);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isGold(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
							this.res.put(en, 1);
						} else if (in == 2) {
							this.res.put(en, 1);
						} else if (in == 3) {
							this.res.put(en, 2);
						} else if (in == 4) {
							this.res.put(en, 3);
						} else if (in == 5) {
							this.res.put(en, 4);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isStoneOrLeather(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
							this.res.put(en, 1);
						} else if (in == 2) {
							this.res.put(en, 1);
						} else if (in == 3) {
							this.res.put(en, 2);
						} else if (in == 4) {
							this.res.put(en, 3);
						} else if (in == 5) {
							this.res.put(en, 4);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isWood(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
							this.res.put(en, 1);
						} else if (in == 2) {
							this.res.put(en, 1);
						} else if (in == 3) {
							this.res.put(en, 2);
						} else if (in == 4) {
							this.res.put(en, 3);
						} else if (in == 5) {
							this.res.put(en, 4);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isChain(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
							this.res.put(en, 1);
						} else if (in == 2) {
							this.res.put(en, 1);
						} else if (in == 3) {
							this.res.put(en, 2);
						} else if (in == 4) {
							this.res.put(en, 3);
						} else if (in == 5) {
							this.res.put(en, 4);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isBow(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
							this.res.put(en, 1);
						} else if (in == 2) {
							this.res.put(en, 1);
						} else if (in == 3) {
							this.res.put(en, 2);
						} else if (in == 4) {
							this.res.put(en, 3);
						} else if (in == 5) {
							this.res.put(en, 4);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		}

		EnchantModifyEvent event = new EnchantModifyEvent(item, l, ens,
				this.res);
		Bukkit.getPluginManager().callEvent(event);
		this.res.clear();
	}

	/**
	 * Provide an enchantment 90-99% of vanilla enchant.
	 * 
	 * @param ens
	 *            the ens
	 * @param item
	 *            the item
	 * @param l
	 * @param wild
	 *            the wild
	 * @param group
	 *            the group
	 */
	private void l(Map<Enchantment, Integer> ens, ItemStack item, int l,
			Boolean wild, Group group) {
		if (this.res == null) {
			this.res = new HashMap<Enchantment, Integer>();
		}
		if (ItemLookup.isDiamond(item)) {
			if (!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
							this.res.put(en, 1);
						} else if (in == 2) {
							this.res.put(en, 2);
						} else if (in == 3) {
							this.res.put(en, 3);
						} else if (in == 4) {
							this.res.put(en, 4);
						} else if (in == 5) {
							this.res.put(en, 4);
						}
					}
				}
			} else {
				// Add nifty wild card code 
			}
		} else if (ItemLookup.isIron(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
							this.res.put(en, 1);
						} else if (in == 2) {
							this.res.put(en, 2);
						} else if (in == 3) {
							this.res.put(en, 3);
						} else if (in == 4) {
							this.res.put(en, 4);
						} else if (in == 5) {
							this.res.put(en, 4);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isGold(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
							this.res.put(en, 1);
						} else if (in == 2) {
							this.res.put(en, 2);
						} else if (in == 3) {
							this.res.put(en, 3);
						} else if (in == 4) {
							this.res.put(en, 4);
						} else if (in == 5) {
							this.res.put(en, 4);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isStoneOrLeather(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
							this.res.put(en, 1);
						} else if (in == 2) {
							this.res.put(en, 2);
						} else if (in == 3) {
							this.res.put(en, 3);
						} else if (in == 4) {
							this.res.put(en, 4);
						} else if (in == 5) {
							this.res.put(en, 4);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isWood(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
							this.res.put(en, 1);
						} else if (in == 2) {
							this.res.put(en, 2);
						} else if (in == 3) {
							this.res.put(en, 3);
						} else if (in == 4) {
							this.res.put(en, 4);
						} else if (in == 5) {
							this.res.put(en, 4);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isChain(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
							this.res.put(en, 1);
						} else if (in == 2) {
							this.res.put(en, 2);
						} else if (in == 3) {
							this.res.put(en, 3);
						} else if (in == 4) {
							this.res.put(en, 4);
						} else if (in == 5) {
							this.res.put(en, 4);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		} else if (ItemLookup.isBow(item)) {
			if(!wild) {
				for (Enchantment en : ens.keySet()) {
					for (Integer in : ens.values()) {
						if (in == 1) {
							this.res.put(en, 1);
						} else if (in == 2) {
							this.res.put(en, 2);
						} else if (in == 3) {
							this.res.put(en, 3);
						} else if (in == 4) {
							this.res.put(en, 4);
						} else if (in == 5) {
							this.res.put(en, 4);
						}
					}
				}
			} else {
				// Add nifty wild card code
			}
		}

		EnchantModifyEvent event = new EnchantModifyEvent(item, l, ens,
				this.res);
		Bukkit.getPluginManager().callEvent(event);
		this.res.clear();
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

	
	
	
	public static Player getEnchanter() {
		return enchanter;
	}
	
	public static void setEnchanter(Player enchanterr) {
		enchanter = enchanterr;
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
