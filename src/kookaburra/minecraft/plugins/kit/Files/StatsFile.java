package kookaburra.minecraft.plugins.kit.Files;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

public class StatsFile {
	
private StatsFile() { }
	
	static StatsFile instance = new StatsFile();
	
	public static StatsFile getInstance() {
		return instance;
	}
	
	Plugin p;
	
	FileConfiguration stats;
	File statfile;
	
	public void setup(Plugin p) {
		this.p = p;
		
		if (!p.getDataFolder().exists()) p.getDataFolder().mkdir();
		
		statfile = new File(p.getDataFolder(), "data.yml");
		stats = YamlConfiguration.loadConfiguration(statfile);
		
		if (!statfile.exists()) {
			try {
				statfile.createNewFile();
			}
			catch (IOException e) {
				
			}
		}
	}
	
	public FileConfiguration getConfig() {
		return stats;
	}
	
	public void saveConfig() {
		try {
			stats.save(statfile);
		}
		catch (IOException e) {
		}
	}
	
	public PluginDescriptionFile getDescription() {
		return p.getDescription();
	}
}


