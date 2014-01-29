package com.clay.listeners;

import org.bukkit.event.inventory.FurnaceBurnEvent;

import com.clay.core.ClayListener;
import com.clay.recipe.FurnaceFuelBase;
import com.clay.recipe.FurnaceFuelManager;

public class FurnaceListener extends ClayListener {

	public void FurnaceEvent(FurnaceBurnEvent event) {
		if(event.isCancelled()) {
			return;
		}
		
		FurnaceFuelBase furnace_fuel = FurnaceFuelManager.getFuel(event.getFuel());
		
		if(furnace_fuel != null) {
			event.setBurnTime(furnace_fuel.getBurnTime());
			event.setBurning(true);
		}
	}
}
