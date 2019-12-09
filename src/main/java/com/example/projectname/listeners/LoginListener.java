package com.example.projectname.listeners;

import com.example.projectname.ProjectName;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class LoginListener implements Listener {
    @EventHandler
    public void onPostLogin(PostLoginEvent e) {

    }

    @EventHandler
    public void onConnect(ServerConnectEvent e) {
        // Suppress "Could not connect to server you're already on" error
        if (e.getPlayer().getServer() != null && e.getPlayer().getServer().getInfo().equals(e.getTarget())) {
            e.setCancelled(true);
            return;
        }
        ProxiedPlayer player = e.getPlayer();

        ProjectName.addPlayerId(player.getUniqueId().toString());

        player.disconnect(new TextComponent("Hello World"));
    }
}
