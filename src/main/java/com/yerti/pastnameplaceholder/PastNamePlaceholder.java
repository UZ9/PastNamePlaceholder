package com.yerti.pastnameplaceholder;

import com.yerti.pastnameplaceholder.api.Placeholders;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class PastNamePlaceholder extends JavaPlugin {

    public void onEnable() {
        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            new Placeholders(this).hook();
        }
    }

    public void onDisable() {

    }
}