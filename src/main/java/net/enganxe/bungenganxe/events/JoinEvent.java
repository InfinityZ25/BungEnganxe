package net.enganxe.bungenganxe.events;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.util.Collection;


public class JoinEvent implements Listener {
    @EventHandler
    public void LoginEvent (PostLoginEvent event){
        ProxiedPlayer player = event.getPlayer();
        TextComponent msg = new TextComponent();
        msg.setText(" Has joined to the lobby!");
        Collection<String> group = player.getGroups();
        if (group.contains("owner")) {
            ProxyServer.getInstance().broadcast(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "Owner" + ChatColor.DARK_GRAY + "] " + ChatColor.RED + player + msg);
        }
        else if (group.contains("staff")) {
            ProxyServer.getInstance().broadcast(ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "Staff" + ChatColor.DARK_GRAY + "] " + ChatColor.YELLOW + player + msg);
        }
        else if (group.contains("mod")) {
            ProxyServer.getInstance().broadcast(ChatColor.DARK_GRAY + "[" + ChatColor.BLUE + "Mod" + ChatColor.DARK_GRAY + "] " + ChatColor.LIGHT_PURPLE + player + msg);
        }
        else if (group.contains("diamond")) { //diamante
            ProxyServer.getInstance().broadcast(ChatColor.AQUA + "[♦] " + player + msg);
        }
        else if (group.contains("pica")) { //pica
            ProxyServer.getInstance().broadcast(ChatColor.LIGHT_PURPLE + "[♠] " + player + msg);
        }
        else if (group.contains("trebol")) { //trebol
            ProxyServer.getInstance().broadcast(ChatColor.GREEN + "[♣] " + player + msg);
        }
        else if (group.contains("heart")) { //heart/corazon
            ProxyServer.getInstance().broadcast(ChatColor.RED + "[♥] " + player + msg);
        }
        else if (group.contains("media")) {
            ProxyServer.getInstance().broadcast(ChatColor.GRAY + "[" + ChatColor.LIGHT_PURPLE + "Media" + ChatColor.GRAY + "] " + ChatColor.LIGHT_PURPLE + player + msg);
        }
    }
}
