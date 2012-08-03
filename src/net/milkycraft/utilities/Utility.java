package net.milkycraft.utilities;

import java.util.Map;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class Utility {

	public static void enchant(ItemStack item, Map<Enchantment, Integer> enchants) {
		if(item == null) {
			return;
		}
		for(Enchantment ench : item.getEnchantments().keySet()) {
			item.removeEnchantment(ench);
		}
		item.addEnchantments(enchants);
	}
	
}
