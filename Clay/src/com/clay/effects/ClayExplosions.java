package com.clay.effects;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class ClayExplosions {
	public static HashMap<Integer, Location> event_holder = new HashMap<Integer, Location>();
	
	/*
	 * Location's
	 */
	public static boolean createExplosionAtLocation(Location location_reference) {
		if(location_reference == null) {
			return false;
		}
		
		
		return Bukkit.getWorld(location_reference.getWorld().getName()).createExplosion(location_reference, (float)4, false);
	}
	
	public static boolean createExplosionAtLocation(Location location_reference, int explosion_power) {
		if(location_reference == null) {
			return false;
		}
		
		
		return Bukkit.getWorld(location_reference.getWorld().getName()).createExplosion(location_reference, (float)explosion_power, false);
	}
	
	public static boolean createExplosionEffectAtLocation(Location location_reference) {
		if(location_reference == null) {
			return false;
		}
		
		return Bukkit.getWorld(location_reference.getWorld().getName()).createExplosion(location_reference, (float)0.2, false);
	}
		
	public static boolean createFireExplosionAtLocation(Location location_reference) {
		if(location_reference == null) {
			return false;
		}
		
		return Bukkit.getWorld(location_reference.getWorld().getName()).createExplosion(location_reference, (float)4, true);
	}
	
	public static boolean createFireExplosionAtLocation(Location location_reference, int explosion_power) {
		if(location_reference == null) {
			return false;
		}
		
		return Bukkit.getWorld(location_reference.getWorld().getName()).createExplosion(location_reference, (float)explosion_power, true);
	}
	
	/*
	 * Players
	 */
	public static boolean createExplosionAtPlayer(Player player_reference) {
		if(player_reference == null) {
			return false;
		}
		
		return Bukkit.getWorld(player_reference.getLocation().getWorld().getName()).createExplosion(player_reference.getLocation(), (float)4, false);
	}
		
	public static boolean createExplosionAtPlayer(Player player_reference, int explosion_power) {
		if(player_reference == null) {
			return false;
		}
		
		return Bukkit.getWorld(player_reference.getLocation().getWorld().getName()).createExplosion(player_reference.getLocation(), (float)explosion_power, false);
	}
	
	public static boolean createExplosionEffectAtPlayer(Player player_reference) {
		if(player_reference == null) {
			return false;
		}
		
		return Bukkit.getWorld(player_reference.getLocation().getWorld().getName()).createExplosion(player_reference.getLocation(), (float)0.2, false);
	}
	
	public static boolean createFireExplosionAtPlayer(Player player_reference) {
		if(player_reference == null) {
			return false;
		}
		
		return Bukkit.getWorld(player_reference.getLocation().getWorld().getName()).createExplosion(player_reference.getLocation(), (float)4, true);
	}
	
	public static boolean createFireExplosionAtPlayer(Player player_reference, int explosion_power) {
		if(player_reference == null) {
			return false;
		}
		
		return Bukkit.getWorld(player_reference.getLocation().getWorld().getName()).createExplosion(player_reference.getLocation(), (float)explosion_power, true);
	}
	
	public static boolean createExplosionAtPlayer(String player_name) {
		Player player_reference = Bukkit.getPlayer(player_name);
		
		if(player_reference == null) {
			return false;
		}
		
		if(!player_reference.isOnline()) {
			return false;
		}
		
		return Bukkit.getWorld(player_reference.getLocation().getWorld().getName()).createExplosion(player_reference.getLocation(), (float)4, false);
	}
		
	public static boolean createExplosionAtPlayer(String player_name, int explosion_power) {
		Player player_reference = Bukkit.getPlayer(player_name);
		
		if(player_reference == null) {
			return false;
		}
		
		if(!player_reference.isOnline()) {
			return false;
		}
		
		return Bukkit.getWorld(player_reference.getLocation().getWorld().getName()).createExplosion(player_reference.getLocation(), (float)explosion_power, false);
	}
	
	public static boolean createExplosionEffectAtPlayer(String player_name) {
		Player player_reference = Bukkit.getPlayer(player_name);
		
		if(player_reference == null) {
			return false;
		}
		
		if(!player_reference.isOnline()) {
			return false;
		}
		
		return Bukkit.getWorld(player_reference.getLocation().getWorld().getName()).createExplosion(player_reference.getLocation(), (float)0.2, false);
	}
		
	public static boolean createFireExplosionAtPlayer(String player_name) {
		Player player_reference = Bukkit.getPlayer(player_name);
		
		if(player_reference == null) {
			return false;
		}
		
		if(!player_reference.isOnline()) {
			return false;
		}
		
		return Bukkit.getWorld(player_reference.getLocation().getWorld().getName()).createExplosion(player_reference.getLocation(), (float)4, true);
	}
	
	public static boolean createFireExplosionAtPlayer(String player_name, int explosion_power) {
		Player player_reference = Bukkit.getPlayer(player_name);
		
		if(player_reference == null) {
			return false;
		}
		
		if(!player_reference.isOnline()) {
			return false;
		}
		
		return Bukkit.getWorld(player_reference.getLocation().getWorld().getName()).createExplosion(player_reference.getLocation(), (float)explosion_power, true);
	}
	
	/*
	 * Entitys
	 */
	
	public static boolean createExplosionAtEntity(Entity entity_reference) {
		if(entity_reference == null) {
			return false;
		}
		
		
		return Bukkit.getWorld(entity_reference.getLocation().getWorld().getName()).createExplosion(entity_reference.getLocation(), (float)4, false);
	}
		
	public static boolean createExplosionAtEntity(Entity entity_reference, int explosion_power) {
		if(entity_reference == null) {
			return false;
		}
		
		return Bukkit.getWorld(entity_reference.getLocation().getWorld().getName()).createExplosion(entity_reference.getLocation(), (float)explosion_power, false);
	}
	
	public static boolean createExplosionEffectAtEntity(Entity entity_reference) {
		if(entity_reference == null) {
			return false;
		}
		
		return Bukkit.getWorld(entity_reference.getLocation().getWorld().getName()).createExplosion(entity_reference.getLocation(), (float)0.2, false);
	}
	
	public static boolean createFireExplosionAtEntity(Entity entity_reference) {
		if(entity_reference == null) {
			return false;
		}
		
		return Bukkit.getWorld(entity_reference.getLocation().getWorld().getName()).createExplosion(entity_reference.getLocation(), (float)4, true);
	}
	
	public static boolean createFireExplosionAtEntity(Entity entity_reference, int explosion_power) {
		if(entity_reference == null) {
			return false;
		}
		
		return Bukkit.getWorld(entity_reference.getLocation().getWorld().getName()).createExplosion(entity_reference.getLocation(), (float)explosion_power, true);
	}
}
