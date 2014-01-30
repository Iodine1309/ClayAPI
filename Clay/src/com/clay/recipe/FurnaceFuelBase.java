package com.clay.recipe;

import org.bukkit.Material;

public class FurnaceFuelBase {
	private String fuel_name;
	private Material fuel_material;
	private int fuel_time;
	
	public FurnaceFuelBase(String name, Material item, int burntime) {
		this.fuel_material = item;
		this.fuel_name = name;
		this.fuel_time = burntime;
	}
	
	public void setName(String name) {
		fuel_name = name;
	}
	
	public void setItem(Material item) {
		fuel_material = item;
	}
	
	public void setBurnTime(int time) {
		fuel_time = time;
	}
	
	public String getName() {
		return fuel_name;
	}
	
	public Material getItem() {
		return fuel_material;
	}
	
	public int getBurnTime() {
		return fuel_time;
	}
}
