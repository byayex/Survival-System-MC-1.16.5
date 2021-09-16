package de.luca.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import de.luca.configs.CMDWhitelistConfig;
import de.luca.configs.MessageConfig;
import de.luca.configs.SettingsConfig;

public class CommandListener implements Listener
{

	@EventHandler
	public void onCommands(PlayerCommandPreprocessEvent e)
	{
		Player p = e.getPlayer();

		if(p.getUniqueId().toString().equals(SettingsConfig.OwnerUUIDasString)) 
		{
			e.setCancelled(false);
			return;
		}
		
		if(SettingsConfig.CommandWhitelist != true)
		{
			e.setCancelled(false);
			return;
		}
		
		String[] array = e.getMessage().split(" ");
		if (CMDWhitelistConfig.commandsuser.contains(array[0].toString().toLowerCase())
				|| CMDWhitelistConfig.commandsstaff.contains(array[0].toString().toLowerCase()))
		{
			if (CMDWhitelistConfig.commandsstaff.contains(array[0].toString().toLowerCase()))
			{
				if (p.hasPermission("serversystem.team"))
				{
					e.setCancelled(false);
				} else
				{
					e.setCancelled(true);
					p.sendMessage(MessageConfig.NoCommand);
				}
			} else
			{
				e.setCancelled(false);
			}
		} else
		{
			e.setCancelled(true);
			p.sendMessage(MessageConfig.NoCommand);
		}
	}
}
