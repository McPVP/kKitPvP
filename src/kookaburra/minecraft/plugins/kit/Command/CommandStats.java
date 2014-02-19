package kookaburra.minecraft.plugins.kit.Command;

import kookaburra.minecraft.plugins.kit.Files.StatsFile;
import kookaburra.minecraft.plugins.kit.Utils.MessageUtil;
import kookaburra.minecraft.plugins.kit.Utils.StatsUtils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandStats implements CommandExecutor {
	public static MessageUtil msgu = MessageUtil.getInstance();
	public static StatsUtils st = StatsUtils.getInstance();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
		if(!(sender instanceof Player)) {
			msgu.noConsole(sender);
			return true;
		}
		Player p = (Player) sender;
		int length = args.length;
		if(cmd.getName().equalsIgnoreCase("stats")) {
			if(length == 0) {
				int kills = StatsFile.getInstance().getConfig().getInt("Data." + p.getName() + ".Kills");
				p.sendMessage(ChatColor.GREEN + "Kills: " + kills); //kills
				p.sendMessage(ChatColor.GREEN + "Deaths: "); //deaths
				p.sendMessage(ChatColor.GREEN + "Current Kill Streak:"); //streak?
				p.sendMessage(ChatColor.GREEN + "Credits: ");
				p.sendMessage(ChatColor.GREEN + "Your worth: ");
				return true;
			}
			Player target = Bukkit.getServer().getPlayer(args[0]);
			if(target != null) {
				int kills = StatsFile.getInstance().getConfig().getInt("Data." + target.getName() + ".Kills");
				p.sendMessage(ChatColor.GREEN + "Their Kills: " + kills); //kills
				p.sendMessage(ChatColor.GREEN + "Their Deaths: "); //deaths
				p.sendMessage(ChatColor.GREEN + "Their Current Kill Streak: "); //streak?
				p.sendMessage(ChatColor.GREEN + "Their Credits: ");
				p.sendMessage(ChatColor.GREEN + "Their worth: ");
			}
			else {
				p.sendMessage("Couldn't find " + args[0]);
			}
		}
		return false;
	}

}
