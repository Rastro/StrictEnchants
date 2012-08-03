package net.milkycraft;

import net.milkycraft.utilities.Group;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;

public class EnchantListener extends StricterEnchant implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onEnchant(EnchantItemEvent e) {
		if (e.getItem() == null) {
			return;
		}
		if (groups.get(e.getEnchanter().getName()) == Group.MAX) {
			return;
		} 
			Algorithm.get().analyze(e.getEnchanter(), e.getEnchantsToAdd(),
					e.getExpLevelCost(), e.getItem());
		
	}


}
