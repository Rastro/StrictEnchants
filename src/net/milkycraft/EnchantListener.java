package net.milkycraft;

import net.milkycraft.utilities.Group;
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
			return;
		}
		if (this.groups.get(e.getEnchanter().getName()) == Group.MAX) {
			return;
		}
		Algorithm.get().analyze(e.getEnchanter(), e.getEnchantsToAdd(),
				e.getExpLevelCost(), e.getItem());

	}

}
