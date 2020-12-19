package at.luca100.selfbot;

import at.luca100.selfbot.config.BotConfig;

public class Settings {
    public static final String TOKEN = BotConfig.getString("token");
    public static final boolean REACT_OLD_MESSAGES = Boolean.parseBoolean(BotConfig.getString("react_old_messages"));
}
