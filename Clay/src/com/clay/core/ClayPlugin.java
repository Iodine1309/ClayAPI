package com.clay.core;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.JavaPluginLoader;

public class ClayPlugin extends JavaPlugin {
	
	
	public ClayPlugin() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onEnable() {
		/*
		 * Attach Clay library listeners
		 */
		Clay.onEnable();
		
		
	}
	
	@Override 
	public void onDisable() {
		/*
		 * Disable Clay Library components
		 */
		Clay.onDisable();
		
	}
	
	public void disablePlugin() {
		Bukkit.getPluginManager().disablePlugin(this);
	}
}
