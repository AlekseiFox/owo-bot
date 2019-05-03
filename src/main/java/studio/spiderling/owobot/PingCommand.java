package studio.spiderling.owobot;

import org.javacord.api.event.message.MessageCreateEvent;
import studio.spiderling.Commandler.Command;

import java.util.Arrays;
import java.util.List;

public class PingCommand extends Command {
    @Override public String Name() { return "Ping Command"; }
    @Override public String Description() { return "Am I alive or na?"; }
    @Override public String Category() { return "Utility"; }
    @Override public String Usage() { return "ping"; }
    @Override public List<String> Aliases() { return Arrays.asList("ping"); }
    @Override public List<String> Permissions() { return Arrays.asList("none"); }

    @Override
    public void onCommand(MessageCreateEvent event, String[] args) {
        long start = System.currentTimeMillis();
        event.getChannel().sendMessage("Pong?").thenAcceptAsync(msg -> {
           msg.edit("Pong! (" + (System.currentTimeMillis() - start) + "ms)");
        });
    }
}
