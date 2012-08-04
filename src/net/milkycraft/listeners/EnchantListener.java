package net.milkycraft.listeners;

import net.milkycraft.StricterEnchant;
import net.milkycraft.configuration.Settings;
import net.milkycraft.events.EnchantModifyEvent;
import net.milkycraft.hooks.EntityManagerHook;
import net.milkycraft.utilities.Algorithm;
import net.milkycraft.utilities.Group;
import net.milkycraft.utilities.Utility;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving enchant events. The class that is
 * interested in processing a enchant event implements this interface, and the
 * object created with that class is registered with a component using the
 * component's <code>addEnchantListener<code> method. When
 * the enchant event occurs, that object's appropriate
 * method is invoked.
 * 
 * @see EnchantEvent
 */
public class EnchantListener extends StricterEnchant implements Listener {
	/**
	 * On enchant.
	 * 
	 * @param e
	 *            the e
	 */
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onEnchant(EnchantItemEvent e) {
		if (e.getItem() == null) {
			Utility.debug("Enchant item was null, returned");
			return;
		}
		if (this.groups.get(e.getEnchanter().getName()) == Group.MAX) {
			Utility.debug("Enchanter has MAX, returning = vanilla enchant");
			return;
		}
		if (Settings.hook) {
			if (EntityManagerHook.api.canEnchant(e.getEnchanter())) {
				Algorithm.get().cal(e.getEnchanter(), e.getEnchantsToAdd(),
						e.getExpLevelCost(), e.getItem());
				Utility.debug("Called algorithm thru entitymanager");
				return;
			}
		}
		Algorithm.get().cal(e.getEnchanter(), e.getEnchantsToAdd(),
				e.getExpLevelCost(), e.getItem());
		Utility.debug("Called algorithm without entitymanager");
	}

	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onEnchantModification(EnchantModifyEvent e) {
		if(e.getItem() == null) {
			return;
		}
		if(isHigh(Algorithm.getEnchanter().getName())) {
		// Lets make a filter	Utility.getBlocked(Group.HIGH);
		} else if(isMedium(Algorithm.getEnchanter().getName())) {
			// Lets make a filter	Utility.getBlocked(Group.MEDIUM);
		} else if(isLow(Algorithm.getEnchanter().getName())) {
			// Lets make a filter	Utility.getBlocked(Group.LOW);
		} else if(isDefault(Algorithm.getEnchanter().getName())) {
			// Lets make a filter	Utility.getBlocked(Group.DEFAULT);
		}
			e.enchant(e.getItem(), e.getResult());
			Utility.debug("Enchanted Item was modifed via EnchantModifyEvent");
	}
}
