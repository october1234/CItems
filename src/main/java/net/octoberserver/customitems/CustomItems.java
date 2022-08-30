package net.octoberserver.customitems;

import net.octoberserver.customitems.eventListener.eventListener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.LogManager;

public final class CustomItems extends JavaPlugin {

    public static Plugin main ;
    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new eventListener(), this);
        main = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
