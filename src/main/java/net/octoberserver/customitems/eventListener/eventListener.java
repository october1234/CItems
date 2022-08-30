package net.octoberserver.customitems.eventListener;

import net.md_5.bungee.api.ChatColor;
import net.octoberserver.customitems.CustomItems;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.tags.CustomItemTagContainer;
import org.bukkit.inventory.meta.tags.ItemTagType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class eventListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        ItemStack MainMenuItem = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = MainMenuItem.getItemMeta();
        itemMeta.setDisplayName(ChatColor.GREEN + ChatColor.translateAlternateColorCodes('&', "&a&kX &6主選單 &a&kX"));
        itemMeta.getCustomTagContainer().setCustomTag(new NamespacedKey(CustomItems.main, "octCustomItems"), ItemTagType.STRING, "MainMenu");
        MainMenuItem.setItemMeta(itemMeta);
        MainMenuItem.setLore(new ArrayList<String>(Arrays.asList(ChatColor.GREEN + "點擊我開啟主選單")));

        if (event.getPlayer().getInventory().getItem(8) == null) {
            event.getPlayer().getInventory().setItem(8, MainMenuItem);
        }
        else {
            event.getPlayer().getInventory().addItem(MainMenuItem);
        }
    }

    @EventHandler(priority= EventPriority.HIGH)
    public void onPlayerUse(PlayerInteractEvent event){
        Player p = event.getPlayer();
        if (!(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
        if (event.getPlayer().getItemInHand().getItemMeta() == null) return;
        NamespacedKey key = new NamespacedKey(CustomItems.main, "octCustomItems");
        CustomItemTagContainer tagContainer = event.getPlayer().getItemInHand().getItemMeta().getCustomTagContainer();
        if(tagContainer.hasCustomTag(key, ItemTagType.STRING)){
            if (Objects.equals(tagContainer.getCustomTag(key, ItemTagType.STRING), "MainMenu")) {
                p.performCommand("cp MainMenu");
            }
        }
    }
}
