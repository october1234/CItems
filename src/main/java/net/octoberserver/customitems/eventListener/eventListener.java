package net.octoberserver.customitems.eventListener;

import net.octoberserver.customitems.CustomItems;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class eventListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if(event.getPlayer().getInventory().getItem(8) == null){
            CustomItems.main.getLogger().info("TEST!");
        }
    }
}
