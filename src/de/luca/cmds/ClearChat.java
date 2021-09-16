package de.luca.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.luca.configs.MessageConfig;

public class ClearChat implements CommandExecutor 
{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player)
		{
			if(sender.hasPermission("serversystem.chat.clear"))	
			{
				for(int i = 0; i < 200; i++)
				{
					for(Player all : Bukkit.getOnlinePlayers())
					{
						all.sendMessage("&6");
					}
				}
				Bukkit.broadcastMessage(MessageConfig.ChatwurdeGeleert.replaceAll("%player%", ((Player) sender).getPlayer().getDisplayName()));
			}else {
				sender.sendMessage(MessageConfig.FehlendeRechte);
			}
			return false;
		}else 
		{
			sender.sendMessage(MessageConfig.NoConsole);
			return false;
		}
	}
}
