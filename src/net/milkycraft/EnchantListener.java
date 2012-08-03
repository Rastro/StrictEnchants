package net.milkycraft;

import java.util.Map;

import net.milkycraft.utilities.Group;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.inventory.ItemStack;

public class EnchantListener extends StricterEnchant implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onEnchant(EnchantItemEvent e) {
		if (e.getItem() == null) {
			return;
		}
		if (groups.get(e.getEnchanter().getName()) == Group.MAX) {
			return;
		} else if (groups.get(e.getEnchanter().getName()) == Group.HIGH) {
			analyze(e.getEnchanter(), e.getEnchantsToAdd(),
					e.getExpLevelCost(), e.getItem());
		} else if (groups.get(e.getEnchanter().getName()) == Group.MEDIUM) {
			analyze(e.getEnchanter(), e.getEnchantsToAdd(),
					e.getExpLevelCost(), e.getItem());
		} else if (groups.get(e.getEnchanter().getName()) == Group.LOW) {
			analyze(e.getEnchanter(), e.getEnchantsToAdd(),
					e.getExpLevelCost(), e.getItem());
		} else if (groups.get(e.getEnchanter().getName()) == Group.DEFAULT) {
			analyze(e.getEnchanter(), e.getEnchantsToAdd(),
					e.getExpLevelCost(), e.getItem());
		}
	}

	private void analyze(Player enchanter,
			Map<Enchantment, Integer> enchantsToAdd, int lvl, ItemStack item) {
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

}
