package net.milkycraft;

import java.util.Map;

import net.milkycraft.utilities.Group;
import org.bukkit.enchantments.Enchantment;
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
			Algorithm.analyze(e.getEnchanter(), e.getEnchantsToAdd(),
					e.getExpLevelCost(), e.getItem());
		} else if (groups.get(e.getEnchanter().getName()) == Group.MEDIUM) {
			Algorithm.analyze(e.getEnchanter(), e.getEnchantsToAdd(),
					e.getExpLevelCost(), e.getItem());
		} else if (groups.get(e.getEnchanter().getName()) == Group.LOW) {
			Algorithm.analyze(e.getEnchanter(), e.getEnchantsToAdd(),
					e.getExpLevelCost(), e.getItem());
		} else if (groups.get(e.getEnchanter().getName()) == Group.DEFAULT) {
			Algorithm.analyze(e.getEnchanter(), e.getEnchantsToAdd(),
					e.getExpLevelCost(), e.getItem());
		}
	}

	
	public void enchant(ItemStack item, Map<Enchantment, Integer> enchants) {
		if(item == null) {
			return;
		}
		for(Enchantment ench : item.getEnchantments().keySet()) {
			item.removeEnchantment(ench);
		}
		item.addEnchantments(enchants);
	}
}
