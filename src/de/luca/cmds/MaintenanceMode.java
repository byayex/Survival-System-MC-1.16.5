package de.luca.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.luca.configs.MessageConfig;

public class MaintenanceMode implements CommandExecutor 
{

	public static Boolean Wartungsmodus = false;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player)
		{
			Player p = (Player)sender;	
			if(p.hasPermission("serversystem.maintenance.toggle"))
			{
				if(Wartungsmodus == true)
				{
					p.sendMessage(MessageConfig.WartungsmodusAus);
					Wartungsmodus = false;
				}else
				{
					p.sendMessage(MessageConfig.WartungsmodusAn);
					Wartungsmodus = true;
					
					for(Player all : Bukkit.getOnlinePlayers())
					{
						if(!all.hasPermission("serversystem.maintenance.join"))
						{
							all.kickPlayer(MessageConfig.KickOnWartungsmodus);
						}
					}
				}
			}
			return false;
		}else 
		{
			sender.sendMessage(MessageConfig.NoConsole);
			return false;
		}
	}
}
