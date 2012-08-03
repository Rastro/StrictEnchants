package net.milkycraft.utilities;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemLookup.
 */
public class ItemLookup {

	/**
	 * Checks if is diamond.
	 * 
	 * @param item
	 *            the item
	 * @return true, if is diamond
	 */
	public static boolean isDiamond(ItemStack item) {
		if (item.getType() == Material.DIAMOND_SWORD
				|| item.getType() == Material.DIAMOND_AXE
				|| item.getType() == Material.DIAMOND_SPADE
				|| item.getType() == Material.DIAMOND_PICKAXE) {
			return true;
		} else if (item.getType() == Material.DIAMOND_BOOTS
				|| item.getType() == Material.DIAMOND_HELMET
				|| item.getType() == Material.DIAMOND_CHESTPLATE
				|| item.getType() == Material.DIAMOND_LEGGINGS) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if is iron.
	 * 
	 * @param item
	 *            the item
	 * @return true, if is iron
	 */
	public static boolean isIron(ItemStack item) {
		if (item.getType() == Material.IRON_SWORD
				|| item.getType() == Material.IRON_AXE
				|| item.getType() == Material.IRON_SPADE
				|| item.getType() == Material.IRON_PICKAXE) {
			return true;
		} else if (item.getType() == Material.IRON_BOOTS
				|| item.getType() == Material.IRON_HELMET
				|| item.getType() == Material.IRON_CHESTPLATE
				|| item.getType() == Material.IRON_LEGGINGS) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if is gold.
	 * 
	 * @param item
	 *            the item
	 * @return true, if is gold
	 */
	public static boolean isGold(ItemStack item) {
		if (item.getType() == Material.GOLD_SWORD
				|| item.getType() == Material.GOLD_AXE
				|| item.getType() == Material.GOLD_SPADE
				|| item.getType() == Material.GOLD_PICKAXE) {
			return true;
		} else if (item.getType() == Material.GOLD_BOOTS
				|| item.getType() == Material.GOLD_HELMET
				|| item.getType() == Material.GOLD_CHESTPLATE
				|| item.getType() == Material.GOLD_LEGGINGS) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if is stone or leather.
	 * 
	 * @param item
	 *            the item
	 * @return true, if is stone or leather
	 */
	public static boolean isStoneOrLeather(ItemStack item) {
		if (item.getType() == Material.STONE_SWORD
				|| item.getType() == Material.STONE_AXE
				|| item.getType() == Material.STONE_SPADE
				|| item.getType() == Material.STONE_PICKAXE) {
			return true;
		} else if (item.getType() == Material.LEATHER_BOOTS
				|| item.getType() == Material.LEATHER_HELMET
				|| item.getType() == Material.LEATHER_CHESTPLATE
				|| item.getType() == Material.LEATHER_LEGGINGS) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if is wood.
	 * 
	 * @param item
	 *            the item
	 * @return true, if is wood
	 */
	public static boolean isWood(ItemStack item) {
		if (item.getType() == Material.WOOD_SWORD
				|| item.getType() == Material.WOOD_AXE
				|| item.getType() == Material.WOOD_SPADE
				|| item.getType() == Material.WOOD_PICKAXE) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if is chain.
	 * 
	 * @param item
	 *            the item
	 * @return true, if is chain
	 */
	public static boolean isChain(ItemStack item) {
		if (item.getType() == Material.CHAINMAIL_BOOTS
				|| item.getType() == Material.CHAINMAIL_LEGGINGS
				|| item.getType() == Material.CHAINMAIL_CHESTPLATE
				|| item.getType() == Material.CHAINMAIL_HELMET) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if is bow.
	 * 
	 * @param item
	 *            the item
	 * @return true, if is bow
	 */
	public static boolean isBow(ItemStack item) {
		return item.getType() == Material.BOW;
	}
}
