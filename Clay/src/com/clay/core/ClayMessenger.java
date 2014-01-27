package com.clay.core;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ClayMessenger {

	public static void sendConsole(String message) {
		
	}
	
	public static boolean sendMessage(String player_name, String message) {
		Player player = Bukkit.getPlayer(player_name);
		
		if(player == null) {
			// The player is invalid, 
			return false;
		}
		
		player.sendMessage(message);
		return true;
	}
	
	public static void sendMessageList(ArrayList<String> players, String message) {
		
	}

	public static void broadcastMessage(String message) {
		Bukkit.broadcastMessage(message);
	}
	
	public static String coloriseMessage(String o) {
		return (String)colorise((Object)o);
	}
	
	private static String colorise(Object o) {
        String msg = o.toString();
        
        String[] andCodes = {"&0", "&1", "&2", "&3", "&4", "&5", "&6", "&7", 
            "&8", "&9", "&a", "&b", "&c", "&d", "&e", "&f", "&l", "&o", "&n", 
            "&m", "&k", "&r"};
        
        String[] altCodes = {"§0", "§1", "§2", "§3", "§4", "§5", "§6", "§7", 
            "§8", "§9", "§a", "§b", "§c", "§d", "§e", "§f", "§l", "§o", "§n", 
            "§m", "§k", "§r"};
        
        for(int x = 0; x < andCodes.length; x++) {
            msg = msg.replaceAll(andCodes[x], altCodes[x]);
        }
        
        return msg;
    }
    
    public static String deColorise(Object o) {
        String msg = o.toString();
        
        String[] andCodes = {"&0", "&1", "&2", "&3", "&4", "&5", "&6", "&7", 
            "&8", "&9", "&a", "&b", "&c", "&d", "&e", "&f", "&l", "&o", "&n", 
            "&m", "&k", "&r"};
        
        String[] altCodes = {"§0", "§1", "§2", "§3", "§4", "§5", "§6", "§7", 
                "§8", "§9", "§a", "§b", "§c", "§d", "§e", "§f", "§l", "§o", "§n", 
                "§m", "§k", "§r"};
        
        for(int x = 0; x < andCodes.length; x++) {
            msg = msg.replaceAll(altCodes[x], andCodes[x]);
        }
        
        return msg;
    } 
    
    public static void sendPermissionMessage(String playerName) {
		sendMessage(playerName, coloriseMessage(ClayPermission.getPermissionMessage()));
	}

}
