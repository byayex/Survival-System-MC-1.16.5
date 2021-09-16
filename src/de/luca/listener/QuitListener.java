package de.luca.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import de.luca.configs.MessageConfig;
import de.luca.configs.SettingsConfig;

public class QuitListener implements Listener
{

	@EventHandler
	public void onQuit(PlayerQuitEvent e)
	{
		Player p = e.getPlayer();
		
		if(SettingsConfig.changeVanillaQuitMessage)
			e.setQuitMessage(MessageConfig.playerQuitMessage.replaceAll("%player%", p.getDisplayName()));
	}
}
