package net.milkycraft;

import java.util.Map;

import net.milkycraft.utilities.ItemLookup;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Algorithm extends StricterEnchant {
	public static void analyze(Player enchanter,Map<Enchantment, Integer> enchants, int lvl, ItemStack item) {
		if (lvl == 1) {
			if (ItemLookup.isDiamond(item)) {
				
			} else if (ItemLookup.isIron(item)) {

			} else if (ItemLookup.isGold(item)) {

			} else if (ItemLookup.isStoneOrLeather(item)) {

			} else if (ItemLookup.isWood(item)) {

			} else if (ItemLookup.isChain(item)) {

			}
		} else if (lvl >= 5 && lvl <= 10) {
			if (ItemLookup.isDiamond(item)) {

			} else if (ItemLookup.isIron(item)) {

			} else if (ItemLookup.isGold(item)) {

			} else if (ItemLookup.isStoneOrLeather(item)) {

			} else if (ItemLookup.isWood(item)) {

			} else if (ItemLookup.isChain(item)) {

			}
		} else if (lvl >= 11 && lvl <= 15) {
			if (ItemLookup.isDiamond(item)) {

			} else if (ItemLookup.isIron(item)) {

			} else if (ItemLookup.isGold(item)) {

			} else if (ItemLookup.isStoneOrLeather(item)) {

			} else if (ItemLookup.isWood(item)) {

			} else if (ItemLookup.isChain(item)) {

			}
		} else if (lvl >= 16 && lvl <= 20) {
			if (ItemLookup.isDiamond(item)) {

			} else if (ItemLookup.isIron(item)) {

			} else if (ItemLookup.isGold(item)) {

			} else if (ItemLookup.isStoneOrLeather(item)) {

			} else if (ItemLookup.isWood(item)) {

			} else if (ItemLookup.isChain(item)) {

			}
		} else if (lvl >= 21 && lvl <= 25) {
			if (ItemLookup.isDiamond(item)) {

			} else if (ItemLookup.isIron(item)) {

			} else if (ItemLookup.isGold(item)) {

			} else if (ItemLookup.isStoneOrLeather(item)) {

			} else if (ItemLookup.isWood(item)) {

			} else if (ItemLookup.isChain(item)) {

			}
		} else if (lvl >= 26 && lvl <= 30) {
			if (ItemLookup.isDiamond(item)) {

			} else if (ItemLookup.isIron(item)) {

			} else if (ItemLookup.isGold(item)) {

			} else if (ItemLookup.isStoneOrLeather(item)) {

			} else if (ItemLookup.isWood(item)) {

			} else if (ItemLookup.isChain(item)) {

			}
		}
	}
	public int wildcardChance() {
		
		return 0;
	}
}
