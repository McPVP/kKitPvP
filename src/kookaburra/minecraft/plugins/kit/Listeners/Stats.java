package kookaburra.minecraft.plugins.kit.Listeners;

import kookaburra.minecraft.plugins.kit.Utils.StatsUtils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Stats implements Listener {

	public static StatsUtils st = StatsUtils.getInstance();
	
	@EventHandler
	public void onKill(PlayerDeathEvent e) {
		if(e.getEntity().getKiller() instanceof Player) {
			Player killer = (Player)e.getEntity().getKiller();
			Player p = e.getEntity();
			p.sendMessage(ChatColor.AQUA + "You were slained by " + killer.getName());
			
			killer.sendMessage(ChatColor.RED + "You slained " + p.getName());
			
			st.addKills(killer, 1);
		}
	}
}