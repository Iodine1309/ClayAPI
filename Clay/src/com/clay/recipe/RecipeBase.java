package com.clay.recipe;

import org.bukkit.inventory.Recipe;

public abstract class RecipeBase {

	public abstract String getName();
	public abstract Recipe getRecipe();
	public abstract RecipeTypeEnum getType();
	
	public Recipe loadRecipeFromFile() {
		
		return null;
	}
}
