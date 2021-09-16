package de.luca.configs;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.luca.main.Main;

import java.io.File;
import java.io.IOException;

public class MessageConfig {

    private File file;
    private FileConfiguration cfg;

    public static String prefix, teamchatprefix, FirstjoinMessage, playerJoinMessage, playerQuitMessage, NoConsole, NoCommand, UsageTeamChat,
    TeamChatSuccessfully, GameModeUsage, FehlendeRechte, AlreadyInThisGameMode, ChangedGameModeSuccefully, InvSeeUsage, PlayerNotFound,
    helpMessage1, helpMessage2, helpMessage3, helpMessage4, helpMessage5, MsgUsage, PlayerMsgOff, MSGEnabled, MSGDisabled, WartungsmodusAn,
    WartungsmodusAus, VoteReceive, ChatwurdeGeleert, KickOnWartungsmodus;

    public MessageConfig() {
    	file = new File(Main.plugin.getDataFolder() + "/Messages.yml");
        cfg = YamlConfiguration.loadConfiguration(file);
        load();
    }

    private void load() {
        if(!getFile().exists()) {

            getCfg().set("prefix", "&5Server-System &f>> &7");
            getCfg().set("teamchatprefix", "&6Chikara-Teamchat - &2%player% &f>> &7");
            getCfg().set("FirstjoinMessage", "&5Herzlich Willkommen auf Chikara-Survival.de");
            getCfg().set("playerJoinMessage", "&5%player% hat den Server betreten.");
            getCfg().set("playerQuitMessage", "&5%player% hat den Server verlassen.");
            getCfg().set("NoConsole", "&6Die Konsole darf dies nicht!");
            getCfg().set("NoCommand", "&6Dieser Command existiert leider nicht. -> /help");
            getCfg().set("UsageTeamChat", "&5Benutzung: &6/tc|/teamchat [text an team]");
            getCfg().set("GameModeUsage", "&5Benutzung: &6/gm|/gamemode [0|1|3]");
            getCfg().set("InvSeeUsage", "&2Benutzung: &6/invsee [ec/inv] {player}");
            getCfg().set("MsgUsage", "&4Benutzung: /msg [player] {nachricht}");
            getCfg().set("FehlendeRechte", "&6Dafür hast du leider keine Berechtigung!");
            getCfg().set("AlreadyInThisGameMode", "&6Du bist schon in diesem GameMode!");
            getCfg().set("ChangedGameModeSuccefully", "&2Dein GameMode wurde erfolgreich geändert!");
            getCfg().set("PlayerNotFound", "&6Der Spieler ist nicht online, oder wurde nicht gefunden.");
            getCfg().set("helpMessage1", "&7=-= &5Server-System &7=-=");
            getCfg().set("helpMessage2", "2");
            getCfg().set("helpMessage3", "3");
            getCfg().set("helpMessage4", "4");
            getCfg().set("helpMessage5", "5");
            getCfg().set("PlayerMsgOff", "&6Der Spieler hat Privat-Nachrichten mit /msgtoggle deaktiviert.");
            getCfg().set("MSGEnabled", "&6Privat-Nachrichten wurden erfolgreich aktiviert.");
            getCfg().set("MSGDisabled", "&6Privat-Nachrichten wurden erfolgreich deaktiviert.");
            getCfg().set("WartungsmodusAn", "&6Der Wartungsmodus wurde aktiviert!");
            getCfg().set("WartungsmodusAus", "&6Der Wartungsmodus wurde deaktiviert!");
            getCfg().set("VoteReceive", "&6Du hast deine Vote-Belohnung erhalten. Diese besteht aus 5 XP-Leveln und einigen Ingame Items.");
            getCfg().set("ChatwurdeGeleert", "&6%player% &7hat den Chat geleert.");
            getCfg().set("KickOnWartungsmodus", "§6Wartungsmodus ist aktiv.\\n\\n§5Entschuldigung für die Unannehmlichkeiten!");
            
            try {
                getCfg().save(getFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        prefix = convert("prefix");
        teamchatprefix = convert("teamchatprefix");
        FirstjoinMessage = prefix + convert("FirstjoinMessage");
        playerJoinMessage = prefix + convert("playerJoinMessage");
        playerQuitMessage = prefix + convert("playerQuitMessage");
        NoConsole = prefix + convert("NoConsole");
        NoCommand = prefix + convert("NoCommand");
        UsageTeamChat = prefix + convert("UsageTeamChat");
        GameModeUsage = prefix + convert("GameModeUsage");
        InvSeeUsage = prefix + convert("InvSeeUsage");
        FehlendeRechte = prefix + convert("FehlendeRechte");
        AlreadyInThisGameMode = prefix + convert("AlreadyInThisGameMode");
        ChangedGameModeSuccefully = prefix + convert("ChangedGameModeSuccefully");
        PlayerNotFound = prefix + convert("PlayerNotFound");
        helpMessage1 = convert("helpMessage1");
        helpMessage2 = convert("helpMessage2");
        helpMessage3 = convert("helpMessage3");
        helpMessage4 = convert("helpMessage4");
        helpMessage5 = convert("helpMessage5");
        PlayerMsgOff = convert("PlayerMsgOff");
        MSGEnabled = prefix + convert("MSGEnabled");
        MSGDisabled = prefix + convert("MSGDisabled");
        WartungsmodusAn = prefix + convert("WartungsmodusAn");
        WartungsmodusAus = prefix + convert("WartungsmodusAus");
        VoteReceive = prefix + convert("VoteReceive");
        ChatwurdeGeleert = prefix + convert("ChatwurdeGeleert");
        KickOnWartungsmodus = prefix + convert("KickOnWartungsmodus");
    }

    private String convert(String in) {
        return getCfg().getString(in).replace("&", "§");
    }

    public File getFile() {
        return file;
    }

    public FileConfiguration getCfg() {
        return cfg;
    }
}
