package de.luca.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.luca.configs.MessageConfig;

public class Msg implements CommandExecutor 
{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player)
		{		
			if(args.length > 2)
			{
				Player p = (Player) sender;
				Player target = Bukkit.getPlayer(args[0]);
				String message = "";
                for (int i = 0; i < args.length; i++) 
                {
                    message = message + args[i] + " ";
                }
				if(target != null)
				{
					if(MsgToggle.msgoff.contains(target.getUniqueId()))
					{
						p.sendMessage(MessageConfig.PlayerMsgOff);
					}else 
					{
						target.sendMessage(MessageConfig.prefix + p.getDisplayName() + "§6an §4Dich §7-> §6 " + message);
					}
				}else {
					sender.sendMessage(MessageConfig.PlayerNotFound);
				}
			}else {
				
			}
			return false;
		}else 
		{
			sender.sendMessage(MessageConfig.NoConsole);
			return false;
		}
	}
}
