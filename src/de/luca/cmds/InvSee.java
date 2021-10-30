package de.luca.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.luca.configs.MessageConfig;

public class InvSee implements CommandExecutor
{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if (sender instanceof Player)
		{
			if (args.length == 2)
			{
				if (args[0].equals("ec") || args[0].equals("inv"))
				{
					Player target = Bukkit.getPlayer(args[1]);
					if (target != null)
					{
						if (args[0].equals("ec"))
						{
							if (!sender.hasPermission("serversystem.invsee.ec"))
							{
								sender.sendMessage(MessageConfig.FehlendeRechte);
								return false;
							}

							if (target.hasPermission("serversystem.invsee.ec.admin"))
							{
								if (sender.hasPermission("serversystem.invsee.ec.admin"))
								{
									((Player) sender).openInventory(target.getEnderChest());
								} else
								{
									sender.sendMessage(MessageConfig.FehlendeRechte);
								}
							} else
							{
								((Player) sender).openInventory(target.getEnderChest());
							}
						}

						if (args[0].equals("inv"))
						{
							if (!sender.hasPermission("serversystem.invsee.inv"))
							{
								sender.sendMessage(MessageConfig.FehlendeRechte);
								return false;
							}

							if (target.hasPermission("serversystem.invsee.inv.admin"))
							{
								if (sender.hasPermission("serversystem.invsee.inv.admin"))
								{
									((Player) sender).openInventory(target.getInventory());
								} else
								{
									sender.sendMessage(MessageConfig.FehlendeRechte);
								}
							} else
							{
								((Player) sender).openInventory(target.getInventory());
							}
						}
					} else
					{
						sender.sendMessage(MessageConfig.PlayerNotFound);
					}
				} else
				{
					sender.sendMessage(MessageConfig.InvSeeUsage);
				}
			} else
			{
				sender.sendMessage(MessageConfig.InvSeeUsage);
				return false;
			}
			return false;
		} else
		{
			sender.sendMessage(MessageConfig.NoConsole);
			return false;
		}
	}
}
