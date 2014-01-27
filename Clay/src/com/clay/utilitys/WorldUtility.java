package com.clay.utilitys;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;

import com.clay.core.Clay;

public class WorldUtility {

	public static Block getBlockAt(Location block_location) {
		return Bukkit.getWorld(Clay.getWorldName()).getBlockAt(block_location);
	}

	public static void setBlockAt(Location block_location, Block block_reference) {
		Block target_block = getBlockAt(block_location);
		
		if(target_block == null) {
			return;
		}
		
		target_block = block_reference;
	}
	
	public static Location getHighestBlockAtLocation(Location location_reference) {
		if(location_reference == null) {
			return null;
		}

		Block block_reference = Bukkit.getWorld(location_reference.getWorld().toString()).getHighestBlockAt(location_reference);
		
		if(block_reference == null) {
			return null;
		}
		
		return block_reference.getLocation();
		
	}
}
