package com.clay.effects;

import java.util.List;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;

public class ClayFireworks {

	public static void createFirework(Location location_reference, Color color_reference) {
		Firework firework_reference = location_reference.getWorld().spawn(location_reference, Firework.class);
		FireworkMeta fwmeta_reference = firework_reference.getFireworkMeta();
		fwmeta_reference.addEffect(FireworkEffect.builder().flicker(false).withColor(color_reference).build());
		firework_reference.setFireworkMeta(fwmeta_reference);
		firework_reference.detonate();
	}
	
	public static void createFirework(Location location_reference, List<Color> color_reference) {
		Firework firework_reference = location_reference.getWorld().spawn(location_reference, Firework.class);
		
		FireworkMeta fwmeta_reference = firework_reference.getFireworkMeta();
		
		fwmeta_reference.addEffect(FireworkEffect.builder().flicker(false).withColor(color_reference).build());
		
		firework_reference.setFireworkMeta(fwmeta_reference);
		
		firework_reference.detonate();
	}
}
