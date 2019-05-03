package studio.spiderling.owobot;

import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class owoListener implements MessageCreateListener {

    public void onMessageCreate(MessageCreateEvent event) {
        String messageContent = event.getMessageContent();
        String[] content = messageContent.split(" ");

        for (String word : content) {
            if (word.equalsIgnoreCase("owo") || word.equalsIgnoreCase("uwu")) {
                sendowo(event.getChannel());
            }
        }
    }

    private void sendowo(TextChannel channel) {
        EmbedBuilder embed = new EmbedBuilder()
                .setImage("https://ih0.redbubble.net/image.617761791.8241/raf,750x1000,075,t,101010:01c5ca27c6.jpg");

        channel.sendMessage(embed);
    }
}
