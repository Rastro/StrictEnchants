package net.milkycraft;

import java.util.HashSet;
import java.util.Set;

import net.milkycraft.utilities.Group;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class SyncListener extends StricterEnchant implements Listener {

	public Set<String> queue = new HashSet<String>();
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onJoin(PlayerJoinEvent e) {
		if (e.getPlayer() == null) {
			return;
		}
		if (e.getPlayer().isOp()
				|| e.getPlayer().hasPermission("senchant.group.max")) {
			this.groups.put(e.getPlayer().getName(), Group.MAX);
			return;
		} else if (e.getPlayer().hasPermission("senchant.group.high")) {
			this.groups.put(e.getPlayer().getName(), Group.HIGH);
			return;
		} else if (e.getPlayer().hasPermission("senchant.group.medium")) {
			this.groups.put(e.getPlayer().getName(), Group.MEDIUM);
			return;
		} else if (e.getPlayer().hasPermission("senchant.group.low")) {
			this.groups.put(e.getPlayer().getName(), Group.LOW);
			return;
		} else {
			this.groups.put(e.getPlayer().getName(), Group.DEFAULT);
			return;
		}
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onQuit(PlayerQuitEvent e) {
		if (this.groups.containsKey(e.getPlayer().getName())
				|| this.queue.contains(e.getPlayer().getName())) {
			this.queue.add(e.getPlayer().getName());
			Bukkit.getScheduler().scheduleSyncDelayedTask(this.main, new Timer(e.getPlayer().getName()),1200L);
		}
	}
	
	@EventHandler(priority = EventPriority.MONITOR)
	public void onKick(PlayerKickEvent e) {
		if(e.getPlayer() == null) {
			return;
		}
		if(e.getReason().equals("The Ban Hammer has Spoken!")) {
			this.queue.remove(e.getPlayer().getName());
		} else {
			Bukkit.getScheduler().scheduleSyncDelayedTask(this.main, new Timer(e.getPlayer().getName()),600L);
		}
	}

class Timer extends SyncListener implements Runnable {
	String name;

	public Timer(String playername) {
		this.name = playername;
	}

	@Override
	public void run() {
		runQueue(this.name);
	}
}

public void syncGroups() {
	if(this.groups != null && !this.groups.isEmpty()) {
		this.groups.clear();
	}
	for(Player p : Bukkit.getOnlinePlayers()) {
		if(p.isOp() || p.hasPermission("senchant.group.max")) {
			this.groups.put(p.getName(), Group.MAX);
			continue;
		} else if(p.hasPermission("senchant.group.high")) {
			this.groups.put(p.getName(), Group.HIGH);
			continue;
		} else if(p.hasPermission("senchant.group.medium")) {
			this.groups.put(p.getName(), Group.MEDIUM);
			continue;
		} else if(p.hasPermission("senchant.group.low")) {
			this.groups.put(p.getName(), Group.LOW);
			continue;
		} else {
			this.groups.put(p.getName(), Group.DEFAULT);
		}
	}
}


public void runQueue(String name) {
	if(Bukkit.getPlayerExact(name).isOnline()) {
		return;
	}
	this.queue.remove(name);
}
}
