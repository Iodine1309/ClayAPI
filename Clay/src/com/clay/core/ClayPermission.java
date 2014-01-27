package com.clay.core;

import java.util.ArrayList;
import java.util.HashMap;

public class ClayPermission {
	private static String PERMISSION_MESSAGE = "";
	private static HashMap<String, ArrayList<String>> permission_map = new HashMap<String, ArrayList<String>>();
	
	public static void onEnable() {
		loadPermissions();
		
	}
	
	public static void onDisable() {
		savePermissions();
		
	}
	
	private static void loadPermissions() {
		
	}
	
	private static void savePermissions() {
		
	}

	public static boolean hasPermission(String player_name, String permission_name) {
		if(permission_map.containsKey(permission_name)) {
			ArrayList<String> temp_list = permission_map.get(permission_name);
			
			if(temp_list.contains(player_name)) {
				return true;
			} else {
				return false;
			}
			
		} else {
			return false;
		}
	}
	
	public static void addPermission(String permission_name) {
		if(permission_map.containsKey(permission_name)) {
			return;
		}
		
		ArrayList<String> temp_list = new ArrayList<String>();
		permission_map.put(permission_name, temp_list);
	}
	
	public static void addPermissionToPlayer(String player_name, String permission_name) {
		if(permission_map.containsKey(permission_name)) {
			// Permission does exist
			ArrayList<String> temp_list = permission_map.get(permission_name);
			
			if(temp_list.contains(player_name)) {
				// Player already has this permission...
			} else {
				// Player doesnt have this permission...
				temp_list.add(player_name);
				permission_map.put(permission_name, temp_list);
			}
		} else {
			// Permission doesnt exist
			ArrayList<String> temp_list = new ArrayList<String>();
			temp_list.add(player_name);
			
			permission_map.put(permission_name, temp_list);
		}
	}
	
	public static void removePermissionFromPlayer(String player_name, String permission_name) {
		if(permission_map.containsKey(permission_name)) {
			// Permission does exist
			ArrayList<String> temp_list = permission_map.get(permission_name);
			
			if(temp_list.contains(player_name)) {
				// Player already has this permission...
				temp_list.remove(player_name);
				permission_map.put(permission_name, temp_list);
			} else {
				// Player doesnt have this permission...
				return;
			}
		} else {
			// Permission doesnt exist
			return;
		}
	}
	
	public static String getPermissionMessage() {
		return PERMISSION_MESSAGE;
	}
	
	public static void setPermissionMessage(String message) {
		PERMISSION_MESSAGE = message;
	}
	
	public static void removePermission(String permission_name) {
		if(permission_map.containsKey(permission_name)) {
			permission_map.remove(permission_name);
		}
	}
}
