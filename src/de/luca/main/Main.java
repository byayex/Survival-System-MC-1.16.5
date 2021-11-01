package de.luca.main;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.luca.cmds.ClearChat;
import de.luca.cmds.GameModeCMD;
import de.luca.cmds.Help;
import de.luca.cmds.InvSee;
import de.luca.cmds.MaintenanceMode;
import de.luca.cmds.Msg;
import de.luca.cmds.MsgToggle;
import de.luca.cmds.TeamChat;
import de.luca.configs.ConfigManager;
import de.luca.listener.ChatListener;
import de.luca.listener.CommandListener;
import de.luca.listener.JoinListener;
import de.luca.listener.QuitListener;
import de.luca.listener.VoteListener;

public class Main extends JavaPlugin {
	
	private ConfigManager configManager;
	public static Main plugin;
	
	public void onEnable()
	{
		System.out.println("System erfolgreich geladen!");
		loadInit();
		registerCommands();
		registerListener();
	}
	
	private void loadInit() 
	{
	       plugin = this;
	       configManager = new ConfigManager();
	}

	private void registerCommands()
	{
		this.getCommand("tc").setExecutor(new TeamChat());
		this.getCommand("teamchat").setExecutor(new TeamChat());
		this.getCommand("gm").setExecutor(new GameModeCMD());
		this.getCommand("gamemode").setExecutor(new GameModeCMD());
		this.getCommand("invsee").setExecutor(new InvSee());
		this.getCommand("help").setExecutor(new Help());
		this.getCommand("h").setExecutor(new Help());
		this.getCommand("msg").setExecutor(new Msg());
		this.getCommand("msgtoggle").setExecutor(new MsgToggle());
		this.getCommand("maintenance").setExecutor(new MaintenanceMode());
		this.getCommand("clearchat").setExecutor(new ClearChat());
		this.getCommand("cc").setExecutor(new ClearChat());
	}
	
	private void registerListener() 
	{
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new JoinListener(), this);
		pm.registerEvents(new QuitListener(), this);
		pm.registerEvents(new CommandListener(), this);
		pm.registerEvents(new ChatListener(), this);
		pm.registerEvents(new VoteListener(), this);
	}

	public void onDisable() 
	{
		System.out.println("System erfolgreich entladen!");
	}
	
    public ConfigManager getConfigManager() {
        return configManager;
    }
	
}
