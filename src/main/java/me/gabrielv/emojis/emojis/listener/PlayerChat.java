package me.gabrielv.emojis.emojis.listener;

import me.gabrielv.emojis.emojis.Emojis;
import me.gabrielv.emojis.emojis.emoji.Unimoji;
import me.gabrielv.emojis.emojis.emoji.service.UnimojiService;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener {

    private final Emojis plugin;
    private final UnimojiService unimojiService;

    public PlayerChat(final Emojis plugin) {
        this.plugin = plugin;
        this.unimojiService = plugin.getUnimojiService();

        Bukkit.getPluginManager().registerEvents(this, this.plugin);
    }

    @EventHandler
    public void onChat(final AsyncPlayerChatEvent event) {

        for (final Unimoji emoji : this.unimojiService.getEmojis()) {

            if (event.getMessage().contains(emoji.getTerm())) {
                event.setMessage(event.getMessage().replace(emoji.getTerm(), emoji.getUnicode()));
            }
        }
    }
}
