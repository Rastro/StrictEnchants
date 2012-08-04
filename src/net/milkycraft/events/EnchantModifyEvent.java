package net.milkycraft.events;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

public class EnchantModifyEvent implements Cancellable {
	private static final HandlerList handlers = new HandlerList();
	private final Block table;
	private final ItemStack item;
	private int level;
	private boolean cancelled;
	private final Map<Enchantment, Integer> original;
	private final Map<Enchantment, Integer> result;
	private final Player enchanter;

	public EnchantModifyEvent(final Player enchanter, final Block table,
			final ItemStack item, final int level,
			final Map<Enchantment, Integer> original,
			final Map<Enchantment, Integer> result) {
		this.enchanter = enchanter;
		this.table = table;
		this.item = item;
		this.level = level;
		this.original = new HashMap<Enchantment, Integer>(original);
		this.result = new HashMap<Enchantment, Integer>(result);
		this.cancelled = false;
	}

	/**
	 * Gets the player enchanting the item
	 * 
	 * @return enchanting player
	 */
	public Player getEnchanter() {
		return this.enchanter;
	}

	/**
	 * Gets the block being used to enchant the item
	 * 
	 * @return the block used for enchanting
	 */
	public Block getEnchantBlock() {
		return this.table;
	}

	/**
	 * Gets the item to be enchanted (can be modified)
	 * 
	 * @return ItemStack of item
	 */
	public ItemStack getItem() {
		return this.item;
	}

	/**
	 * Get cost in exp levels of the enchantment
	 * 
	 * @return experience level cost
	 */
	public int getExpLevelCost() {
		return this.level;
	}

	/**
	 * Get map of enchantment (levels, keyed by type) to be added to item
	 * (modify map returned to change values) Note: Any enchantments not allowed
	 * for the item will be ignored
	 * 
	 * @return map of enchantment levels, keyed by enchantment
	 */
	public Map<Enchantment, Integer> getOriginalEnchants() {
		return this.original;
	}

	@Override
	public boolean isCancelled() {
		return this.cancelled;
	}

	@Override
	public void setCancelled(boolean cancel) {
		this.cancelled = cancel;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	public Map<Enchantment, Integer> getResult() {
		return this.result;
	}
}