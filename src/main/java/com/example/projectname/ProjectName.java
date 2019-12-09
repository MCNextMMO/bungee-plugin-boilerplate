package com.example.projectname;

import net.md_5.bungee.api.plugin.Plugin;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.example.projectname.listeners.LoginListener;

public class ProjectName extends Plugin {
    private static Set<String> playerIds;

    @Override
    public void onEnable() {
        getProxy().getPluginManager().registerListener(this, new LoginListener());

        playerIds = ConcurrentHashMap.newKeySet();
    }

    @Override
    public void onDisable() {
        playerIds = null;
    }

    public static void addPlayerId(String id) {
      playerIds.add(id);
    }
}
