package com.clay.core;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.bukkit.Bukkit;

public class ClayLogger {
	private Logger this_logger;
	private ClayLogger this_instance;
	private String this_filename;
	private FileHandler file_handler;
	private Formatter this_formatter;
	
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
		
		this_filename = filename;
		
		openFile();
		
		return this_instance;
	}
	
	public void setFormatter(Formatter formatter) {
		this_formatter = formatter;
	}
	
	public void destoryInstance() {
		closeFile();
		
		this_instance = null;
	}
	
	public String getFilename() {
		return this_filename;
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
	
	private void openFile() {
		try {
			file_handler = new FileHandler(this_filename);
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
		
		this_logger.addHandler(file_handler);
		
		file_handler.setFormatter(this_formatter);
	}
	
	private void closeFile() {
		this_logger.removeHandler(file_handler);
		
		file_handler.close();
	}
}
