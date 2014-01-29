package com.clay.recipe;

import org.bukkit.inventory.ItemStack;

public abstract class FurnaceFuelBase {
	
	public FurnaceFuelBase() {
		
	}

	public abstract String getName();
	public abstract ItemStack getItem();
	public abstract int getBurnTime();
}
