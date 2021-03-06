package net.enganxe.bungenganxe.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class PingCommand extends Command {
    public PingCommand() {
        super("ping");
    }

    @Override
    public void execute(CommandSender commandSender, String[] args) {
        if (commandSender instanceof ProxiedPlayer){
            ProxiedPlayer p = (ProxiedPlayer) commandSender;
            int ping = p.getPing();
            if (ping < 150){
                p.sendMessage(new TextComponent(ChatColor.GRAY + "Your ping is: " + ChatColor.GREEN + ping));
            } else if (ping < 200){
                p.sendMessage(new TextComponent(ChatColor.GRAY + "Your ping is: " + ChatColor.YELLOW + ping));
            } else if (ping >= 200){
                p.sendMessage(new TextComponent(ChatColor.GRAY + "Your ping is: " + ChatColor.RED + ping));
            }
        }
    }
}
