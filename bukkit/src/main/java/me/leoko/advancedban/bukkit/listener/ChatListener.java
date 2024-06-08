package me.leoko.advancedban.bukkit.listener;

import me.leoko.advancedban.Universal;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * Created by Leoko @ dev.skamps.eu on 16.07.2016.
 */
public class ChatListener implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onChat(AsyncPlayerChatEvent event) {
        if (Universal.get().getMethods().callChat(event.getPlayer(), event.getMessage())) {
            if (!Universal.get().getMethods().isSoftMuted(event.getPlayer())) {
                event.setCancelled(true);
                return;
            }
            event.getRecipients().clear();
            // Don't cancel the event, but send the message to softmuted players and players with the permission
            for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                if (Universal.get().getMethods().isSoftMuted(player)) {
                    event.getRecipients().add(player);
                    continue;
                }
                if (player.hasPermission("ab.softmute.see")) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&7(Softmuted) " + event.getPlayer().getName() + " >> " + event.getMessage()));
                }
            }
        }
    }
}