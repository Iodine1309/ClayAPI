package com.clay.core;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class ClayListener implements Listener {

	private static final List<ClayListener> LISTENERS = new ArrayList<ClayListener>();
	
	public ClayListener() {
		ClayListener.registerListener(this);
	}

	public static List<ClayListener> getListeners() {
        return ClayListener.LISTENERS;
    }
	
	public void deRegisterListener() {
		ClayListener.deRegisterListener(this);
    }
	
	protected static void registerListener(ClayListener listener) {
		if(Clay.getPluginInstance() == null) {
			// The plugin instance has not been set, this is the a plugin developer mistake..
			return;
		}
		
		Bukkit.getPluginManager().registerEvents(listener, (JavaPlugin)Clay.getPluginInstance());
		ClayListener.getListeners().add(listener);
	}
	
	protected static void deRegisterListener(ClayListener listener) {
        Method[] methods = listener.getClass().getMethods();
        for(Method m : methods) {
            EventHandler ev = m.getAnnotation(EventHandler.class);
            if(ev == null) continue;
            Class<?>[] params = m.getParameterTypes();
            for(Class<?> param : params) {
                if(param == null) continue;
                Class<? extends Event> e = param.asSubclass(Event.class);
                if(e == null) continue;
                try {
                    Method h = e.getMethod("getHandlerList");
                    HandlerList r = (HandlerList) h.invoke(null);
                    r.unregister(listener);
                } catch(Exception ex) {
                    continue;
                }
            }
        }
        ClayListener.getListeners().remove(listener);
    }

}
