package com.clay.core;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;

import com.clay.utilitys.StringUtility;

public abstract class ClayCommand extends Clay implements CommandExecutor { //, TabCompleter {
		private List<ClayCommand> COMMANDS = new ArrayList<ClayCommand>();
		
		private PluginCommand registerCommand(ClayCommand command) {
			try {
				PluginCommand cmd = Clay.getPluginInstance().getCommand(command.getCommand());
				cmd.setExecutor(command);
	            cmd.setPermissionMessage(ClayMessenger.coloriseMessage(ClayPermission.getPermissionMessage()));
	            COMMANDS.add(command);
	            return cmd;
	        } catch(Exception e) {
	        	e.printStackTrace();
	        	
	        	Clay.logError("Failed to Register Command \"" + command.command + "\"");
	            return null;
	        }
		}
		
		public List<ClayCommand> getCommands() {
			return new ArrayList<ClayCommand>(COMMANDS);
		}
		
		public ClayCommand getCommand(String command) {
			for(ClayCommand tc : COMMANDS) {
				if(!tc.getCommand().equalsIgnoreCase(command)) continue; 
				return tc;
			}
			
			return null;
		}
		

		public ClayCommand getCommandSearchAliases(String name) {
			for(ClayCommand tc : COMMANDS) {
				if(tc.isCommand(name)) return tc;
			}
			
			return null;
		}
		
		private String command;
		private PluginCommand cmd;
		
		public ClayCommand(String command) {
			this.command = command;
			this.cmd = this.registerCommand(this);
		}
		
		@Override
	    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	        if(cmd.getName().equalsIgnoreCase(this.command)) {
	            if(!sender.hasPermission(cmd.getPermission())) return noPermission(sender, cmd, label, args);
	            boolean result = false;
	            //Error Handling
	            try {
	                result = this.cmd(sender, cmd, label, args);
	            } catch(Exception e) {
	            	e.printStackTrace();
	            	Clay.logDebug("Exception e:" + e.getMessage());
	            	Clay.logError("Command Execution failed \"" + this.toFullCommand(sender, cmd, label, args) + "\" Show to Plugin Author!");
	                ClayMessenger.sendMessage(sender.getName().toString(), ChatColor.RED + "A command error occured and the command was not finished successfully, please contact an admin!");
	            }
	            
	            if(!result) return commandFailed(sender, cmd, label, args);
	            return commandSuccess(sender, cmd, label, args);
	        }
	        
	        return badCommand(sender, cmd, label, args);
	    }

	  
		/*
		@Override
		public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
	        if(cmd.getName().equalsIgnoreCase(this.getCommand())) {
	            List<String> tab = this.badTab(sender, cmd, label, args);
	            if(tab != null) {
	                return tabSuccess(sender, cmd, label, args, tab);
	            }
	            
	            return this.tabFailed(sender, cmd, label, args);
	        }
	        return badTab(sender, cmd, label, args);
	    }
	    */
	    
	    public String getCommand() { return this.command; }
	    public PluginCommand getCmd() {return this.cmd;}
	    
	    
	    public boolean cmd(CommandSender sender, Command cmd, String label, String[] args) {return false;}
	    public boolean badCommand(CommandSender sender, Command cmd, String label, String[] args) {return false;}
	    public boolean commandSuccess(CommandSender sender, Command cmd, String label, String[] args) {return true;}
	    public boolean commandFailed(CommandSender sender, Command cmd, String label, String[] args) {return false;}
	    
	    public List<String> tabFailed(CommandSender sender, Command cmd, String label, String[] args) {return null;}
	    public List<String> badTab(CommandSender sender, Command cmd, String label, String[] args) {return null;}
	    public List<String> tabSuccess(CommandSender sender, Command cmd, String label, String[] args, List<String> successValue) {return successValue;}
	    
	    public boolean noPermission(CommandSender sender, Command cmd, String label, String[] args) {
	        ClayMessenger.sendPermissionMessage(sender.getName());
	        return true;
	    }
	    
	    public boolean fakeExecute(CommandSender sender, String commandLine) {
	        if(commandLine.startsWith("/")) commandLine = commandLine.replaceFirst("/", "");
	        
	        String[] s = commandLine.split(" ");
	        if(s.length < 1) return false;
	        
	        String lbl = s[0];
	        String[] args = new String[0];
	        if(s.length > 1) {
	            args = new String[s.length - 1];
	            
	            for(int i = 1; i < s.length; i++) {
	                args[i-1] = s[i];
	            }
	        }
	        
	        return this.onCommand(sender, cmd, lbl, args);
	    }
	    
	        
	    public boolean isCommand(String name) {
	        if(name.equalsIgnoreCase(this.command)) {
	        	return true;
	        }
	 
	        return false;
	    }

	    private String toFullCommand(CommandSender sender, Command cmd, String label, String[] args) {
	        String s = ClayPlayer.isPlayerInstance(sender) ? "/" : "";
	        s += label + " " + StringUtility.arrayToString(args);
	        
	        return s;
	    }
	    
	    
	}
