/**
 * 
 */
package com.clay.core;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import com.clay.listeners.FurnaceListener;
import com.clay.utilitys.ClayVersion;

/**
 * @author Ian
 *
 */
public class Clay {
	public final static ClayVersion CLAY_VERSION = new ClayVersion(0, 0, 2, true);
	private static boolean debug_enabled = false;
	private static boolean allow_feedback = false;
	private static boolean allow_metrics = false;
	private static JavaPlugin plugin_instance;
	private static String PLUGIN_MESSAGE_HEADER = "";
	private static World bukkit_world;
	
	/*
	 * Internal Listener's
	 */
	private static FurnaceListener furnace_listener;
	
	public static void onEnable() {
		
		ClayPermission.onEnable();
		
		// Setup Internal Listeners
		furnace_listener = new FurnaceListener();
		
		// Print disclaimer message
		ClayMessenger.sendConsole("This plugin uses Clay API " + CLAY_VERSION.getVersion());
		ClayMessenger.sendConsole("Find more about Clay @ " + ChatColor.WHITE + "clay.site90.com");

	}
	
	public static void onDisable() {
		ClayPermission.onDisable();

		furnace_listener = null;
	}
	
	public static String getWorldName() {
		return bukkit_world.getName();
	}
	
	public static World getWorld() {
		return bukkit_world;
	}
	
	public static void setWorld(World world) {
		bukkit_world = world;
	}
	
	/*
	 * Enable/Disable debug
	 */
	public static void setDebug(boolean debug) {
		debug_enabled = debug;
	}

	/*
	 * Gets if debug is enabled.
	 */
	public static boolean getDebug() {
		return debug_enabled;
	}
	
	/*
	 * log Clay Message to the console
	 */
	public static void logClay(String message) {
		Bukkit.getLogger().log(Level.INFO, "[CLAY] " + message);
	}
	
	/*
	 * log message to the console
	 */
	public static void log(String message) {
		Bukkit.getLogger().log(Level.INFO, PLUGIN_MESSAGE_HEADER + " " + message);
	}
	
	/*
	 * log debug message to the console
	 */
	public static void logDebug(String message) {
		if(!debug_enabled) {
			return;
		}
		
		Bukkit.getLogger().log(Level.INFO, PLUGIN_MESSAGE_HEADER + " " + message);
	}
	
	/*
	 * log error message to the console
	 */
	public static void logError(String message) {
		Bukkit.getLogger().log(Level.WARNING, PLUGIN_MESSAGE_HEADER + " " + message);
	}
	
	/*
	 * log notice message to the console
	 */
	public static void logNotice(String message) {
		Bukkit.getLogger().log(Level.INFO, PLUGIN_MESSAGE_HEADER + " " + message);
	}
	
	/*
	 * Set the plugin instance
	 */
	public static void setPluginInstance(JavaPlugin plugin_reference) {
		plugin_instance = plugin_reference;
	}
	
	/*
	 * Get the plugin instance
	 */
	public static JavaPlugin getPluginInstance() {
		return plugin_instance;
	}
	
	
	
}
