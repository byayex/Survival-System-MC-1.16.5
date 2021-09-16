package de.luca.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.luca.configs.MessageConfig;

public class Help implements CommandExecutor 
{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player)
		{
			sender.sendMessage(MessageConfig.helpMessage1);
			sender.sendMessage(MessageConfig.helpMessage2);
			sender.sendMessage(MessageConfig.helpMessage3);
			sender.sendMessage(MessageConfig.helpMessage4);
			sender.sendMessage(MessageConfig.helpMessage5);			
			return false;
		}else 
		{
			sender.sendMessage(MessageConfig.NoConsole);
			return false;
		}
	}
}
