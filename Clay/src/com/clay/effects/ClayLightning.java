package com.clay.effects;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.Player;

public class ClayLightning {

	public static boolean strikePlayer(String player_name) {
		Player player_reference = Bukkit.getPlayer(player_name);
		
		return strikePlayer(player_reference, true);
	}
	
	public static boolean strikePlayer(String player_name, boolean kill_player) {
		Player player_reference = Bukkit.getPlayer(player_name);
		
		return strikePlayer(player_reference, kill_player);
	}
	
	public static boolean strikeLocation(Location location_reference) {
		if(location_reference == null) {
			return false;
		}
		
		Bukkit.getWorld(location_reference.getWorld().getName()).strikeLightning(location_reference);
		return true;
	}
	
	public static boolean strikePlayer(Player player_reference) {
		return strikePlayer(player_reference, true);
	}
	
	public static boolean strikePlayer(Player player_reference, boolean kill_player) {
		if(player_reference == null) {
			return false;
		}
		
		if(!player_reference.isOnline()) {
			return false;
		}
		
		Bukkit.getWorld(player_reference.getLocation().getWorld().getName()).strikeLightning(player_reference.getLocation());
		
		if(kill_player) {
			player_reference.damage(player_reference.getHealth());
		}
		
		return true;
	}
	
	public static boolean strikeEntity(Entity entity_reference) {
		return strikeEntity(entity_reference, true);
	}
	
	public static boolean strikeEntity(Entity entity_reference, boolean kill_entity) {
		if(entity_reference == null) {
			return false;
		}
		
		if(entity_reference.isDead()) {
			return false;
		}
		
		Bukkit.getWorld(entity_reference.getLocation().getWorld().getName()).strikeLightning(entity_reference.getLocation());
		
		if(kill_entity) {
			entity_reference.remove();
		}
		return true;
	}
	
	public static boolean createLightningEffect(Location location_reference) {
		if(location_reference == null) {
			return false;
		}
		
		Bukkit.getWorld(location_reference.getWorld().getName()).strikeLightningEffect(location_reference);
		
		return true;
	}
	
	public static boolean createLightningEffect(String player_name) {
		Player player_reference = Bukkit.getPlayer(player_name);
		
		if(player_reference == null) {
			return false;
		}
		
		if(!player_reference.isOnline()) {
			return false;
		}
		
		return createLightningEffect(player_reference.getLocation());
	}
	
	public static boolean createLightningEffect(Player player_reference) {
		if(player_reference == null) {
			return false;
		}
		
		if(!player_reference.isOnline()) {
			return false;
		}
		
		return createLightningEffect(player_reference.getLocation());
	}

}
