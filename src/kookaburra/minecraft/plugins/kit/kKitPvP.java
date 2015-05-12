package kookaburra.minecraft.plugins.kit;

import kookaburra.minecraft.plugins.kit.Command.CommandStats;
import kookaburra.minecraft.plugins.kit.Files.StatsFile;
import kookaburra.minecraft.plugins.kit.Listeners.Stats;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class kKitPvP extends JavaPlugin {
	
	public void onEnable() {
		load();
		loadListeners(this, new Stats());
	}
	
	public void loadListeners(Plugin plugin, Listeners... listeners) {
		for (Listener l : listeners) {
			Bukkit.getPluginManager.registerEvents(plugin, l);
		}
	}
	
	public void load() {
		getCommand("stats").setExecutor(new CommandStats());
		
		StatsFile.getInstance().setup(this);
	}
	
	public void onDisable() {
		// Do something eventually.
	}
}
