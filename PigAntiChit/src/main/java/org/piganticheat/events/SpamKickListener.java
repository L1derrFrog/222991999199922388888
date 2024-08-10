package com.L1derrFrog.PigAntiCheat.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class SpamKickListener implements Listener {

    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        long lastCommand = player.getMetadata("last-command") != null ? player.getMetadata("last-command").get(0).asLong() : 0;
        long currentTime = System.currentTimeMillis();

        if (currentTime - lastCommand < 200) {
            event.setCancelled(true);
            player.kickPlayer(ChatColor.RED + "You have been kicked for command spam!");
        }

        player.setMetadata("last-command", new FixedMetadataValue(plugin, currentTime));
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        long lastMessage = player.getMetadata("last-message") != null ? player.getMetadata("last-message").get(0).asLong() : 0;
        long currentTime = System.currentTimeMillis();

        if (currentTime - lastMessage < 200) {
            event.setCancelled(true);
            player.kickPlayer(ChatColor.RED + "You have been kicked for chat spam!");
        }

        player.setMetadata("last-message", new FixedMetadataValue(plugin, currentTime));
    }
}
