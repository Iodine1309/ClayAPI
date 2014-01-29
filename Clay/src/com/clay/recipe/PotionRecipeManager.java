package com.clay.recipe;

import java.util.ArrayList;

public class PotionRecipeManager {
	private static ArrayList<PotionRecipeBase> potions = new ArrayList<PotionRecipeBase>();
	
	public static boolean addPotion(PotionRecipeBase potion) {
		if(potion == null) {
			return false;
		}

		// Make sure we havent already added it.
		if(potions.contains(potion)) {
			return false;
		} else {
			potions.add(potion);
			
			// Check to see if it is craftable, then add it to the RecipeManager
			if(potion.isCraftable()) {
				if(potion.getRecipe() == null) {
					return false;
				}
				
				if(!RecipeManager.addRecipe(potion.getRecipe())) {
					return false;
				}
			}
			
			return true;
		}
	}
	
	public static void removePotion(PotionRecipeBase potion) {
		if(potion == null) {
			return;
		}
		
		if(potions.contains(potion)) {
			potions.remove(potion);
			
			// Check to see if the potion is craftable, if it is, we need to remove it.
			if(potion.isCraftable()) {
				
				// make sure the recipe isnt null
				if(potion.getRecipe() == null) {
					return;
				}
				
				// Remove the recipe from the recipe manager
				if(RecipeManager.removeRecipe(potion.getRecipe())) {
					return;
				}
			}
		}
	}
	
	public static PotionRecipeBase getPotion(String potion_name) {
		if(potion_name == null || potion_name.isEmpty()) {
			return null;
		}
		
		for(PotionRecipeBase potion : potions) {
			if(potion.getName() == potion_name) {
				return potion;
			}
		}
		
		return null;
	}
	
	
}
