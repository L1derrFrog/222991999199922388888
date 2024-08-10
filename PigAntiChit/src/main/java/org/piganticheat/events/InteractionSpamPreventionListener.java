package com.L1derrFrog.PigAntiCheat.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class InteractionSpamPreventionListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        long lastInteract = player.getMetadata("last-interact") != null ? player.getMetadata("last-interact").get(0).asLong() : 0;
        long currentTime = System.currentTimeMillis();

        if (currentTime - lastInteract < 100) {
            event.setCancelled(true);
            player.sendMessage(ChatColor.RED + "Interaction spam is not allowed!");
        }

        player.setMetadata("last-interact", new FixedMetadataValue(plugin, currentTime));
    }
}
