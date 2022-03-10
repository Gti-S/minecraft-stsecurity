package com.sefo.protections.sts.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import com.sefo.protections.sts.Main;

public class ConnectionsListener implements Listener {
	
	@EventHandler
	public void onJoin(PlayerLoginEvent e){
		Player p = e.getPlayer();
		
		if(p.isOp() && !Main.opList.contains(p.getName())){
			e.disallow(Result.KICK_OTHER, Main.C("&8&m&l------------&7&l» &bSTSecurity &7&l«&8&m&l------------&r\n\n &cThe Security has been kicked out for suspicious moves"));
			Bukkit.broadcastMessage(Main.C("&4" + p.getName() + "&4 got kicked for suspicious moves."));
		}
		
	}

}
