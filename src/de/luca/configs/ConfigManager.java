package de.luca.configs;

public class ConfigManager {

    private SettingsConfig settingsConfig;
    private MessageConfig messageConfig;
    private CMDWhitelistConfig cmdwhitelistConfig;

    public ConfigManager() {
        settingsConfig = new SettingsConfig();
        messageConfig = new MessageConfig();
        cmdwhitelistConfig = new CMDWhitelistConfig();
    }

    public MessageConfig getMessagesConfig() {
        return messageConfig;
    }

    public SettingsConfig getSettingsConfig() {
        return settingsConfig;
    }
    
    public CMDWhitelistConfig getCMDWhitelistConfig() {
    	return cmdwhitelistConfig;
    }
}
