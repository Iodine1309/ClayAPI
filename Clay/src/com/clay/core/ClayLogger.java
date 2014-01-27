package com.clay.core;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Bukkit;

public class ClayLogger {
	private Logger this_logger;
	private ClayLogger this_instance;
	
	public ClayLogger ClayLogger() {
		if(this_instance == null) {
			this_instance = this;
		}
		
		return this_instance;
	}
	
	public ClayLogger ClayLogger(String filename) {
		if(this_instance == null) {
			this_instance = this;
		}
		
		return this_instance;
	}
	
	public void destoryInstance() {
		this_instance = null;
	}
	
	public String getFilename() {
		return "";
	}
	
	public Logger getLogger() {
		return this_logger;
	}
	
	public void log(String message) {
		this_logger.log(Level.INFO, message);
	}
	
	public void logError(String message) {
		this_logger.log(Level.WARNING, message);
	}
}
