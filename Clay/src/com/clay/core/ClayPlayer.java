package com.clay.core;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import com.clay.utilitys.WorldUtility;

public class ClayPlayer {

	public static boolean isPlayerInstance(Object object_reference) {
		if(object_reference instanceof Player) {
			return true;
		}
		
		return false;
	}

	public static boolean isPlayerOP(Object object_reference) {
		if(isPlayerInstance(object_reference)) {
			return ((Player)object_reference).isOp();
		}
			
		if(object_reference instanceof String) {
			Player player_reference = Bukkit.getPlayer((String)object_reference);
			
			if(player_reference != null) {
				return player_reference.isOp();
			}
		}
		
		return false;
	}
	
	public static boolean isPlayerOnline(String player_name) {
		Player player_reference = Bukkit.getPlayer(player_name);
		
		if(player_reference == null) {
			return false;
		}
				
		return player_reference.isOnline();
	}
	
	public static ItemStack getItemInHand(String player_name) {
		Player player_reference = Bukkit.getPlayer(player_name);
		
		if(player_reference == null) {
			return null;
		}
		
		return player_reference.getItemInHand();
	}
	
	public static PlayerInventory getInventory(String player_name) {
		Player player_reference = Bukkit.getPlayer(player_name);
		
		if(player_reference == null) {
			return null; 
		}
		
		return player_reference.getInventory();
	}
	
	public static void giveItems(String player_name, ItemStack[] items_reference) {
		Player player_reference = Bukkit.getPlayer(player_name);
		
		if(player_reference == null) {
			return;
		}
		
		for(ItemStack temp_reference : items_reference) {
			if(temp_reference != null) {
				player_reference.getInventory().addItem(temp_reference);
			}
		}
	}
	
	public static void giveItem(String player_name, ItemStack item_reference) {
		Player player_reference = Bukkit.getPlayer(player_name);
		
		if(player_reference == null) {
			return;
		}
		
		if(item_reference == null) {
			return;
		}
		
		player_reference.getInventory().addItem(item_reference);
	}
	
	public static int getInventoryCount(String player_name, ItemStack item_reference) {
		Player player_reference = Bukkit.getPlayer(player_name);
		int item_count = 0;
		
		if(player_reference == null) {
			return 0;
		}
		
		for(int index = 0; index < player_reference.getInventory().getSize(); index++) {
			ItemStack temp_reference = player_reference.getInventory().getItem(index);
			
			if(temp_reference != null) {
				if(temp_reference.getType() == item_reference.getType()) {
					item_count += item_reference.getAmount();
				}
			}
		}
		
		for(ItemStack temp_reference : player_reference.getInventory().getArmorContents()) {
			if(temp_reference != null) {
				if(temp_reference.getType() == item_reference.getType()) {
					item_count += item_reference.getAmount();
				}
			}
		}
		
		return item_count;
	}
	
	public static void setInventory(String player_name, PlayerInventory player_inventory) {
		Player player_reference = Bukkit.getPlayer(player_name);
		
		if(player_reference == null) {
			return; 
		}

	
	}
	
	public static boolean teleportPlayer(String player_name, Location location_reference) {
		Player player_reference = Bukkit.getPlayer(player_name);
		
		if(player_reference == null) {
			return false;
		}
		
		if(!player_reference.isOnline()) {
			return false;
		}
		
		if(location_reference == null) {
			return false;
		}
		
		if(player_reference.getLocation() == location_reference) {
			// Make sure that the player isn't already at the destination.
			return false;
		}
		
		Location teleport_location = WorldUtility.getHighestBlockAtLocation(location_reference);
		
		teleport_location.add(0, 2, 0);
		
		return player_reference.teleport(teleport_location);
	}
	
	public static boolean teleportPlayer(Player player_reference, Location location_reference) {
		if(player_reference == null) {
			return false;
		}
		
		if(!player_reference.isOnline()) {
			return false;
		}
		
		if(location_reference == null) {
			return false;
		}
		
		if(player_reference.getLocation() == location_reference) {
			// Make sure that the player isn't already at the destination.
			return false;
		}
		
		
		Location teleport_location = WorldUtility.getHighestBlockAtLocation(location_reference);
		
		teleport_location.add(0, 2, 0);
		
		return player_reference.teleport(teleport_location);
	}
	
	public static Block getSelectedBlock(Player p) {
		Block target_block = p.getTargetBlock(null, 100);
		return target_block;
	}
	
	public static Location getTargetBlockLocation(Player p) {
		Block target_block = p.getTargetBlock(null, 100);
		return target_block.getLocation();
	}
}
