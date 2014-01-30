package com.clay.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.inventory.FurnaceBurnEvent;

import com.clay.core.Clay;
import com.clay.core.ClayListener;
import com.clay.recipe.FurnaceFuelBase;
import com.clay.recipe.FurnaceFuelManager;

public class FurnaceListener extends ClayListener {

	@EventHandler(priority = EventPriority.MONITOR)
	public void FurnaceEvent(FurnaceBurnEvent event) {
		if(event.isCancelled()) {
			return;
		}
		
		if(FurnaceFuelManager.hasFuel(event.getFuel().getType())) {
			FurnaceFuelBase furnace_fuel = FurnaceFuelManager.getFuel(event.getFuel().getType());
			if(furnace_fuel != null) {
				event.setBurnTime(furnace_fuel.getBurnTime());
				event.setBurning(true);
			}
		}
	}
}
