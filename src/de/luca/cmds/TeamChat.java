package de.luca.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.luca.configs.MessageConfig;

public class TeamChat implements CommandExecutor 
{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player)
		{
			Player p = (Player) sender;
			if(p.hasPermission("serversystem.teamchat"))
			{
				if(args.length < 1)
				{
					p.sendMessage(MessageConfig.UsageTeamChat);
					return false;
				}
				String message = "";
                for (int i = 0; i < args.length; i++) 
                {
                    message = message + args[i] + " ";
                }
				for(Player all : Bukkit.getOnlinePlayers())
				{
					if(all.hasPermission("serversystem.teamchat"))
					{
						all.sendMessage(MessageConfig.teamchatprefix.replaceAll("%player%", p.getDisplayName()) + message);
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
