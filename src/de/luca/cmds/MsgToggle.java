package de.luca.cmds;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.luca.configs.MessageConfig;

public class MsgToggle implements CommandExecutor 
{

	public static ArrayList<UUID> msgoff = new ArrayList<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player)
		{		
			Player p = (Player)sender;
			if(msgoff.contains(p.getUniqueId()))
			{
				msgoff.remove(p.getUniqueId());
				p.sendMessage(MessageConfig.MSGEnabled);
			}else 
			{
				msgoff.add(p.getUniqueId());
				p.sendMessage(MessageConfig.MSGDisabled);
			}			
			return false;
		}else 
		{
			sender.sendMessage(MessageConfig.NoConsole);
			return false;
		}
	}
}
