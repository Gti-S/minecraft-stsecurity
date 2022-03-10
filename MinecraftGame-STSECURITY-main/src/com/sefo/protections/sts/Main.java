package com.sefo.protections.sts;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.sefo.protections.sts.Executors.STSecurity;
import com.sefo.protections.sts.listeners.ChatListener;
import com.sefo.protections.sts.listeners.ConnectionsListener;

public class Main extends JavaPlugin{
	
	public static String C(String G) {return ChatColor.translateAlternateColorCodes('&', G);}
	public static List<String> opList = new ArrayList<String>();
	public void console(String consolesender){Bukkit.getServer().getConsoleSender().sendMessage(Main.C(consolesender));}
	public static Main instance;
	
	
	public void onEnable(){
		
		this.console("&8&l============================");
		this.console("         &a&lActivated!");
		this.console("");
		this.console("&rLicenseID: &cnull");
		this.console("&rVersion: 1.0");
		this.console("&rAuthor: &bNot defined");
		this.console("&rName: &bST-Security");
		this.console("");
		this.console("         &a&lActivated!");
		this.console("&8&l============================");
		
		registerListeners();
		registerCommands();
		loadConfig();
		instance = this;
		
	}
	
	public void onDisable(){
		
		this.console("&8&l============================");
		this.console("         &4&lDeActivated!");
		this.console("");
		this.console("&rLicenseID: &cnull");
		this.console("&rVersion: 1.0");
		this.console("&rAuthor: &bNot defined");
		this.console("&rName: &bST-Security");
		this.console("");
		this.console("         &4&lDeActivated!");
		this.console("&8&l============================");
		
		registerListeners();
		registerCommands();
		loadConfig();
		instance = this;
		
	}
	
	
	public void registerCommands(){
		this.getCommand("stsecurity").setExecutor(new STSecurity());
	}
	
	public void registerListeners(){
		PluginManager pm = Bukkit.getServer().getPluginManager();
		
		pm.registerEvents(new ConnectionsListener(), this);
		pm.registerEvents(new ChatListener(), this);
	}
	
	public void loadConfig(){
		FileConfiguration cfg = this.getConfig();
		FileConfigurationOptions cfgOptions = this.getConfig().options();
		
		opList = (ArrayList<String>)this.getConfig().getStringList("settings.antiop.list");
		cfg.set("settings.antiop.password", "af#$1H5ts!c");
		cfgOptions.copyDefaults(true);
		this.saveConfig();
	}
	
	
	public static Main getInstance() {return instance;}

}
