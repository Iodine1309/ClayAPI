package com.clay.recipe;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;

import com.clay.core.Clay;

public class RecipeManager {
	private static ArrayList<RecipeBase> recipe_items = new ArrayList<RecipeBase>();

	public static boolean addRecipe(RecipeBase recipe_reference) {
		return addRecipe(recipe_reference, false);
	}
	
	public static boolean addRecipe(RecipeBase recipe_reference, boolean reset_recipes) {
		if(recipe_reference == null) {
			return false;
		}
		if(recipe_items.contains(recipe_reference)) {
			return false;
		} else {
			boolean recipe_added = false;
			if(recipe_reference.getType() == RecipeTypeEnum.FURNACE) {
				recipe_added = Bukkit.getServer().addRecipe((FurnaceRecipe) recipe_reference.getRecipe());
			} else if(recipe_reference.getType() == RecipeTypeEnum.SHAPED) {
				recipe_added = Bukkit.getServer().addRecipe((ShapedRecipe) recipe_reference.getRecipe());
			} else if(recipe_reference.getType() == RecipeTypeEnum.SHAPELESS) {
				recipe_added = Bukkit.getServer().addRecipe((ShapelessRecipe) recipe_reference.getRecipe());
			}
			
			if(recipe_added) {
				
				recipe_items.add(recipe_reference);
				
				if(reset_recipes) {
					// We added a recipe, so we need to load it.
					resetRecipes(true);
				}
				
				return true;
			} else {
				Clay.logClay(ChatColor.RED + "Failed to load recipe '" + recipe_reference.getName() + "'");
				return false;
			}
		}
	}
	
	public static boolean removeRecipe(String recipe_name) {
		return removeRecipe(recipe_name, false);
	}
	
	public static boolean removeRecipe(RecipeBase recipe) {
		return removeRecipe(recipe, false);
	}
	
	public static boolean removeRecipe(RecipeBase recipe, boolean reset_recipes) {
		if(recipe == null) {
			return false;
		}
		
		if(recipe_items.contains(recipe)) {
			recipe_items.remove(recipe);
			
			if(reset_recipes) {
				// We removed the Recipe, so now we need to remove from the server.
				resetRecipes(true);
			}
		}
		return false;
	}
	
	
	public static boolean removeRecipe(String recipe_name, boolean reload_recipes) {
		if(recipe_name.length() == 0) {
			return false;
		}
		
		for(RecipeBase recipe : recipe_items) {
			if(recipe.getName().equalsIgnoreCase(recipe_name)) {
				return removeRecipe(recipe, reload_recipes);
			}
		}
		return false;
	}
	
	
	public static void resetRecipes(boolean reload_recipes) {
		Bukkit.getServer().resetRecipes();

		if(reload_recipes) {
			for(RecipeBase recipe : recipe_items) {
				addRecipe(recipe);
			}
		}
	}
	
	public static List<String> getRecipeNames() {
		ArrayList<String> temp_list = new ArrayList<String>();
		
		String temp_name;
		
		for(RecipeBase recipe : recipe_items) {
			temp_name = recipe.getName() + "[" + recipe.getType().toString() + "]";
			temp_list.add(temp_name);
			temp_name = "";
		}
		
		return temp_list;
	}
	
	public static List<RecipeBase> getRecipes() {
		return recipe_items;
	}
}