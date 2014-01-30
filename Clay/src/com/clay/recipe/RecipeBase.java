package com.clay.recipe;

import org.bukkit.inventory.Recipe;

public class RecipeBase {
	private RecipeTypeEnum recipe_type;
	private Recipe recipe_recipe;
	private String recipe_name;
	
	public RecipeBase(String filename) {
		loadRecipe(filename);
	}
	
	public RecipeBase(String name, RecipeTypeEnum type, Recipe recipe) {
		recipe_type = type;
		recipe_name = name;
		recipe_recipe = recipe;
	}
	
	public boolean loadRecipe(String filename) {
		return false;
	}
	
	public boolean saveRecipe(String filename) {
		return false;
	}
	
	public String getName() {
		return recipe_name;
	}
	
	public void setName(String name) {
		recipe_name = name;
	}
	
	public void setType(RecipeTypeEnum type) {
		recipe_type = type;
	}
	
	public RecipeTypeEnum getType() {
		return recipe_type;
	}
	
	public Recipe getRecipe() {
		return recipe_recipe;
	}
	
	public void setRecipe(Recipe recipe) {
		recipe_recipe = recipe;
	}
	
	
	public Recipe loadRecipeFromFile() {
		
		return null;
	}
}
