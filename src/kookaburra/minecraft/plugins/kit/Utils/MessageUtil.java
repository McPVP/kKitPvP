package kookaburra.minecraft.plugins.kit.Utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageUtil {
	
	private MessageUtil() { }
	
	static MessageUtil instance = new MessageUtil();
	
	public static MessageUtil getInstance() {
		return instance;
	}

	public void debug(Player p, String msg) {
		p.sendMessage(ChatColor.AQUA + "? " + ChatColor.WHITE + msg);
	}
	
	public void noConsole(CommandSender sender) {
		sender.sendMessage(ChatColor.AQUA + "? " + ChatColor.WHITE + " You cannot acess console to use this command!");
	}
}
