package de.luca.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import com.vexsoftware.votifier.model.VotifierEvent;

import de.luca.configs.MessageConfig;
import de.luca.configs.SettingsConfig;


public class VoteListener implements Listener 
{

	@EventHandler
	public void onVote(VotifierEvent e)
	{
		if(!SettingsConfig.VoteReward)
		{
			return;
		}
		
		Player p = Bukkit.getPlayer(e.getVote().getUsername());

		Bukkit.broadcastMessage(MessageConfig.prefix + e.getVote().getUsername() + "&6 hat für den Server gevotet -> /vote");
		
		if(p != null)
		{
			p.sendMessage(MessageConfig.VoteReceive);
			
			p.setExp(p.getExp() + 5);
			
			p.getInventory().addItem(new ItemStack(Material.BEEF, 16));
			p.getInventory().addItem(new ItemStack(Material.IRON_INGOT, 6));
			p.getInventory().addItem(new ItemStack(Material.DIAMOND, 3));
			
		}else 
		{
			Bukkit.getConsoleSender().sendMessage(MessageConfig.prefix + "Spieler " + e.getVote().getUsername() + " konnten nicht gefunden werden - FEHLER");
		}
	}
}
