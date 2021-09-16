package de.luca.configs;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.luca.main.Main;

import java.io.File;
import java.io.IOException;

public class SettingsConfig {

    private File file;
    private FileConfiguration cfg;

    public static Boolean sendFirstJoinMessage, changeVanillaJoinMessage, changeVanillaQuitMessage, disableOP, CommandWhitelist, VoteReward;
    public static String OwnerUUIDasString;
    
    public SettingsConfig() {
        file = new File(Main.plugin.getDataFolder() + "/Settings.yml");
        cfg = YamlConfiguration.loadConfiguration(file);
        load();
    }

    private void load() {
        if(!getFile().exists()) {
        	
        	getCfg().set("OwnerUUID", "de5bbcbe-3d9f-43ee-a79f-93012bdc8693");
            getCfg().set("sendFirstJoinMessage", true);
            getCfg().set("changeVanillaJoinMessage", true);
            getCfg().set("changeVanillaQuitMessage", true);
            getCfg().set("disableOP", true);
            getCfg().set("CommandWhitelist", true);
            getCfg().set("VoteReward", true);

            try {
                getCfg().save(getFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        OwnerUUIDasString = getCfg().getString("OwnerUUID");
        sendFirstJoinMessage = getCfg().getBoolean("sendFirstJoinMessage");
        changeVanillaJoinMessage = getCfg().getBoolean("changeVanillaJoinMessage");
        changeVanillaQuitMessage = getCfg().getBoolean("changeVanillaQuitMessage");
        disableOP = getCfg().getBoolean("disableOP");
        CommandWhitelist = getCfg().getBoolean("CommandWhitelist");
        VoteReward = getCfg().getBoolean("VoteReward");
    }

    public FileConfiguration getCfg() {
        return cfg;
    }

    public File getFile() {
        return file;
    }
}
