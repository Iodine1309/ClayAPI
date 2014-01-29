package com.clay.recipe;

/*
 * These are the normal fuels, found in minecraft & there burn times.
 * 
 * These can be used for a reference to creating your own furnace fuel
 * 
 * Source: http://minecraft.gamepedia.com/Furnace
 */

public enum NormalFurnaceFuelEnum {
	COAL(80),
	CHARCOAL(80),
	WOOD(15),
	WOOD_PLANKS(15),
	WOOD_SLAB(7.5),
	SAPLINGS(5),
	WOOD_PRESSURE_PLATE(15),
	STICK(5),
	FENCE(15),
	FENCE_GATE(15),
	WOODEN_STAIRS(15),
	TRAPDOOR(15),
	CRAFTING_TABLE(15),
	BOOKSHELF(15),
	CHEST(15),
	TRAPPED_CHEST(15),
	DAYLIGHT_SENSOR(15),
	JUKEBOX(15),
	NOTE_BLOCK(15),
	HUGE_MUSHROOMS(15),
	BLAZE_ROD(120),
	BLOCK_COAL(800),
	LAVA_BUCKET(1000);
	
	private double burn_time;
	
	NormalFurnaceFuelEnum(double burnTime) {
		burn_time = burnTime;
	}
	
	public double getBurnTime() {
		return burn_time;
	}
}
