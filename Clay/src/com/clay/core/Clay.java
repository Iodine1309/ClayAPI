/**
 * 
 */
package com.clay.core;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

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
	
	public static void onEnable() {
		
		ClayPermission.onEnable();
		
		// Print disclaimer message
		ClayMessenger.sendConsole(ChatColor.YELLOW + " ******************************************** ");
		ClayMessenger.sendConsole(ChatColor.WHITE +  "  THIS PLUGIN USES THE CLAY API WHICH DOES    ");
		ClayMessenger.sendConsole(ChatColor.WHITE +  "  ACCESS FILES OUTSIDE OF THE 'PLUGIN DATA'   ");
		ClayMessenger.sendConsole(ChatColor.WHITE +  "  DIRECTORY. THIS MESSAGE IS JUST TO WARN     ");
		ClayMessenger.sendConsole(ChatColor.WHITE +  "  YOU! THE FILES ARE FOR INTERNAL USE AND     ");
		ClayMessenger.sendConsole(ChatColor.WHITE +  "  DOES NOT POSE ANY HARM TO YOUR SERVER or    ");
		ClayMessenger.sendConsole(ChatColor.WHITE +  "  YOUR SAFETY OF INFOMATION                   ");
		ClayMessenger.sendConsole("");
		ClayMessenger.sendConsole(ChatColor.WHITE +  "  CLAY VERSION: " + ChatColor.YELLOW + CLAY_VERSION.getVersion());
		ClayMessenger.sendConsole("");
		ClayMessenger.sendConsole(ChatColor.WHITE +  "          FIND MORE ABOUT CLAY HERE:          ");
		ClayMessenger.sendConsole(ChatColor.YELLOW + "		      http://clay.site90.com            ");
		ClayMessenger.sendConsole(ChatColor.YELLOW + " ******************************************** ");
		ClayMessenger.sendConsole("");
	}
	
	public static void onDisable() {
		ClayPermission.onDisable();
		
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
