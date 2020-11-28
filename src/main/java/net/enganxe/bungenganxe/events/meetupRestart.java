package net.enganxe.bungenganxe.events;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.event.ServerDisconnectEvent;
import net.md_5.bungee.api.event.ServerKickEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class meetupRestart implements Listener {
    @EventHandler
    public void ServerRestart (ServerKickEvent event) {
        Server server = (Server) event.getCancelServer();
        ServerInfo target = ProxyServer.getInstance().getServerInfo("lobby");
        for (ProxiedPlayer all : server.getInfo().getPlayers()){
            all.connect(target);
        }
    }
}
