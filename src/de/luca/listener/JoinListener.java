package de.luca.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import de.luca.cmds.MaintenanceMode;
import de.luca.configs.MessageConfig;
import de.luca.configs.SettingsConfig;

public class JoinListener implements Listener {

	@EventHandler
	public void OnJoin(PlayerJoinEvent e)
	{
		Player p = e.getPlayer();
		
		if(MaintenanceMode.Wartungsmodus)
		{
			if(!p.hasPermission("serversystem.maintenance.join"))
				p.kickPlayer(MessageConfig.KickOnWartungsmodus);
		}
		
		if(SettingsConfig.changeVanillaJoinMessage)
			e.setJoinMessage(MessageConfig.playerJoinMessage.replaceAll("%player%", p.getDisplayName()));
		
		if(p.isOp())
			if(SettingsConfig.disableOP)
				p.setOp(false);
		
		if(!p.hasPlayedBefore())
		{
			if(SettingsConfig.sendFirstJoinMessage)
				p.sendMessage(MessageConfig.FirstjoinMessage);
		}
	}
}
