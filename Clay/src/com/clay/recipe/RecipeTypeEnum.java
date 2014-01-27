package com.clay.recipe;

public enum RecipeTypeEnum {
	SHAPELESS("Shapeless"),
	SHAPED("Shaped"),
	FURNACE("Furnace");
	
	private String name;
	
	RecipeTypeEnum(String this_name) {
		this.name = this_name;
	}
	
	public String toString() {
		return name;
	}
}
