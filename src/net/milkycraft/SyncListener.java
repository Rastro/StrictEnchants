package net.milkycraft;

import java.util.HashSet;
import java.util.Set;

import net.milkycraft.utilities.Group;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class SyncListener extends StricterEnchant implements Listener {

	public Set<String> queue = new HashSet<String>();

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onJoin(PlayerJoinEvent e) {
		if (e.getPlayer() == null) {
			return;
		}
		if (e.getPlayer().isOp()
				|| e.getPlayer().hasPermission("stricterenchant.group.max")) {
			groups.put(e.getPlayer().getName(), Group.MAX);
			return;
		} else if (e.getPlayer().hasPermission("stricterenchant.group.high")) {
			groups.put(e.getPlayer().getName(), Group.HIGH);
			return;
		} else if (e.getPlayer().hasPermission("stricterenchant.group.medium")) {
			groups.put(e.getPlayer().getName(), Group.MEDIUM);
			return;
		} else if (e.getPlayer().hasPermission("stricterenchant.group.low")) {
			groups.put(e.getPlayer().getName(), Group.LOW);
			return;
		} else {
			groups.put(e.getPlayer().getName(), Group.DEFAULT);
			return;
		}
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onQuit(PlayerQuitEvent e) {
		if (groups.containsKey(e.getPlayer().getName())
				|| queue.contains(e.getPlayer().getName())) {
			queue.add(e.getPlayer().getName());
			Bukkit.getScheduler().scheduleSyncDelayedTask(main, new Timer(e.getPlayer().getName()),600L);
		}
	}

class Timer extends SyncListener implements Runnable {
	String name;

	public Timer(String playername) {
		this.name = playername;
	}

	@Override
	public void run() {
		runQueue(name);
	}
}


public void runQueue(String name) {
	if(Bukkit.getPlayerExact(name).isOnline()) {
		return;
	} else {
		queue.remove(name);
	}
}
}
