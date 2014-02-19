package kookaburra.minecraft.plugins.kit;

import java.util.logging.Logger;

import kookaburra.minecraft.plugins.kit.Command.CommandStats;
import kookaburra.minecraft.plugins.kit.Files.StatsFile;
import kookaburra.minecraft.plugins.kit.Listeners.Stats;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class kKitPvP extends JavaPlugin {
	public static Plugin pl;
	public static Logger log;
	
	public void onEnable() {
		log = getLogger();
		pl = this;
		
		onLoad();
		onListeners();
		
		PluginDescriptionFile pdf = this.getDescription();
		log.info(pdf.getName() + " version " + pdf.getVersion() + " is enabled!");
	}
	
	public void onListeners() {
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new Stats(), this);
	}
	
	
	public void onLoad() {
		getCommand("stats").setExecutor(new CommandStats());
		StatsFile.getInstance().setup(this);
	}
	
	
	
	
	public void onDisable() {
		PluginDescriptionFile pdf = this.getDescription();
		log.info(pdf.getName() + " version " + pdf.getVersion() + " is disabled!");
	}

}
