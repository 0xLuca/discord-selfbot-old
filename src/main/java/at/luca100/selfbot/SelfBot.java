package at.luca100.selfbot;

import org.javacord.api.AccountType;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.TextChannel;

import java.util.Collections;

public class SelfBot {
    public static void main(String[] args) {
        DiscordApi api = new DiscordApiBuilder().setToken(Settings.TOKEN).setAccountType(AccountType.CLIENT).login().join();

        api.addMessageCreateListener(event -> {
            TextChannel channel = event.getChannel();
            String reactionHawara = "HawaraSalesch:779575855218688001"; //Reagiert mit :HawaraSalesch:
            String reactionStone = "\uD83D\uDDFF"; //Reagiert mit 🗿
            String activeReaction = reactionStone;
            event.getMessage().addReaction(activeReaction);
            String content = event.getMessageContent();
            if (event.getMessage().getAuthor().getId() == api.getYourself().getId()) {
                if (channel.getId() == Long.parseLong("746276747376459816")) { // Channel ID von offtopic
                    if (content.startsWith("-rml")) {
                        content = content.substring(4);
                        int toDelete = Integer.parseInt(content);
                        channel.getMessages(toDelete).join().stream().sorted(Collections.reverseOrder()).filter(message -> message.getAuthor().getId() == api.getYourself().getId()).forEach(message -> {
                            message.delete().join();
                        });
                    } else if (content.contains("emoji")) {
                        content = content.replace("emoji", "");
                        //event.getMessage().addReaction(activeReaction);
                        if (Settings.REACT_OLD_MESSAGES) {
                            boolean remove = content.startsWith("-");
                            if (remove) {
                                content = content.substring(1);
                            }
                            channel.getMessages(Integer.parseInt(content)).join().stream().sorted(Collections.reverseOrder()).forEach(message -> {
                                //event.getMessage().addReaction(activeReaction);
                                if (remove) {
                                    message.removeOwnReactionByEmoji(activeReaction);
                                } else {
                                    message.addReaction(activeReaction);
                                }
                            });
                        }
                    }
                }
            }
        });
    }
}
