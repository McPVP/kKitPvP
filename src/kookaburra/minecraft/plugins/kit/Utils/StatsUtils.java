package kookaburra.minecraft.plugins.kit.Utils;

import kookaburra.minecraft.plugins.kit.Files.StatsFile;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class StatsUtils {
	
	private StatsUtils() { }
	
	static StatsUtils instance = new StatsUtils();
	
	public static StatsUtils getInstance() {
		return instance;
	}
	
	public void setCredits(Player p, int amount) {
	}
	
	
	public void getCredits(Player p) {
		
	}
	
	public  void setKills(Player p, int amount) {
		try {
			StatsFile.getInstance().getConfig().set("Data." + p.getName() + ".Kills", Integer.valueOf(amount));
			p.sendMessage(ChatColor.RED + "Kills set to: " + amount);
		}catch(NumberFormatException  ie) {
			//LODLSOLDSOLDSOLDSOL
		}
	}
	

	
	public void addKills(Player p, int amount) {
		StatsFile.getInstance().getConfig().set("Data." + p.getName() + ".Kills", StatsFile.getInstance().getConfig().getInt("Data." + p.getName() + ".Kills") + amount);
		StatsFile.getInstance().saveConfig();
	}
	

}
