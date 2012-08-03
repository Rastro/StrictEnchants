package net.milkycraft.utilities;


import org.bukkit.entity.Player;

public class Utility {
	
	public static Group getEnchanterGroup(Player player) {
		if(player.isOp() || player.hasPermission("stricterenchant.group.max")) {
			return Group.MAX;
		} else if(player.hasPermission("stricterenchant.group.high")) {
			return Group.HIGH;
		} else if(player.hasPermission("stricterenchant.group.medium")) {
			return Group.MEDIUM;
		} else if(player.hasPermission("stricterenchant.group.low")) {
			return Group.LOW;
		} else {
			return Group.DEFAULT;
		}
	}
}
