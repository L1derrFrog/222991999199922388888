package com.L1derrFrog.PigAntiCheat.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class MultiHitPreventionListener implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            if (player.hasMetadata("recent-hit")) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.RED + "Hitting multiple entities at the same time is not allowed!");
            } else {
                player.setMetadata("recent-hit", new FixedMetadataValue(plugin, true));
                plugin.getServer().getScheduler().runTaskLater(plugin, () -> player.removeMetadata("recent-hit", plugin), 1L);
            }
        }
    }
}
