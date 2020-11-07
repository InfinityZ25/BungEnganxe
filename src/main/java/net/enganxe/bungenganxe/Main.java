package net.enganxe.bungenganxe;

import net.enganxe.bungenganxe.commands.InviteCommand;
import net.enganxe.bungenganxe.commands.UhcCommand;
import net.enganxe.bungenganxe.events.JoinEvent;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {
    private static Main instance;

    @Override
    public void onEnable() {
        getProxy().getPluginManager().registerListener(this, new JoinEvent());
        getProxy().getPluginManager().registerCommand(this, new InviteCommand());
        getProxy().getPluginManager().registerCommand(this, new UhcCommand());
        getLogger().info("BungEnganxe by Wixent is enabled");
    }
    public static Main getInstance(){
        return instance;
    }
    private static void  setInstance(Main instance){
        Main.instance = instance;
    }

}