package studio.spiderling.owobot;

import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.permission.Permissions;
import org.javacord.api.entity.permission.PermissionsBuilder;
import studio.spiderling.Commandler.CommandRegistry;
import studio.spiderling.Commandler.FrameworkConfig;

public class owoBot {

    public static void main(String[] args) {
        CommandRegistry registry = new CommandRegistry();

        new DiscordApiBuilder().setToken(FrameworkConfig.getToken()).login().thenAcceptAsync(api -> {
            registry.addCommandlerWorkloads(api);

            Permissions botPerms = new PermissionsBuilder().setAllAllowed().build();
            System.out.println(api.createBotInvite(botPerms));

            api.addMessageCreateListener(new owoListener());
            api.addMessageCreateListener(registry.registerCommand(new PingCommand()));
        });
    }
}
