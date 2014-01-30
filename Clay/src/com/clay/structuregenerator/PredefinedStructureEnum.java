package com.clay.structuregenerator;

public enum PredefinedStructureEnum {
	PORTAL("portal"),
	WELL("well");
	
	private String structure_name;
	
	PredefinedStructureEnum(String name) {
		structure_name = name;
	}
	
	public String getName() {
		return structure_name;
	}
}
