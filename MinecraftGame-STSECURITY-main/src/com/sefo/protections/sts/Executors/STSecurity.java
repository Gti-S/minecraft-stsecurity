package com.sefo.protections.sts.Executors;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import com.sefo.protections.sts.Main;

public class STSecurity implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player)sender;
		ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
		boolean isPlayer = sender instanceof Player;
		
		if(cmd.getName().equalsIgnoreCase("stsecurity")){
			
			if(isPlayer){
				
				if(p.isOp()){
					if(args.length == 0){
						
						p.sendMessage(Main.C("&8&m&l------------&7&l» &bSTSecurity &7&l«&8&m&l------------"));
						p.sendMessage("");
						p.sendMessage(Main.C("&e/" + cmd.getName() + " addop &c<player> <password>"));
						p.sendMessage(Main.C("&e/" + cmd.getName() + " removeop &c<player> <password>"));
						p.sendMessage(Main.C("&e/" + cmd.getName() + " anticurse &c<enable/disable>"));
						p.sendMessage("");
						p.sendMessage(Main.C("&8&m&l------------&7&l» &bSTSecurity &7&l«&8&m&l------------"));
						
					} else if(args.length == 1){
						
						p.performCommand("sts");
						
					} else if(args.length == 2){
						
						if(args[0].equalsIgnoreCase("addop") || args[0].equalsIgnoreCase("removeop")){
							p.performCommand("sts");
						}
						
					} else if(args.length == 3){
						if(args[0].equalsIgnoreCase("addop")){
							if(args[2].equalsIgnoreCase(Main.getInstance().getConfig().getString("settings.antiop.password"))){
								Main.opList.add(p.getName());
								Main.getInstance().getConfig().set("settings.antiop.list", Main.opList);
								Main.getInstance().saveConfig();
								p.sendMessage(Main.C("&b&lSTS &7» &bPlayer " + p.getName() + " &bhas been added to the list."));
							} else {
								p.sendMessage(Main.C("&cIncorrect password"));
							}
						}
						
						if(args[0].equalsIgnoreCase("removeop")){
							if(args[2].equalsIgnoreCase(Main.getInstance().getConfig().getString("settings.antiop.password"))){
								Main.opList.remove(p.getName());
								Main.getInstance().getConfig().set("settings.antiop.list", Main.opList);
								Main.getInstance().saveConfig();
								p.sendMessage(Main.C("&b&lSTS &7» &bPlayer " + p.getName() + " &bhas been removed from the list."));
							} else {
								p.sendMessage(Main.C("&cIncorrect password"));
							}
						}
					}
				} else {p.sendMessage(Main.C("&fUnknown command. Type '/help' for help"));}
				
			} else {console.sendMessage(Main.C("&cBlocked command"));}
			
		}
		
		return false;
	}

}
