package net.milkycraft.events;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

// TODO: Extend EnchantItemEvent so we naturally get all the proper arguements 
// That will improve the over-parameter problem
public class EnchantModifyEvent extends Event implements Cancellable {
	private static final HandlerList handlers = new HandlerList();
	private final ItemStack item;
	private int level;
	private boolean cancelled;
	private final Map<Enchantment, Integer> original;
	private final Map<Enchantment, Integer> result;

	/**
	 * Instantiates a new enchant modify event.
	 * 
	 * @param enchanter
	 *            the enchanter
	 * @param table
	 *            the table
	 * @param item
	 *            the item
	 * @param level
	 *            the level
	 * @param original
	 *            the original
	 * @param result
	 *            the result
	 */
	public EnchantModifyEvent(final ItemStack item, final int level,
			final Map<Enchantment, Integer> original,
			final Map<Enchantment, Integer> result) {
		this.item = item;
		this.level = level;
		this.original = new HashMap<Enchantment, Integer>(original);
		this.result = new HashMap<Enchantment, Integer>(result);
		this.cancelled = false;
	}

	/**
	 * Gets the item to be enchanted (can be modified).
	 * 
	 * @return ItemStack of item
	 */
	public ItemStack getItem() {
		return this.item;
	}

	/**
	 * Get cost in exp levels of the enchantment.
	 * 
	 * @return experience level cost
	 */
	public int getExpLevelCost() {
		return this.level;
	}

	/**
	 * Get map of enchantment (levels, keyed by type) to be added to item
	 * (modify map returned to change values) Note: Any enchantments not allowed
	 * for the item will be ignored.
	 * 
	 * @return map of enchantment levels, keyed by enchantment
	 */
	public Map<Enchantment, Integer> getOriginalEnchants() {
		return this.original;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.event.Cancellable#isCancelled()
	 */
	@Override
	public boolean isCancelled() {
		return this.cancelled;
	}

	/* (non-Javadoc)
	 * @see org.bukkit.event.Cancellable#setCancelled(boolean)
	 */
	@Override
	public void setCancelled(boolean cancel) {
		this.cancelled = cancel;
	}

	/**
	 * Gets the handler list.
	 * 
	 * @return the handler list
	 */
	public static HandlerList getHandlerList() {
		return handlers;
	}

	/**
	 * Gets the result.
	 * 
	 * @return the result
	 */
	public Map<Enchantment, Integer> getResult() {
		return this.result;
	}
	
	/**
	 * Enchant.
	 * 
	 * @param item
	 *            the item
	 * @param enchants
	 *            the enchants
	 */
	public void enchant(ItemStack item,
			Map<Enchantment, Integer> enchants) {
		if (item == null) {
			return;
		}
		for (Enchantment ench : item.getEnchantments().keySet()) {
			item.removeEnchantment(ench);
		}
		item.addEnchantments(enchants);
	}

	@Override
	public HandlerList getHandlers() {
		// TODO Auto-generated method stub
		return null;
	}
}