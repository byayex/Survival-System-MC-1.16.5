package de.luca.configs;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import de.luca.main.Main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CMDWhitelistConfig
{

	private File file;
	private FileConfiguration cfg;

	public static List<String> commandsuser;
	public static List<String> commandsstaff;

	public CMDWhitelistConfig()
	{
		file = new File(Main.plugin.getDataFolder() + "/Commands.yml");
		cfg = YamlConfiguration.loadConfiguration(file);
		load();
	}

	private void load()
	{
		if (!getFile().exists())
		{

			List<String> cmduser = new ArrayList<String>();
			cmduser.add("/help");
			cmduser.add("/h");
			cmduser.add("/msg");
			cmduser.add("/msgtoggle");
			getCfg().set("Commands-User", cmduser);

			List<String> cmdstaff = new ArrayList<String>();
			cmdstaff.add("/tc");
			cmdstaff.add("/teamchat");
			cmdstaff.add("/gamemode");
			cmdstaff.add("/gm");
			cmdstaff.add("/invsee");
			cmdstaff.add("/maintenance");
			cmdstaff.add("/clearchat");
			cmdstaff.add("/cc");
			getCfg().set("Commands-Staff", cmdstaff);

			try
			{
				getCfg().save(getFile());
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		commandsuser = getCfg().getStringList("Commands-User");
		commandsstaff = getCfg().getStringList("Commands-Staff");
	}

	public File getFile()
	{
		return file;
	}

	public FileConfiguration getCfg()
	{
		return cfg;
	}
}
