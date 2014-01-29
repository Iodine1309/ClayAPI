package com.clay.recipe;

import org.bukkit.inventory.ItemStack;

public abstract class PotionRecipeBase {

	public PotionRecipeBase() {
		// TODO Auto-generated constructor stub
	}

	public abstract String getName();
	public abstract ItemStack getPotion();
	public abstract boolean isCraftable();
	public abstract RecipeBase getRecipe();
}
