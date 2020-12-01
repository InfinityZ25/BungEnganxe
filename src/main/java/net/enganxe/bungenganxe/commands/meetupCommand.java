package net.enganxe.bungenganxe.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class meetupCommand extends Command {
    public meetupCommand() {
        super("meetup");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(new ComponentBuilder("This command can only be run by a player!").color(ChatColor.RED).create());
            return;
        }
        ProxiedPlayer player = (ProxiedPlayer) sender;
        if (player.getServer().getInfo().getName().equalsIgnoreCase("meetup")) {
            player.sendMessage(new ComponentBuilder("You are already connected to the Meetup server!").color(ChatColor.RED).create());
            return;
        }
        ServerInfo target = ProxyServer.getInstance().getServerInfo("uhc");
        player.sendMessage(ChatColor.GREEN + "Connecting to meetup...");
        player.connect(target);
    }
}
