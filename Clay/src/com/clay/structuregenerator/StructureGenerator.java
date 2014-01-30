package com.clay.structuregenerator;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import com.clay.core.ClayPlayer;
import com.clay.utilitys.WorldUtility;

public class StructureGenerator {
	
	public StructureGenerator() {
		
	}
	
	public void buildStructure(String structure_name, Location start_location) {
		
	}
	
	/*
	 * Builds a predefined Structure
	 */
	public void buildStructure(PredefinedStructureEnum structure, Location start_location) {
		if(structure.getName() == "portal") {
			Block b = WorldUtility.getBlockAt(start_location);
			b.setType(Material.OBSIDIAN);
			
			// Layer 1
			WorldUtility.setBlockAt(start_location.add(0,0,0), b);
			WorldUtility.setBlockAt(start_location.add(1,0,0),b);
			WorldUtility.setBlockAt(start_location.add(2,0,0),b);
			WorldUtility.setBlockAt(start_location.add(3,0,0),b);
			
			// Layer 2
			WorldUtility.setBlockAt(start_location.add(0,1,0),b);
			WorldUtility.setBlockAt(start_location.add(3,1,0),b);
			
			// Layer 3
			WorldUtility.setBlockAt(start_location.add(0,2,0),b);
			WorldUtility.setBlockAt(start_location.add(3,2,0),b);
			
			// Layer 4
			WorldUtility.setBlockAt(start_location.add(0,3,0),b);
			WorldUtility.setBlockAt(start_location.add(1,3,0),b);
			WorldUtility.setBlockAt(start_location.add(2,3,0),b);
			WorldUtility.setBlockAt(start_location.add(3,3,0),b);
		}
	}
	
	public void loadStructure() {
		
	}
	
	public void saveStructure() {
		
	}
	
}
