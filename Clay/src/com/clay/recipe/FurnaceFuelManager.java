package com.clay.recipe;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.clay.core.Clay;

public class FurnaceFuelManager {
	private static ArrayList<FurnaceFuelBase> fuels = new ArrayList<FurnaceFuelBase>();
	
	
	public static boolean addFuel(FurnaceFuelBase fuel) {
		if(fuel == null) {
			return false;
		}
		
		if(fuels.contains(fuel)) {
			return false;
		} else {
			fuels.add(fuel);
			Clay.logClay("[FURNACE-FUEL] Added Fuel Type '" + fuel.getName() + "' (" + fuel.getBurnTime() + ")");
			return true;
		}
	}
	
	public static void removeFuel(FurnaceFuelBase fuel) {
		if(fuel == null) {
			return;
		}
		
		if(fuels.contains(fuel)) {
			fuels.remove(fuel);
		}
	}
	 
	public static List<String> getFuelNames() {
		ArrayList<String> temp_list = new ArrayList<String>();
			
		for(FurnaceFuelBase fuel : fuels) {
			temp_list.add(fuel.getName());
		}
		
		return temp_list;
	}
	
	public static boolean hasFuel(Material item) {
		for(FurnaceFuelBase fuel : fuels) {
			if(fuel.getItem() == item) {
				return true;
			}
		}
		
		return false;
	}
	
	public static FurnaceFuelBase getFuel(String name) {
		if(name == null || name.isEmpty()) {
			return null;
		}
		
		for(FurnaceFuelBase fuel : fuels) {
			if(fuel.getName().toString() == name.toUpperCase()) {
				return fuel;
			}
		}
		
		return null;
	}
	
	public static FurnaceFuelBase getFuel(Material item) {
		if(item == null) {
			return null;
		}
		
		for(FurnaceFuelBase fuel : fuels) {
			if(fuel.getItem() == item) {
				return fuel;
			}
		}
		
		return null;
	}
}
