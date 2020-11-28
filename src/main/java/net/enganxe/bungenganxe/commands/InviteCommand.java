package net.enganxe.bungenganxe.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.util.HashMap;

public class InviteCommand extends Command {
    public HashMap<String, Long> cooldowns = new HashMap<String, Long>();
    public InviteCommand() {
        super("invite");
    }

    @Override
    public void execute(CommandSender sender, String[] strings) {
        int cooldownTime = 60;
        if (cooldowns.containsKey(sender.getName())) {
            long secondsLeft = ((cooldowns.get(sender.getName()) / 1000) + cooldownTime) - (System.currentTimeMillis() / 1000);
            if (secondsLeft > 0) {
                sender.sendMessage(ChatColor.RED + "You cant use that commands for another " + secondsLeft + " seconds!");
                return;
            }
        }
        cooldowns.put(sender.getName(), System.currentTimeMillis());

        ProxiedPlayer player = (ProxiedPlayer) sender;
        String p = player.getName();
        TextComponent msg = new TextComponent();
        TextComponent serverr = new TextComponent();
        TextComponent type = new TextComponent();
        TextComponent click = new TextComponent(); // player + msg + serverr + type + click
        msg.setText(ChatColor.GREEN + " Is inviting you to play ");
        if (player.getServer().getInfo().getName().equalsIgnoreCase("uhc") || player.getServer().getInfo().getName().equalsIgnoreCase("meetup")) {
            if (player.getServer().getInfo().getName().equalsIgnoreCase("uhc")) {
                type.setText(ChatColor.GOLD + " type /uhc to join or");
            } else if (player.getServer().getInfo().getName().equalsIgnoreCase("meetup")) {
                type.setText(ChatColor.RED + "type /meetup to join or");
            }
            click.setText(ChatColor.BOLD + "Click here");
            if (player.getServer().getInfo().getName().equalsIgnoreCase("uhc") || player.getServer().getInfo().getName().equalsIgnoreCase("meetup")) {
                if (player.getServer().getInfo().getName().equalsIgnoreCase("uhc")) {
                    serverr.setText(ChatColor.GOLD + "UHC,");
                    click.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "server uhc"));
                } else if (player.getServer().getInfo().getName().equalsIgnoreCase("meetup")) {
                    serverr.setText(ChatColor.RED + "UHC Meetup,");
                    click.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "server meetup"));
                }
                if (player.hasPermission("enganxe.owner")) {
                    ProxyServer.getInstance().broadcast(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "Owner" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + p + msg + serverr + type + click);
                } else if (player.hasPermission("enganxe.staff")) {
                    ProxyServer.getInstance().broadcast(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "Staff" + ChatColor.DARK_GRAY + "] " + ChatColor.YELLOW + p + msg + serverr + type + click);
                } else if (player.hasPermission("enganxe.mod")) {
                    ProxyServer.getInstance().broadcast(ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + "Mod" + ChatColor.DARK_GRAY + "] " + ChatColor.LIGHT_PURPLE + p + msg + serverr + type + click);
                } else if (player.hasPermission("enganxe.d")) { //diamante
                    ProxyServer.getInstance().broadcast(ChatColor.AQUA + "[♦] " + p + msg + serverr + type + click);
                } else if (player.hasPermission("enganxe.p")) {  //pica
                    ProxyServer.getInstance().broadcast(ChatColor.LIGHT_PURPLE + "[♠] " + p + msg + serverr + type + click);
                } else if (player.hasPermission("enganxe.t")) {//trebol
                    ProxyServer.getInstance().broadcast(ChatColor.GREEN + "[♣] " + p + msg + serverr + type + click);
                } else if (player.hasPermission("enganxe.h")) { //heart/corazon
                    ProxyServer.getInstance().broadcast(ChatColor.RED + "[♥] " + p + msg + serverr + type + click);
                } else if (player.hasPermission("enganxe.media")) {
                    ProxyServer.getInstance().broadcast(ChatColor.GRAY + "[" + ChatColor.LIGHT_PURPLE + "Media" + ChatColor.GRAY + "] " + ChatColor.LIGHT_PURPLE + p + msg + serverr + type + click);
                }
            }
            return;
        }
    }
}
