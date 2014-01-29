package com.clay.recipe;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.inventory.ItemStack;

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
	
	public static boolean hasFuel(ItemStack item) {
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
			if(fuel.getName() == name) {
				return fuel;
			}
		}
		
		return null;
	}
	
	public static FurnaceFuelBase getFuel(ItemStack item) {
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
