package at.luca100.selfbot;

import org.javacord.api.AccountType;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class SelfBot {
    public static void main(String[] args) {
        DiscordApi api = new DiscordApiBuilder().setToken(Settings.TOKEN).setAccountType(AccountType.CLIENT).login().join();

        api.addMessageCreateListener(event -> {
           if (event.getMessage().getChannel().getId() == Long.parseLong("746276747376459816")) {
               //event.getMessage().addReaction("HawaraSalesch:779575855218688001");
               event.getMessage().addReaction("\uD83D\uDDFF");
           }
        });
    }
}
