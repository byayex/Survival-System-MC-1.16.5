package de.luca.cmds;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.luca.configs.MessageConfig;

public class GameModeCMD implements CommandExecutor 
{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player)
		{
			Player p = (Player) sender;
			
			if(args.length != 1)
			{
				p.sendMessage(MessageConfig.GameModeUsage);
			}else 
			{
				switch(args[0])
				{
				case "0":
					if(p.hasPermission("serversystem.gamemode.survival"))
					{
						if(p.getGameMode() != GameMode.SURVIVAL)
						{
							p.setGameMode(GameMode.SURVIVAL);
							p.sendMessage(MessageConfig.ChangedGameModeSuccefully);
						}else {
							p.sendMessage(MessageConfig.AlreadyInThisGameMode);
							return true;
						}
					}else 
					{
						p.sendMessage(MessageConfig.FehlendeRechte);
						return true;
					}
					break;
				case "1":
					if(p.hasPermission("serversystem.gamemode.creative"))
					{
						if(p.getGameMode() != GameMode.CREATIVE)
						{
							p.setGameMode(GameMode.CREATIVE);
							p.sendMessage(MessageConfig.ChangedGameModeSuccefully);
						}else {
							p.sendMessage(MessageConfig.AlreadyInThisGameMode);
							return true;
						}
					}else 
					{
						p.sendMessage(MessageConfig.FehlendeRechte);
						return true;
					}
					break;
				case "3":
					if(p.hasPermission("serversystem.gamemode.spectator"))
					{
						if(p.getGameMode() != GameMode.SPECTATOR)
						{
							p.setGameMode(GameMode.SPECTATOR);
							p.sendMessage(MessageConfig.ChangedGameModeSuccefully);
						}else {
							p.sendMessage(MessageConfig.AlreadyInThisGameMode);
							return true;
						}
					}else 
					{
						p.sendMessage(MessageConfig.FehlendeRechte);
						return true;
					}
					break;
				default:
					p.sendMessage(MessageConfig.GameModeUsage);
					break;
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
