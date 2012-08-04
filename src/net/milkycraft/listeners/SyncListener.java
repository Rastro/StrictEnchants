package net.milkycraft.listeners;

import java.util.HashSet;
import java.util.Set;

import net.milkycraft.StricterEnchant;
import net.milkycraft.utilities.Group;
import net.milkycraft.utilities.Utility;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving sync events. The class that is
 * interested in processing a sync event implements this interface, and the
 * object created with that class is registered with a component using the
 * component's <code>addSyncListener<code> method. When
 * the sync event occurs, that object's appropriate
 * method is invoked.
 * 
 * @see SyncEvent
 */
public class SyncListener extends StricterEnchant implements Listener {

	/** The queue. */
	public Set<String> queue = new HashSet<String>();

	/**
	 * On join.
	 * 
	 * @param e
	 *            the e
	 */
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onJoin(PlayerJoinEvent e) {
		if (e.getPlayer() == null) {
			return;
		}
		if(this.queue.contains(e.getPlayer().getName())) {
			Utility.debug(e.getPlayer().getName() + " was in queue, didnt give them a group");
			return;
		}
		if (e.getPlayer().isOp()
				|| e.getPlayer().hasPermission("senchant.group.max")) {
			this.groups.put(e.getPlayer().getName(), Group.MAX);
			Utility.debug(e.getPlayer().getName() + " was given max");
			return;
		} else if (e.getPlayer().hasPermission("senchant.group.high")) {
			this.groups.put(e.getPlayer().getName(), Group.HIGH);
			Utility.debug(e.getPlayer().getName() + " was given high");
			return;
		} else if (e.getPlayer().hasPermission("senchant.group.medium")) {
			this.groups.put(e.getPlayer().getName(), Group.MEDIUM);
			Utility.debug(e.getPlayer().getName() + " was given medium");
			return;
		} else if (e.getPlayer().hasPermission("senchant.group.low")) {
			this.groups.put(e.getPlayer().getName(), Group.LOW);
			Utility.debug(e.getPlayer().getName() + " was given low");
			return;
		} else {
			this.groups.put(e.getPlayer().getName(), Group.DEFAULT);
			Utility.debug(e.getPlayer().getName() + " was given default");
			return;
		}
	}

	/**
	 * On quit.
	 * 
	 * @param e
	 *            the e
	 */
	@EventHandler(priority = EventPriority.MONITOR)
	public void onQuit(PlayerQuitEvent e) {
		if (this.groups.containsKey(e.getPlayer().getName())
				|| this.queue.contains(e.getPlayer().getName())) {
			this.queue.add(e.getPlayer().getName());
			Bukkit.getScheduler().scheduleSyncDelayedTask(this.main,
					new Timer(e.getPlayer().getName()), 1200L);
		}
	}

	/**
	 * On kick.
	 * 
	 * @param e
	 *            the e
	 */
	@EventHandler(priority = EventPriority.MONITOR)
	public void onKick(PlayerKickEvent e) {
		if (e.getPlayer() == null) {
			return;
		}
		if (e.getReason().equals("The Ban Hammer has Spoken!")) {
			this.queue.remove(e.getPlayer().getName());
			Utility.debug("Kick reason was ban, removed " + e.getPlayer());
		} else {
			Bukkit.getScheduler().scheduleSyncDelayedTask(this.main,
					new Timer(e.getPlayer().getName()), 600L);
			Utility.debug("Queueing a removal in 30 seconds, " + e.getPlayer() + " was kicked");
		}
	}

	/**
	 * The Class Timer.
	 */
	class Timer extends SyncListener implements Runnable {

		/** The name. */
		String name;

		/**
		 * Instantiates a new timer.
		 * 
		 * @param playername
		 *            the playername
		 */
		public Timer(String playername) {
			this.name = playername;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			runQueue(this.name);
			Utility.debug("Run queue @ line 124 was called");
		}
	}

	/**
	 * Sync groups.
	 */
	public void syncGroups() {
		if (this.groups != null && !this.groups.isEmpty()) {
			this.groups.clear();
		}
		for (Player p : Bukkit.getOnlinePlayers()) {
			if (p.hasPermission("senchant.group.max")) {
				this.groups.put(p.getName(), Group.MAX);
				Utility.debug(p.getName() + " was put in Group.MAX");
				continue;
			} else if (p.hasPermission("senchant.group.high")) {
				this.groups.put(p.getName(), Group.HIGH);
				Utility.debug(p.getName() + " was put in Group.HIGH");
				continue;
			} else if (p.hasPermission("senchant.group.medium")) {
				this.groups.put(p.getName(), Group.MEDIUM);
				Utility.debug(p.getName() + " was put in Group.MEDIUM");
				continue;
			} else if (p.hasPermission("senchant.group.low")) {
				this.groups.put(p.getName(), Group.LOW);
				Utility.debug(p.getName() + " was put in Group.LOW");
				continue;
			} else {
				this.groups.put(p.getName(), Group.DEFAULT);
				Utility.debug(p.getName() + " was put in Group.DEFAULT");
			}
		}
	}

	/**
	 * Run queue.
	 * 
	 * @param name
	 *            the name
	 */
	public void runQueue(String name) {
		if (Bukkit.getPlayerExact(name).isOnline()) {
			return;
		}
		Utility.debug("Removing " + name + " from queue");
		this.queue.remove(name);
	}

}
